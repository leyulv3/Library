package com.example.book.Service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.book.Entity.Author;
import com.example.book.mapper.AuthorMapper;
import com.example.book.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthorServiceImpl extends ServiceImpl<AuthorMapper, Author> implements AuthorService {
    @Autowired
    private AuthorService authorService;


}
