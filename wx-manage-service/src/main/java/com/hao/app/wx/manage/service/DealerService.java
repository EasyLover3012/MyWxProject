package com.hao.app.wx.manage.service;

import java.util.List;

import com.hao.app.wx.manage.commons.entity.result.JsonResult;
import com.hao.app.wx.manage.pojo.Dealer;


/**
 * Created by haoguowei.
 * Time 2017/11/30 21:12
 * Desc
 */
public interface DealerService {
	
	List<Dealer> getAllDealer();

    Dealer getByDealerName(String dealerName);

    JsonResult<Dealer> searchDealer(int start, int limit, String dealerName,String sort,String dir);

	int delDealerById(int dealerNameId);
	
	boolean saveDealer(Dealer dealer);
}
