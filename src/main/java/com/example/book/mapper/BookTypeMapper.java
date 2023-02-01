package com.example.book.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.book.Entity.BookType;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookTypeMapper extends BaseMapper<BookType> {
}
