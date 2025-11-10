package com.yjj.mapper;


import com.yjj.pojo.Emp;
import com.yjj.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Mapper
public interface EmpMapper {

//    //原始方法
//    // 查询员工总记录数
//    @Select("select count(*) from emp left join dept on emp.dept_id = dept.id")
//    public Long count();
//    // 分页查询员工数据
//    @Select("select emp.*,dept.name as dept_name from emp left join dept on emp.dept_id = dept.id order by emp.update_time desc limit #{start},#{pageSize}")
//    public List<Emp> page(Integer start, Integer pageSize);

    //分页插件方法
    //@Select("select e.*, d.name deptName from emp as e left join dept as d on e.dept_id = d.id")
    public List<Emp> list(EmpQueryParam  param);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into emp(username,name,gender,phone,job,salary,image,entry_date,dept_id,create_time,update_time) values(#{username},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void add(Emp emp);

    void deleteByIds(List<Integer> ids);

    Emp getById(Integer id);

    void updateById(Emp emp);

    @MapKey("pos")
    List<Map<String, Object>> countEmpJobData();


    @MapKey("name")
    List<Map<String, Object>> countEmpGenderData();

    /**
     * 查询所有班主任
     */
    List<Emp> listAll();
    /**
     * 根据用户名和密码查询员工信息
     */
    @Select("select * from emp where username = #{username} and password = #{password}")
    Emp getUsernameAndPassword(Emp emp);
}
