package com.qiangssvip.web;

import com.qiangssvip.domain.AjaxRes;
import com.qiangssvip.domain.PageListRes;
import com.qiangssvip.domain.QueryVo;
import com.qiangssvip.domain.Role;
import com.qiangssvip.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RoleController {

    /* 注入业务层 */
    @Autowired
    private RoleService roleService;

    /* 接收 保存角色请求地址 */
    @RequestMapping("/saveRole")
    @ResponseBody
    public AjaxRes saveRole(Role role){

        AjaxRes ajaxRes = new AjaxRes();
        try {
            roleService.saveRole(role);
            ajaxRes.setMsg("保存成功");
            ajaxRes.setSuccess(true);
        }catch (Exception e){
            ajaxRes.setMsg("保存失败");
            ajaxRes.setSuccess(false);
        }
        return ajaxRes;
    }

    /* 获取所有角色 */
    @RequestMapping("/getRoles")
    @ResponseBody
    public PageListRes getRoles(QueryVo vo){
        PageListRes roles = roleService.getRoles(vo);
        return roles;
        /*System.out.println(vo);
        return null;*/
    }

    @RequestMapping("/role")
    public String employee(){
        return "role";
    }
}
