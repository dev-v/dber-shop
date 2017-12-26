package com.dber.shop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dber.base.service.IService;
import com.dber.base.web.controller.AbstractController;
import com.dber.shop.api.entity.ShopService;
import com.dber.shop.service.IShopServiceService;

/**
 * <li>文件名称: ShopServiceController.java</li>
 * <li>修改记录: ...</li>
 * <li>内容摘要: ...</li>
 * <li>其他说明: ...</li>
 * 
 * @version 1.0
 * @since 2017年12月21日
 * @author dev-v
 */
@RestController
@RequestMapping("/shop_service")
public class ShopServiceController extends AbstractController<ShopService> {

	@Autowired
	private IShopServiceService service;

	@Override
	protected IService<ShopService> getService() {
		return this.service;
	}
}
