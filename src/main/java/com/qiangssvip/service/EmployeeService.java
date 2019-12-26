package com.qiangssvip.service;

import com.qiangssvip.domain.Employee;
import com.qiangssvip.domain.PageListRes;

public interface EmployeeService {
    /*查询员工*/
    public PageListRes getEmployee();
    /* 保存员工 */
    public void saveEmployee(Employee employee);
    /* 更新员工 */
    public void updateEmployee(Employee employee);
    /* 离职 */
    public void updateState(Long id);
}
