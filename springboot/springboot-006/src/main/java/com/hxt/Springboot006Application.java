package com.hxt;

import com.hxt.pojo.Cat;
import com.hxt.pojo.Dog;
import com.hxt.pojo.Student;
import com.hxt.pojo.Teacher;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Springboot006Application {

    public static void main(String[] args) {
        // 1. SpringApplication: Boot应用的核心API
        ConfigurableApplicationContext context = SpringApplication.run(Springboot006Application.class, args);

//        // 自定义SpringApplication的底层设置
//        SpringApplication springApplication = new SpringApplication(Springboot006Application.class);
//
//        // 调整SpringApplication的参数
//        // springApplication.setDefaultProperties();
//
//        //这个不优先，配置文件优先，由于配置文件是off，所以不会打印banner
//        springApplication.setBannerMode(Banner.Mode.CONSOLE);
//
//        // 配置文件优先于程序
//
//        springApplication.run(args);

//        ConfigurableApplicationContext context = new SpringApplicationBuilder()
//                .main(Springboot006Application.class)
//                .sources(Springboot006Application.class)
//                .bannerMode(Banner.Mode.CONSOLE)
//                .properties("server.port=8088", "spring.profiles.active=dev")
//                .run(args);

        try {
            Cat cat = context.getBean(Cat.class);
            System.out.println(cat);
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            Dog dog = context.getBean(Dog.class);
            System.out.println(dog);
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            Student student = context.getBean(Student.class);
            System.out.println(student);
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            Teacher teacher = context.getBean(Teacher.class);
            System.out.println(teacher);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
