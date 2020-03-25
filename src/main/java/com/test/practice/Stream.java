package com.test.practice;

import java.io.*;

public class Stream {
    public static void main(String[] args) throws IOException {

        InputStreamReader sr = new InputStreamReader(System.in);
        BufferedInputStream bf = new BufferedInputStream(System.in);
        BufferedReader br = new BufferedReader(sr);
        System.out.print("请输入：" );
        System.out.println("字节流为：" + (char)bf.read());
        System.out.print("请输入：" );
        System.out.println("字符流为：" + (char)br.read());
        FileInputStream stream = new FileInputStream("C:\\Users\\user\\Desktop\\1234.txt");
//        ByteArrayInputStream bis = new ByteArrayInputStream("{1,2,3,4}");
        int streamInt = stream.read();
        System.out.println(streamInt);
        Error error;
    }
}
