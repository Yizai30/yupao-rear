package com.mena.yupao.service;

import com.mena.yupao.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

@SpringBootTest
public class RedisTest {

    @Resource
    private RedisTemplate redisTemplate;

    @Test
    void test() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        // 增
        valueOperations.set("yizaiString", "cat");
        valueOperations.set("yizaiInt", 1);
        valueOperations.set("yizaiDouble", 3.0);
        User user = new User();
        user.setId(1L);
        user.setUsername("yizai");
        valueOperations.set("yizaiUser", user);
        // 查
        Object yizai = valueOperations.get("yizaiString");
        Assertions.assertTrue("cat".equals((String) yizai));
        yizai = valueOperations.get("yizaiInt");
        Assertions.assertTrue(1 == (Integer) yizai);
        yizai = valueOperations.get("yizaiDouble");
        Assertions.assertTrue(3.0 == (Double) yizai);
        System.out.println(valueOperations.get("yizaiUser"));
        // 改
        valueOperations.set("yizaiString", "catcat");
        // 删
        redisTemplate.delete("yizaiDouble");
    }
}
