package com.hao.app.wx.manage.service;

import com.hao.app.wx.manage.commons.entity.result.JsonResult;
import com.hao.app.wx.manage.pojo.ProductParts;

/**
 * Created by haoguowei.
 * Time 2017/11/30 21:13
 * Desc
 */
public interface ProductPartsService {


	ProductParts getParts(String partsNo);

	JsonResult<ProductParts> searchPartsList(String contractNo, String proNo, String partName, int start, int limit);

	int updatePartsStatus(ProductParts part);

	int delPartsByContractNo(String contractNo);

	ProductParts getPartsByPartNo(String partNo);

	boolean editParts(ProductParts part);

}
