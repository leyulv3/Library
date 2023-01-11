package com.example.book.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.book.Dao.UserDao;
import com.example.book.Entity.User;
import com.example.book.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public  class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public boolean save(User user) {
        return userDao.insert(user)>0;
    }

    @Override
    public boolean delete(int id) {
        return userDao.deleteById(id)>0;
    }

    @Override
    public User getUser(Integer id) {
        return userDao.selectById(id);
    }

    @Override
    public boolean updateUser(User user) {
        QueryWrapper qw = new QueryWrapper();
        qw.like("id",user.getId());
        return userDao.update(user, qw)>0;
    }
}