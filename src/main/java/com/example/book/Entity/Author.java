package com.example.book.Entity;

import com.baomidou.mybatisplus.annotation.*;
import com.sun.istack.internal.NotNull;
import lombok.Data;

@Data
public class Author {
	@NotNull
	@TableId(value = "author_id")
	private String authorId;	//作者ID
	private String authorName;	//作者姓名
	private String authorStatus;	//作者状态
}
