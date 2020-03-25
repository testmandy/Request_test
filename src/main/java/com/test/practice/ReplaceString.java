package com.test.practice;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ReplaceString {
    public static void main(String[] args) {
        Scanner scan  = new Scanner(System.in);
        System.out.print("请输入：");
        String input = scan.nextLine();
//        String result = input.replaceAll(" ","");
        // pattern 对象是一个正则表达式的编译表示
        Pattern pattern = Pattern.compile("\\s*|\t|\r|\n");
        // Matcher 对象是对输入字符串进行解释和匹配操作的引擎
        String result =  pattern.matcher(input).replaceAll("");
        System.out.printf("结果是： %s \n",result);
    }
}
