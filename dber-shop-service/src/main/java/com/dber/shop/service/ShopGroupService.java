package com.dber.shop.service;

import com.dber.base.enums.GroupCourseBooking;
import com.dber.base.result.Result;
import com.dber.plat.api.IPlatClient;
import com.dber.plat.api.entity.BookingStrategy;
import com.dber.shop.api.entity.ShopSite;
import com.dber.shop.api.entity.ShopSiteBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dber.base.mapper.IMapper;
import com.dber.base.service.AbstractService;
import com.dber.shop.api.entity.ShopGroup;
import com.dber.shop.mapper.IShopGroupMapper;
import org.springframework.transaction.annotation.Transactional;

/**
 * <li>文件名称: ShopGroupService.java</li>
 * <li>修改记录: ...</li>
 * <li>内容摘要: ...</li>
 * <li>其他说明: ...</li>
 * 
 * @version 1.0
 * @since 2017年12月20日
 * @author dev-v
 */
@Service
public class ShopGroupService extends AbstractService<ShopGroup> implements IShopGroupService {

	@Autowired
	private IShopGroupMapper mapper;

	@Autowired
	private IShopSiteBookingService siteBookingService;

	@Autowired
	private IShopSiteService siteService;

	@Autowired
	private IPlatClient platClient;

	@Transactional
	@Override
	public int save(ShopGroup group) {
		ShopSite site = new ShopSite();
		site.setId(group.getSiteId());
		site.setShopId(group.getShopId());
		site = siteService.queryOne(site);
		if (site == null) {//不属于自己的场地
			throw new IllegalArgumentException("非法请求！");
		}

		int count = 0;
		if (GroupCourseBooking.CANCEL.is(group.getStatus())) {//取消操作
			if (group.getSiteBookingId() == null) {
				throw new IllegalArgumentException("非法请求！");
			}
		}

		Result<BookingStrategy> bookingStrategyResult = platClient.getGroupBookingStrategy();
		if (bookingStrategyResult.isSuccess()) {
			BookingStrategy strategy = bookingStrategyResult.getResponse();
			int span = group.getTimeEnd() - group.getTimeBegin();
			if (span < strategy.getBookShortestTime() || span > strategy.getBookLongestTime()) {
				throw new IllegalArgumentException("预约时长需为：【" + strategy.getBookShortestTime() + '-' + strategy.getBookLongestTime() + "】分钟！");
			}
			ShopSiteBooking siteBooking = new ShopSiteBooking();
			siteBooking.setId(group.getSiteBookingId());
			siteBooking.setSiteId(group.getSiteId());
			siteBooking.setBookingDate(group.getBookingDate());
			siteBooking.setTimeBegin(group.getTimeBegin());
			siteBooking.setTimeEnd(group.getTimeEnd());
			if (siteBookingService.hasBooking(siteBooking)) {
				throw new IllegalArgumentException("预约的部分时间段已被预约！");
			}
			siteBooking.setStatus(group.getStatus());
			count = siteBookingService.save(siteBooking);
			group.setSiteBookingId(siteBooking.getId());

			if (count > 0) {
				//保存数据
				count = super.save(group);
			}
		}
		return count;
	}

	@Override
	protected IMapper<ShopGroup> getMapper() {
		return this.mapper;
	}

}
