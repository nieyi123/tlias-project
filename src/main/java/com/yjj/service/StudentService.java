package com.yjj.service;

import com.yjj.pojo.PageResult;
import com.yjj.pojo.Student;
import com.yjj.pojo.StudentQueryParam;

import java.util.List;

public interface StudentService {

    PageResult<Student> page(StudentQueryParam param);
    void save(Student student);
    Student getById(Integer id);
    void update(Student student);
    void deleteByIds(List<Integer> ids);
    void addViolation(Integer studentId, Integer violationType);

}
