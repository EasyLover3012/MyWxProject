package com.hao.app.wx.manage.mapper;



import org.apache.ibatis.annotations.Param;

import com.hao.app.wx.manage.commons.entity.param.QueryParam;
import com.hao.app.wx.manage.pojo.Contract;

import java.util.List;


public interface ContractMapper {

    int insert(Contract record);

    Contract getByContractNo(@Param("contractNo") String contractNo);

    int queryCount(QueryParam queryParam);

    List<Contract> queryPageList(QueryParam queryParam);

	int delContractByNo(@Param("contractNo")String contractNo);
}