package com.dber.shop.api.entity;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.Data;

/**
 * <li>文件名称: ShopCustomerViewCount.java</li>
 * <li>修改记录: ...</li>
 * <li>内容摘要: ...</li>
 * <li>其他说明: ...</li>
 * 
 * @version 1.0
 * @since 2017年12月20日
 * @author dev-v
 */
@Data
public class ShopCustomerViewCount {
	
	/**
	 * 
	 */
	private Integer shopId;

	/**
	 * 统计日
	 */
	private Date date;

	/**
	 * 到店人数
	 */
	private Integer count;

	/**
	 * 
	 */
	private Timestamp modifyTime;


}
