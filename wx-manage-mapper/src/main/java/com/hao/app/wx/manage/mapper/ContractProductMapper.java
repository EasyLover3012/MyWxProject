package com.hao.app.wx.manage.mapper;


import org.apache.ibatis.annotations.Param;

import com.hao.app.wx.manage.commons.entity.param.ContractQueryParam;
import com.hao.app.wx.manage.pojo.ContractProduct;

import java.util.List;


public interface ContractProductMapper {

    int insert(ContractProduct record);

    ContractProduct getByContractNoAndProNo(@Param("contractNo") String contractNo, @Param("proNo") String proNo);

    int queryCount(ContractQueryParam queryParam);

    List<ContractProduct> queryPageList(ContractQueryParam queryParam);

	int delProductByContractNo(@Param("contractNo")String contractNo);
}