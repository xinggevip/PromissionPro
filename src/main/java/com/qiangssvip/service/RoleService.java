package com.qiangssvip.service;

import com.qiangssvip.domain.PageListRes;
import com.qiangssvip.domain.QueryVo;
import com.qiangssvip.domain.Role;

import java.util.List;

public interface RoleService {
    /* 查询角色列表 */
    public PageListRes getRoles(QueryVo vo);
    /* 保存角色 */
    public void saveRole(Role role);
    /* 更新角色请求 */
    void updateRole(Role role);
    /* 删除角色 */
    void deleteRole(Long rid);
    /* 获取下拉框角色列表 */
    List<Role> roleList();
    /* 根据用户id查询角色 */
    List<Long> getRoleByEid(Long id);
}
