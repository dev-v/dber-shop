package com.dber.shop.web.controller;

import com.dber.base.service.IService;
import com.dber.base.web.controller.AbstractReadController;
import com.dber.base.entity.Response;
import com.dber.shop.api.entity.ShopVipCard;
import com.dber.shop.service.IShopVipCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * <li>文件名称: ShopVipCardController.java</li>
 * <li>修改记录: ...</li>
 * <li>内容摘要: ...</li>
 * <li>其他说明: ...</li>
 *
 * @author dev-v
 * @version 1.0
 * @since 2017年12月21日
 */
@RestController
@RequestMapping("/shop_vip_card")
public class ShopVipCardController extends AbstractReadController<ShopVipCard> {

    @Autowired
    private IShopVipCardService service;

    @Override
    public Response<Collection<ShopVipCard>> queryWithoutPage(ShopVipCard data) {
        data.setShopId(getAccountId());
        return super.queryWithoutPage(data);
    }

    @RequestMapping("/save")
    public Response save(ShopVipCard card) {
        card.setShopId(getAccountId());
        service.save(card);
        return Response.newSuccessResponse(card);
    }

    @Override
    protected IService<ShopVipCard> getService() {
        return this.service;
    }
}
