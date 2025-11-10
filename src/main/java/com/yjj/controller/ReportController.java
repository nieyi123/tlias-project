package com.yjj.controller;

import com.yjj.pojo.ClazzCountOption;
import com.yjj.pojo.JobOption;
import com.yjj.pojo.Result;
import com.yjj.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@Slf4j
@RequestMapping("/report")
@RestController
public class ReportController {
    @Autowired
    private ReportService reportService;
    @GetMapping("/empJobData")
    public Result getEmpJobData(){
        log.info("查询员工数据统计结果");
        JobOption jobOption = reportService.getEmpJobData();
        return Result.success(jobOption);
    }

    @GetMapping("/empGenderData")
    public Result getEmpGenderData(){
        log.info("查询员工性别数据统计结果");
        List<Map<String,Object>> genderList = reportService.getEmpGenderData();
        return Result.success(genderList);
    }
    //请求路径：/report/studentDegreeData
    //请求方式：GET
    //接口描述：统计学员的学历信息
    @GetMapping("/studentDegreeData")
    public Result getStudentDegreeData(){
        log.info("查询学员学历数据统计结果");
        List<Map<String,Object>> degreeList = reportService.getEmpEducationData();
        return Result.success(degreeList);
    }
    //班级人数统计
    @GetMapping("/studentCountData")
    public Result getStudentCountData(){
        log.info("查询班级学生人数统计结果");
        ClazzCountOption clazzCountOption = reportService.getSubjectData();
        return Result.success(clazzCountOption);
    }

}
