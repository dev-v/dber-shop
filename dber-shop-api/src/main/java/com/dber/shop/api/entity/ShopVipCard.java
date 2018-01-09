package com.dber.shop.api.entity;

import lombok.Data;

/**
 * <li>文件名称: ShopVipCard.java</li>
 * <li>修改记录: ...</li>
 * <li>内容摘要: ...</li>
 * <li>其他说明: ...</li>
 * 
 * @version 1.0
 * @since 2017年12月20日
 * @author dev-v
 */
@Data
public class ShopVipCard {
	
	/**
	 * 
	 */
	private Integer id;

	/**
	 * 
	 */
	private Integer shopId;

	/**
	 * 年卡所使用的策略id
	 */
	private Integer cardStrategyId;

	/**
	 * 
	 */
	private String cardName;

	/**
	 * 真实价格
	 */
	private Double price;

	/**
	 * 销售数量
	 */
	private Integer count;

	/**
	 * 转让中的数量
	 */
	private Integer transferingCount;

	/**
	 * 已转让数量
	 */
	private Integer transferedCount;

	/**
	 * 状态：1-待用，2-启用（同一个店铺使用同一策略的年卡只能启用一张），3-停用
	 */
	private Integer status;

	/**
	 * 
	 */
	private java.sql.Date createTime;

	/**
	 * 
	 */
	private java.sql.Timestamp modifyTime;


}
