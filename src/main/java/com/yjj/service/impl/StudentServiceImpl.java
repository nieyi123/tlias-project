package com.yjj.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yjj.mapper.StudentMapper;
import com.yjj.pojo.PageResult;
import com.yjj.pojo.Student;
import com.yjj.pojo.StudentQueryParam;
import com.yjj.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public PageResult<Student> page(StudentQueryParam  param) {
        PageHelper.startPage(param.getPage(), param.getPageSize());
        List<Student> rows = studentMapper.list(param);
        Page<Student> p = (Page<Student>) rows;
        return new PageResult<>(p.getTotal(),p.getResult());
    }
    @Override
    public void save(Student student) {
        // 设置违纪次数和扣分的默认值
        if (student.getViolationCount() == null) {
            student.setViolationCount((short) 0);
        }
        if (student.getViolationScore() == null) {
            student.setViolationScore((short) 0);
        }
        // 设置时间
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.save(student);
    }
    @Override
    public Student getById(Integer id) {
        return studentMapper.getById(id);
    }
    @Override
    public void update(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.update(student);
    }
    @Override
    public void deleteByIds(List<Integer> ids) {
        studentMapper.deleteByIds(ids);
    }
    @Override
    public void addViolation(Integer studentId, Integer violationType) {
        // 根据违纪类型更新学生的违纪次数和扣分
        studentMapper.addViolation(studentId, violationType);
    }
}
