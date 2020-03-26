package com.test.controller;

import com.test.model.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public SqlSessionTemplate template = null;

    @Override
    public String getUser(int id) {
        return template.selectOne("getUserInfo",id).toString();
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
