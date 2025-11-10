package com.yjj.mapper;

import com.yjj.pojo.Clazz;
import com.yjj.pojo.ClazzQueryParam;
import com.yjj.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface ClazzMapper {
    /**
     * 条件查询班级列表（分页）
     */
    List<Clazz> list(ClazzQueryParam param);

    /**
     * 添加班级
     */
    @Insert("insert into clazz(name,room,create_time,update_time,begin_date,end_date,master_id,subject) values(#{name},#{room},#{createTime},#{updateTime},#{beginDate}, #{endDate},#{masterId},#{subject})")
    void save(Clazz clazz);

    /**
     * 根据id回显班级信息
     */
    Clazz getById(Integer id);

    /**
     * 修改班级
     */
    void update(Clazz clazz);

    /**
     * 删除班级
     */
    @Delete("DELETE FROM clazz WHERE id = #{id}")
    void deleteByIds(Integer id);

    /**
     * 查询所有班级
     */
    @Select("SELECT * FROM clazz")
    List<Clazz> listAll();

    @MapKey("count")
    List<Map<String, Object>> countSubjectData();

}