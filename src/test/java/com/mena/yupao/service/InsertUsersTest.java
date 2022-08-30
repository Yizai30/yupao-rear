package com.mena.yupao.service;

import com.mena.yupao.model.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@SpringBootTest
public class InsertUsersTest {

    @Resource
    private UserService userService;

    private final ExecutorService executorService = new ThreadPoolExecutor(7, 1000,
            10000, TimeUnit.MINUTES, new ArrayBlockingQueue<>(10000));

    /**
     * 批量插入用户
     */
    @Test
    public void doInsertUsers() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        final int INSERT_NUM = 100000;
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < INSERT_NUM; i++) {
            User user = new User();
            user.setUsername("假用户");
            user.setUserAccount("fakemena");
            user.setAvatarUrl("https://s2.loli.net/2022/08/13/nyW9ViMBht85GeJ.png");
            user.setGender((byte)0);
            user.setUserPassword("12345678");
            user.setPhone("413243213");
            user.setEmail("3213r2@qq.com");
            user.setUserStatus(0);
            user.setUserRole(0);
            user.setPlanetCode("3213");
            user.setTags("[]");
            userList.add(user);
        }
        userService.saveBatch(userList, 10000);
        stopWatch.stop();
        // 30 秒 10 万条
        System.out.println(stopWatch.getTotalTimeMillis());
    }

    /**
     * 并发批量插入用户
     */
    @Test
    public void doConcurrencyInsertUsers() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        final int INSERT_NUM = 100000;
        // 分成 20 组
        int batchSize = 5000;
        int j = 0;
        List<CompletableFuture<Void>> futureList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            List<User> userList = new ArrayList<>();
            while (true) {
                j++;
                User user = new User();
                user.setUsername("假用户");
                user.setUserAccount("fakemena");
                user.setAvatarUrl("https://s2.loli.net/2022/08/13/nyW9ViMBht85GeJ.png");
                user.setGender((byte)0);
                user.setUserPassword("12345678");
                user.setPhone("413243213");
                user.setEmail("3213r2@qq.com");
                user.setUserStatus(0);
                user.setUserRole(0);
                user.setPlanetCode("3213");
                user.setTags("[]");
                userList.add(user);
                if (j % batchSize == 0) {
                    break;
                }
            }
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                System.out.println("ThreadName: " + Thread.currentThread().getName());
                userService.saveBatch(userList, batchSize);
            }, executorService);
            futureList.add(future);

        }
        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[]{})).join();
        stopWatch.stop();
        // 10 秒 10 万条
        System.out.println(stopWatch.getTotalTimeMillis());
    }
}
