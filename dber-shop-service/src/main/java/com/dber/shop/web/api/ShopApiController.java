package com.dber.shop.web.api;

import com.dber.base.IClient;
import com.dber.base.entity.Response;
import com.dber.base.result.Page;
import com.dber.base.result.Result;
import com.dber.shop.api.entity.Shop;
import com.dber.shop.service.IShopService;
import com.dber.shop.service.IShopServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <li>修改记录: ...</li>
 * <li>内容摘要: 任何客户端api-server请务必实现IClient标记接口</li>
 * <li>访问需授权</li>
 * <li>本类获取数据时建议从数据源本身获取，redis等缓存建议在api-sdk上面做</li>
 * <li>其他说明: ...</li>
 *
 * @author dev-v
 * @version 1.0
 * @since 2018/1/12
 */
@RestController
@RequestMapping("/api/")
public class ShopApiController implements IClient {

    @Autowired
    private IShopService shopService;

    @Autowired
    IShopServiceService shopServiceService;

    @RequestMapping("save")
    public Result<Integer> save(Shop shop) {
        if (shop.getId() != null) {
            return Response.newSuccessResponse(shopService.save(shop)).toResult();
        }
        return Response.newSuccessResponse(0).toResult();
    }

    @RequestMapping("setBasePrice")
    public Result<Integer> setBasePrice(Shop shop) {
        return Response.newSuccessResponse(shopService.setBasePrice(shop)).toResult();
    }

    @RequestMapping("query/{currentPage}")
    public Result<Page<Shop>> query(@PathVariable("currentPage") int page, Shop shop) {
        Page<Shop> page1 = new Page<>(page);
        page1.setCondition(shop);
        page1.setSort("id desc");
        shopService.query(page1);
        return Response.newSuccessResponse(page1).toResult();
    }

}
