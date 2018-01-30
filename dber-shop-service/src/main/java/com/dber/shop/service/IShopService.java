package com.dber.shop.service;

import com.dber.base.service.IService;
import com.dber.shop.api.entity.Shop;

/**
 * <li>文件名称: IShopService.java</li>
 * <li>修改记录: ...</li>
 * <li>内容摘要: ...</li>
 * <li>其他说明: ...</li>
 *
 * @author dev-v
 * @version 1.0
 * @since 2017年12月20日
 */
public interface IShopService extends IService<Shop> {

    /**
     * 设置基础价格
     *
     * @param shop
     * @return
     */
    int setBasePrice(Shop shop);

    /**
     * 设置营业状态
     *
     * @return
     */
    int setBusinessStatus(long shopId);

    int setPrice(Shop shop);
}
