package com.dber.shop.service;

import com.dber.base.service.IService;
import com.dber.shop.api.entity.ShopPosition;

import java.util.Collection;

/**
 * <li>文件名称: IShopPositionService.java</li>
 * <li>修改记录: ...</li>
 * <li>内容摘要: ...</li>
 * <li>其他说明: ...</li>
 *
 * @author dev-v
 * @version 1.0
 * @since 2017年12月20日
 */
public interface IShopPositionService extends IService<ShopPosition> {

  Collection<ShopPosition> queryShopByPosition(ShopPosition leftTop, ShopPosition rightBottom);

  int countByPosition(ShopPosition leftTop, ShopPosition rightBottom);
}
