package com.yjj.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yjj.mapper.ClazzMapper;
import com.yjj.pojo.Clazz;
import com.yjj.pojo.ClazzQueryParam;
import com.yjj.pojo.PageResult;
import com.yjj.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    private ClazzMapper clazzMapper;

    @Override
    public PageResult<Clazz> page(ClazzQueryParam  param) {
        PageHelper.startPage(param.getPage(), param.getPageSize());
        List<Clazz> rows = clazzMapper.list(param);
        Page<Clazz> p = (Page<Clazz>) rows;
        return new PageResult<>(p.getTotal(),p.getResult());
    }
    @Override
    public void save(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.save(clazz);
    }
    @Override
    public void update(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.update(clazz);
    }

    @Override
    public Clazz getById(Integer id) {
        return clazzMapper.getById(id);
    }

    @Override
    public void deleteByIds(Integer ids) {
        clazzMapper.deleteByIds(ids);
    }

    @Override
    public List<Clazz> listAll() {
        return clazzMapper.listAll();
    }


}
