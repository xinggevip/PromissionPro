package com.qiangssvip.web;

import com.qiangssvip.domain.PageListRes;
import com.qiangssvip.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmployeeController {

    /*注入业务层*/
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/employeeList")
    @ResponseBody
    public PageListRes employeeList(){
        /*调用业务层查询员工*/
        PageListRes employee = employeeService.getEmployee();
        return employee;
    }

    @RequestMapping("/employee")
    public String employee(){
        return "employee";
    }
}
