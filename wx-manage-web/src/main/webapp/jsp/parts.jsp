<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="../import.jsp"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>
    </title>
    	<!-- 上传图片 -->
	<link rel="stylesheet" type="text/css" href="<%=syspath%>/utils/upload/FileUploadField.css" />
	<script type="text/javascript" src="<%=syspath%>/utils/upload/FileUploadField.js"></script>
	<script type="text/javascript" src="<%=syspath%>/utils/upload/FileUpLoadWindow.js"></script>
    
    <script type="text/javascript" src="<%=syspath%>/js/parts.js"></script>
    <script type="text/javascript" src="<%=syspath%>/utils/jquery.js"></script>
</head>
<body>
<div id="search_div_id">
    <table class="Mytable">
        <tr><td class="Myfont">
            合同号：
            <input type="text" name="contractNo" id="contractNo" value="${contractNo}">
            公司货号：
            <input type="text" name="proNo" id="proNo" value="${proNo}">
            配件名称：
            <input type="text" name="partName" id="partName">
            <input type="button" value="搜索" class="Mybotton" onclick="searchFunc()">
        </td>
        </tr>
    </table>
</div>

<!-- 操作日志窗 -->
<div id="logWindow" class="windowDiv" style="height:380px;overflow: auto;">
    <table>
        <tr><td>无相关记录！</td></tr>
    </table>
</div>


<!-- 新增日志窗 -->
<div id="addLongWindow" class="windowDiv" style="height:380px;overflow: auto;z-index: 10">
    <input type="hidden" id="partNos" name="partNos">
    <table class="myTable">
        <tr><td style="width: 200px;">当前操作人：</td><td>${sysMember.showName}(${sysMember.name})</td></tr>
        <tr>
            <td>收发类型：</td>
            <td>
                <input type="radio" id="sfTypes0" name="sfTypes" value="0" style="width: 20px;"><label for="sfTypes0">收货</label>
                <input type="radio" id="sfTypes1" name="sfTypes" value="1" style="width: 20px;"><label for="sfTypes1">外发-发</label>
                <input type="radio" id="sfTypes2" name="sfTypes" value="2" style="width: 20px;"><label for="sfTypes2">外发-收</label>
            </td>
        </tr>
        <tr><td>日期：</td><td>
            <div id="startTimeDIV" style="z-index: -1"></div>
        </td></tr>
        <tr><td>数量：</td><td>
            <input type="text" id="numbs" name="numbs">
        </td></tr>
        <tr><td>供应商/加工户：</td><td>
            <input type="text" id="processMan" name="processMan">
        </td></tr>
        <tr><td>工厂收发人：</td><td>
            <input type="text" id="remark" name="remark">
        </td></tr>
    </table>
</div>

<!-- 编辑窗 -->
<div id="menuWindow" class="windowDiv">
	<input type="hidden" id="epartsNo" name="epartsNo" value="">
	<table>
		<tbody>
			<tr>
				<td>配件名称:</td>
				<td>
					<input id="epartsName" name="epartsName" value="">
				</td>
			</tr>
			<tr>
				<td>配件规格:</td>
				<td>
					<input id="epartsFmt" name="epartsFmt" value="">
				</td>
			</tr>
			<tr>
				<td>单位（个\斤\枝\条等等）:</td>
				<td>
					<input id="eunits" name="eunits" value="">
				</td>
			</tr>
			<tr>
				<td>每款用量:</td>
				<td>
					<input id="eyongliang" name="eyongliang" value="">
				</td>
			</tr>
			<tr>
				<td>领用单位:</td>
				<td>
					<input id="elingyong" name="elingyong" value="">
				</td>
			</tr>
			<tr>
				<td>本合同量:</td>
				<td>
					<input id="ehetongNum" name="ehetongNum" value="">
				</td>
			</tr>
			<tr>
				<td>库存存量:</td>
				<td>
					<input id="ekucunNum" name="ekucunNum" value="">
				</td>
			</tr>
			<tr>
				<td>购买数量:</td>
				<td>
					<input id="ebuyNum" name="ebuyNum" value="">
				</td>
			</tr>
		</tbody>
	</table>
</div>
</body>
</html>