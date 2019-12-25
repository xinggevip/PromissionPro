package com.qiangssvip.web;

import com.qiangssvip.domain.AjaxRes;
import com.qiangssvip.domain.Employee;
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

    /* 更新员工 */
    @RequestMapping("/updateEmployee")
    @ResponseBody
    public AjaxRes updateEmployee(Employee employee){
        System.out.println(employee);
        AjaxRes ajaxRes = new AjaxRes();
        try {
            employeeService.updateEmployee(employee);
            ajaxRes.setMsg("更新成功");
            ajaxRes.setSuccess(true);
        }catch (Exception e){
            ajaxRes.setMsg("更新失败");
            ajaxRes.setSuccess(false);
        }
        return ajaxRes;
    }

    /* 保存员工 */
    @RequestMapping("/saveEmployee")
    @ResponseBody
    public AjaxRes saveEmployee(Employee employee){
        System.out.println(employee);
        AjaxRes ajaxRes = new AjaxRes();
        try {
            employee.setState(true);
            employeeService.saveEmployee(employee);
            ajaxRes.setMsg("保存成功");
            ajaxRes.setSuccess(true);
        }catch (Exception e){
            ajaxRes.setMsg("保存失败");
            ajaxRes.setSuccess(false);
        }

        return ajaxRes;
    }

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
