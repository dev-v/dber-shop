package com.dber.shop.service;

import com.dber.base.mapper.IMapper;
import com.dber.base.service.AbstractService;
import com.dber.shop.api.entity.ShopService;
import com.dber.shop.api.entity.ShopSite;
import com.dber.shop.mapper.IShopSiteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <li>文件名称: ShopSiteService.java</li>
 * <li>修改记录: ...</li>
 * <li>内容摘要: ...</li>
 * <li>其他说明: ...</li>
 *
 * @author dev-v
 * @version 1.0
 * @since 2017年12月20日
 */
@Service
public class ShopSiteService extends AbstractService<ShopSite> implements IShopSiteService {

    @Autowired
    private IShopSiteMapper mapper;

    @Autowired
    private IShopServiceService shopServiceService;

    @Override
    public int save(ShopSite shopSite) {
        boolean flag = shopSite.getId() == null;
        int count = super.save(shopSite);
        if (flag && count == 1) {
            ShopService shopService = shopServiceService.get(shopSite.getShopServiceId());
            shopService.setCount(shopService.getCount() + 1);
            shopServiceService.save(shopService);
        }
        return count;
    }

    @Override
    public int del(ShopSite shopSite) {
        shopSite = queryOne(shopSite);
        if (shopSite != null) {
            boolean flag = shopSite.getId() != null;
            int count = super.del(shopSite.getId());
            if (flag && count > 0) {
                ShopService shopService = shopServiceService.get(shopSite.getShopServiceId());
                shopService.setCount(shopService.getCount() - count);
                shopServiceService.save(shopService);
            }
            return count;
        } else {
            return 0;
        }
    }

    @Override
    protected IMapper<ShopSite> getMapper() {
        return this.mapper;
    }

}
