package com.hao.app.wx.manage.mapper;



import org.apache.ibatis.annotations.Param;

import com.hao.app.wx.manage.commons.entity.param.QueryParam;
import com.hao.app.wx.manage.pojo.Dealer;

import java.util.List;


public interface DealerMapper {
	
	List<Dealer> getAllDealer();

    int insert(Dealer record);

    Dealer getByDealerName(@Param("dealerName") String dealerName);

    int queryCount(QueryParam queryParam);

    List<Dealer> queryPageList(QueryParam queryParam);

	int delDealerById(@Param("dealerNameId")int dealerNameId);
	
	void update(Dealer dealer);
	
}