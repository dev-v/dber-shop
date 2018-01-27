package com.dber.shop.api.entity;

import lombok.Data;

/**
 * <li>文件名称: ShopSiteGroupBooking.java</li>
 * <li>修改记录: ...</li>
 * <li>内容摘要: ...</li>
 * <li>其他说明: ...</li>
 * 
 * @version 1.0
 * @since 2017年12月20日
 * @author dev-v
 */
@Data
public class ShopSiteGroupBooking {
	
	/**
	 * 
	 */
	private Long id;

	/**
	 * 
	 */
	private Long siteBookingId;

	/**
	 * 
	 */
	private Integer shopId;

	/**
	 * 
	 */
	private Long siteId;

	/**
	 * 团体教练id
	 */
	private Integer coacherId;

	/**
	 * 
	 */
	private Integer shopServiceId;

	/**
	 * 

针对团体课：
1-启用；
1-取消；
3-已过期；
	 */
	private Integer status;

	/**
	 * 团体教练的价格
	 */
	private Double coacherPrice;

	/**
	 * 
	 */
	private String shopName;

	/**
	 * 
	 */
	private String serviceName;

	/**
	 * 场馆名称冗余
	 */
	private String siteName;

	/**
	 * 顾客订场用户姓名（或昵称） 或团体教练姓名
	 */
	private String coacherName;

	/**
	 * 团体教练电话
	 */
	private String coacherCellphone;

	/**
	 * 场地预订事项描述 或 需求描述
	 */
	private String content;

	/**
	 * 
	 */
	private java.sql.Date bookingDate;

	/**
	 * 
	 */
	private Integer timeBegin;

	/**
	 * 
	 */
	private Integer timeEnd;

	/**
	 * 
	 */
	private java.sql.Date createTime;

	/**
	 * 
	 */
	private java.sql.Timestamp modifyTime;


}
