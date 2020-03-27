package com.test.controller;

import com.test.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Log4j
@RestController
@Api(value = "v1")
@RequestMapping
@ResponseBody
public class MyGet {
    @Autowired
    public UserService userService = null;

    @GetMapping("/getUser")
    @ApiOperation(value = "获取用户信息",httpMethod = "GET")
    public String getUser(int id) throws IOException {
        return userService.getUser(id);
    }

    @GetMapping("/getUserList")
    @ApiOperation(value = "获取用户列表",httpMethod = "GET")
    public List<User> getUserList(int page) throws IOException {
        return userService.getUserList((page-1)*10);
    }
}
