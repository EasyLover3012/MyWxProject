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
    <script type="text/javascript">
        Ext.onReady(function(){
            Ext.QuickTips.init();

            this.searchFunc=function(){
                gridStore.setBaseParam("contractNo", document.getElementById("contractNo").value);
                gridStore.setBaseParam("proNo", document.getElementById("proNo").value);
                gridStore.load();
            };

            this.viewDetail=function(id, contractNo, proNo){
//                alert(id)
//                alert(contractNo)
//                alert(proNo)
                location.href = "initParts.do?contractNo=" + contractNo + "&proNo=" + proNo;
            };

            //列表数据
            var gridStore = new Ext.data.JsonStore({
                url : 'searchPro.do',
                root : 'resultList',
                remoteSort: false,
                totalProperty:'total',
                fields: [
                    {name:'id'},
                    {name:'contractNo'},
                    {name:'proNo'},
                    {name:'proName'},
                    {name:'proImg'},
                    {name:'proUnits'},
                    {name:'proGross'},
                    {name:'userName'},
                    {name:'createTime'},
                    {name:'updateTime'},
                    {name:'remark'}
                ],
                baseParams : {
                    limit : 20,
                    name :''
                }
            });

            var grid = new com.custom.GridPanel({
                store : gridStore,
                region : 'center',
                frame : false,
                border : false,
                autoHeight:true,
                columns: [
                    {width:1,header:'合同号', align:'center',sortable:false, dataIndex:'contractNo'},
                    {width:1,header:'公司货号', align:'center',sortable:false, dataIndex:'proNo'},
                    {width:2,header:'产品名称', align:'center',sortable:false, dataIndex:'proName'},
                    {width:1,header:'产品图片', align:'center',sortable:false, dataIndex:'proImg',renderer:function(val,cell,record){
                        return '<img src="'+ (IMAGEURL + val) +'"  style="max-width: 75px;">';
                    }},
                    {width:0.5,header:'高度(cm)', align:'center',sortable:false, dataIndex:'proUnits'},
                    {width:1,header:'本合同数量', align:'right',sortable:false, dataIndex:'proGross'},
                    {width:1,header:'系统操作人', align:'left',sortable:false, dataIndex:'userName',renderer:function(val,m,rec){
                        return val + '<br><span style="color: grey">' + Ext.util.Format.date(rec.data.createTime,'Y-m-d H:i') + '</span>';
                    }},
                    {width:1,header:'操作', align:'center',sortable:false, dataIndex:'id',renderer:function(val,cell,record){
                        return '<input type="button" value="产品详情" class="Mybotton" onclick="viewDetail(\''+val+'\',\''+record.data.contractNo+'\',\''+record.data.proNo+'\')">';
                    }}
                ]
            });

            new Ext.Viewport({
                layout : 'border',
                items : [{
                    region : 'north',
                    title :  "合同产品",
                    border : false,
                    height : 75,
                    keys : {
                        key : Ext.EventObject.ENTER,
                        fn : function(btn,e){
                            searchFunc();
                        }
                    },
                    contentEl : 'search_div_id'
                },{
                    region : 'center',
                    frame : false,
                    border : true,
                    autoScroll : true,
                    items : [grid],
                    tbar : ['->',new Ext.PagingToolbar({
                        pageSize: 20,
                        store: gridStore,
                        style : {'border' : 0},
                        displayInfo: true
                    })]
                }]
            });

            searchFunc();
        });
    </script>
</head>
<body>
<div id="search_div_id">
    <table class="Mytable">
        <tr><td class="Myfont">
            合同号：
            <input type="text" name="contractNo" id="contractNo" value="${contract.contractNo}">
            公司货号：
            <input type="text" name="proNo" id="proNo">
            <input type="button" value="搜索" class="Mybotton" onclick="searchFunc()">
        </td>
        </tr>
    </table>
</div>
</body>
</html>