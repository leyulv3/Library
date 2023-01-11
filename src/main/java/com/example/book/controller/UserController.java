package com.example.book.controller;

import com.example.book.Entity.User;
import com.example.book.Service.UserService;
import com.example.book.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.example.book.util.ReturnCode.ERROR;
import static com.example.book.util.ReturnCode.SUCCESS;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/{id}")
    R getUser(@PathVariable Integer id){
        User user=userService.getUser(id);
        return new R(user!=null?SUCCESS:ERROR,user);

    }
    @DeleteMapping("/{id}")
    R deleteUser(@PathVariable Integer id){
        return new R(userService.delete(id)?SUCCESS:ERROR);
    }
    @PostMapping
    R addUser(@RequestBody User user){
        return new R(userService.save(user)?SUCCESS:ERROR);
    }
    @PutMapping
    R updateUser(@RequestBody User user){
        return new R(userService.updateUser(user)?SUCCESS:ERROR);
    }
}
