package com.example.book.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.book.Entity.Book;
import com.example.book.Entity.Borrowed;
import com.example.book.Service.BookService;
import com.example.book.mapper.BorrowedMapper;
import com.example.book.Service.BorrowedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowedServiceImpl extends ServiceImpl<BorrowedMapper, Borrowed> implements BorrowedService {
    @Autowired
    private BookService bookService;

    @Override
    public boolean submintOrder(String bookId, String userId) {
        //查询书籍
        Book book = bookService.getById(bookId);
        //判断书籍是否存在
        if (book != null) {
            //判断书籍是否已经借出
            if (book.getBookStatus() == "0") {
                //判断书籍是否已经被预约
                LambdaQueryWrapper<Borrowed> queryWrapper = new LambdaQueryWrapper<>();
                queryWrapper.eq(Borrowed::getBookId, bookId);
                List<Borrowed> list = list(queryWrapper);
                if (list.size() == 0) {
                    //借阅书籍
                    Borrowed borrowed = new Borrowed();
                    borrowed.setBookId(bookId);
                    borrowed.setUserId(userId);
                    save(borrowed);
                    //修改书籍状态
                    //book.setIsBorrowed(1);
                    bookService.updateById(book);
                    return true;
                }
            }
        }



        return false;
    }
}
