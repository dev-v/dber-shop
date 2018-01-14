package com.dber.shop.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dber.base.service.IService;
import com.dber.base.web.controller.AbstractController;
import com.dber.shop.api.entity.ShopSite;
import com.dber.shop.service.IShopSiteService;

/**
 * <li>文件名称: ShopSiteController.java</li>
 * <li>修改记录: ...</li>
 * <li>内容摘要: ...</li>
 * <li>其他说明: ...</li>
 * 
 * @version 1.0
 * @since 2017年12月21日
 * @author dev-v
 */
@RestController
@RequestMapping("/shop_site")
public class ShopSiteController extends AbstractController<ShopSite> {

	@Autowired
	private IShopSiteService service;

	@Override
	protected IService<ShopSite> getService() {
		return this.service;
	}
}
