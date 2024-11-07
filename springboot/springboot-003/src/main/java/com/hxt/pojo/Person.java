package com.hxt.pojo;

//import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//@JacksonXmlRootElement
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person {
    private int id;
    private String name;
    private int age;
}
