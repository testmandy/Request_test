package com.test.cases;

import org.apache.http.NameValuePair;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import springfox.documentation.spring.web.json.Json;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;


public class HttpMethod {
    //创建httpclient
    CloseableHttpClient client = HttpClients.createDefault();

    //定义url地址
    String getUrl = "https://reqres.in/api/users";
    String postUrl = "https://reqres.in/api/login";


    //创建get请求
    public HttpGet getMethod(int page){
        System.out.println("[MyLog]-----------开始执行get请求-----------");
        String uri = "?page=";
        String testUrl = this.getUrl + uri + page;
        return new HttpGet(testUrl);
    }

    //创建post请求
    public HttpPost postMethod() throws UnsupportedEncodingException {
        System.out.println("[MyLog]-----------开始执行post请求-----------");
        HttpPost post = new HttpPost(this.postUrl);
        this.addMyHeaders(post);
        String paramStr = "{'email': 'eve.holt@reqres.in', 'password': 'pistol'}";
        JSONObject paramJson = new JSONObject(paramStr);
        System.out.printf("paramJson is: %s \n",paramJson);
        JSONObject param = new JSONObject();
        //遍历字符串中的key和value
        Iterator<String> it = paramJson.keys();
        while (it.hasNext()){
            String key = it.next();
            String value = paramJson.getString(key);
            System.out.printf("遍历结果为--- %s : %s \n",key,value);
            param.put(key,value);
        }
        StringEntity entity = new StringEntity(param.toString());
        post.setEntity(entity);
        return post;
    }


    //添加headers
    public void addMyHeaders(HttpPost post){
        System.out.println("[MyLog]-----------开始添加headers-----------");
        String headers = "";
        List<NameValuePair> list = new ArrayList<NameValuePair>();
        post.addHeader("Content-Type","application/json; charset=utf-8");
    }


    //接收response
    public CloseableHttpResponse getResponse(String method) throws IOException {
        System.out.println("[MyLog]-----------开始获取response-----------");
        CloseableHttpResponse response = null;
        if (method.equals("get")){
            HttpGet get = this.getMethod(1);
            response = client.execute(get);
        } else if (method.equals("post")){
            HttpPost post = this.postMethod();
            response = client.execute(post);
        } else {
            System.out.println("请输入正确的请求方式");
        }
        return response;
    }

    //断言
    public void getResult(String method) throws IOException {
        CloseableHttpResponse response = this.getResponse(method);
        int expectCode = 200;
        int actualCode = response.getStatusLine().getStatusCode();
        String result = EntityUtils.toString(response.getEntity());
        System.out.println("[MyLog]-----------开始获取执行结果，断言-----------");
        Assert.assertEquals(actualCode,expectCode,"断言失败");
        System.out.println(result);
    }


    /**
     *
     * @param url
     * @return
     * @throws IOException
     */
    public String get(String url) throws IOException {
        HttpGet get = new HttpGet(url);
        System.out.println("[MyLog]-----------开始获取response-----------");
        CloseableHttpResponse response = client.execute(get);
        int expectCode = 200;
        int actualCode = response.getStatusLine().getStatusCode();
        String result = EntityUtils.toString(response.getEntity());
        System.out.println("[MyLog]-----------开始获取执行结果，断言-----------");
        Assert.assertEquals(actualCode,expectCode,"断言失败");
        System.out.println(result);
        return result;
    }

    /**
     *
     * @param url
     * @param param
     * @return
     * @throws URISyntaxException
     * @throws IOException
     */
    public String getWithParam(String url, Map<String,Integer> param) throws URISyntaxException, IOException {
        System.out.println("[MyLog]-----------开始执行get请求-----------");
        URIBuilder builder = new URIBuilder(url);
        if (param != null){
            for (String key:param.keySet()){
                builder.addParameter(key, String.valueOf(param.get(key)));
            }
        }
        URI uri = builder.build();
        System.out.println(uri);
        HttpGet get = new HttpGet(uri);
        System.out.println("[MyLog]-----------开始获取response-----------");
        CloseableHttpResponse response = client.execute(get);
        int expectCode = 200;
        int actualCode = response.getStatusLine().getStatusCode();
        String result = EntityUtils.toString(response.getEntity());
        System.out.println("[MyLog]-----------开始获取执行结果，断言-----------");
        Assert.assertEquals(actualCode,expectCode,"断言失败");
        System.out.println(result);
        return result;
    }

    /**
     *
     * @param url
     * @param param
     * @return
     * @throws IOException
     */
    public String postWithParam(String url, String param) throws IOException {
        System.out.println("[MyLog]-----------开始执行post请求-----------");
        JSONObject json = new JSONObject(param);
        System.out.printf("paramJson is: %s \n",json);
        JSONObject paramJson = new JSONObject();
        //遍历字符串中的key和value
        Iterator<String> it = json.keys();
        while (it.hasNext()){
            String key = it.next();
//            String value = String.valueOf(paramJson.getInt(key));
            String value = json.getString(key);
            System.out.printf("遍历结果为--- %s : %s \n",key,value);
            paramJson.put(key,value);
        }
        StringEntity entity = new StringEntity(paramJson.toString());
        HttpPost post = new HttpPost(url);
        post.setHeader("Content-Type","application/json");
        post.setEntity(entity);
        System.out.println("[MyLog]-----------开始获取response-----------");
        CloseableHttpResponse response = client.execute(post);
        int actualCode = response.getStatusLine().getStatusCode();
        String result = EntityUtils.toString(response.getEntity());
        System.out.println("[MyLog]-----------开始获取执行结果，断言-----------");
        Assert.assertEquals(actualCode,200,"断言失败");
        System.out.println(result);
        return result;
    }

}
