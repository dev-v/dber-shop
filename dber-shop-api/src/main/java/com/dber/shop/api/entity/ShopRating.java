package com.dber.shop.api.entity;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.Data;

/**
 * <li>文件名称: ShopRating.java</li>
 * <li>修改记录: ...</li>
 * <li>内容摘要: ...</li>
 * <li>其他说明: ...</li>
 * 
 * @version 1.0
 * @since 2017年12月20日
 * @author dev-v
 */
@Data
public class ShopRating {
	
	/**
	 * 
	 */
	private Long id;

	/**
	 * 
	 */
	private Integer shopId;

	/**
	 * 评价年月
	 */
	private Date yearMonth;

	/**
	 * 基本硬件分数（数据主要来自于shop表）
	 */
	private Integer baseScore;

	/**
	 * 服务项目分数（主要来自于service_item表）
	 */
	private Integer serviceItemScore;

	/**
	 * 当月顾客数量
	 */
	private Integer customerCount;

	/**
	 * 当月顾客评价平均分数（总分数*100/评价人数）
	 */
	private Integer customerEvaluateScore;

	/**
	 * 私教到店数量
	 */
	private Integer coacherCount;

	/**
	 * 私教评价平均分数（总分数*100/评价数量）
	 */
	private Integer coacherEvaluateScore;

	/**
	 * 店铺拥挤度
	 */
	private Integer congestionDegree;

	/**
	 * 最终分数
	 */
	private Integer score;

	/**
	 * 本月最终获评等级
	 */
	private Integer level;

	/**
	 * 评估常规消费价格
	 */
	private Integer evalutePrice;

	/**
	 * 
	 */
	private Timestamp modifyTime;


}
