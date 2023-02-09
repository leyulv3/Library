package com.example.book.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.book.Entity.Author;
import com.example.book.Entity.Borrowed;
import com.example.book.Service.BookService;
import com.example.book.Service.BorrowedService;
import com.example.book.util.R;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//订单
@RestController
@RequestMapping("/borrowed")
public class BorrowedController {
    @Autowired
    private BorrowedService borrowedService;
    @Autowired
    private BookService bookService;

    /**
     * 新增订单
     *
     * @param bookId
     * @return
     */
    @PostMapping
    public R<String> save(@RequestParam String bookId, @RequestParam String userId) {
        return borrowedService.submintOrder(bookId, userId) ? R.success("借阅成功") : R.error("借阅失败");
    }

    /**
     * 分页查询
     *
     * @param page
     * @param pageSize
     * @return
     */

    //删除订单
    @DeleteMapping
    public R delete(String id) {
        return borrowedService.removeById(id) ? R.success("删除订单成功") : R.error("删除订单失败");
    }


}
