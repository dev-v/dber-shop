package com.dber.shop.api.entity;

import lombok.Data;

/**
 * <li>文件名称: ShopSite.java</li>
 * <li>修改记录: ...</li>
 * <li>内容摘要: ...</li>
 * <li>其他说明: ...</li>
 * 
 * @version 1.0
 * @since 2017年12月20日
 * @author dev-v
 */
@Data
public class ShopSite {
	
	/**
	 * 
	 */
	private Long id;

	/**
	 * 
	 */
	private Integer shopServiceId;

	/**
	 * 场馆或场地名称
	 */
	private String name;

	/**
	 * 场馆每小时出租或预约价格
	 */
	private Double price;

	/**
	 * 
	 */
	private java.sql.Date createTime;

	/**
	 * 
	 */
	private java.sql.Timestamp modifyTime;


}
