package com.qiangssvip.mapper;

import com.qiangssvip.domain.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Long rid);

    int insert(Role record);

    Role selectByPrimaryKey(Long rid);

    List<Role> selectAll();

    int updateByPrimaryKey(Role record);

    int insertRoleAndPermissionRel(@Param("rid") Long rid, @Param("pid") Long pid);

    int delPermissionRel(Long rid);

    List<Long> getRoleWidthId(Long id);
}