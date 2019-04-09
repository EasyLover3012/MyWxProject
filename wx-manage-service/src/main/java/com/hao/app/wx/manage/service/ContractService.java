package com.hao.app.wx.manage.service;

import com.hao.app.wx.manage.commons.entity.result.JsonResult;
import com.hao.app.wx.manage.pojo.Contract;

/**
 * Created by haoguowei.
 * Time 2017/11/30 21:12
 * Desc
 */
public interface ContractService {

    Contract getByContractNo(String contractNo);

    JsonResult<Contract> searchContract(int start, int limit, String contractNo,String sort,String dir);

	int delContractByNo(String contractNo);
}
