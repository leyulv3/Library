package com.example.book.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.book.Entity.UserLogin;
import com.example.book.Service.UserLoginService;
import com.example.book.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;



@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserLoginService userLoginService;


    /**
     * 用户登录
     *
     * @param request
     * @param userLogin
     * @return
     */
    @PostMapping("/login")
    public R userLogin(/*HttpServletRequest request,*/ @RequestBody UserLogin userLogin) {
        return userLoginService.userLogin(/*request,*/ userLogin);
    }

    //用户退出
    @PostMapping("/logout")
    public R userLogout(HttpServletRequest request) {
        request.getSession().removeAttribute("userId");
        return R.success("退出成功");
    }

    /**
     * 新增
     *
     * @param userLogin
     * @return
     */
    @PostMapping("/register")
    public R userRegister(@RequestBody UserLogin userLogin) {
        return userLoginService.addUser(userLogin);
    }

    /**
     * 修改密码
     *
     * @param userLogin
     * @return
     */
    @PutMapping("/changePassword")
    public R changePassword(@RequestBody UserLogin userLogin) {
        return userLoginService.changePassword(userLogin);
    }

    /**
     * 员工信息分页查询
     *
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/page")
    public R<Page> page(int page, int pageSize, String id) {
        return userLoginService.UserInfopage(page, pageSize, id);
    }

    /**
     * 根据id修改账号信息
     *
     * @param userLogin
     * @return
     */
    @PutMapping
    public R<String> update(@RequestBody UserLogin userLogin) {
        return userLoginService.updateById(userLogin) ? R.success("账号信息修改成功") : R.error("账号信息修改失败");
    }

    /**
     * 根据id查询账号信息
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public R<UserLogin> getById(@PathVariable String id) {
        UserLogin userLogin = userLoginService.getById(id);
        if (userLogin != null) {
            return R.success(userLogin);
        }
        return R.error("没有查询到对应账号信息");
    }

    /**
     * 根据id删除账号信息
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public R<String> deleteById(@PathVariable String id) {
        return userLoginService.removeById(id) ? R.success("账号信息删除成功") : R.error("账号信息删除失败");
    }


}
