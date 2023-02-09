package com.example.book.Entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
public class Student {
    @TableId(value = "student_id")
    private String studentId;
    private String studentName;
    @Pattern(regexp = "\"^[0-1]*$\",message = \"性别输入错误\"")
    private int studentGender;  //性别
    private String studentClass;
    private String studentPhone;
    private Date studentDate;
}
