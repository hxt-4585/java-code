package com.hxt.pojo;

import lombok.Data;
import lombok.ToString;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({"prod"})
@Component
@Data
@ToString
public class Student {
    private String name;
    private Integer age;
}
