package com.dber.shop.web.controller;

import com.dber.base.service.IService;
import com.dber.base.web.controller.AbstractReadController;
import com.dber.base.web.vo.Response;
import com.dber.shop.api.entity.ShopSite;
import com.dber.shop.service.IShopSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <li>文件名称: ShopSiteController.java</li>
 * <li>修改记录: ...</li>
 * <li>内容摘要: ...</li>
 * <li>其他说明: ...</li>
 *
 * @author dev-v
 * @version 1.0
 * @since 2017年12月21日
 */
@RestController
@RequestMapping("/shop_site")
public class ShopSiteController extends AbstractReadController<ShopSite> {

    @Autowired
    private IShopSiteService service;

    @RequestMapping("/save")
    public Response save(ShopSite data) {
        if (data.getShopServiceId() == null || data.getShopServiceId() < 1) {
            return Response.newFailureResponse("请先保存服务基本信息设置！");
        }
        data.setShopId(getAccountId());
        service.save(data);
        return Response.newSuccessResponse(data);
    }

    @RequestMapping("/del/{id}")
    public Response del(@PathVariable("id") long id) {
        ShopSite shopSite = new ShopSite();
        shopSite.setShopId(getAccountId());
        shopSite.setId(id);
        return Response.newSuccessResponse(service.del(shopSite));
    }

    @Override
    protected IService<ShopSite> getService() {
        return this.service;
    }
}
