package com.example.book.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.book.Entity.UserLogin;
import com.example.book.util.R;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserLoginService extends IService<UserLogin> {
    R userLogin(/*HttpServletRequest request, */@RequestBody UserLogin userLogin);

    R addUser(UserLogin userLogin);

    R changePassword(UserLogin userLogin);

    R UserInfopage(int page, int pageSize, String id);
}
