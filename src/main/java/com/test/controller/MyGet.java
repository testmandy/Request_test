package com.test.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Log4j
@RestController
@Api(value = "v1",description = "用户相关接口")
@RequestMapping("v1")
public class MyGet {
    @Autowired
    public SqlSessionTemplate template;

    @GetMapping(value = "/getUser")
    @ApiOperation(value = "获取用户信息",httpMethod = "GET")
    public String getUser(int id) throws IOException {
        return template.selectOne("getUserInfo",id).toString();
    }
}
