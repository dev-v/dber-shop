package com.dber.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dber.base.mapper.IMapper;
import com.dber.base.service.AbstractService;
import com.dber.shop.api.entity.ShopSiteGroupBooking;
import com.dber.shop.mapper.IShopSiteGroupBookingMapper;

/**
 * <li>文件名称: ShopSiteGroupBookingService.java</li>
 * <li>修改记录: ...</li>
 * <li>内容摘要: ...</li>
 * <li>其他说明: ...</li>
 * 
 * @version 1.0
 * @since 2017年12月20日
 * @author dev-v
 */
@Service
public class ShopSiteGroupBookingService extends AbstractService<ShopSiteGroupBooking> implements IShopSiteGroupBookingService {

	@Autowired
	private IShopSiteGroupBookingMapper mapper;

	@Override
	protected IMapper<ShopSiteGroupBooking> getMapper() {
		return this.mapper;
	}

}
