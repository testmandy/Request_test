package com.test.practice;

import com.test.model.User;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;


public class Demo {
    @Test
    public User getCount() throws IOException {
        SqlSession session = DButil.getSession();
        return session.selectOne("sendLottery",1);
    }


    public static JSONObject getResult() throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        String testUrl = "https://reqres.in/api/users?page=2";
        HttpGet get = new HttpGet(testUrl);
        HttpResponse response = client.execute(get);
        String result = EntityUtils.toString(response.getEntity());
        JSONObject resultJson = new JSONObject(result);
        System.out.println(result);
        return resultJson;
    }

}
