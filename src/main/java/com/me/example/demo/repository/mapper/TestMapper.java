package com.me.example.demo.repository.mapper;

import com.me.example.demo.repository.po.TestPo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: Chen Wei
 * @Date: Created in 20:28 2020/1/4
 */

public interface TestMapper {
    @Select("select * from demo where id=#{id}")
    TestPo get(@Param("id") String id);

    @Insert("insert into demo (id,name) values (#{id},#{name})")
    int create(TestPo po);
}
