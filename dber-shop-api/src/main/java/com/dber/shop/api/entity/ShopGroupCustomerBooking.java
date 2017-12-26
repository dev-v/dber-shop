package com.dber.shop.api.entity;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.Data;

/**
 * <li>文件名称: ShopGroupCustomerBooking.java</li>
 * <li>修改记录: ...</li>
 * <li>内容摘要: ...</li>
 * <li>其他说明: ...</li>
 * 
 * @version 1.0
 * @since 2017年12月20日
 * @author dev-v
 */
@Data
public class ShopGroupCustomerBooking {
	
	/**
	 * 
	 */
	private Long id;

	/**
	 * 
	 */
	private Long bookingDetailId;

	/**
	 * 
	 */
	private Integer customerId;

	/**
	 * 
	 */
	private Date createTime;

	/**
	 * 
	 */
	private Timestamp modifyTime;


}
