package com.powernode;

public class Main {
    public static void main(String[] args) {
        String[] strings = new String[]{"我", "是", "中", "国", "人"};
        method(strings);

        method("我", "是", "中", "国", "人");
    }

    public static void method(String... arg){
        for (String str : arg){
            System.out.println(str);
        }
    }
}