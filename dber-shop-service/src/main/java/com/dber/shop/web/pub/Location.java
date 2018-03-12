package com.dber.shop.web.pub;

import com.dber.shop.api.entity.ShopPosition;
import lombok.Data;

@Data
public class Location {

  private ShopPosition leftTop;

  private ShopPosition rightBottom;
}
