package com.example.book.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.book.Entity.Borrowed;
import com.example.book.Service.BookService;
import com.example.book.Service.BorrowedService;
import com.example.book.dto.OrderDto;
import com.example.book.util.R;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

//订单
@RestController
@RequestMapping("/borrowed")
public class BorrowedController {
    @Autowired
    private BorrowedService borrowedService;
    @Autowired
    private BookService bookService;

    /**
     * 借书
     *
     * @param borrowed
     * @return
     */
    @PostMapping("/save")
    public R<String> save(@RequestBody Borrowed borrowed) {
        return borrowedService.submintOrder(borrowed);
    }

    /**
     * 归还书籍
     *
     * @param borrowed
     * @return
     */
    @PostMapping("/return")
    public R returnBook(@RequestBody Borrowed borrowed) {
        return borrowedService.returnBook(borrowed);
    }

    /**
     * 分页查询
     *
     * @param page
     * @param pageSize
     * @param id
     * @return
     */
    @PostMapping("/list")
    public R<Page> page(int page, int pageSize, String id,String status) {

        //分页查询
        //构造分页对象
        Page<Borrowed> borrowedPage = new Page<>(page, pageSize);
        Page<OrderDto> orderDtoPage = new Page<>();
        //构造查询条件
        LambdaQueryWrapper<Borrowed> qw = new LambdaQueryWrapper<>();
        //添加过滤条件
        qw.like(StringUtils.isNotEmpty(id), Borrowed::getBorrowedId, id);
        qw.like(StringUtils.isNotEmpty(status), Borrowed::getBorrowStatus, status);
        //排序
        qw.orderByDesc(Borrowed::getBorrowedId);
        //执行查询
        borrowedService.page(borrowedPage, qw);

        //将查询结果封装到dto中
        BeanUtils.copyProperties(borrowedPage, orderDtoPage, "records");
        List<Borrowed> records = borrowedPage.getRecords();
        //将查询结果转换为dto
        List<OrderDto> list = records.stream().map(borrowed -> {
            //计算借阅时长
            Long day = borrowed.getBorrowedEndDate() == null ? Duration.between(borrowed.getBorrowedStartDate(), LocalDateTime.now()).toDays() : Duration.between(borrowed.getBorrowedStartDate(), borrowed.getBorrowedEndDate()).toDays();
            if (day > 7 && borrowed.getBorrowStatus() != 2) {
                borrowed.setBorrowStatus(2);
                setOrderTimeOut(borrowed);
            }
            //将查询结果封装到dto中
            OrderDto orderDto = new OrderDto();
            //将borrowed中的属性复制到orderDto中
            BeanUtils.copyProperties(borrowed, orderDto);
            //根据图书id查询图书信息
            orderDto.setBookName(bookService.getById(borrowed.getBookId()).getBookName());
            orderDto.setBorrowedDate(day);
            return orderDto;
        }).collect(Collectors.toList());
        //将查询结果封装到分页对象中
        orderDtoPage.setRecords(list);
        return R.success(orderDtoPage);
    }
    //日期 姓名 书籍名称  借阅时长 归还状态

    /**
     * 删除订单
     *
     * @param id
     * @return
     */
    @DeleteMapping
    public R<String> delete(String id) {
        return borrowedService.removeById(id) ? R.success("删除订单成功") : R.error("删除订单失败");
    }

    //设置订单为超时
    public R<String> setOrderTimeOut(Borrowed borrowed) {
        return borrowedService.updateById(borrowed) ? R.success("设置订单超时成功") : R.error("设置订单超时失败");
    }



}
