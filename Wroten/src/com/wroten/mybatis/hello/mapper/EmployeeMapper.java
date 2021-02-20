package com.wroten.mybatis.hello.mapper;

import com.wroten.mybatis.hello.domain.Employee;
import com.wroten.mybatis.hello.domain.User;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeMapper {

    List<Employee> query(@Param("minSalary") BigDecimal minSalary);

    List<Employee> query(
            @Param("minSalary") BigDecimal minSalary,//
            @Param("maxSalary") BigDecimal masSalary//
    );

    List<Employee> query(
            @Param("minSalary") BigDecimal minSalary,//
            @Param("maxSalary") BigDecimal masSalary,//
            @Param("deptId") Long deptId
    );
}
