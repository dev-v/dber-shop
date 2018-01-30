package com.dber.shop.service;

import com.dber.base.mapper.IMapper;
import com.dber.base.service.AbstractService;
import com.dber.shop.api.entity.ShopService;
import com.dber.shop.mapper.IShopServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <li>文件名称: ShopServiceService.java</li>
 * <li>修改记录: ...</li>
 * <li>内容摘要: ...</li>
 * <li>其他说明: ...</li>
 *
 * @author dev-v
 * @version 1.0
 * @since 2017年12月20日
 */
@Service
public class ShopServiceService extends AbstractService<ShopService> implements IShopServiceService {

    @Autowired
    private IShopServiceMapper mapper;

    @Autowired
    private IShopService shopService;

    @Override
    public int save(ShopService shopService) {
        int count = super.save(shopService);
        this.shopService.setBusinessStatus(shopService.getShopId());
        return count;
    }

    @Override
    protected IMapper<ShopService> getMapper() {
        return this.mapper;
    }

}
