package com.yjj.service;

import com.yjj.pojo.ClazzCountOption;
import com.yjj.pojo.JobOption;

import java.util.List;
import java.util.Map;

public interface ReportService {
    JobOption getEmpJobData();
    List<Map<String, Object>> getEmpGenderData();
    //学员学历统计
    List<Map<String, Object>> getEmpEducationData();
    //班级人数统计
    ClazzCountOption getSubjectData();
}
