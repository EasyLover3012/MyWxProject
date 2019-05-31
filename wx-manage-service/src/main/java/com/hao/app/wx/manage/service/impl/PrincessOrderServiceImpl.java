package com.hao.app.wx.manage.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hao.app.wx.manage.commons.entity.param.PrincessOrderQueryParam;
import com.hao.app.wx.manage.commons.entity.result.JsonResult;
import com.hao.app.wx.manage.mapper.PrincessOrderMapper;
import com.hao.app.wx.manage.pojo.Contract;
import com.hao.app.wx.manage.pojo.PrincessOrder;
import com.hao.app.wx.manage.service.PrincessOrderService;

@Service
public class PrincessOrderServiceImpl implements PrincessOrderService {

	@Autowired
	private PrincessOrderMapper princessOrderMapper;
	
	@Override
	public JsonResult<PrincessOrder> searchOrder(int start, int limit, Map<String, Object> map, String sort,
			String dir)  {
		try{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		PrincessOrderQueryParam queryParam=new PrincessOrderQueryParam(start,limit);
		
		Date startTime=sdf.parse( map.get("startTime").toString());
		Date endTime=sdf.parse( map.get("endTime").toString());
		Integer shopNameId=NumberUtils.toInt(map.get("shopNameId").toString());
		String sellCode=map.get("sellCode").toString();
		String customerPhone=map.get("customerPhone").toString();
		
		queryParam.setStartTime(startTime);
		queryParam.setEndTime(endTime);
		queryParam.setShopNameId(shopNameId);
		
				
		  if (StringUtils.isNotBlank(sellCode)){
	            queryParam.setSellCode(sellCode);
	        }
		  if (StringUtils.isNotBlank(customerPhone)){
	            queryParam.setSellCode(customerPhone);
	        }
		  queryParam.setSortStr(" id desc ");
		   int count = princessOrderMapper.queryCount(queryParam);
	        List<PrincessOrder> list = princessOrderMapper.queryPageList(queryParam);
	        return new JsonResult<>(count, list);
		}catch(Exception ex){
			return null;
		}
	}

}
