package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 学生数据Sql映射器
 * @author 老杜
 * @version 1.0
 * @since 1.0
 */
public interface StudentMapper {
    /**
     * 根据name查询
     * @param name
     * @return
     */
    List<Student> selectByName(String name);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Student selectById(Long id);

    /**
     * 根据birth查询
     * @param birth
     * @return
     */
    List<Student> selectByBirth(Date birth);
//    List<Student> selectByBirth(String birth);

    /**
     * 根据sex查询
     * @param sex
     * @return
     */
    List<Student> selectBySex(Character sex);

    /**
     * 根据name和age查询
     * @param paramMap
     * @return
     */
    List<Student> selectByParamMap(Map<String,Object> paramMap);

    /**
     * 多参数
     * @param name
     * @param sex
     * @return
     */
    List<Student> selectByNameAndSex(@Param(value = "name") String name,@Param("sex") Character sex);
}
