package com.hxt.cloud;

import com.hxt.cloud.entities.Pay;
import com.hxt.cloud.mapper.PayMapper;
import com.hxt.cloud.service.PayService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PayTest {

    @Resource
    private PayService payService;

    @Resource
    private PayMapper payMapper;

    @Test
    public void testGetById() {
//        Pay pay = payService.getById(1);
//        System.out.println(pay);

        List<Pay> pays = payMapper.selectAll();
        for (Pay pay : pays) {
            System.out.println(pay);
        }
    }
}
