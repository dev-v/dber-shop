package com.dber.shop.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ShopClient.class)
public class ShopClientTest {

    @Autowired
    private ShopClient client;

    @Test
    public void test(){
        System.out.println(client.test());
    }
}
