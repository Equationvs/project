package com.byterain.controller;

import com.byterain.entity.CommonResult;
import com.byterain.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/findById/{id}")
    public CommonResult<User> findById(@PathVariable Integer id){
        User user = new User(id,"刘备","555");
        return new CommonResult(200,"success",user);
    }
}
