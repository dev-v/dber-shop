package com.dber.shop.api;

import com.dber.base.result.Page;
import com.dber.base.result.Result;
import com.dber.shop.api.entity.Shop;

/**
 * <li>修改记录: ...</li>
 * <li>内容摘要: ...</li>
 * <li>其他说明: ...</li>
 *
 * @author chenw
 * @version 1.0
 * @since 2018/1/15
 */
public interface IShopClient {

    Result<Integer> save(Shop shop);

    Result<Integer> setBasePrice(Shop shop);

    Result<Page<Shop>> query(int currentPage, Shop shop);
}
