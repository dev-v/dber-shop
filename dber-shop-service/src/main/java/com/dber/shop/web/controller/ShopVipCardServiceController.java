package com.dber.shop.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dber.base.service.IService;
import com.dber.base.web.controller.AbstractController;
import com.dber.shop.api.entity.ShopVipCardService;
import com.dber.shop.service.IShopVipCardServiceService;

/**
 * <li>文件名称: ShopVipCardServiceController.java</li>
 * <li>修改记录: ...</li>
 * <li>内容摘要: ...</li>
 * <li>其他说明: ...</li>
 * 
 * @version 1.0
 * @since 2017年12月21日
 * @author dev-v
 */
@RestController
@RequestMapping("/shop_vip_card_service")
public class ShopVipCardServiceController extends AbstractController<ShopVipCardService> {

	@Autowired
	private IShopVipCardServiceService service;

	@Override
	protected IService<ShopVipCardService> getService() {
		return this.service;
	}
}
