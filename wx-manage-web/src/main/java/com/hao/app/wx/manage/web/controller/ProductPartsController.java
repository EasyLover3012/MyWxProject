package com.hao.app.wx.manage.web.controller;


import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hao.app.wx.manage.commons.entity.Page;
import com.hao.app.wx.manage.commons.entity.result.JsonResult;
import com.hao.app.wx.manage.commons.entity.result.JsonResultAjax;
import com.hao.app.wx.manage.pojo.ProductParts;
import com.hao.app.wx.manage.service.ContractProductService;
import com.hao.app.wx.manage.service.ContractService;
import com.hao.app.wx.manage.service.ProductPartsService;

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
public class ProductPartsController extends BaseController{

    @Autowired
    private ProductPartsService productPartsService;
    
    @Autowired
    private ContractProductService contractProductService;

    @Autowired
    private ContractService contractService;

    @RequestMapping("/initParts.do")
    public String initPrats(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //查询合同信息、产品信息
    	  String contractNo = request.getParameter("contractNo");
        String proNo = request.getParameter("proNo");
//        Contract contract = null;
//        ContractProduct product = null;
//        if (StringUtils.isNotBlank(contractNo)) {
//            contract = contractService.getByContractNo(contractNo);
//            product  = contractProductService.getByContractNoAndProNo(contractNo, proNo);
//        }
        request.setAttribute("contractNo", contractNo);
        request.setAttribute("proNo", proNo);
        request.setAttribute("sysMember", getCurrentUser(request));
        return "jsp/parts";
    }


    @RequestMapping("/searchParts.do")
    public void searchPro(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int start = NumberUtils.toInt(request.getParameter(START));
        int limit = NumberUtils.toInt(request.getParameter(LIMIT), Page.LIMIT);
        String contractNo = request.getParameter("contractNo");
        String proNo = request.getParameter("proNo");
        String partName = request.getParameter("partName");

        JsonResult<ProductParts> result = productPartsService.searchPartsList(contractNo,proNo,partName,start,limit);
        writeResponse(response, result);
    }
	@RequestMapping("/getPartsByPartNo.do")
	public void getPartsByPartNo(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String partNo = request.getParameter("partNo");
		System.out.println("getPartsByPartNo"+partNo);
		ProductParts parts = productPartsService.getPartsByPartNo(partNo);
		System.out.println("getPartsByPartNo parts:"+parts.toString());

		writeResponse(response, parts);
	}
	@RequestMapping("/editParts.do")
	public void editParts(HttpServletRequest request,HttpServletResponse response) throws IOException {
		 String partsNo    = request.getParameter("partsNo");
		 String partsName = request.getParameter("partsName");
		 String partsFmt = request.getParameter("partsFmt");
         String units    = request.getParameter("units");
         String yongliang = request.getParameter("yongliang");
         Double hetongNum = NumberUtils.toDouble(request.getParameter("hetongNum"));
         String lingyong  = request.getParameter("lingyong");
         Double kucunNum  = NumberUtils.toDouble(request.getParameter("kucunNum"));
         String buyNum    = request.getParameter("buyNum");

         //配件编号
         ProductParts part = new ProductParts();
         part.setPartsNo(partsNo);
         part.setYongliang(yongliang);
         part.setLingyong(lingyong);
         part.setPartsName(partsName);
         part.setPartsFmt(partsFmt);
         part.setUnits(units);
         part.setHetongNum(hetongNum);
         part.setKucunNum(kucunNum);
         part.setBuyNum(buyNum);
 		System.out.println("editParts part:"+part.toString());
		boolean result = productPartsService.editParts(part);
		writeResponse(response, new JsonResultAjax(result));
	}
	
	@RequestMapping("/savePartImgs.do")
	public void savePartImgs(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String partsNo = request.getParameter("partsNo");
		String imgs = request.getParameter("imgs");
		
		try {
			if(!partsNo.equals("0")){
				ProductParts part = new ProductParts();
		        part.setPartsNo(partsNo);
		        part.setPartsImg(imgs);
		 		System.out.println("savePartImgs part:"+part.toString());
				productPartsService.editParts(part);
				writeResponse(response, new JsonResultAjax(true));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		writeResponse(response, new JsonResultAjax(true));
	}
	
	
}
