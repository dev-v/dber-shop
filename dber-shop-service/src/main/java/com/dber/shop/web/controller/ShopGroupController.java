package com.dber.shop.web.controller;

import com.dber.base.entity.Response;
import com.dber.base.service.IService;
import com.dber.base.web.controller.AbstractReadController;
import com.dber.shop.api.entity.ShopGroup;
import com.dber.shop.service.IShopGroupService;
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
@RequestMapping("/shop_group")
public class ShopGroupController extends AbstractReadController<ShopGroup> {

    @Autowired
    private IShopGroupService service;

    @RequestMapping("/save")
    public Response save(ShopGroup group) {
        if (group.getBookingDate() == null || group.getSiteId() == null) {
            return Response.newFailureResponse("参数错误");
        }
        group.setShopId(getAccountId());
        service.save(group);
        return Response.newSuccessResponse(group);
    }

    @Override
    protected IService<ShopGroup> getService() {
        return this.service;
    }
}
