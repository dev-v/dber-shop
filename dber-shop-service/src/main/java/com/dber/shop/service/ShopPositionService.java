package com.dber.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dber.base.mapper.IMapper;
import com.dber.base.service.AbstractService;
import com.dber.shop.api.entity.ShopPosition;
import com.dber.shop.mapper.IShopPositionMapper;

import java.util.Collection;

/**
 * <li>文件名称: ShopPositionService.java</li>
 * <li>修改记录: ...</li>
 * <li>内容摘要: ...</li>
 * <li>其他说明: ...</li>
 *
 * @author dev-v
 * @version 1.0
 * @since 2017年12月20日
 */
@Service
public class ShopPositionService extends AbstractService<ShopPosition> implements IShopPositionService {

  @Autowired
  private IShopPositionMapper mapper;

  @Override
  protected IMapper<ShopPosition> getMapper() {
    return this.mapper;
  }

  @Override
  public Collection<ShopPosition> queryShopByPosition(ShopPosition leftTop, ShopPosition rightBottom) {
    return mapper.queryShopByPosition(leftTop, rightBottom);
  }

  @Override
  public int countByPosition(ShopPosition leftTop, ShopPosition rightBottom) {
    return mapper.countByPosition(leftTop, rightBottom);
  }
}
