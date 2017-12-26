package com.dber.shop.api.entity;

import java.sql.Date;
import java.sql.Timestamp;

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
	 * 场馆每小时出租或预约价格，单位分
	 */
	private Integer price;

	/**
	 * 
	 */
	private Date createTime;

	/**
	 * 
	 */
	private Timestamp modifyTime;


}
