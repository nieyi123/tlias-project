package com.yjj.controller;


import com.yjj.pojo.Emp;
import com.yjj.pojo.EmpQueryParam;
import com.yjj.pojo.PageResult;
import com.yjj.pojo.Result;
import com.yjj.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping
    public Result page(EmpQueryParam  param){
        log.info("分页查询,参数: page={},pageSize={}",param);
        PageResult<Emp> PageResult = empService.page(param);
        return Result.success(PageResult);
    }
    @PostMapping
    public Result add(@RequestBody Emp emp){
        log.info("新增员工,员工数据: {}",emp);
        empService.save(emp);
        return Result.success();
    }

    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids){
        log.info("删除员工：ids={}",ids);
        empService.deleteByIds(ids);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("查询员工：id={}",id);
        Emp emp = empService.getInfo(id);
        return Result.success(emp);
    }

    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("更新员工：员工数据: {}",emp);
        empService.update(emp);
        return Result.success();
    }

    @GetMapping("/list")
    public Result listAll(){
        log.info("查询所有员工");
        List<Emp> list = empService.listAll();
        return Result.success(list);
    }
}