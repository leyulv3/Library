package com.example.book.Entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Data
public class Borrowed {
    @TableId(value = "borrowed_id")
    private String borrowedId;    //借阅ID
    private String userId;    //用户ID
    private String bookId;    //书籍ID
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime borrowedStartDate;    //借阅开始日期
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime borrowedEndDate;    //借阅结束日期
    private int borrowStatus;    //借阅状态 0未归还 1已归还 2逾期未归还
    private int borrowedNumber;    //借阅数量

    /**
     * 根据时间戳生成订单号
     */
    public static String getOrderNo() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        LocalDateTime localDateTime = Instant.ofEpochMilli(System.currentTimeMillis()).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
        return df.format(localDateTime);
    }


}
