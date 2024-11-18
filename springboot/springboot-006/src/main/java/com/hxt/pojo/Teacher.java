package com.hxt.pojo;

import lombok.Data;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

//@Profile({"default"})
@Component
@Data
public class Teacher {
    private String name;
    private Integer age;
}
