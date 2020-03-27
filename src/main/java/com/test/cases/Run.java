package com.test.cases;

import com.test.config.TestConfig;
import com.test.model.InterfaceName;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class Run {
    HttpMethod method = new HttpMethod();

    @BeforeMethod
    public void beforeMethod(){

    }

    @Test
    public void getUser() throws IOException, URISyntaxException {
        String url = TestConfig.getUrl(InterfaceName.GETUSER);
        Map<String, Integer> param = new HashMap<String, Integer>();
        param.put("id",1);
        this.method.getWithParam(url,param);
    }

    @Test
    public void getUserList() throws IOException, URISyntaxException {
        String url = TestConfig.getUrl(InterfaceName.GETUSERLIST);
        Map<String, Integer> param = new HashMap<String, Integer>();
        param.put("page",1);
        this.method.getWithParam(url,param);
    }

    @Test
    public void addUser() throws IOException{
        String url = TestConfig.getUrl(InterfaceName.ADDUSER);
        String param = "{'age':'18','password':'add','sex':'1','username':'test'}";
        this.method.postWithParam(url,param);
    }

    @Test
    public void updateUser() throws IOException{
        String url = TestConfig.getUrl(InterfaceName.UPDATEUSER);
        String param = "{'id':'19','age':'18','password':'change','sex':'1','username':'mandy'}";
        this.method.postWithParam(url,param);
    }

}
