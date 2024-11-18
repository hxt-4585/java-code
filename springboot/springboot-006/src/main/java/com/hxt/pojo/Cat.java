package com.hxt.pojo;

import lombok.Data;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({"dev"})
@Component
@Data
public class Cat {
    private String name;
    private Integer age;
}
