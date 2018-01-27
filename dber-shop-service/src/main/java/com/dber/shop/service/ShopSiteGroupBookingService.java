package com.dber.shop.service;

import com.dber.base.enums.GroupCourseBooking;
import com.dber.base.mapper.IMapper;
import com.dber.base.result.Result;
import com.dber.base.service.AbstractService;
import com.dber.plat.api.IPlatClient;
import com.dber.plat.api.entity.BookingStrategy;
import com.dber.shop.api.entity.ShopSite;
import com.dber.shop.api.entity.ShopSiteBooking;
import com.dber.shop.api.entity.ShopSiteGroupBooking;
import com.dber.shop.mapper.IShopSiteGroupBookingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <li>文件名称: ShopSiteGroupBookingService.java</li>
 * <li>修改记录: ...</li>
 * <li>内容摘要: ...</li>
 * <li>其他说明: ...</li>
 *
 * @author dev-v
 * @version 1.0
 * @since 2017年12月20日
 */
@Service
public class ShopSiteGroupBookingService extends AbstractService<ShopSiteGroupBooking> implements IShopSiteGroupBookingService {

    @Autowired
    private IShopSiteGroupBookingMapper mapper;

    @Autowired
    private IShopSiteBookingService siteBookingService;

    @Autowired
    private IShopSiteService siteService;

    @Autowired
    private IPlatClient platClient;

    @Transactional
    @Override
    public int save(ShopSiteGroupBooking groupBooking) {
        ShopSite site = new ShopSite();
        site.setId(groupBooking.getSiteId());
        site.setShopId(groupBooking.getShopId());
        site = siteService.queryOne(site);
        if (site == null) {//不属于自己的场地
            throw new IllegalArgumentException("非法请求！");
        }

        int count = 0;
        if (GroupCourseBooking.CANCEL.is(groupBooking.getStatus())) {//取消操作
            if (groupBooking.getSiteBookingId() == null) {
                throw new IllegalArgumentException("非法请求！");
            }
        }

        Result<BookingStrategy> bookingStrategyResult = platClient.getGroupBookingStrategy();
        if (bookingStrategyResult.isSuccess()) {
            BookingStrategy strategy = bookingStrategyResult.getResponse();
            int span = groupBooking.getTimeEnd() - groupBooking.getTimeBegin();
            if (span < strategy.getBookShortestTime() || span > strategy.getBookLongestTime()) {
                throw new IllegalArgumentException("预约时长需为：【" + strategy.getBookShortestTime() + '-' + strategy.getBookLongestTime() + "】分钟！");
            }
            ShopSiteBooking siteBooking = new ShopSiteBooking();
            siteBooking.setId(groupBooking.getSiteBookingId());
            siteBooking.setSiteId(groupBooking.getSiteId());
            siteBooking.setBookingDate(groupBooking.getBookingDate());
            siteBooking.setTimeBegin(groupBooking.getTimeBegin());
            siteBooking.setTimeEnd(groupBooking.getTimeEnd());
            if (siteBookingService.hasBooking(siteBooking)) {
                throw new IllegalArgumentException("预约的部分时间段已被预约！");
            }
            siteBooking.setStatus(groupBooking.getStatus());
            count = siteBookingService.save(siteBooking);
            groupBooking.setSiteBookingId(siteBooking.getId());

            if (count > 0) {
                //保存数据
                count = super.save(groupBooking);
            }
        }
        return count;
    }

    @Override
    protected IMapper<ShopSiteGroupBooking> getMapper() {
        return this.mapper;
    }

}
