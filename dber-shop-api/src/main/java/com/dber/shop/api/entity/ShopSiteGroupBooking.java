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
	 * 团体教练id
	 */
	private Integer coacherId;

	/**
	 * 
	 */
	private Integer shopServiceId;

	/**
	 * 定制类型：1-店铺团体课程排课，2-顾客场地预约
	 */
	private Integer type;

	/**
	 * 状态（针对顾客）：
1-新建（待支付，客户端缓存，可提交或直接支付）；
2-待支付（已提交，服务端存储）；
3-未支付过期（每天检查一次）；
4-未支付取消；
5-待消费（已付款）；
6-已取消；
7-已消费；

针对团体课：
1-新建；
2-启用；
3-取消；
4-已过期；
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
	private java.sql.Time timeBegin;

	/**
	 * 
	 */
	private java.sql.Time timeEnd;

	/**
	 * 
	 */
	private java.sql.Date createTime;

	/**
	 * 
	 */
	private java.sql.Timestamp modifyTime;


}
