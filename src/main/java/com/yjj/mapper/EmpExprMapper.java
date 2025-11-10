package com.yjj.mapper;

import com.yjj.pojo.Emp;
import com.yjj.pojo.EmpExpr;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.List;

@Mapper
public interface EmpExprMapper {
    void insertBatch(List<EmpExpr> exprList);
    void deleteByEmpIds(List<Integer> ids);
}
