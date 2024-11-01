package com.powernode;

import com.powernode.mybatis.mapper.ClazzMapper;
import com.powernode.mybatis.mapper.StudentMapper;
import com.powernode.mybatis.pojo.Clazz;
import com.powernode.mybatis.pojo.Student;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.junit.Test;


public class StudentMapperTest {
    @Test
    public void testSelectBySid(){
        StudentMapper mapper = SqlSessionUtil.openSession().getMapper(StudentMapper.class);
        Student student = mapper.selectBySid(1);
        System.out.println(student.getSname());
        System.out.println(student.getClazz());
    }

    @Test
    public void testSelectClazzAndStudentsByCid(){
        ClazzMapper mapper = SqlSessionUtil.openSession().getMapper(ClazzMapper.class);
        Clazz clazz = mapper.selectClazzAndStudentsByCid(1001);
        System.out.println(clazz);
    }
}
