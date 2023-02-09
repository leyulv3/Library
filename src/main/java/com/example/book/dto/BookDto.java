package com.example.book.dto;

import com.example.book.Entity.Author;
import com.example.book.Entity.Book;
import com.example.book.Entity.BookType;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class BookDto  extends Book {

    private String bookType;
    private String authorName;
    private String pressName;
}
