package com.byterain.controller;

import com.byterain.entity.CommonResult;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getUserById/{id}")
    public CommonResult<User> getUserById(@PathVariable Integer id){
        //服务间的调用, Server_2100 --->调用 Server_1100
        //使用RestTemplate调用 并且满足Rest风格调用，让spring容器管理
        //调用server_1100子工程 UserController 下面的findById 方法

        CommonResult<User> result =
                    restTemplate.getForObject("http://localhost:1100/user/findById/" + id, CommonResult.class);
            return result;

        }
    }

