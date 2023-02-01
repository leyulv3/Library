package com.example.book;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.book.Entity.UserLogin;
import com.example.book.Service.UserLoginService;
import com.example.book.mapper.BookMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookApplicationTests {
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private UserLoginService userLoginService;

    @Test
    public void changePassword() {
        UserLogin userLogin = new UserLogin();
        userLogin.setUserId("1111");
        userLogin.setUserPassword("1111");
        userLogin.setNewPassword("11111");
        System.out.println(userLogin);

        QueryWrapper qw = new QueryWrapper();
        qw.eq("user_id", userLogin.getUserId());
        qw.eq("user_password", userLogin.getUserPassword());
        UserLogin user = userLoginService.getOne(qw);
        userLogin.setUserPassword(userLogin.getNewPassword());
        if (user == null) {
            System.out.println("用户不存在");
        } else {
            userLoginService.updateById(userLogin);
            System.out.println("修改成功");
        }


    }

}
