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
    <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
	 <META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
	 <META HTTP-EQUIV="Expires" CONTENT="0">
    <title>
    </title>

    <script type="text/javascript" src="<%=syspath%>/js/princessOrder.js"></script>
</head>
<body>
<div id="search_div_id">
    <table class="Mytable Myfont">

        <tr>
            <td style="width:20%">授权姓名:</td>
            <td style="width:80%"><input type="text" name="sellCodeName" id="sellCodeName"></td>
            
             <input type="button" value="搜索" class="Mybotton" onclick="searchFunc()">
                <input type="button" value="新增经销商" class="Mybotton" onclick="addF(this)">
          
            
        </tr>
        <tr>
            <td style="width:20%">授权手机号:</td>
            <td style="width:80%"><input type="text" name="customerPhone" id="customerPhone"></td>
        </tr>
        <tr>
            <td style="width:20%">店铺名:</td>
            <td style="width:80%">
	            <select id="highlevelID" name="highlevelID">
					<option value="0">请选择经销商...
					<c:forEach items="${allDealerList }" var="levelDealerVar">
						<option   value="${levelDealerVar.id}">${levelDealerVar.dealerName}
					</c:forEach>
				</select>
            </td>
        </tr>
    </table>
</div>

<!-- 编辑窗 -->
	<div id="pWindow" class="windowDiv">
		<input type="hidden" id="hidDealerIdEdit" name="hidDealerIdEdit" value="">
		<table>
			<tbody>
				<tr>
					<td>姓名:</td>
					<td>
						<input id="wdealerName" name="wdealerName" value="">
					</td>
				</tr>
				<tr>
					<td>微信号:</td>
					<td>
						<input id="wxID" name="wxID" value="">
					</td>
				</tr>
				<tr>
					<td>手机号:</td>
					<td>
						<input id="phone" name="phone" value="">
					</td>
				</tr>
				<tr>
					<td>上线:</td>
					<td>
							
						<select id="highlevelID" name="highlevelID">
							<option value="0">请选择经销商...
							<c:forEach items="${allDealerList }" var="levelDealerVar">
								<option   value="${levelDealerVar.id}">${levelDealerVar.dealerName}
							</c:forEach>
						</select>
			
					</td>
				</tr>
				<tr>
					<td>地址:</td>
					<td>
						
						<textarea id="address" name="address" cols="" rows="3"></textarea>
					</td>
				</tr>
			</tbody>
		</table>
	</div>

</body>
</html>