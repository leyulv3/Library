package com.example.book.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.book.Entity.UserLogin;
import com.example.book.mapper.UserLoginMapper;
import com.example.book.Service.UserLoginService;
import com.example.book.util.R;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserLoginServiceImpl extends ServiceImpl<UserLoginMapper, UserLogin> implements UserLoginService {
    @Autowired
    private UserLoginService userLoginService;

    /*
     * 登录
     **/
    @Override
    public R userLogin(/*HttpServletRequest request,*/ @RequestBody UserLogin userLogin) {
        //1、将页面提交的密码password
        //2、根据用户名和密码查询数据库
        QueryWrapper<UserLogin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userLogin.getUserId());
        queryWrapper.eq("user_password", userLogin.getUserPassword());
        UserLogin user = userLoginService.getOne(queryWrapper);
        //3、如果没有查询到则返回登录失败结果
        if (user == null) {
            return R.error("登录失败");
        }
        //4、密码比对，如果不一致则返回登录失败结果
        if (!userLogin.getUserPassword().equals(user.getUserPassword())) {
            return R.error("登录失败");
        }
        //5、查看员工状态，如果为已禁用状态，则返回员工已禁用结果
        if (user.getUserStatus() .equals("1") ) {
            return R.error("员工已禁用");
        }
        //6、登录成功，将员工id存入Session并返回登录成功结果
        //request.getSession().setAttribute("userId", user.getUserId());
        return R.success("登录成功");
    }
    //用户注册
    @Override
    public R addUser(UserLogin userLogin) {
        userLogin.setUserPassword("123456");
        if (userLoginService.save(userLogin)) {
            return R.success("注册成功");
        } else {
            return R.error("注册失败");
        }
    }
    //修改密码
    @Override
    public R changePassword(UserLogin userLogin) {
        QueryWrapper<UserLogin> queryWrapper = new QueryWrapper<>();
        System.out.println(userLogin.getNewPassword());
        queryWrapper.eq("user_id", userLogin.getUserId());
        queryWrapper.eq("user_password", userLogin.getUserPassword());
        UserLogin user = userLoginService.getOne(queryWrapper);
        if (user == null) {
            return R.error("原密码错误");
        }else {
            System.out.println(userLogin.getNewPassword());
            user.setUserPassword(userLogin.getNewPassword());
            return userLoginService.updateById(user)?R.success("修改成功"):R.error("修改失败");
        }
    }
    //查询所有用户
    @Override
    public R UserInfopage(int page, int pageSize, String id) {
        //构造分页构造器
        Page pageInfo = new Page(page,pageSize);
        //构造条件构造器
        LambdaQueryWrapper<UserLogin> queryWrapper = new LambdaQueryWrapper();
        //添加过滤条件
        queryWrapper.like(StringUtils.isNotEmpty(id),UserLogin::getUserId,id);
        //添加排序条件
        //queryWrapper.orderByDesc(UserLogin::getUpdateTime);
        //执行查询
        userLoginService.page(pageInfo,queryWrapper);
        return R.success(pageInfo);
    }
}
