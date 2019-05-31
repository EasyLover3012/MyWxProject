package com.hao.app.wx.manage.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.hao.app.wx.manage.commons.entity.result.JsonResult;
import com.hao.app.wx.manage.pojo.Dealer;
import com.hao.app.wx.manage.pojo.PrincessOrder;


/**
 * Created by haoguowei.
 * Time 2017/11/30 21:12
 * Desc
 */
public interface PrincessOrderService {
	


    JsonResult<PrincessOrder> searchOrder(int start, int limit, Map<String,Object> map,String sort,String dir);


}
