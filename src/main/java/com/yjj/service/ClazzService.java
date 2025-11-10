package com.yjj.service;

import com.yjj.pojo.Clazz;
import com.yjj.pojo.ClazzQueryParam;
import com.yjj.pojo.PageResult;

import java.util.List;
import java.util.Map;

public interface ClazzService {
    PageResult<Clazz> page(ClazzQueryParam param);
    void save(Clazz clazz);
    void update(Clazz clazz);
    Clazz getById(Integer id);
    void deleteByIds(Integer ids);

    List<Clazz> listAll();

}
