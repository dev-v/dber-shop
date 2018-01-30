package com.dber.shop.web.clients;

import com.dber.base.entity.Account;
import com.dber.base.enums.ShopStatus;
import com.dber.plat.api.PlatLoginHelper;
import com.dber.shop.api.entity.Shop;
import com.dber.shop.service.IShopService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <li>修改记录: ...</li>
 * <li>内容摘要: ...</li>
 * <li>其他说明: ...</li>
 *
 * @author dev-v
 * @version 1.0
 * @since 2018/1/27
 */
public class ShopLoginHelper extends PlatLoginHelper {

    @Autowired
    private IShopService shopService;

    @Override
    protected void addAccount(Account account) {
        Shop shop = new Shop();
        shop.setId(account.getId());
        shop.setStatus(ShopStatus.NEW.getValue());
        shopService.save(shop);
    }
}
