package com.example.book.Entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
public class Book {
    @TableId(value = "book_id")
    private String bookId;    //书籍ID
    private String bookName;    //书籍名称
    private String bookTypeId;    //书籍类型ID
    //注解不在表内
    @TableField(exist = false)
    private String bookType;    //书籍类型
    private String authorId;    //作者ID
    @TableField (exist = false)
    private String authorName;    //作者姓名
    private String pressId;    //出版社ID
    @TableField (exist = false)
    private String pressName;    //出版社名称
    private Integer borrowedNumber;   //借阅次数
    private Integer remainingNumber;    //剩余数量
    private String bookStatus;  //书籍状态

}
