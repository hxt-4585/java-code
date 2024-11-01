package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Student;

import java.util.List;


public interface StudentMapper {

    Student selectBySid(Integer sid);
    List<Student> selectByCid(Integer cid);
}
