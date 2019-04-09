package com.hao.app.wx.manage.service.impl;


import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hao.app.wx.manage.commons.entity.param.DealerQueryParam;
import com.hao.app.wx.manage.commons.entity.result.JsonResult;
import com.hao.app.wx.manage.mapper.DealerMapper;
import com.hao.app.wx.manage.pojo.Dealer;
import com.hao.app.wx.manage.pojo.SysRole;
import com.hao.app.wx.manage.service.DealerService;

import java.util.List;


/**
 * Created by haoguowei.
 * Time 2017/11/30 21:14
 * Desc
 */
@Service
public class DealerServiceImpl implements DealerService {

    @Autowired
    private DealerMapper dealerMapper;


    
    
    @Override
	public List<Dealer> getAllDealer() {
		// TODO Auto-generated method stub
		return dealerMapper.getAllDealer();
	}


	@Override
    public Dealer getByDealerName(String dealerName) {
        return dealerMapper.getByDealerName(dealerName);
    }


    @Override
    public JsonResult<Dealer> searchDealer(int start, int limit, String dealerName,String sort,String dir) {
        DealerQueryParam queryParam = new DealerQueryParam(start, limit);
        if (StringUtils.isNotBlank(dealerName)){
            queryParam.setDealerName(dealerName);
        }

        String str = " id asc";
      
        queryParam.setSortStr(str);

        int count = dealerMapper.queryCount(queryParam);
        List<Dealer> list = dealerMapper.queryPageList(queryParam);
        return new JsonResult<>(count, list);
    }


	@Override
	public int delDealerById(int dealerNameId) {
        return dealerMapper.delDealerById(dealerNameId);
	}
	
	@Override
	public boolean saveDealer(Dealer dealer) {
		if(dealer.getId() > 0){
			//修改
			dealerMapper.update(dealer);
		}else{
			//新增
			dealerMapper.insert(dealer);
		}
		return true;
	}
}
