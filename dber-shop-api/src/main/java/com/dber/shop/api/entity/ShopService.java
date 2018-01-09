package com.dber.shop.api.entity;

import lombok.Data;

/**
 * <li>文件名称: ShopService.java</li>
 * <li>修改记录: ...</li>
 * <li>内容摘要: ...</li>
 * <li>其他说明: ...</li>
 * 
 * @version 1.0
 * @since 2017年12月20日
 * @author dev-v
 */
@Data
public class ShopService {
	
	/**
	 * 逻辑主键
	 */
	private Integer id;

	/**
	 * 
	 */
	private Integer shopId;

	/**
	 * 服务项目id
	 */
	private Integer serviceId;

	/**
	 * 服务名称冗余
	 */
	private String serviceName;

	/**
	 * 该场地、服务位置个数、最大容纳人数等的数量
	 */
	private Integer count;

	/**
	 * 服务类型：1-共享场地、2-独占场地、3-团体科目
	 */
	private Integer type;

	/**
	 * 是否允许私人教练：1-是，2-否
	 */
	private Integer coach;

	/**
	 * 状态：1-新建，2-启用，3-停用
	 */
	private Integer status;

	/**
	 * （团体课程或者订场的默认价格）服务价格
	 */
	private Double price;

	/**
	 * 
	 */
	private java.sql.Date createTime;

	/**
	 * 
	 */
	private java.sql.Timestamp modifyTime;


}
