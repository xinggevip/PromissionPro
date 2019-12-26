package com.qiangssvip.service;

import com.qiangssvip.domain.PageListRes;
import com.qiangssvip.domain.QueryVo;

public interface RoleService {
    /* 查询角色列表 */
    public PageListRes getRoles(QueryVo vo);
}
