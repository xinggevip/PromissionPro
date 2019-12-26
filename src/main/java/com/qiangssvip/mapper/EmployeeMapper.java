package com.qiangssvip.mapper;

import com.qiangssvip.domain.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Employee record);

    Employee selectByPrimaryKey(Long id);

    List<Employee> selectAll(@Param("keyword") String keyword);

    int updateByPrimaryKey(Employee record);

    int updateState(Long id);
}