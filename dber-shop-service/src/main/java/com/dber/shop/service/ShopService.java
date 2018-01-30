package com.dber.shop.service;

import com.dber.base.enums.ShopStatus;
import com.dber.base.enums.YesNo;
import com.dber.base.mapper.IMapper;
import com.dber.base.service.AbstractService;
import com.dber.shop.api.entity.Shop;
import com.dber.shop.api.entity.ShopVipCard;
import com.dber.shop.mapper.IShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <li>文件名称: ShopService.java</li>
 * <li>修改记录: ...</li>
 * <li>内容摘要: ...</li>
 * <li>其他说明: ...</li>
 *
 * @author dev-v
 * @version 1.0
 * @since 2017年12月20日
 */
@Service
public class ShopService extends AbstractService<Shop> implements IShopService {

    private static final float minPricePercent = 0.7f;
    private static final float maxPricePercent = 1.7f;


    @Autowired
    private IShopMapper mapper;

    @Autowired
    private IShopServiceService shopServiceService;

    @Autowired
    private IShopVipCardService vipCardService;

    @Override
    protected IMapper<Shop> getMapper() {
        return this.mapper;
    }

    @Transactional
    @Override
    public int setBasePrice(Shop shop) {
        if (shop.getId() != null) {
            double basePrice = shop.getBasePrice();
            double maxPrice = basePrice * maxPricePercent + 0.01;
            double minPrice = basePrice * minPricePercent - 0.01;
            double expectPrice = shop.getExpectPrice();
            int count = 0;
            if (expectPrice > maxPrice) {
                shop.setStatus(ShopStatus.ENQUIRING_HIGHER.getValue());
                count = mapper.save(shop);
            } else if (expectPrice < minPrice) {
                shop.setStatus(ShopStatus.ENQUIRING_LOWER.getValue());
                count = mapper.save(shop);
            } else {
                shop.setStatus(ShopStatus.BUSINESSING_NO_SERVICE.getValue());
                shop.setPrice(expectPrice);
                count = mapper.save(shop);
                setBusinessStatus(shop.getId());
            }
            return count;
        }
        return 0;
    }

    @Override
    public int setPrice(Shop shop) {
        if (shop.getId() != null) {
            double price = shop.getPrice();

            Shop shop1 = mapper.get(shop.getId());
            double basePrice = shop1.getBasePrice();
            double maxPrice = basePrice * maxPricePercent + 0.01;
            double minPrice = basePrice * minPricePercent - 0.01;
            
            if (price < maxPrice && price > minPrice) {
                return mapper.save(shop);
            }
        }
        return 0;
    }

    @Transactional
    @Override
    public int setBusinessStatus(long shopId) {
        Shop shop = mapper.get(shopId);
        int status = shop.getStatus();
        if (ShopStatus.BUSINESSING_WITH_SERVICE.is(status) || ShopStatus.BUSINESSING_NO_SERVICE.is(status)) {
            com.dber.shop.api.entity.ShopService shopService = new com.dber.shop.api.entity.ShopService();
            shopService.setShopId(shop.getId());
            shopService.setStatus(YesNo.YES.getValue());
            boolean hasService = shopServiceService.has(shopService);

            ShopVipCard vipCard = new ShopVipCard();
            vipCard.setShopId(shop.getId());
            vipCard.setStatus(YesNo.YES.getValue());
            boolean hasCard = vipCardService.has(vipCard);

            if (hasService || hasCard) {
                if (ShopStatus.BUSINESSING_NO_SERVICE.is(status)) {
                    shop.setStatus(ShopStatus.BUSINESSING_WITH_SERVICE.getValue());
                    return mapper.save(shop);
                }
            } else {
                if (ShopStatus.BUSINESSING_WITH_SERVICE.is(status)) {
                    shop.setStatus(ShopStatus.BUSINESSING_NO_SERVICE.getValue());
                    return mapper.save(shop);
                }
            }
        }
        return 0;
    }
}
