package com.hao.app.wx.manage.service.impl;


import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hao.app.wx.manage.commons.entity.param.ContractQueryParam;
import com.hao.app.wx.manage.commons.entity.result.JsonResult;
import com.hao.app.wx.manage.mapper.ContractProductMapper;
import com.hao.app.wx.manage.pojo.ContractProduct;
import com.hao.app.wx.manage.service.ContractProductService;

import java.util.List;


/**
 * Created by haoguowei.
 * Time 2017/11/30 21:14
 * Desc
 */
@Service
public class ContractProductServiceImpl implements ContractProductService {

    @Autowired
    private ContractProductMapper contractProductMapper;


    @Override
    public ContractProduct getByContractNoAndProNo(String contractNo, String proNo) {
        return contractProductMapper.getByContractNoAndProNo(contractNo,proNo);
    }


    @Override
    public JsonResult<ContractProduct> searchProList(int start, int limit, String contractNo, String proNo) {
        ContractQueryParam queryParam = new ContractQueryParam(start, limit);
        if (StringUtils.isNotBlank(contractNo)){
            queryParam.setContractNo(contractNo);
        }
        if (StringUtils.isNotBlank(proNo)){
            queryParam.setProNo(proNo);
        }

        int count = contractProductMapper.queryCount(queryParam);
        List<ContractProduct> list = contractProductMapper.queryPageList(queryParam);
        return new JsonResult<>(count, list);
    }


	@Override
	public int delProductByContractNo(String contractNo) {
        return contractProductMapper.delProductByContractNo(contractNo);

	}
}
