package com.dber.shop.api.entity;

import lombok.Data;

/**
 * <li>文件名称: Shop.java</li>
 * <li>修改记录: ...</li>
 * <li>内容摘要: ...</li>
 * <li>其他说明: ...</li>
 * 
 * @version 1.0
 * @since 2017年12月20日
 * @author dev-v
 */
@Data
public class Shop {
	
	/**
	 * 实际为account_id(所属账号id)
	 */
	private Integer id;

	/**
	 * 店铺名称（全名）
	 */
	private String name;

	/**
	 * 店铺详细地址
	 */
	private String address;

	/**
	 * 店铺服务电话
	 */
	private String tellphone;

	/**
	 * 店长（经理）
	 */
	private String manager;

	/**
	 * 店长（经理）电话
	 */
	private String managerPhone;

	/**
	 * 营业开始时间
	 */
	private Integer businessBegin;

	/**
	 * 营业结束时间
	 */
	private Integer businessEnd;

	/**
	 * 占地面积（建筑或室内），单位平米
	 */
	private Integer area;

	/**
	 * 是否连锁经营：1-是、2-否
	 */
	private Integer chain;

	/**
	 * 
	 */
	private Integer bathing;

	/**
	 * 
	 */
	private Integer sauna;

	/**
	 * 
	 */
	private Integer airSystem;

	/**
	 * 
	 */
	private String physicalTesting;

	/**
	 * 店铺状态：
1-新注册
2-通过认证询问门店价格（同意变4、拒绝重新设置门店价格（不得超过询问价的150%）然后进入4）
3-重新申请门店期望价格
4-通过认证（没有服务启用提供）
5-正常营业（通过认证，并且有服务启用提供）
6-休业
7-关闭
	 */
	private Integer status;

	/**
	 * 店铺二维码图片id
	 */
	private Integer matrixCodeId;

	/**
	 * 当前店铺分数
	 */
	private Integer score;

	/**
	 * 当前店铺级别（未来需要有级别代号）
	 */
	private Integer level;

	/**
	 * 
	 */
	private Double basePrice;

	/**
	 * 期望常规消费价，单位分
	 */
	private Integer expectPrice;

	/**
	 * 实际常规消费价
	 */
	private Double price;

	/**
	 * 店铺主页图片
	 */
	private Integer imgId;

	/**
	 * 
	 */
	private java.sql.Date createTime;

	/**
	 * 
	 */
	private java.sql.Timestamp modifyTime;


}
