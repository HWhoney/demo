package com.jd.dao;

import com.jd.bean.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Qualifier("db1SqlSessionTemplate")
@Repository
public interface UserDao {
    /**
     *通过名字查询用户信息
     * */
    @Select("SELECT * FROM user WHERE name =#{name}")
    User findUserByName(String name);
}
