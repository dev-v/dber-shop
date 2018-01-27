package com.dber.shop.web.controller;

import com.dber.base.service.IService;
import com.dber.base.web.controller.AbstractReadController;
import com.dber.base.entity.Response;
import com.dber.shop.api.entity.ShopVipCardService;
import com.dber.shop.service.IShopVipCardServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <li>文件名称: ShopVipCardServiceController.java</li>
 * <li>修改记录: ...</li>
 * <li>内容摘要: ...</li>
 * <li>其他说明: ...</li>
 *
 * @author dev-v
 * @version 1.0
 * @since 2017年12月21日
 */
@RestController
@RequestMapping("/shop_vip_card_service")
public class ShopVipCardServiceController extends AbstractReadController<ShopVipCardService> {

    @Autowired
    private IShopVipCardServiceService service;

    @Override
    public Response queryWithoutPage(ShopVipCardService data) {
        if (data.getShopVipCardId() == null) {
            return Response.newFailureResponse("请选择会员卡！");
        }
        data.setShopId(getAccountId());
        return super.queryWithoutPage(data);
    }

    @RequestMapping("/save")
    public Response save(ShopVipCardService data) {
        data.setShopId(getAccountId());
        service.save(data);
        return Response.newSuccessResponse(data);
    }

    @RequestMapping("/delWithCondition")
    public Response delWithCondition(ShopVipCardService data) {
        data.setShopId(getAccountId());
        data.setServiceName(null);
        return Response.newSuccessResponse(service.del(data));
    }

    @Override
    protected IService<ShopVipCardService> getService() {
        return this.service;
    }
}
