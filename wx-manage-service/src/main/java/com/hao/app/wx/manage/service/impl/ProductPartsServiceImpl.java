package com.hao.app.wx.manage.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hao.app.wx.manage.commons.entity.param.ContractQueryParam;
import com.hao.app.wx.manage.commons.entity.result.JsonResult;
import com.hao.app.wx.manage.mapper.ProductPartsMapper;
import com.hao.app.wx.manage.pojo.ProductParts;
import com.hao.app.wx.manage.service.ProductPartsService;

import java.util.List;


/**
 * Created by haoguowei.
 * Time 2017/11/30 21:15
 * Desc
 */
@Service
public class ProductPartsServiceImpl implements ProductPartsService {

    @Autowired
    private ProductPartsMapper productPartsMapper;


	@Override
	public ProductParts getParts(String partsNo) {
		ProductParts parts = productPartsMapper.getParts(partsNo);
		return parts;
	}


	@Override
	public JsonResult<ProductParts> searchPartsList(String contractNo, String proNo, String partName, int start, int limit) {
		ContractQueryParam queryParam = new ContractQueryParam(start, limit);

		if (StringUtils.isNotBlank(contractNo)){
			queryParam.setContractNo(contractNo);
		}
		if (StringUtils.isNotBlank(proNo)){
			queryParam.setProNo(proNo);
		}
		if (StringUtils.isNotBlank(partName)){
			queryParam.setPartName(partName);
		}

		int count = productPartsMapper.queryCount(queryParam);
		List<ProductParts> list = productPartsMapper.queryPageList(queryParam);
		return new JsonResult<>(count, list);
	}


	@Override
	public int updatePartsStatus(ProductParts part) {
		return productPartsMapper.updatePartsStatus(part);
	}


	@Override
	public int delPartsByContractNo(String contractNo) {
		 return productPartsMapper.delPartsByContractNo(contractNo);
	}


	@Override
	public ProductParts getPartsByPartNo(String partsNo) {
		ProductParts parts = productPartsMapper.getParts(partsNo);
		return parts;
	}
	
	@Override
	public boolean editParts(ProductParts part){
		int res = productPartsMapper.editParts(part);
		if(res>0){
			return true;
		}
		return false;
	}
}
