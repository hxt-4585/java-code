package com.powernode.reflect;

public class Student {
//    public static int no;
    public int no;
    private String name;
    protected int age;
    boolean sex;

    public boolean login(String name, String pwd){
        if (name.equals("zhangsan") && pwd.equals("123")){
            System.out.println("登陆成功");
            return true;
        }
        System.out.println("登陆失败");
        return false;
    }

    public void logout(){
        System.out.println("登出");
    }

    @Override
    public String toString() {
        return "Student{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
