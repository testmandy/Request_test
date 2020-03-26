package com.test.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Log4j
@RestController
@Api(value = "v1")
@RequestMapping
@ResponseBody
public class MyGet {
//    @Autowired
//    public SqlSessionTemplate template;
    @Autowired
    public UserService userService = null;

    @GetMapping(value = "/getUser")
    @ApiOperation(value = "获取用户信息",httpMethod = "GET")
    public String getUser(int id) throws IOException {
        return userService.getUser(id);
    }
}
