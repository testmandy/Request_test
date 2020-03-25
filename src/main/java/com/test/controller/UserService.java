package com.test.controller;

import com.test.model.User;

import java.io.IOException;
import java.util.List;

public interface UserService {
    public User getUser(int id) throws IOException;

    public List<User> findUser(String email);

    public int deleteUser(int id);

    public int updateUser(int id,String email);

}
