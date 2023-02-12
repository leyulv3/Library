package com.example.book.Service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.book.Entity.Book;
import com.example.book.Entity.Borrowed;
import com.example.book.Service.BookService;
import com.example.book.mapper.BorrowedMapper;
import com.example.book.Service.BorrowedService;
import com.example.book.util.R;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import static com.example.book.Entity.Borrowed.getOrderNo;

@Service
public class BorrowedServiceImpl extends ServiceImpl<BorrowedMapper, Borrowed> implements BorrowedService {
    @Resource
    private BookService bookService;

    @Override
    public R submintOrder(Borrowed borrowed) {
        //查询书籍
        Book book = bookService.getById(borrowed.getBookId());
        if (book == null) {
            return R.error("该书籍不存在");
        }
        //判断书籍是否还有库存
        if (book.getRemainingNumber() <= 0) {
            return R.error("该书籍已无库存");
        }
        //借阅书籍
        book.setBorrowedNumber(book.getBorrowedNumber() - 1);
        bookService.updateById(book);
        //新增订单
        borrowed.setBorrowedId(getOrderNo());
        borrowed.setBorrowedStartDate(LocalDateTime.now());
        return save(borrowed) ? R.success("借阅成功") : R.error("借阅失败");
    }

    @Override
    public R returnBook(Borrowed borrowed) {
        //查询书籍
        Book book = bookService.getById(borrowed.getBookId());
        if (book == null) {
            return R.error("该书籍不存在");
        }
        //归还书籍
        book.setBorrowedNumber(book.getBorrowedNumber() + 1);
        bookService.updateById(book);
        //修改订单
        borrowed.setBorrowedEndDate(LocalDateTime.now());
        borrowed.setBorrowStatus(1);
        return updateById(borrowed) ? R.success("归还成功") : R.error("归还失败");
    }
}
