package com.dber.shop.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Repository;

import com.dber.base.mapper.IMapper;
import com.dber.shop.api.entity.ShopPosition;

import java.util.Collection;

/**
 * <li>文件名称: IShopPositionMapper.java</li>
 * <li>修改记录: ...</li>
 * <li>内容摘要: ...</li>
 * <li>其他说明: ...</li>
 *
 * @author dev-v
 * @version 1.0
 * @since 2017年12月20日
 */
@Repository
public interface IShopPositionMapper extends IMapper<ShopPosition> {
  @SelectProvider(type = IShopPositionMapperSql.class, method = "queryShopByPosition")
  Collection<ShopPosition> queryShopByPosition(@Param("leftTop") ShopPosition leftTop, @Param("rightBottom") ShopPosition rightBottom);

  @SelectProvider(type = IShopPositionMapperSql.class, method = "countByPosition")
  int countByPosition(@Param("leftTop") ShopPosition leftTop, @Param("rightBottom") ShopPosition rightBottom);


  static class IShopPositionMapperSql {
    public String queryShopByPosition() {
      return wrapCondition(new SQL().SELECT("id,name,lat,lng")).toString();

    }

    public String countByPosition() {
      return wrapCondition(new SQL().SELECT("count(*)")).toString();
    }

    private SQL wrapCondition(SQL sql) {
      return sql.FROM("shop_position")
              .WHERE("lat<#{leftTop.lat}")
              .WHERE("lat>#{rightBottom.lat}")
              .WHERE("lng>#{rightBottom.lng}")
              .WHERE("lng<#{leftTop.lng}");
    }
  }
}
