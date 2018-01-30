package com.dber.shop.web.pub;

import com.dber.base.entity.Response;
import com.dber.shop.api.entity.ShopPosition;
import com.dber.shop.api.entity.ShopSiteBooking;
import com.dber.shop.service.IShopPositionService;
import com.dber.shop.service.IShopSiteBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <li>修改记录: ...</li>
 * <li>内容摘要: ...</li>
 * <li>其他说明: ...</li>
 *
 * @author dev-v
 * @version 1.0
 * @since 2018/1/18
 */
@RestController
@RequestMapping("/pub/")
public class ShopPublicController {

    @Autowired
    private IShopSiteBookingService siteBookingService;

    @Autowired
    private IShopPositionService positionService;

    /**
     * 根据日期和场地id查询有效的场地预订情况
     *
     * @return
     */
    @RequestMapping("getSiteBookings")
    public Response getSiteBookings(ShopSiteBooking siteBooking) {
        if (siteBooking.getSiteId() == null || siteBooking.getBookingDate() == null) {
            return Response.newFailureResponse("参数错误！");
        }
        siteBooking.setStatus(1);
        return Response.newSuccessResponse(siteBookingService.queryWithoutPage(siteBooking));
    }

    @RequestMapping("getShopPosition/{shopId}")
    public Response<ShopPosition> getShopPosition(@PathVariable("shopId") int shopId) {
        return Response.newSuccessResponse(positionService.get(shopId));
    }
}
