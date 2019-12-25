package com.qiangssvip.service.impl;

import com.qiangssvip.domain.Department;
import com.qiangssvip.mapper.DepartmentMapper;
import com.qiangssvip.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department>  getDepartmentList() {
        List<Department> departments = departmentMapper.selectAll();
        return departments;
    }
}
