package com.yjj.mapper;

import com.yjj.pojo.Dept;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Mapper
public interface DeptMapper {

    @Select("select id,name,create_time,update_time from dept order by update_time desc")
    public List<Dept> findAll();

    @Delete("delete from dept where id=#{id}")
    public void deleteById(Integer id);

    @Insert("insert into dept(name,create_time,update_time) values(#{name},#{createTime},#{updateTime})")
    public void addDept(Dept dept);

    @Select("select id,name,create_time,update_time from dept where id=#{id}")
    public Dept getById(Integer id);

    @Update("update dept set name=#{name},update_time=#{updateTime} where id=#{id}")
    public void update(Dept dept);
}
