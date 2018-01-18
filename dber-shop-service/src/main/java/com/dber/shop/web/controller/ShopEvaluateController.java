package com.dber.shop.web.controller;

import com.dber.base.web.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dber.base.service.IService;
import com.dber.base.web.controller.AbstractReadController;
import com.dber.shop.api.entity.ShopEvaluate;
import com.dber.shop.service.IShopEvaluateService;

import java.util.Collection;

/**
 * <li>文件名称: ShopEvaluateController.java</li>
 * <li>修改记录: ...</li>
 * <li>内容摘要: ...</li>
 * <li>其他说明: ...</li>
 * 
 * @version 1.0
 * @since 2017年12月21日
 * @author dev-v
 */
@RestController
@RequestMapping("/shop_evaluate")
public class ShopEvaluateController extends AbstractReadController<ShopEvaluate> {

	@Autowired
	private IShopEvaluateService service;

	@Override
	protected IService<ShopEvaluate> getService() {
		return this.service;
	}
}
