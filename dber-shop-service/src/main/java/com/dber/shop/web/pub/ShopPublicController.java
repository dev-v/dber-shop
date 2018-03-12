package com.dber.shop.web.pub;

import com.dber.base.entity.Response;
import com.dber.shop.api.entity.*;
import com.dber.shop.api.entity.ShopService;
import com.dber.shop.api.entity.ShopVipCardService;
import com.dber.shop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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

  @Autowired
  private IShopService shopService;

  @Autowired
  private IShopServiceService shopServiceService;

  @Autowired
  private IShopSiteService shopSiteService;

  @Autowired
  private IShopGroupService shopGroupService;

  @Autowired
  private IShopVipCardService shopVipCardService;

  @Autowired
  private IShopVipCardServiceService shopVipCardServiceService;

  /**
   * 根据坐标信息查询范围内的店铺
   *
   * @return
   */
  @RequestMapping("queryShopByPosition")
  public Response<Collection<ShopPosition>> queryShopByPosition(Location location) {
    return Response.newSuccessResponse(positionService.queryShopByPosition(location.getLeftTop(), location.getRightBottom()));
  }

  /**
   * 根据坐标信息查询范围内的店铺
   *
   * @return
   */
  @RequestMapping("countShopByPosition")
  public Response<Integer> countByPosition(Location location) {
    return Response.newSuccessResponse(positionService.countByPosition(location.getLeftTop(), location.getRightBottom()));
  }

  /**
   * 根据坐标信息查询范围内的店铺
   *
   * @return
   */
//  @RequestMapping("countShopByPosition")
//  public Response<Integer> countByPosition(Map<String, ShopPosition> params) {
//    return Response.newSuccessResponse(positionService.countByPosition(params.get("leftTop"), params.get("rightBottom")));
//  }

  /**
   * 查询店铺坐标信息
   *
   * @param shopId
   * @return
   */
  @RequestMapping("getShopPosition/{shopId}")
  public Response<ShopPosition> getShopPosition(@PathVariable("shopId") int shopId) {
    return Response.newSuccessResponse(positionService.get(shopId));
  }

  /**
   * 获取店铺详情信息
   *
   * @param shopId
   * @return
   */
  @RequestMapping("getShopDetail/{shopId}")
  public Response<Shop> getShopDetail(@PathVariable("shopId") int shopId) {
    return Response.newSuccessResponse(shopService.get(shopId));
  }

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

  /**
   * 根据场地日期及场地id集合 查询所有有效的场地预订情况
   *
   * @param date
   * @param siteIds
   * @return
   */
  @RequestMapping("getAllSiteBookings")
  public Response getAllSiteBookings(@ModelAttribute("date") Date date, @ModelAttribute("siteIds") long[] siteIds) {
    ShopSiteBooking siteBooking = new ShopSiteBooking();
    siteBooking.setBookingDate(date);
    siteBooking.setStatus(1);
    Map<Long, Collection<ShopSiteBooking>> result = new HashMap<>();
    for (long id : siteIds) {
      siteBooking.setSiteId(id);
      result.put(id, siteBookingService.queryWithoutPage(siteBooking));
    }
    return Response.newSuccessResponse(result);
  }

  /**
   * 根据店铺服务id查询服务场地
   *
   * @param shopServiceId
   * @return
   */
  @RequestMapping("getSites/{shopServiceId}")
  public Response<Collection<ShopSite>> getSites(@PathVariable("shopServiceId") int shopServiceId) {
    ShopSite site = new ShopSite();
    site.setShopServiceId(shopServiceId);
    return Response.newSuccessResponse(shopSiteService.queryWithoutPage(site));
  }

  /**
   * 根据店铺id查询所有店铺服务场地
   *
   * @param shopId
   * @return
   */
  @RequestMapping("getShopSites/{shopId}")
  public Response<Collection<ShopSite>> getShopSites(@PathVariable("shopId") int shopId) {
    ShopSite site = new ShopSite();
    site.setShopId(shopId);
    return Response.newSuccessResponse(shopSiteService.queryWithoutPage(site));
  }

  /**
   * 获取店铺服务列表
   *
   * @param shopId
   * @return
   */
  @RequestMapping("getServices/{shopId}")
  public Response<Collection<ShopService>> getServices(@PathVariable("shopId") int shopId) {
    ShopService shopService = new ShopService();
    shopService.setShopId(shopId);
    shopService.setStatus(2);
    return Response.newSuccessResponse(shopServiceService.queryWithoutPage(shopService));
  }

  /**
   * 获取店铺团体课程列表
   *
   * @param shopId
   * @return
   */
  @RequestMapping("getGroups/{shopId}")
  public Response<Collection<ShopGroup>> getGroups(@PathVariable("shopId") int shopId) {
    ShopGroup group = new ShopGroup();
    group.setShopId(shopId);
    group.setStatus(1);
    return Response.newSuccessResponse(shopGroupService.queryWithoutPage(group));
  }

  /**
   * 获取店铺会员卡
   *
   * @param shopId
   * @return
   */
  @RequestMapping("getVipCards/{shopId}")
  public Response<Collection<ShopVipCard>> getVipCards(@PathVariable("shopId") int shopId) {
    ShopVipCard vipCard = new ShopVipCard();
    vipCard.setShopId(shopId);
    vipCard.setStatus(2);
    return Response.newSuccessResponse(shopVipCardService.queryWithoutPage(vipCard));
  }

  /**
   * 获取vip-card绑定的服务
   *
   * @param vipCardId
   * @return
   */
  @RequestMapping("getVipCardService/{vipCardId}")
  public Response<Collection<ShopVipCardService>> getVipCardService(@PathVariable("vipCardId") int vipCardId) {
    ShopVipCardService vipCardService = new ShopVipCardService();
    vipCardService.setShopVipCardId(vipCardId);
    return Response.newSuccessResponse(shopVipCardServiceService.queryWithoutPage(vipCardService));
  }

}
