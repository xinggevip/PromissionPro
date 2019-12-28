package com.qiangssvip.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qiangssvip.domain.Employee;
import com.qiangssvip.domain.PageListRes;
import com.qiangssvip.domain.QueryVo;
import com.qiangssvip.domain.Role;
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
    public PageListRes getEmployee(QueryVo vo) {
        /*调用mapper 查询员工*/
        Page<Object> page = PageHelper.startPage(vo.getPage(), vo.getRows());
        List<Employee> employees = employeeMapper.selectAll(vo.getKeyword());

        PageListRes pageListRes = new PageListRes();
        pageListRes.setTotal(page.getTotal());
        pageListRes.setRows(employees);

        return pageListRes;
    }

    /* 保存员工 */
    @Override
    public void saveEmployee(Employee employee) {
        /* 保存员工 */
        employeeMapper.insert(employee);
        /* 保存员工角色关系记录 */
        for (Role role : employee.getRoles()) {
            employeeMapper.insertEmployeeAndRoleRel(employee.getId(),role.getRid());
            System.out.println("插入关系记录");
        }

    }

    /* 更新员工 */
    @Override
    public void updateEmployee(Employee employee) {
        /*  删除员工角色记录 */
        employeeMapper.deleteRoleRel(employee.getId());
        /* 更新员工 */
        employeeMapper.updateByPrimaryKey(employee);
        /* 保存员工角色关系记录 */
        for (Role role : employee.getRoles()) {
            employeeMapper.insertEmployeeAndRoleRel(employee.getId(),role.getRid());
            System.out.println("插入关系记录");
        }
    }

    /* 离职 */
    @Override
    public void updateState(Long id) {
        employeeMapper.updateState(id);
    }
}
