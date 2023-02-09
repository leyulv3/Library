package com.example.book.Entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class BookType {
    @TableId(value = "book_type_id")
    @NotNull
    private String bookTypeId;    //书籍类型ID
    @NotNull
    private String bookTypeName;    //书籍类型名称
    @Pattern(regexp ="^[0-1]*$",message = "书籍类型状态输入错误")
    private String bookTypeStatus;    //书籍类型状态  0正常 1禁用

}
