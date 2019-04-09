package com.hao.app.wx.manage.web.controller;

import com.google.gson.JsonObject;
import com.hao.app.wx.manage.commons.entity.Page;
import com.hao.app.wx.manage.commons.entity.result.JsonResult;
import com.hao.app.wx.manage.commons.entity.result.JsonResultAjax;
import com.hao.app.wx.manage.pojo.Dealer;
import com.hao.app.wx.manage.pojo.SysRole;
import com.hao.app.wx.manage.service.DealerService;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by haoguowei.
 * Time 2017/11/30 21:16
 * Desc
 */

@Controller
@RequestMapping
public class DealerController extends BaseController{

    @Autowired
    private DealerService dealerService;

    @RequestMapping("/initDealer.do")
    public String initContract(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	List<Dealer> Dealerlist= dealerService.getAllDealer();
    	request.setAttribute("allDealerList", Dealerlist);
    	return "jsp/dealer";
    }

    @RequestMapping("/searchDealer.do")
    public void searchDealer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int start = NumberUtils.toInt(request.getParameter(START));
        int limit = NumberUtils.toInt(request.getParameter(LIMIT), Page.LIMIT);
        String dealerName = request.getParameter("dealerName");
        String sort = request.getParameter("sort");
        String dir = request.getParameter("dir");
        JsonResult<Dealer> result = dealerService.searchDealer(start, limit, dealerName,sort,dir);
        writeResponse(response, result);
    }
    
    @RequestMapping("/saveDealer.do")
	public void saveDealer(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Dealer dealer = new Dealer();
		dealer.setId(NumberUtils.toInt(request.getParameter("id")));
		dealer.setDealerName(request.getParameter("dealerName"));
		dealer.setWxId(request.getParameter("wxID"));
		dealer.setTelphone(request.getParameter("phone"));
		dealer.setHighlevelid(NumberUtils.toInt(request.getParameter("highlevelID")));
		dealer.setAddress(request.getParameter("address"));
		
		
		boolean result = dealerService.saveDealer(dealer);
		
		sysLogsService.writeLog(getCurrentUserName(request), "保存经销商，result : " + result + ";dealer：" + dealer.toString());
		writeResponse(response, new JsonResultAjax(result));
	}
    
    @RequestMapping("/delDealer.do")
    public void delDealer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int dealerNameId =NumberUtils.toInt( request.getParameter("dealerNameId"));
        boolean success = false;
        String msg = "删除失败！";
        //删除经销商
        if(del(dealerNameId)){
	       	success = true;
	        msg = "保存成功！";
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("success", success);
        jsonObject.addProperty("msg", msg);
        response.getWriter().write(jsonObject.toString());

    }

	private boolean del(int dealerNameId) {
		int con = dealerService.delDealerById(dealerNameId);
		if(con>0){
			return true;
		}
		return false;
	}
    
}
