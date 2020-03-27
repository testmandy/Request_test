package com.test.model;

import lombok.Data;

@Data
public class User {
    public int id;
    public String username = null;
    public String password = null;
    public int age = 0;
    public int sex = 0;

    public String toString(){
        return ("username: " + username + ", age: " + age + ", sex: " + sex);
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public int getSex() {
        return sex;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
