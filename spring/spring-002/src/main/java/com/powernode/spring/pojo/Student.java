package com.powernode.spring.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.Properties;

@Setter
@Getter
@ToString
public class Student {
    private String name;
    private Integer age;
    private Clazz clazz;
    private String[] favoriteFoods;
    private List<String> sports;
    private Map<String, Object> cities;
    private Properties properties;
}
