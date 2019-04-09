package com.hao.app.wx.manage.mapper;

import org.apache.ibatis.annotations.Param;

import com.hao.app.wx.manage.commons.entity.param.ContractQueryParam;
import com.hao.app.wx.manage.pojo.ProductParts;

import java.util.List;


public interface ProductPartsMapper {

    int insert(ProductParts record);

	ProductParts getParts(@Param("partsNo")String partsNo);

    int queryCount(ContractQueryParam queryParam);

    List<ProductParts> queryPageList(ContractQueryParam queryParam);

    int updatePartsStatus(ProductParts part);

    int delPartsByContractNo(@Param("contractNo")String contractNo);

	int editParts(ProductParts part);

}