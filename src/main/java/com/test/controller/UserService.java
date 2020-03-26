package com.test.controller;

import com.test.model.User;

import java.io.IOException;
import java.util.List;

public interface UserService {
    String getUser(int id) throws IOException;

    List<User> findUser(String email);

    int addUser(User user);

    int deleteUser(int id);

    int updateUser(int id,String email);

}
