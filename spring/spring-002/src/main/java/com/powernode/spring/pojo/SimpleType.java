package com.powernode.spring.pojo;

import lombok.Setter;
import lombok.ToString;

import java.net.URI;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

@Setter
@ToString
public class SimpleType {
    private byte b;
    private short s;
    private int i;
    private long l;
    private float f;
    private double d;
    private boolean flag;
    private char c;

    private Byte b1;
    private Short s1;
    private Integer i1;
    private Long l1;
    private Float f1;
    private Double d1;
    private Boolean flag1;
    private Character c1;

    private String str;

    private Date date;

    private Season season;

    private URI uri;

    private URL url;

    private LocalDate localDate;

    private Locale locale;

    private Class clazz;


}
enum Season {
    SPRING, SUMMER, AUTUMN, WINTER
}