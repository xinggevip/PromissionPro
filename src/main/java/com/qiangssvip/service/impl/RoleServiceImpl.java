package com.qiangssvip.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qiangssvip.domain.PageListRes;
import com.qiangssvip.domain.Permission;
import com.qiangssvip.domain.QueryVo;
import com.qiangssvip.domain.Role;
import com.qiangssvip.mapper.RoleMapper;
import com.qiangssvip.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    /* 查询角色列表 */
    @Override
    public PageListRes getRoles(QueryVo vo) {
        /* 查询 */
        Page<Object> page = PageHelper.startPage(vo.getPage(), vo.getRows());
        List<Role> roles = roleMapper.selectAll();
        /* 封装结果 */
        PageListRes pageListRes = new PageListRes();
        pageListRes.setTotal(page.getTotal());
        pageListRes.setRows(roles);
        return pageListRes;
    }

    /* 保存角色 保存角色与全拿先之间的关系 */
    @Override
    public void saveRole(Role role) {
        /* 1.保存角色 */
        roleMapper.insert(role);
        /* 2.保存角色与全拿先之间的关系 */
        for (Permission permission : role.getPermissions()) {
            roleMapper.insertRoleAndPermissionRel(role.getRid(),permission.getPid());
        }
    }

    /* 更新角色请求 */
    @Override
    public void updateRole(Role role) {

        /* 1.删除角色与权限之间的关系 */
        roleMapper.delPermissionRel(role.getRid());
        /* 2.更新角色 */
        roleMapper.updateByPrimaryKey(role);
        /* 3.重新建立角色与权限之间的关系 */
        for (Permission permission : role.getPermissions()) {
            roleMapper.insertRoleAndPermissionRel(role.getRid(),permission.getPid());
        }

    }
}
