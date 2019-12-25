package com.qiangssvip.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qiangssvip.domain.Employee;
import com.qiangssvip.domain.PageListRes;
import com.qiangssvip.mapper.EmployeeMapper;
import com.qiangssvip.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public PageListRes getEmployee() {
        /*调用mapper 查询员工*/
        Page<Object> page = PageHelper.startPage(1, 5);
        List<Employee> employees = employeeMapper.selectAll();

        PageListRes pageListRes = new PageListRes();
        pageListRes.setTotal(page.getTotal());
        pageListRes.setRows(employees);

        return pageListRes;
    }

    /* 保存员工 */
    @Override
    public void saveEmployee(Employee employee) {

        int insert = employeeMapper.insert(employee);

    }
}
