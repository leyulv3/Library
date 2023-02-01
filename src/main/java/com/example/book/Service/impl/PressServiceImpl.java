package com.example.book.Service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.book.Entity.Press;
import com.example.book.mapper.PressMapper;
import com.example.book.Service.PressService;
import org.springframework.stereotype.Service;

@Service
public class PressServiceImpl extends ServiceImpl<PressMapper, Press>implements PressService {

}
