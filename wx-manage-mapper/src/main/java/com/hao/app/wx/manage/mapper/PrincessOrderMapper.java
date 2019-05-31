package com.hao.app.wx.manage.mapper;



import org.apache.ibatis.annotations.Param;

import com.hao.app.wx.manage.commons.entity.param.QueryParam;
import com.hao.app.wx.manage.pojo.PrincessOrder;

import java.util.List;


public interface PrincessOrderMapper {

	 int queryCount(QueryParam queryParam);
	
    List<PrincessOrder> queryPageList(QueryParam queryParam);

}