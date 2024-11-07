package com.hxt.controller;

import com.hxt.pojo.Person;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    /**
     * 默认支持将对象转换成json形式，因为web场景导入了jackson处理json的包
     * jackson也支持把数据写为xml。导入xml的相关依赖
     * @return
     */
    @GetMapping("/hello")
    public Person hello() {
        Person person = new Person();
        person.setId(1);
        person.setName("张三");
        person.setAge(18);

        int i = 10/0;
        return person;
    }

    /**
     * 默认只能处理这个类发生的错误
     * @param e
     * @return
     */
//    @ExceptionHandler(Exception.class)
//    public String exception(Exception e) {
//        return e.getMessage();
//    }
}
