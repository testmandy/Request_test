package com.test.controller;

import com.test.model.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.List;

@Controller
public class UserServiceImpl implements UserService {
    @Autowired
    public SqlSessionTemplate template;

    @Override
    public User getUser(int id) throws IOException {
        return template.selectOne("getUserInfo",1);
    }

    @Override
    public List<User> findUser(String email) {
        return null;
    }

    @Override
    public int deleteUser(int id) {
        return 0;
    }

    @Override
    public int updateUser(int id, String email) {
        return 0;
    }
}
