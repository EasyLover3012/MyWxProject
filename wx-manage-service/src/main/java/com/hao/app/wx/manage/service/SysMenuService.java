package com.hao.app.wx.manage.service;

import java.util.List;

import com.hao.app.wx.manage.commons.entity.TreeNodeMode;
import com.hao.app.wx.manage.pojo.SysMenu;



public interface SysMenuService {

	/**
	 * 查找菜单树
	 * @return
	 */
	List<TreeNodeMode> getMenuTree();

	/**
	 * 菜单列表
	 * @return
	 */
	List<SysMenu> getMenuList();

	SysMenu queryByPrimaryKey(int menuId);

	boolean saveMenu(SysMenu menu);

	boolean deleteMenu(int menuId);

}
