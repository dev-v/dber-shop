package com.dber.shop.web.controller;

import com.dber.base.entity.Response;
import com.dber.base.enums.ShopStatus;
import com.dber.base.service.IService;
import com.dber.base.web.controller.AbstractReadController;
import com.dber.shop.api.entity.Shop;
import com.dber.shop.service.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        resetShop(shop);
        service.save(shop);
        return Response.newSuccessResponse(shop);
    }

    /**
     * 申请开店
     *
     * @return
     */
    @RequestMapping("/apply")
    public Response<Shop> apply(Shop shop) {
        if (ShopStatus.NEW.is(shop.getStatus()) || ShopStatus.AUDIT_FAILURE.is(shop.getStatus())) {
            resetShop(shop);
            shop.setStatus(ShopStatus.AUDITING.getValue());
            service.save(shop);
            return Response.newSuccessResponse(shop);
        }
        return null;
    }

    /**
     * 询价
     *
     * @return
     */
    @RequestMapping("/enquiry")
    public Response<Shop> enquiry(Shop shop) {
        int status = shop.getStatus();
        if (ShopStatus.EVALUATE_BASE_PRICE.is(status) || ShopStatus.ENQUIRING.is(status) || ShopStatus.ENQUIRING_HIGHER.is(status) || ShopStatus.ENQUIRING_LOWER.is(status)) {
            resetShop(shop);
            shop.setStatus(ShopStatus.EVALUATE_BASE_PRICE.getValue());
            service.save(shop);
            return Response.newSuccessResponse(shop);
        }
        return null;
    }

    /**
     * 询价
     *
     * @return
     */
    @RequestMapping("/setPrice")
    public Response<Integer> setPrice(Shop shop) {
        int status = shop.getStatus();
        if (ShopStatus.BUSINESSING_NO_SERVICE.is(status) || ShopStatus.BUSINESSING_WITH_SERVICE.is(status) ||
                ShopStatus.BUSINESS_SUSPEND.is(status)) {
            double price = shop.getPrice();
            resetShop(shop);
            shop.setPrice(price);
            return Response.newSuccessResponse(service.setPrice(shop));
        }
        return null;
    }

    /**
     * 停业或休业（暂时只支持休业）
     *
     * @return
     */
    @RequestMapping("/stop")
    public Response<Shop> stop(Shop shop) {
        int status = shop.getStatus();
        if (ShopStatus.BUSINESSING_NO_SERVICE.is(status) || ShopStatus.BUSINESSING_WITH_SERVICE.is(status)) {
            resetShop(shop);
            shop.setStatus(ShopStatus.BUSINESS_SUSPEND.getValue());
            service.save(shop);
            return Response.newSuccessResponse(shop);
        }
        return null;
    }

    private void resetShop(Shop shop) {
        shop.setId(getAccountId());
        shop.setStatus(null);
        shop.setMatrixCodeId(null);
        shop.setLevel(null);
        shop.setScore(null);
        shop.setBasePrice(null);
        shop.setPrice(null);
    }

    @Override
    public IService<Shop> getService() {
        return this.service;
    }
}
