package com.yjj.service;


import com.yjj.pojo.Emp;
import com.yjj.pojo.EmpQueryParam;
import com.yjj.pojo.LoginInfo;
import com.yjj.pojo.PageResult;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    PageResult<Emp> page(EmpQueryParam empQueryParam);

    void save(Emp emp);
    void deleteByIds(List<Integer> ids);
    Emp getInfo(Integer id);
    void update(Emp emp);
    List<Emp> listAll();
    LoginInfo login(Emp emp);
}
