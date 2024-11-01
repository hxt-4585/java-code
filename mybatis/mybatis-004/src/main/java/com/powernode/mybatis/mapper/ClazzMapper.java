package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Clazz;

public interface ClazzMapper {
    Clazz selectByCid(Integer cid);
    /**
     * 根据班级编号查询班级信息。同时班级中所有的学生信息也要查询。
     * @param cid
     * @return
     */
    Clazz selectClazzAndStudentsByCid(Integer cid);
}
