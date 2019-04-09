package com.hao.app.wx.manage.service.impl;


import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hao.app.wx.manage.commons.entity.param.ContractQueryParam;
import com.hao.app.wx.manage.commons.entity.result.JsonResult;
import com.hao.app.wx.manage.mapper.ContractMapper;
import com.hao.app.wx.manage.pojo.Contract;
import com.hao.app.wx.manage.service.ContractService;

import java.util.List;


/**
 * Created by haoguowei.
 * Time 2017/11/30 21:14
 * Desc
 */
@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractMapper contractMapper;


    @Override
    public Contract getByContractNo(String contractNo) {
        return contractMapper.getByContractNo(contractNo);
    }


    @Override
    public JsonResult<Contract> searchContract(int start, int limit, String contractNo,String sort,String dir) {
        ContractQueryParam queryParam = new ContractQueryParam(start, limit);
        if (StringUtils.isNotBlank(contractNo)){
            queryParam.setContractNo(contractNo);
        }

        String str = "delivery_date desc, contract_no desc";
        if (StringUtils.isNotBlank(sort)){
            String tmp = "";
            if (sort.equals("contractNo")){
                tmp = " contract_no ";
            }
            if (sort.equals("deliveryDate")){
                tmp = " delivery_date ";
            }
            String dirtmp = StringUtils.isBlank(dir) ? " desc " : dir;
            str = tmp + dirtmp;
        }
        queryParam.setSortStr(str);

        int count = contractMapper.queryCount(queryParam);
        List<Contract> list = contractMapper.queryPageList(queryParam);
        return new JsonResult<>(count, list);
    }


	@Override
	public int delContractByNo(String contractNo) {
        return contractMapper.delContractByNo(contractNo);
	}
}
