package com.dber.shop.service;

import com.dber.base.mapper.IMapper;
import com.dber.base.service.AbstractService;
import com.dber.shop.api.entity.ShopVipCardService;
import com.dber.shop.mapper.IShopVipCardServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <li>文件名称: ShopVipCardServiceService.java</li>
 * <li>修改记录: ...</li>
 * <li>内容摘要: ...</li>
 * <li>其他说明: ...</li>
 *
 * @author dev-v
 * @version 1.0
 * @since 2017年12月20日
 */
@Service
public class ShopVipCardServiceService extends AbstractService<ShopVipCardService> implements IShopVipCardServiceService {

    @Autowired
    private IShopVipCardServiceMapper mapper;

    @Autowired
    private IShopService shopService;

    @Override
    public int save(ShopVipCardService shopVipCardService) {
        int count = super.save(shopVipCardService);
        shopService.setBusinessStatus(shopVipCardService.getShopId());
        return count;
    }

    @Override
    protected IMapper<ShopVipCardService> getMapper() {
        return this.mapper;
    }

}
