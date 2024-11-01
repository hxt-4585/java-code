package com.powernode.reflect;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Properties;
import java.util.ResourceBundle;

public class ReflectTest {
    public static void main(String[] args) {
//        try {"com.powernode.reflect.User"
//            Class c = Class.forName("java.util.Date");
//            Object o = c.newInstance();
//            System.out.println(o);
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
//            throw new RuntimeException(e);
//        }
//        String s = "123";
//        Class c = s.getClass();
//        Class d = String.class;
//        System.out.println(c == d);

//        try {
//            FileReader reader = new FileReader("javase-001-reflect\\src\\main\\resources\\classInfo.properties");
//            Properties properties = new Properties();
//            properties.load(reader);
//            reader.close();
//            String className = properties.getProperty("className");
//            Class c = Class.forName(className);
//
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

//        try {
//
//            InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("classInfo.properties");
//            Properties properties = new Properties();
//            properties.load(stream);
//            stream.close();
//            String className = properties.getProperty("className");
//            Class c = Class.forName(className);
//
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

//        ResourceBundle bundle = ResourceBundle.getBundle("classInfo");
//        String className = bundle.getString("className");
//        System.out.println(className);

//        try {
//            Class c = Class.forName("com.powernode.reflect.Student");
//            Field[] fields = c.getDeclaredFields();
//            for (Field field : fields){
//                System.out.println(field.getType());
//                System.out.println(field.getName());
//                // 返回的是一个数字，代表各自的限定符
//                System.out.println(Modifier.toString(field.getModifiers()));
//                System.out.println("========================");
//            }
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }

//        try {
//            Class studentClass = Class.forName("com.powernode.reflect.Student");
//            Object student = studentClass.newInstance();
//            Field no = studentClass.getDeclaredField("no");
//            no.set(student, 111);
//            student = (Student) student;
//            System.out.println(student);
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchFieldException e) {
//            throw new RuntimeException(e);
//        }

//        try {
//            Class studentClass = Class.forName("com.powernode.reflect.Student");
//            Object student = studentClass.newInstance();
//            Method[] methods = studentClass.getDeclaredMethods();
//            for (Method method : methods) {
//                System.out.println(method.getName());
//                System.out.println(Modifier.toString(method.getModifiers()));
//                System.out.println(method.getReturnType());
//                Class[] parameterTypes = method.getParameterTypes();
//                for (Class parameterType : parameterTypes) {
//                    System.out.println(parameterType.getSimpleName());
//                }
//                System.out.println("================");
//            }
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
//            throw new RuntimeException(e);
//        }

        try {
            Class studentClass = Class.forName("com.powernode.reflect.Student");
            Object student = studentClass.newInstance();
            Method method = studentClass.getMethod("login", String.class, String.class);
            Object ret = method.invoke(student, "zhangsan", "123");
            System.out.println(ret);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }

    }
}
