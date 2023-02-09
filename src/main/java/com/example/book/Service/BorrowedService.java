package com.example.book.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.book.Entity.Borrowed;
import com.example.book.util.R;

public interface BorrowedService extends IService<Borrowed> {

    R submintOrder(Borrowed borrowed);

    R returnBook(Borrowed borrowed);
}
