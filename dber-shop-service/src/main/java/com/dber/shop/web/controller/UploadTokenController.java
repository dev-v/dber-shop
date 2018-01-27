package com.dber.shop.web.controller;

import com.dber.base.enums.ImgType;
import com.dber.shop.api.entity.ShopService;
import com.dber.shop.api.entity.ShopSite;
import com.dber.shop.service.IShopServiceService;
import com.dber.shop.service.IShopSiteService;
import com.dber.upload.api.AbstractUploadHelperController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * <li>修改记录: ...</li>
 * <li>内容摘要: ...</li>
 * <li>其他说明: ...</li>
 *
 * @author dev-v
 * @version 1.0
 * @since 2018/1/25
 */
@RestController
public class UploadTokenController extends AbstractUploadHelperController {

    @Autowired
    IShopServiceService shopServiceService;

    @Autowired
    IShopSiteService shopSiteService;

    protected boolean validAuth(int accountId, int imgType, long bsId) {
        if (ImgType.SHOP.is(imgType) || ImgType.MATRIX_CODE.is(imgType)) {
            if (accountId == bsId) {
                return true;
            }
        } else if (ImgType.SHOP_SERVICE.is(imgType)) {
            ShopService shopService = new ShopService();
            shopService.setShopId(accountId);
            shopService.setId((int) bsId);
            if (shopServiceService.has(shopService)) {
                return true;
            }
        } else if (ImgType.SHOP_SITE.is(imgType)) {
            ShopSite shopSite = new ShopSite();
            shopSite.setShopId(accountId);
            shopSite.setId(bsId);
            if (shopSiteService.has(shopSite)) {
                return true;
            }
        }
        return false;
    }
}
