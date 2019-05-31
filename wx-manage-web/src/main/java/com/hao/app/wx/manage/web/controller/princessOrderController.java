package com.hao.app.wx.manage.web.controller;

import com.google.gson.JsonObject;
import com.hao.app.wx.manage.commons.entity.Page;
import com.hao.app.wx.manage.commons.entity.result.JsonResult;
import com.hao.app.wx.manage.pojo.PrincessOrder;
import com.hao.app.wx.manage.service.PrincessOrderService;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by haoguowei.
 * Time 2017/11/30 21:16
 * Desc
 */

@Controller
@RequestMapping
public class princessOrderController extends BaseController{

    @Autowired
    private PrincessOrderService princessOrderService;
    
   

    @RequestMapping("/initPrincessOrder.do")
    public String initContract(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "jsp/princessOrder";
    }

    @RequestMapping("/searchPrincessOrder.do")
    public void searchPrincessOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int start = NumberUtils.toInt(request.getParameter(START));
        int limit = NumberUtils.toInt(request.getParameter(LIMIT), Page.LIMIT);
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        String shopNameId = request.getParameter("shopNameId");
        String sellCode = request.getParameter("sellCode");
        String customerPhone = request.getParameter("customerPhone");
        String sort = request.getParameter("sort");
        String dir = request.getParameter("dir");
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("startTime", startTime);
        map.put("endTime", endTime);
        map.put("shopNameId", shopNameId);
        map.put("sellCode", sellCode);
        map.put("customerPhone", customerPhone);
        
        JsonResult<PrincessOrder> result = princessOrderService.searchOrder(start, limit, map,sort,dir);
        writeResponse(response, result);
    }
    
   
    
}
