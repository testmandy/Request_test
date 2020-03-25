package com.test.practice;

import javax.swing.plaf.TableHeaderUI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.lang.Thread;


public class MapTest {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<String, String>();
        map.put("Angel","female");
        map.put("Bob","male");
        map.put("Cookie","female");
        System.out.println(map.toString());
        Set<String> set = map.keySet();
        Iterator<String> it = set.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }


}
