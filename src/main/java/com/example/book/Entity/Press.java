package com.example.book.Entity;

import com.baomidou.mybatisplus.annotation.TableId;

/**
 * 		出版社信息表
 * 		pressId	出版社编号
 * 		pressName	出版社名称
 * 		pressStatus	出版社状态
 */
public class Press {
	@TableId(value = "press_id")
	private String pressId;
	private String pressName;

	private String pressStatus;

}
