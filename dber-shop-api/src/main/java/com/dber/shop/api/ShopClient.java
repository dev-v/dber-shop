package com.dber.shop.api;

import com.dber.base.AbstractClient;
import com.dber.base.enums.DberSystem;
import com.dber.base.result.Page;
import com.dber.base.result.Result;
import com.dber.base.util.ResultTypeHelper;
import com.dber.shop.api.entity.Shop;
import org.springframework.stereotype.Service;

/**
 * <li>修改记录: ...</li>
 * <li>内容摘要: ...</li>
 * <li>其他说明: ...</li>
 *
 * @author dev-v
 * @version 1.0
 * @since 2018/1/11
 */
@Service
public class ShopClient extends AbstractClient implements IShopClient {
    public ShopClient() {
        super(DberSystem.SHOP);
    }

    @Override
    public Result<Integer> save(Shop shop) {
        return clientUtil.post("/api/save", shop, ResultTypeHelper.getType(Integer.class));
    }

    @Override
    public Result<Integer> setBasePrice(Shop shop) {
        return clientUtil.post("/api/setBasePrice", shop, ResultTypeHelper.getType(Integer.class));
    }

    @Override
    public Result<Page<Shop>> query(int currentPage, Shop shop) {
        return clientUtil.post("/api/query/" + currentPage, shop, ResultTypeHelper.getPageType(Shop.class));
    }
}
