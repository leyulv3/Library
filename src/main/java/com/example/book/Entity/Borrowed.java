package com.example.book.Entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
public class Borrowed {
	@TableId(value = "borrowed_id")
	private String borrowedId;	//借阅ID
	private String userId;	//用户ID
	private String bookId;	//书籍ID
	private String borrowedStartDate;	//借阅开始日期
	private String borrowedEndDate;	//借阅结束日期
	private String borrowedStatus;	//借阅状态
	private Integer borrowedNumber;	//借阅数量

}
