package com.example.book.Service;

import com.baomidou.mybatisplus.extension.service.IService;import com.example.book.Entity.Book;
import com.example.book.Entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserService extends IService<User> {
    boolean save(User user);
    boolean delete(int id);
    User getUser(Integer id);
    boolean updateUser(User user);
}
