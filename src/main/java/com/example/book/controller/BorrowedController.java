package com.example.book.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.book.Entity.Author;
import com.example.book.Entity.Borrowed;
import com.example.book.Service.BorrowedService;
import com.example.book.util.R;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/borrowed")
public class BorrowedController {
    @Autowired
    private BorrowedService borrowedService;


}
