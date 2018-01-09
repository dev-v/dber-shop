package com.dber.shop;

import com.dber.shop.config.ShopAppConfig;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@SpringBootApplication
@Import(ShopAppConfig.class)
public class ApplicationTest {

    public static void main(String[] args) {
        SpringApplication.run(ShopAppConfig.class,args);
    }

}
