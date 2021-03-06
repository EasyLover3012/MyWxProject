package com.hao.app.wx.manage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hao.app.wx.manage.commons.entity.param.QueryParam;
import com.hao.app.wx.manage.pojo.SysMember;



public interface SysMemberMapper {

    SysMember queryByPrimaryKey(@Param("id")Integer id);

	int queryMembersCount();

	List<SysMember> queryMembersPageList(QueryParam queryParam);

    int insert(SysMember member);
    
    int updateByPrimaryKey(SysMember member);

	SysMember queryMemberByName(@Param("name")String name);

	void updateMemberValid(@Param("id")int id, @Param("valid")int valid);

	int updateMemberImgs(@Param("id")int id,@Param("imgs") String imgs);

}