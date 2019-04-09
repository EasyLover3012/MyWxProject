package com.hao.app.wx.manage.web.controller;

import com.google.gson.JsonObject;
import com.hao.app.wx.manage.commons.entity.Page;
import com.hao.app.wx.manage.commons.entity.result.JsonResult;
import com.hao.app.wx.manage.pojo.Contract;
import com.hao.app.wx.manage.service.ContractProductService;
import com.hao.app.wx.manage.service.ContractService;
import com.hao.app.wx.manage.service.ProductPartsService;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by haoguowei.
 * Time 2017/11/30 21:16
 * Desc
 */

@Controller
@RequestMapping
public class ContractController extends BaseController{

    @Autowired
    private ContractService contractService;
    
    @Autowired
    private ContractProductService contractProductService;
    
    @Autowired
    private ProductPartsService productPartsService;

    @RequestMapping("/initContract.do")
    public String initContract(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "jsp/contract";
    }

    @RequestMapping("/searchContract.do")
    public void searchContract(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int start = NumberUtils.toInt(request.getParameter(START));
        int limit = NumberUtils.toInt(request.getParameter(LIMIT), Page.LIMIT);
        String contractNo = request.getParameter("contractNo");
        String sort = request.getParameter("sort");
        String dir = request.getParameter("dir");
        JsonResult<Contract> result = contractService.searchContract(start, limit, contractNo,sort,dir);
        writeResponse(response, result);
    }
    
    @RequestMapping("/delContract.do")
    public void delContract(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String contractNo = request.getParameter("contractNo");
        boolean success = false;
        String msg = "删除失败！";
        //删除合同表、删除产品表、删除配件表
        if(del(contractNo)){
	       	success = true;
	        msg = "保存成功！";
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("success", success);
        jsonObject.addProperty("msg", msg);
        response.getWriter().write(jsonObject.toString());

    }

	private boolean del(String contractNo) {
		int con = contractService.delContractByNo(contractNo);
		if(con>0){
			int pro = contractProductService.delProductByContractNo(contractNo);
			if(pro>0){
				productPartsService.delPartsByContractNo(contractNo);
			}
			return true;
		}
		return false;
	}
    
}
