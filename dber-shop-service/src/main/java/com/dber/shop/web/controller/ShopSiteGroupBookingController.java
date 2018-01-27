package com.dber.shop.web.controller;

import com.dber.base.service.IService;
import com.dber.base.web.controller.AbstractReadController;
import com.dber.base.entity.Response;
import com.dber.shop.api.entity.ShopSiteGroupBooking;
import com.dber.shop.service.IShopSiteGroupBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <li>文件名称: ShopSiteGroupBookingController.java</li>
 * <li>修改记录: ...</li>
 * <li>内容摘要: ...</li>
 * <li>其他说明: ...</li>
 *
 * @author dev-v
 * @version 1.0
 * @since 2017年12月21日
 */
@RestController
@RequestMapping("/shop_site_group_booking")
public class ShopSiteGroupBookingController extends AbstractReadController<ShopSiteGroupBooking> {

    @Autowired
    private IShopSiteGroupBookingService service;

    @RequestMapping("/save")
    public Response save(ShopSiteGroupBooking groupBooking) {
        if (groupBooking.getBookingDate() == null || groupBooking.getSiteId() == null) {
            return Response.newFailureResponse("参数错误");
        }
        groupBooking.setShopId(getAccountId());
        service.save(groupBooking);
        return Response.newSuccessResponse(groupBooking);
    }

    @Override
    protected IService<ShopSiteGroupBooking> getService() {
        return this.service;
    }
}
