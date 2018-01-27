package com.dber.shop.mapper;

import com.dber.base.mapper.IMapper;
import com.dber.shop.api.entity.ShopSiteBooking;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Repository;

/**
 * <li>文件名称: IShopSiteBookingMapper.java</li>
 * <li>修改记录: ...</li>
 * <li>内容摘要: ...</li>
 * <li>其他说明: ...</li>
 *
 * @author dev-v
 * @version 1.0
 * @since 2017年12月20日
 */
@Repository
public interface IShopSiteBookingMapper extends IMapper<ShopSiteBooking> {

    /**
     * 需要排除自己
     *
     * @param siteBooking
     * @return
     */
    @SelectProvider(type = IShopSiteBookingMapperSql.class, method = "hasBooking")
    int hasBooking(ShopSiteBooking siteBooking);

    public static class IShopSiteBookingMapperSql {
        public String hasBooking(ShopSiteBooking siteBooking) {
            return new SQL() {{
                SELECT("COUNT(*)").FROM("shop_site_booking");
                WHERE("site_id=#{siteId} and booking_date=#{bookingDate} " +
                        "and time_begin<#{timeEnd} and time_end>#{timeBegin}");
                if (siteBooking.getId() != null) {
                    WHERE("id<>#{id}");
                }
            }}.toString() + " LIMIT 1";
        }
    }
}
