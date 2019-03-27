package com.hao.app.wx.manage.service;

import java.util.List;

import com.hao.app.wx.manage.pojo.SysRole;


public interface SysRoleService {

	List<SysRole> queryAllRoles();

	SysRole queryByPrimaryKey(int roleId);

	boolean deleteRole(int roleId);

	boolean saveRole(SysRole role);

}
