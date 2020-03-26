package com.test.practice;

import com.test.model.User;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;


public class Demo2 {
    @Test
    public void getCount() throws IOException {
        SqlSession session = DButil.getSession();

        User user = session.selectOne("sendLottery",1);
        JSONObject dependAddress = Demo.getResult().getJSONObject("total");
        System.out.println(dependAddress);
    }

}
