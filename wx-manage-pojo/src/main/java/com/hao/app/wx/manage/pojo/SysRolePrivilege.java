package com.hao.app.wx.manage.pojo;

import java.io.Serializable;

public class SysRolePrivilege implements Serializable{
 
	private Integer roleId;

    private Integer privilegeId;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(Integer privilegeId) {
        this.privilegeId = privilegeId;
    }
}