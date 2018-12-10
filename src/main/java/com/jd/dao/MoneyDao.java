package com.jd.dao;

import com.jd.bean.Money;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Qualifier("db2SqlSessionTemplate")
@Repository
public interface MoneyDao {
    /**
     * 通过id查看工资详情
     * */
    @Select("SELECT * FROM money WHERE id = #{id}")
    Money findMoneyById(@Param("id") int id);
}
