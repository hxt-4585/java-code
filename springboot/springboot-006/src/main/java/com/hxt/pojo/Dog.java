package com.hxt.pojo;

import lombok.Data;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({"test"})
@Component
@Data
public class Dog {
    private String name;
    private Integer age;
}
