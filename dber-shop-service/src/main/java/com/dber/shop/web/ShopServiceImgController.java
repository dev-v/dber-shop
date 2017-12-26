package com.dber.shop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dber.base.service.IService;
import com.dber.base.web.controller.AbstractController;
import com.dber.shop.api.entity.ShopServiceImg;
import com.dber.shop.service.IShopServiceImgService;

/**
 * <li>文件名称: ShopServiceImgController.java</li>
 * <li>修改记录: ...</li>
 * <li>内容摘要: ...</li>
 * <li>其他说明: ...</li>
 * 
 * @version 1.0
 * @since 2017年12月21日
 * @author dev-v
 */
@RestController
@RequestMapping("/shop_service_img")
public class ShopServiceImgController extends AbstractController<ShopServiceImg> {

	@Autowired
	private IShopServiceImgService service;

	@Override
	protected IService<ShopServiceImg> getService() {
		return this.service;
	}
}
