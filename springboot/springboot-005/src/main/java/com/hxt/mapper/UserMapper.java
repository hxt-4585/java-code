package com.hxt.mapper;

import com.hxt.bean.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User selectUserById(@Param("id") int id);
}
