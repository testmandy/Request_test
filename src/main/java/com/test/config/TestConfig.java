package com.test.config;

import com.test.model.InterfaceName;
import sun.security.krb5.internal.SeqNumber;

import java.util.Locale;
import java.util.ResourceBundle;


//swtich()变量类型只能是int、short、char、byte和enum类型

public class TestConfig {

    public static String getData(String key){
        ResourceBundle bundle = ResourceBundle.getBundle("data", Locale.CHINA);
        String data = bundle.getString(key);
        return data;
    }

    public static String baseUrl = getData("baseUrl");

    public static String getUrl(InterfaceName name){
        String uri = null;
        if (name == InterfaceName.GETUSER) {
            uri = getData("getUserUrl");
        }
        if (name == InterfaceName.GETUSERLIST) {
            uri = getData("getUserListUrl");
        }
        if (name == InterfaceName.ADDUSER) {
            uri = getData("addUserUrl");
        }
        if (name == InterfaceName.UPDATEUSER) {
            uri = getData("updateUserUrl");
        }

        String testUrl = baseUrl + uri;
        return testUrl;
    }
}
