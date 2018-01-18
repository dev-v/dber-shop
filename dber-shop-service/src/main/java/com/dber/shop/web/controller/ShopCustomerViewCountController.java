package com.dber.shop.web.controller;

import com.dber.base.web.controller.AbstractReadController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dber.base.service.IService;
import com.dber.base.web.controller.AbstractController;
import com.dber.shop.api.entity.ShopCustomerViewCount;
import com.dber.shop.service.IShopCustomerViewCountService;

/**
 * <li>文件名称: ShopCustomerViewCountController.java</li>
 * <li>修改记录: ...</li>
 * <li>内容摘要: ...</li>
 * <li>其他说明: ...</li>
 * 
 * @version 1.0
 * @since 2017年12月21日
 * @author dev-v
 */
@RestController
@RequestMapping("/shop_customer_view_count")
public class ShopCustomerViewCountController extends AbstractReadController<ShopCustomerViewCount> {

	@Autowired
	private IShopCustomerViewCountService service;

	@Override
	protected IService<ShopCustomerViewCount> getService() {
		return this.service;
	}
}
