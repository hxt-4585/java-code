package com.hxt.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ToString
//@ConfigurationProperties(prefix = "teacher")
public class Teacher {
    private String name;
    private Integer age;
}
