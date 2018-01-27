package com.dber.shop.web.controller;

import com.dber.base.web.controller.AbstractReadController;
import com.dber.base.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dber.base.service.IService;
import com.dber.shop.api.entity.Shop;
import com.dber.shop.service.IShopService;

/**
 * <li>文件名称: ShopController.java</li>
 * <li>修改记录: ...</li>
 * <li>内容摘要: ...</li>
 * <li>其他说明: ...</li>
 *
 * @author dev-v
 * @version 1.0
 * @since 2017年12月21日
 */
@RestController
@RequestMapping("/shop")
public class ShopController extends AbstractReadController<Shop> {

    @Autowired
    private IShopService service;

    @RequestMapping("/save")
    public Response<Shop> save(Shop shop) {
        shop.setId(getAccountId());
        service.save(shop);
        return Response.newSuccessResponse(shop);
    }

    @Override
    public IService<Shop> getService() {
        return this.service;
    }
}
