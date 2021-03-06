package com.qiangssvip.web;

import com.qiangssvip.domain.Permission;
import com.qiangssvip.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PermissionController {
    /* 注入业务层 */
    @Autowired
    private PermissionService permissionService;

    /* 根据角色查权限 */
    @RequestMapping("/getPermissionByRid")
    @ResponseBody
    public List<Permission> getPermissionByRid(Long rid){
        List<Permission> permissionByRid = permissionService.getPermissionByRid(rid);
        return permissionByRid;
    }

    @RequestMapping("/permissionList")
    @ResponseBody
    public List<Permission> permissionList(){
        List<Permission> permissions = permissionService.getPermissions();
        return permissions;
    }
}
