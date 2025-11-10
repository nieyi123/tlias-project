package com.yjj.service.impl;


import com.yjj.mapper.ClazzMapper;
import com.yjj.mapper.EmpMapper;
import com.yjj.mapper.StudentMapper;
import com.yjj.pojo.ClazzCountOption;
import com.yjj.pojo.JobOption;
import com.yjj.pojo.Student;
import com.yjj.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;  // 添加此导入
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;
    
    @Autowired
    private StudentMapper studentMapper;
    
    @Autowired
    private ClazzMapper clazzMapper;

    @Override
    public JobOption getEmpJobData() {
        List<Map<String,Object>> list = empMapper.countEmpJobData();
        List<Object> jobList = list.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("total")).toList();
        return new JobOption(jobList, dataList);
    }

    @Override
    public List<Map<String, Object>> getEmpGenderData() {
        return empMapper.countEmpGenderData();
    }
    //学员学历统计
    @Override
    public List<Map<String, Object>> getEmpEducationData() {
        return studentMapper.countEducationData();
    }
    //班级人数统计
    @Override
    public ClazzCountOption getSubjectData() {
        List<Map<String, Object>> list = clazzMapper.countSubjectData();
        List<Object> clazzList = list.stream().map(dataMap -> dataMap.get("name")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("value")).toList();
        return new ClazzCountOption(clazzList, dataList);
    }

}
