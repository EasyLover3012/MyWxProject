package com.hao.app.wx.manage.service;

import com.hao.app.wx.manage.commons.entity.result.JsonResult;
import com.hao.app.wx.manage.pojo.ContractProduct;

/**
 * Created by haoguowei.
 * Time 2017/11/30 21:12
 * Desc
 */
public interface ContractProductService {

    ContractProduct getByContractNoAndProNo(String contractNo, String proNo);

    JsonResult<ContractProduct> searchProList(int start, int limit, String contractNo, String proNo);

	int delProductByContractNo(String contractNo);
}