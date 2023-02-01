package com.example.book.Entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
public class BookType {
    @TableId(value = "book_type_id")
    private String bookTypeId;    //书籍类型ID
    private String bookTypeName;    //书籍类型名称
    private String bookTypeStatus;    //书籍类型状态

}
