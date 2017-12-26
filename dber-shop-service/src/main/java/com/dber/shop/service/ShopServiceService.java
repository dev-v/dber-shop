package com.dber.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dber.base.mapper.IMapper;
import com.dber.base.service.AbstractService;
import com.dber.shop.api.entity.ShopService;
import com.dber.shop.mapper.IShopServiceMapper;

/**
 * <li>文件名称: ShopServiceService.java</li>
 * <li>修改记录: ...</li>
 * <li>内容摘要: ...</li>
 * <li>其他说明: ...</li>
 * 
 * @version 1.0
 * @since 2017年12月20日
 * @author dev-v
 */
@Service
public class ShopServiceService extends AbstractService<ShopService> implements IShopServiceService {

	@Autowired
	private IShopServiceMapper mapper;

	@Override
	protected IMapper<ShopService> getMapper() {
		return this.mapper;
	}

}
