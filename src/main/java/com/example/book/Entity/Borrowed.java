package com.example.book.Entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;

@Data
public class Borrowed {
	@TableId(value = "borrowed_id")
	private String borrowedId;	//借阅ID
	private String userId;	//用户ID
	private String bookId;	//书籍ID
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private String borrowedStartDate;	//借阅开始日期
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private String borrowedEndDate;	//借阅结束日期
	@Pattern(regexp = "^[0-2]*$",message = "归还状态必须为")
	private String borrowedStatus;	//借阅状态 0未归还 1已归还 2逾期未归还
	@Min(value = 0,message = "借阅数量必须大于0")
	private Integer borrowedNumber;	//借阅数量

}
