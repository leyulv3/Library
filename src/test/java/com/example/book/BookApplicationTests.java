package com.example.book;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.book.Dao.UserDao;
import com.example.book.Entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookApplicationTests {
    @Autowired
    UserDao userDao;
    @Test
    void testGetBy(){
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.like("id","1");
        System.out.println(userDao.selectList(qw));
    }
}
