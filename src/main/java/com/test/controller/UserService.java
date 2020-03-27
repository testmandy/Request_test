package com.test.controller;

import com.test.model.User;

import java.io.IOException;
import java.util.List;

public interface UserService {
    String getUser(int id) throws IOException;

    List<User> getUserList(int start);

    int addUser(User user);

    int deleteUser(int id);

    int updateUser(User user);

}
