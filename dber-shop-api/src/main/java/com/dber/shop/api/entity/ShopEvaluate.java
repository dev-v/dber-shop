package com.dber.shop.api.entity;

import lombok.Data;

/**
 * <li>文件名称: ShopEvaluate.java</li>
 * <li>修改记录: ...</li>
 * <li>内容摘要: ...</li>
 * <li>其他说明: ...</li>
 * 
 * @version 1.0
 * @since 2017年12月20日
 * @author dev-v
 */
@Data
public class ShopEvaluate {
	
	/**
	 * 
	 */
	private Long id;

	/**
	 * 
	 */
	private Integer shopId;

	/**
	 * 用户id
	 */
	private Integer accountId;

	/**
	 * 评价用户昵称(匿名显示***)
	 */
	private String name;

	/**
	 * 评价星数
	 */
	private Integer stars;

	/**
	 * 
	 */
	private String content;

	/**
	 * 
	 */
	private java.sql.Timestamp modifyTime;


}
