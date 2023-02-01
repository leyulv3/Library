package com.example.book.Entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class Student {
    @TableId(value = "student_id")
    private String studentId;
    private String studentName;
    private int studentGender;
    private String studentClass;
    private String studentPhone;
    private Date studentDate;
}
