package com.hao.app.wx.manage.web.controller;


import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hao.app.wx.manage.commons.entity.Page;
import com.hao.app.wx.manage.commons.entity.result.JsonResult;
import com.hao.app.wx.manage.pojo.Contract;
import com.hao.app.wx.manage.pojo.ContractProduct;
import com.hao.app.wx.manage.service.ContractProductService;
import com.hao.app.wx.manage.service.ContractService;

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
public class ContractProductController extends BaseController{

    @Autowired
    private ContractProductService contractProductService;

    @Autowired
    private ContractService contractService;

    @RequestMapping("/initPro.do")
    public String initPro(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String contractNo = request.getParameter("contractNo");
        Contract contract = null;
        if (StringUtils.isNotBlank(contractNo)) {
            contract = contractService.getByContractNo(contractNo);
        }
        request.setAttribute("contract", contract);
        return "jsp/pro";
    }


    @RequestMapping("/searchPro.do")
    public void searchPro(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int start = NumberUtils.toInt(request.getParameter(START));
        int limit = NumberUtils.toInt(request.getParameter(LIMIT), Page.LIMIT);
        String contractNo = request.getParameter("contractNo");
        String proNo = request.getParameter("proNo");


        JsonResult<ContractProduct> result = contractProductService.searchProList(start,limit,contractNo,proNo);
        writeResponse(response, result);
    }
}
