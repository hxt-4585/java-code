package com.powernode;

import com.powernode.mybatis.mapper.StudentMapper;
import com.powernode.mybatis.pojo.Student;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentMapperTest {
    @Test
    public void testSelectByName(){
        StudentMapper mapper = (StudentMapper) SqlSessionUtil.openSession().getMapper(StudentMapper.class);
        List<Student> students = mapper.selectByName("赵六");
        students.forEach(student -> System.out.println(student));
    }

    @Test
    public void testSelectById(){
        StudentMapper mapper = (StudentMapper) SqlSessionUtil.openSession().getMapper(StudentMapper.class);
        Student student = mapper.selectById(2L);
        System.out.println(student);
    }

    @Test
    public void testSelectByBirth() throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2022-09-01");
        StudentMapper mapper = (StudentMapper) SqlSessionUtil.openSession().getMapper(StudentMapper.class);
        List<Student> students = mapper.selectByBirth(date);
        students.forEach(student -> System.out.println(student));
    }

    @Test
    public void testSelectBySex() {
        StudentMapper mapper = (StudentMapper) SqlSessionUtil.openSession().getMapper(StudentMapper.class);
        List<Student> students = mapper.selectBySex('男');
        students.forEach(student -> System.out.println(student));
    }

    @Test
    public void testSelectByParamMap() {
        StudentMapper mapper = SqlSessionUtil.openSession().getMapper(StudentMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("name", "张飞");
        map.put("age", 50);
        List<Student> students = mapper.selectByParamMap(map);
        students.forEach(student -> System.out.println(student));
    }

    @Test
    public void testSelectByNameAndSex() {
        StudentMapper mapper = SqlSessionUtil.openSession().getMapper(StudentMapper.class);
        List<Student> students = mapper.selectByNameAndSex("张飞", '女');
        students.forEach(student -> System.out.println(student));
    }
}
