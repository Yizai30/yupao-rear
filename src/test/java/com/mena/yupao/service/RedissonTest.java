package com.mena.yupao.service;

import org.junit.jupiter.api.Test;
import org.redisson.api.RList;
import org.redisson.api.RLock;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class RedissonTest {

    @Resource
    private RedissonClient redissonClient;

    @Test
    void test() {
        // list
        // 1. 数据存储在本地 JVM 中
        List<String> list = new ArrayList<>();
        list.add("yizai");
        System.out.println("list: " + list.get(0));
        list.remove(0);

        // 2. 数据存在 redis 的内存中
        RList<String> rList = redissonClient.getList("test-list");
        rList.add("yizai");
        System.out.println("rList: " + rList.get(0));
        rList.remove(0);

        // map
        RMap<String, Integer> rMap = redissonClient.getMap("test-map");
        rMap.put("yizai",30);
        System.out.println("yizai: " + rMap.get("yizai"));
        rMap.remove("yizai");

        // set

        // stack


    }

    @Test
    void testWatchDog() {
        RLock lock = redissonClient.getLock("yizai:precachejob:docache:lock");
        try {
            // 只有一个线程能够获取到值
            if (lock.tryLock(0, -1, TimeUnit.MILLISECONDS)) {
                Thread.sleep(300000);
                System.out.println("CurrentThreadId: " + Thread.currentThread().getId());
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            // 只能释放自己的锁
            if (lock.isHeldByCurrentThread()) {
                System.out.println("CurrentThreadId: " + Thread.currentThread().getId());
                lock.unlock();
            }
        }
    }
}
