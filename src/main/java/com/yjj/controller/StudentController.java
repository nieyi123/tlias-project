package com.yjj.controller;


import com.yjj.pojo.PageResult;
import com.yjj.pojo.Result;
import com.yjj.pojo.Student;
import com.yjj.pojo.StudentQueryParam;
import com.yjj.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping
    public Result page(StudentQueryParam param) {
        log.info("学生列表查询，参数：{}", param);
        PageResult<Student> pageResult = studentService.page(param);
        return Result.success(pageResult);  // ✅ 用 Result 包装
    }
    @PostMapping
    public Result add(@RequestBody Student student) {
        log.info("添加学生，参数：{}", student);
        studentService.save(student);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("根据ID查询学生：{}", id);
        Student student = studentService.getById(id);
        return Result.success(student);
    }
    @PutMapping
    public Result update(@RequestBody Student student){
        log.info("更新学生：学生数据: {}",student);
        studentService.update(student);
        return Result.success();
    }
    // 删除学生（支持单个和批量：/students/11 或 /students/11,13）
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable String ids) {
        log.info("删除学生：{}", ids);
        // 将 "11" 或 "11,13" 分割成 List<Integer>
        List<Integer> idList = Arrays.stream(ids.split(","))
                                     .map(Integer::parseInt)
                                     .collect(Collectors.toList());
        studentService.deleteByIds(idList);
        return Result.success();
    }

    // 批量删除（请求体传 JSON 数组）
    @DeleteMapping
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        log.info("批量删除学生：{}", ids);
        studentService.deleteByIds(ids);
        return Result.success();
    }

    @PutMapping("/violation/{studentId}/{violationType}")
    public Result addViolation(@PathVariable Integer studentId,
                               @PathVariable Integer violationType) {
        log.info("记录学生违纪：学生ID={}, 违纪类型={}", studentId, violationType);
        studentService.addViolation(studentId, violationType);
        return Result.success();
    }
}
