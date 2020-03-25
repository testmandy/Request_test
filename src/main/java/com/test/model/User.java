package com.test.model;

import lombok.Data;

@Data
public class User {
    public int id;
//    public String address;
    public String userId;
//    public int amount;
    public static String expected;

    public String toString(){
//        String result = "id: " + id + " address: " + address + " userId: " + userId + " amount: " + amount + " expected: " + expected;
        String result = "id: " + id + " userId: " + userId + " expected: " + expected;
        return result;
    }
}
