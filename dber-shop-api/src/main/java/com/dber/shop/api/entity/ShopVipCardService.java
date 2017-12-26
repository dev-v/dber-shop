package com.dber.shop.api.entity;

import lombok.Data;

/**
 * <li>文件名称: ShopVipCardService.java</li>
 * <li>修改记录: ...</li>
 * <li>内容摘要: ...</li>
 * <li>其他说明: ...</li>
 * 
 * @version 1.0
 * @since 2017年12月20日
 * @author dev-v
 */
@Data
public class ShopVipCardService {
	
	/**
	 * 
	 */
	private Integer id;

	/**
	 * 店铺年卡id
	 */
	private Integer shopVipCardId;

	/**
	 * 店铺服务id
	 */
	private Integer shopServiceId;


}
