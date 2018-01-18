package com.dber.shop.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dber.base.service.IService;
import com.dber.base.web.controller.AbstractReadController;
import com.dber.shop.api.entity.ShopSiteBooking;
import com.dber.shop.service.IShopSiteBookingService;

/**
 * <li>文件名称: ShopSiteBookingController.java</li>
 * <li>修改记录: ...</li>
 * <li>内容摘要: ...</li>
 * <li>其他说明: ...</li>
 * 
 * @version 1.0
 * @since 2017年12月21日
 * @author dev-v
 */
@RestController
@RequestMapping("/shop_site_booking")
public class ShopSiteBookingController extends AbstractReadController<ShopSiteBooking> {

	@Autowired
	private IShopSiteBookingService service;

	@Override
	protected IService<ShopSiteBooking> getService() {
		return this.service;
	}
}
