package com.example.book.dto;

import com.example.book.Entity.Borrowed;
import lombok.Data;

@Data
public class orderDto extends Borrowed {
    private String bookName;
    private String bookType;

}
