package com.example.book.dto;

import com.example.book.Entity.Borrowed;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class OrderDto extends Borrowed {
    private String bookName;
    private Long borrowedDate;

}
