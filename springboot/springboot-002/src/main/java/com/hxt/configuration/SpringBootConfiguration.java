package com.hxt.configuration;

import com.alibaba.druid.FastsqlException;
import com.hxt.pojo.Student;
import com.hxt.pojo.Teacher;
import com.hxt.pojo.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({FastsqlException.class})
@EnableConfigurationProperties(Teacher.class)
public class SpringBootConfiguration {

    @ConditionalOnClass(name = {"com.alibaba.druid.FastsqlException"})
    @Bean
    public User user(){
        return new User();
    }

    @ConfigurationProperties(prefix = "student")
    @Bean
    public Student student(){
        return new Student();
    }
}
