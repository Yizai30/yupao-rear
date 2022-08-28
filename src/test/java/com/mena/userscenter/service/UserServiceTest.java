package com.mena.userscenter.service;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.mena.userscenter.model.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 用户服务测试
 *
 * @author Mena
 */
@SpringBootTest
public class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void testAddUser() {
        User user = new User();
        user.setUsername("yizai");
        user.setUserAccount("123");
        user.setAvatarUrl("https://cdn.nlark.com/yuque/0/2022/png/29695607/1660182740221-avatar/0a4871da-b52c-4cfc-8f9a-b74d8f18429d.png?x-oss-process=image%2Fresize%2Cm_fill%2Cw_112%2Ch_112%2Fformat%2Cpng");
        user.setGender((byte)0);
        user.setUserPassword("xxx");
        user.setPhone("123");
        user.setEmail("456");
        boolean result = userService.save(user);
        System.out.println(user.getId());
        assertTrue(result);
    }

    @Test
    void userRegister() {
        // 非空
        String userAccount = "mena";
        String userPassword = "";
        String checkPassword = "12345678";
        String planetCode = "1";
        long result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        assertEquals(-1, result);
        // 账户不少于 4 位
        userAccount = "me";
        result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        assertEquals(-1, result);
        // 密码不少于 8 位
        userAccount = "mena";
        userPassword = "123456";
        result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        assertEquals(-1, result);
        // 账户不包含特殊字符
        userAccount = "me na";
        userPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        assertEquals(-1, result);
        // 密码和校验密码相同
        userAccount = "mena";
        checkPassword = "123456789";
        result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        assertEquals(-1, result);
        // 注册成功（首次），注册失败（不能重复）
        checkPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
//        assertTrue(result > 0);
        assertEquals(-1, result);
    }

    @Test
    public void testSearchUsersByTags() {
        List<String> tagNameList = Arrays.asList("java", "python");
        List<User> userList = userService.searchUsersByTags(tagNameList);
        assertNotNull(userList);
    }
}