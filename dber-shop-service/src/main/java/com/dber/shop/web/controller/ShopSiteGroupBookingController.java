package com.dber.shop.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dber.base.service.IService;
import com.dber.base.web.controller.AbstractReadController;
import com.dber.shop.api.entity.ShopSiteGroupBooking;
import com.dber.shop.service.IShopSiteGroupBookingService;

/**
 * <li>文件名称: ShopSiteGroupBookingController.java</li>
 * <li>修改记录: ...</li>
 * <li>内容摘要: ...</li>
 * <li>其他说明: ...</li>
 * 
 * @version 1.0
 * @since 2017年12月21日
 * @author dev-v
 */
@RestController
@RequestMapping("/shop_site_group_booking")
public class ShopSiteGroupBookingController extends AbstractReadController<ShopSiteGroupBooking> {

	@Autowired
	private IShopSiteGroupBookingService service;

	@Override
	protected IService<ShopSiteGroupBooking> getService() {
		return this.service;
	}
}
