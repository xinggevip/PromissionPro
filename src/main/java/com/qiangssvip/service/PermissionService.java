package com.qiangssvip.service;

import com.qiangssvip.domain.Permission;

import java.util.List;

public interface PermissionService {
    public List<Permission> getPermissions();
    /* 根据角色查权限 */
    public List<Permission> getPermissionByRid(Long rid);
}
