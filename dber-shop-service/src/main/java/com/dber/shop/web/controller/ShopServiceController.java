package com.dber.shop.web.controller;

import com.dber.base.service.IService;
import com.dber.base.web.controller.AbstractReadController;
import com.dber.base.entity.Response;
import com.dber.shop.api.entity.ShopService;
import com.dber.shop.service.IShopServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * <li>文件名称: ShopServiceController.java</li>
 * <li>修改记录: ...</li>
 * <li>内容摘要: ...</li>
 * <li>其他说明: ...</li>
 *
 * @author dev-v
 * @version 1.0
 * @since 2017年12月21日
 */
@RestController
@RequestMapping("/shop_service")
public class ShopServiceController extends AbstractReadController<ShopService> {

    @Autowired
    private IShopServiceService service;

    @RequestMapping("/save")
    public Response<ShopService> save(ShopService shopService) {
        shopService.setShopId(getAccountId());
//        if (shopService.getId() == null && YesNo.YES.is(shopService.getShareSite())) {
//            shopService.setCount(1);
//        }
        service.save(shopService);
        return Response.newSuccessResponse(shopService);
    }

    @Override
    public Response<Collection<ShopService>> queryWithoutPage(ShopService data) {
        data.setShopId(getAccountId());
        return super.queryWithoutPage(data);
    }

    @Override
    protected IService<ShopService> getService() {
        return this.service;
    }
}