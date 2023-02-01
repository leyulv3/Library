package com.example.book.dto;

import com.example.book.Entity.Book;
import lombok.Data;


@Data
public class BookDto  extends Book {
    private String bookTypeName;
    private String authorName;
    private String pressName;
}
