package com.yjj.controller;


import com.yjj.mapper.EmpMapper;
import com.yjj.pojo.*;
import com.yjj.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/clazzs")
public class ClazzController {
    @Autowired
    private ClazzService clazzService;
    @GetMapping
    public Result page(ClazzQueryParam param) {
        log.info("班级列表查询，参数：{}", param);
        PageResult<Clazz> pageResult = clazzService.page(param);
        return Result.success(pageResult);
    }
    @PostMapping
    public Result add(@RequestBody Clazz clazz) {
        log.info("添加班级，参数：{}", clazz);
        clazzService.save(clazz);
        return Result.success();
    }
    @PutMapping
    public Result update(@RequestBody Clazz clazz){
        log.info("更新班级：班级数据: {}",clazz);
        clazzService.update(clazz);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("根据ID查询班级：{}", id);
        Clazz clazz = clazzService.getById(id);
        return Result.success(clazz);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("删除班级：{}", id);
        clazzService.deleteByIds(id);
        return Result.success();
    }

    @GetMapping("/list")
    public Result listAll(){
        log.info("查询所有班级");
        List<Clazz> list = clazzService.listAll();
        return Result.success(list);
    }



}

