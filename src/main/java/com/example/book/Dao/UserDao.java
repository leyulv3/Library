package com.example.book.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.book.Entity.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserDao extends BaseMapper<User> {
}