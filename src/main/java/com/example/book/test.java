package com.example.book;


import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.*;


public class test {
    public static void main(String[] args) {
        ok:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println("i= " + i + " , j = " + j);
                if (j == 5) {
                    break ok;
                }

            }
        }
    }
}


