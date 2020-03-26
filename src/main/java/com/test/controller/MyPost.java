package com.test.controller;

import com.test.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Log4j
@RestController
@Api(value = "v1")
@RequestMapping
@ResponseBody
public class MyPost {
    @Autowired
    public UserService userService = null;

    @PostMapping("/addUser")
    @ApiOperation(value = "添加用户", httpMethod = "POST")
    public Result addUser(@RequestParam(value = "username") String username,
                          @RequestParam(value = "password") String password,
                          @RequestParam(value = "age", required = false) int age,
                          @RequestParam(value = "sex", required = false) int sex){
//        name = "6-12位字母和数字组合",
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setAge(age);
        user.setSex(sex);
        int i;
        Result result;
        String data;
        String error;
        String message;
        String pattern = "[a-z]|[A-Z]|[0-9]{6,12}";
        // 创建 Pattern 对象
        Matcher m = Pattern.compile(pattern).matcher(password);
        if (!m.find( )) {
            error = "请输入正确的密码";
            result = new Result(error);
        }else {
            i = userService.addUser(user);
            data = user.toString();
            message = i>0? "添加用户成功":"添加用户失败";
            result = new Result(i,message,data);
        }
        return result;
    }

    @PostMapping("/addUser2")
    @ApiOperation(value = "添加用户2", httpMethod = "POST")
    public Result addUser2(@RequestBody @ApiParam(name="data",value="请传入json格式",required=true)User user){
        int i;
        Result result;
        String data;
        String error;
        String message;
        String pattern = "[a-z]|[A-Z]|[0-9]{6,12}";
        // 创建 Pattern 对象
        Matcher m = Pattern.compile(pattern).matcher(user.password);
        if (!m.find( )) {
            error = "请输入正确的密码";
            result = new Result(error);
        }else {
            i = userService.addUser(user);
            data = user.toString();
            message = i>0? "添加用户成功":"添加用户失败";
            result = new Result(i,message,data);
        }
        return result;
    }

    class Result {
        private int success = 0;
        private String message = null;
        private String data = null;
        private String error = null;
        public Result(int success,String message,String data,String reason){
            this.success = success;
            this.message = message;
            this.data = data;
            this.error = reason;
        }
        public Result(int success,String message,String data){
            this.success = success;
            this.message = message;
            this.data = data;
        }

        public Result(String error){
            this.error = error;
        }
        public String getData() {
            return data;
        }
        public void setData(String data) {
            this.data = data;
        }
        public void setError(String reason) {
            this.error = reason;
        }
        public String getError() {
            return error;
        }
        public int getSuccess() {
            return success;
        }
        public String getMessage() {
            return message;
        }
        public void setSuccess(int amount) {
            this.success = amount;
        }
        public void setMessage(String message) {
            this.message = message;
        }
    }
}
