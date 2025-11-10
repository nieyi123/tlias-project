package com.yjj.mapper;


import com.yjj.pojo.Student;
import com.yjj.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    /**
     * 条件查询学员列表（分页）
     */
    List<Student> list(StudentQueryParam  param);
    /**
     * 添加学员
     */
    void save(Student student);
    /**
     * 根据id查找学员
     */
    Student getById(Integer id);
    /**
     * 修改学员
     */
    void update(Student student);
    /**
     * 批量删除学员（包括删除单个）
     */
    void deleteByIds(List<Integer> ids);
    /**
     * 违纪：违纪处理一次，需要将违纪次数+1，违纪扣分+前端输入的分数
     */
    @Delete("update student set violation_count = violation_count + 1, violation_score = violation_score + #{violationType},update_time = NOW() where id = #{studentId}")
    void addViolation(@Param("studentId") Integer studentId,
                      @Param("violationType") Integer violationType);
    /**
     * 学员学历统计
     */
    @MapKey("degree")
    List<Map<String, Object>> countEducationData();
}
