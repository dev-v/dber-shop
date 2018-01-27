package com.dber.shop.service;

import com.dber.base.mapper.IMapper;
import com.dber.base.service.AbstractService;
import com.dber.shop.api.entity.ShopSiteBooking;
import com.dber.shop.mapper.IShopSiteBookingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <li>文件名称: ShopSiteBookingService.java</li>
 * <li>修改记录: ...</li>
 * <li>内容摘要: ...</li>
 * <li>其他说明: ...</li>
 *
 * @author dev-v
 * @version 1.0
 * @since 2017年12月20日
 */
@Service
public class ShopSiteBookingService extends AbstractService<ShopSiteBooking> implements IShopSiteBookingService {

    @Autowired
    private IShopSiteBookingMapper mapper;

    @Override
    protected IMapper<ShopSiteBooking> getMapper() {
        return this.mapper;
    }

    @Override
    public boolean hasBooking(ShopSiteBooking siteBooking) {
        return mapper.hasBooking(siteBooking) > 0;
    }
}