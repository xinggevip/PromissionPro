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

import java.util.List;

@Controller
public class RoleController {

    /* 注入业务层 */
    @Autowired
    private RoleService roleService;

    /* 获取下拉框角色列表 */
    @RequestMapping("/roleList")
    @ResponseBody
    public List<Role> roleList(){
        List<Role> roles = roleService.roleList();
        return roles;
    }

    /* 删除角色 */
    @RequestMapping("/deleteRole")
    @ResponseBody
    public AjaxRes deleteRole(Long rid){
        AjaxRes ajaxRes = new AjaxRes();
        try {
            roleService.deleteRole(rid);
            ajaxRes.setMsg("删除成功");
            ajaxRes.setSuccess(true);
        }catch (Exception e){
            ajaxRes.setMsg("删除失败");
            ajaxRes.setSuccess(false);
        }
        return ajaxRes;
    }

    /* 更新角色请求 */
    @RequestMapping("/updateRole")
    @ResponseBody
    public AjaxRes updateRole(Role role){
        AjaxRes ajaxRes = new AjaxRes();
        try {
            roleService.updateRole(role);
            ajaxRes.setMsg("更新成功");
            ajaxRes.setSuccess(true);
        }catch (Exception e){
            ajaxRes.setMsg("更新失败");
            ajaxRes.setSuccess(false);
        }
        return ajaxRes;
    }

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
