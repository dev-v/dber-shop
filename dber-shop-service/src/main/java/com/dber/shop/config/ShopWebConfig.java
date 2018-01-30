package com.dber.shop.config;

import com.dber.base.config.BaseWebConfig;
import com.dber.shop.web.clients.ShopLoginHelper;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * <li>文件名称: WebConfig.java</li>
 * <li>修改记录: ...</li>
 * <li>内容摘要: ...</li>
 * <li>其他说明: ...</li>
 *
 * @author dev-v
 * @version 1.0
 * @since 2017年12月21日
 */
@Configuration
@Import({ShopServiceConfig.class, BaseWebConfig.class, ShopLoginHelper.class})
@ComponentScan("com.dber.shop.web")
public class ShopWebConfig {
}
