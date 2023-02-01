package com.example.book.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
public class Author {
	@TableId(value = "author_id")
	private String authorId;	//作者ID
	private String authorName;	//作者姓名
	private String authorStatus;	//作者状态
}
