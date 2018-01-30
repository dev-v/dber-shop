package com.dber.shop.api.entity;

import lombok.Data;

/**
 * <li>文件名称: ShopPosition.java</li>
 * <li>修改记录: ...</li>
 * <li>内容摘要: ...</li>
 * <li>其他说明: ...</li>
 * 
 * @version 1.0
 * @since 2017年12月20日
 * @author dev-v
 */
@Data
public class ShopPosition {
	
	/**
	 * 店铺id
	 */
	private Integer id;

	/**
	 * 店铺名称冗余
	 */
	private String name;

	/**
	 * 纬度
	 */
	private Integer lat;

	/**
	 * 经度
	 */
	private Integer lng;


}
