package com.dber.shop.web.controller;

import com.dber.base.entity.Response;
import com.dber.base.service.IService;
import com.dber.base.web.controller.AbstractReadController;
import com.dber.shop.api.entity.ShopPosition;
import com.dber.shop.service.IShopPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <li>文件名称: ShopPositionController.java</li>
 * <li>修改记录: ...</li>
 * <li>内容摘要: ...</li>
 * <li>其他说明: ...</li>
 *
 * @author dev-v
 * @version 1.0
 * @since 2017年12月21日
 */
@RestController
@RequestMapping("/shop_position")
public class ShopPositionController extends AbstractReadController<ShopPosition> {

    @Autowired
    private IShopPositionService service;

    @RequestMapping("/save")
    public Response<ShopPosition> save(ShopPosition position) {
        position.setId(getAccountId());
        service.save(position);
        return Response.newSuccessResponse(position);
    }

    @Override
    protected IService<ShopPosition> getService() {
        return this.service;
    }
}
