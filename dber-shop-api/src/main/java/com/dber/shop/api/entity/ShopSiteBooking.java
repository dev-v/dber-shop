package com.dber.shop.api.entity;

import java.sql.Date;
import java.sql.Time;

import lombok.Data;

/**
 * <li>文件名称: ShopSiteBooking.java</li>
 * <li>修改记录: ...</li>
 * <li>内容摘要: ...</li>
 * <li>其他说明: ...</li>
 * 
 * @version 1.0
 * @since 2017年12月20日
 * @author dev-v
 */
@Data
public class ShopSiteBooking {
	
	/**
	 * 使用shop_site_booking_detail表的id，与其一一对应
	 */
	private Long id;

	/**
	 * 
	 */
	private Long siteId;

	/**
	 * 
	 */
	private Date bookingDate;

	/**
	 * 使用起始时间，单位分钟
	 */
	private Time timeBegin;

	/**
	 * 使用结束时间
	 */
	private Time timeEnd;


}
