package com.hao.app.wx.manage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hao.app.wx.manage.pojo.SysRole;


/**
 * 角色表
 * 
 * @author haoguowei
 *
 */
public interface SysRoleMapper {

    List<SysRole> queryAllRoles();

	SysRole queryByPrimaryKey(@Param("id")int id);

	void updateRole(SysRole role);

	void insertRole(SysRole role);

	void deleteRole(@Param("id")int id);
}