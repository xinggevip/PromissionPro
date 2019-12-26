package com.qiangssvip.service.impl;

import com.qiangssvip.domain.Permission;
import com.qiangssvip.mapper.PermissionMapper;
import com.qiangssvip.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> getPermissions() {
        List<Permission> permissions = permissionMapper.selectAll();
        return permissions;
    }

    /* 根据角色查权限 */
    @Override
    public List<Permission> getPermissionByRid(Long rid) {
        List<Permission> permissions = permissionMapper.selectPermissionByRid(rid);
        return permissions;
    }
}
