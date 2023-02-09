package com.example.book;


import com.alibaba.fastjson.JSONObject;
import com.example.book.Entity.Borrowed;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

import static com.example.book.Entity.Borrowed.getOrderNo;


public class test {
    public static void main(String[] args) {
        Date date = new Date();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println(formatter.format(date));
    }
}


