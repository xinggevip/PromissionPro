package com.qiangssvip.service;

import com.qiangssvip.domain.PageListRes;
import com.qiangssvip.domain.QueryVo;
import com.qiangssvip.domain.Role;

public interface RoleService {
    /* 查询角色列表 */
    public PageListRes getRoles(QueryVo vo);
    /* 保存角色 */
    public void saveRole(Role role);
}
