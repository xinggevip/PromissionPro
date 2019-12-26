package com.qiangssvip.mapper;

import com.qiangssvip.domain.Role;
import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Long rid);

    int insert(Role record);

    Role selectByPrimaryKey(Long rid);

    List<Role> selectAll();

    int updateByPrimaryKey(Role record);
}