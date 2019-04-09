Ext.onReady(function(){
    Ext.QuickTips.init();

    //是否有权限
    var isPRIAddLogs = isHavePRI("addPartLogs.do");
    var isPRISendAndRecList = isHavePRI("initPartsSendAndRec.do");
    var isPRIEdit = isHavePRI("editParts.do");
	var isPRISavePartImgs = isHavePRI("savePartImgs.do");//修改头像
	var uploadId = "0";


    this.searchFunc=function(){
        gridStore.setBaseParam("contractNo", document.getElementById("contractNo").value);
        gridStore.setBaseParam("proNo", document.getElementById("proNo").value);
        gridStore.setBaseParam("partName", document.getElementById("partName").value);
        gridStore.load();
    };


    this.addLog=function(partNos){
        $("#sfTypes0").attr("checked","checked");
        $("#dates").val('');
        $("#numbs").val('');
        $("#processMan").val('');
        $("#remark").val('');
        $("#partNos").val(partNos);
        addLongWindow.show();
    };
    this.sendAndRecList=function(partNos){
        location.href = "initPartsSendAndRec.do?type=-1&partNo=" + partNos;
    };


    new com.custom.DateField({
        renderTo: 'startTimeDIV',
        format: 'Y-m-d',
        name: 'dates',
        width: 180,
        id: 'dates'
    });


    this.showLogWin=function(partNo,type){
        Ext.Ajax.request({
                             url : "listPartLogs.do?partNo=" + partNo+"&type="+type,
                             success : function(response) {
                                 var resp = Ext.util.JSON.decode(response.responseText);
                                 var html = '<table>';

                                 if (resp.resultList == null || resp.resultList.length == 0){
                                     html += '<tr><td>无相关记录！</td></tr>';
                                 }else {
                                     for (var i = 0 ; i< resp.resultList.length; i++){
                                         var obj = resp.resultList[i];
                                         html += '<tr>';
                                         html += '<td style="width: 250px;color: gray">';
                                         html +=  (i+1);
                                         html += '.' + Ext.util.Format.date(obj.createTime,'Y-m-d H:i:s');
                                         html += '.' + obj.handlingMan + "（录）";
                                         html += '</td>';
                                         html += '<td>';

                                         var msg = '';
                                         if (obj.type==0){
                                             msg = '工厂收发人：'+obj.remark+'于'+obj.date+'从供应商：'+obj.processMan+'<span style="color: blue;">收货</span>数量 ' + obj.num;
                                         }
                                         if (obj.type==1){
                                             msg = '工厂收发人：'+obj.remark+'于'+obj.date+'向加工户：'+obj.processMan+'<span style="color: red;">外发-发</span>数量 ' + obj.num;
                                         }
                                         if (obj.type==2){
                                             msg = '工厂收发人：'+obj.remark+'于'+obj.date+'从加工户：'+obj.processMan+'<span style="color: green;">外发-收</span>数量 ' + obj.num;
                                         }

                                         html += msg;
                                         html += '</td>';
                                         html += '</tr>';
                                     }
                                 }
                                 html += '</table>';
                                 $("#logWindow").html(html);
                                 logWin.show();
                             }
                         });
    };

    //日志窗口
    var logWin = new com.custom.Window({
        width : 750,
        height : 500,
        title : '查看收发记录',
        contentEl : 'logWindow',
        buttons : [{
            text : '关闭',
            handler : function(){
                logWin.hide();
            }
        }]
    });

    //新增日志窗口
    var addLongWindow = new com.custom.Window({
        width : 500,
        height : 350,
        title : '新增收发记录',
        contentEl : 'addLongWindow',
        buttons : [{
            text : '保存',
            handler : function(){
                var sfTypes =  _getRadioValueJS('sfTypes');
                var partNo = $("#partNos").val();
                var dates = $("#dates").val();
                var numbs = $("#numbs").val();
                var processMan = $("#processMan").val();
                var remark = $("#remark").val();

                if (_isNull(sfTypes)) {
                    alert("请选择收发类型！");
                    return false;
                }
                if (_isNull(remark)) {
                    alert("请填写工厂收发人！");
                    return false;
                }
                if (_isNull(dates)) {
                    alert("请填写日期！");
                    document.getElementById("dates").focus();
                    return false;
                }
                if (_isNull(numbs)) {
                    alert("请填写数量！");
                    document.getElementById("numbs").focus();
                    return false;
                }
                if (!regexVerify('num1',numbs)) {
                    alert("数量只能填写数字！");
                    document.getElementById("numbs").focus();
                    return false;
                }

                Ext.Ajax.request({
                                     url : "addPartLogs.do?partNo=" + partNo
                                           + "&sfTypes="+sfTypes
                                           + "&dates="+dates
                                           + "&numbs="+numbs
                                           + "&remark="+remark
                                           + "&processMan="+processMan
                                     ,
                                     success : function(response) {
                                         var resp = Ext.util.JSON.decode(response.responseText);
                                         if (resp.success || resp.success == 'true'){
                                             alert("操作记录添加成功！");
                                             addLongWindow.hide();
                                             searchFunc();
                                         }else {
                                             alert(resp.msg);
                                             addLongWindow.hide();
                                         }
                                     }
                                 });

            }
        },{
            text : '关闭',
            handler : function(){
                addLongWindow.hide();
            }
        }]
    });
    
    var menuWindow = new com.custom.Window({
		width : 460,
		height : 480,
		contentEl : 'menuWindow',
		buttons : [{
			text : '保存',
			handler : function(){
				var partsNo = document.getElementById("epartsNo").value;
				var partsName = document.getElementById("epartsName").value;
				var partsFmt = document.getElementById("epartsFmt").value;
				var units = document.getElementById("eunits").value;
				var yongliang = document.getElementById("eyongliang").value;
				var lingyong = document.getElementById("elingyong").value;
				var hetongNum = document.getElementById("ehetongNum").value;
				var kucunNum = document.getElementById("ekucunNum").value;
				var buyNum = document.getElementById("ebuyNum").value;

				if (_isNull(partsName)) {
					alert("请填配件名称！");
					document.getElementById("epartsName").focus();
					return false;
				}
				if (_isNull(partsFmt)) {
					alert("请填配件规格！");
					document.getElementById("epartsFmt").focus();
					return false;
				}
				if (_isNull(units)) {
					alert("请填写单位！");
					document.getElementById("eunits").focus();
					return false;
				}
				if (_isNull(yongliang)) {
					alert("请填写每款用量！");
					document.getElementById("eyongliang").focus();
					return false;
				}
				if (_isNull(lingyong)) {
					alert("请填写领用单位！");
					document.getElementById("elingyong").focus();
					return false;
				}
				if (_isNull(hetongNum)) {
					alert("请填写本合同量！");
					document.getElementById("ehetongNum").focus();
					return false;
				}
				if (_isNull(kucunNum)) {
					alert("请填写库存存量！");
					document.getElementById("ekucunNum").focus();
					return false;
				}
				if (_isNull(buyNum)) {
					alert("请填写购买数量！");
					document.getElementById("ebuyNum").focus();
					return false;
				}
				var editParts = "editParts.do";
				var url = editParts + "?partsNo=" + partsNo
					+"&partsName=" +partsName
					+"&partsFmt=" + partsFmt
					+"&units=" + units
					+"&yongliang=" + yongliang
					+"&lingyong=" + lingyong
					+"&hetongNum=" + hetongNum
					+"&kucunNum=" + kucunNum
					+"&buyNum=" + buyNum
					;
					
				Ext.Ajax.request( {
					url : url,
					success : function(response){
						var resp = Ext.util.JSON.decode(response.responseText);
						if(resp.success){
							alert("操作成功！");
							menuWindow.hide();
							searchFunc();
						}else{
							alert("操作失败：" + resp.resultTipMsg);
						}
					}
				});
			}
		},{
			text : '关闭',
			handler : function(){
				menuWindow.hide();
			}
		}]
	});
    
      //更新
	this.editParts = function(partNo) {
		Ext.Ajax.request( {
			url : 'getPartsByPartNo.do?partNo=' + partNo,
			success : function(response){
				var resp = Ext.util.JSON.decode(response.responseText);
				setWindowValue(resp);
				menuWindow.setTitle("编辑修改配件信息");
				menuWindow.show();
			}
		});
	};
	this.reset = function(){
		document.getElementById("epartsNo").value = '';
		document.getElementById("epartsName").value = '';
		document.getElementById("epartsFmt").value = '';
		document.getElementById("eunits").value = '';
		document.getElementById("eyongliang").value = '';
		document.getElementById("elingyong").value = '';
		document.getElementById("ehetongNum").value = '';
		document.getElementById("ekucunNum").value = '';
		document.getElementById("ebuyNum").value = '';
	};
	
	this.setWindowValue = function(obj){
		reset();
		document.getElementById("epartsNo").value = obj.partsNo;
		document.getElementById("epartsName").value = obj.partsName;
		document.getElementById("epartsFmt").value = obj.partsFmt;
		document.getElementById("eunits").value = obj.units;
		document.getElementById("eyongliang").value = obj.yongliang;
		document.getElementById("elingyong").value = obj.lingyong;
		document.getElementById("ehetongNum").value = obj.hetongNum;
		document.getElementById("ekucunNum").value =obj.kucunNum;
		document.getElementById("ebuyNum").value = obj.buyNum;
	};
	
	this.updateImgs = function(partsNo) {
		uploadId = partsNo;
		pic.show();
	};
	
	var pic = new FileUpLoadWindow(function(fp, response){
		if(response.result.success){
			var path = response.result.data;
			if(_isNull(path)){
				alert("图片上传失败！");
			}else{
			//	location.href = 'savePartImgs.do?imgs='+path+'&partsNo=' + uploadId;
				Ext.Ajax.request( {
					url : 'savePartImgs.do?imgs='+path+'&partsNo=' + uploadId,
					success : function(response){
					    searchFunc();
					}
				});
			}
		}else{
			alert(response.result.msg);
		}
		pic.hide();
	});
	

    //列表数据
    var gridStore = new Ext.data.JsonStore({
        url : 'searchParts.do',
        root : 'resultList',
        remoteSort: false,
        totalProperty:'total',
        fields: [
            {name:'id'},
            {name:'contractNo'},
            {name:'proNo'},
            {name:'partsNo'},
            {name:'partsName'},
            {name:'partsFmt'},
            {name:'partsImg'},
            {name:'units'},
            {name:'yongliang'},
            {name:'lingyong'},
            {name:'hetongNum'},
            {name:'kucunNum'},
            {name:'buyNum'},
            {name:'receiveNum'},
            {name:'sendoutNum'},
            {name:'sendoutReceiveNum'},
            {name:'userName'},
            {name:'createTime'},
            {name:'remark'}
        ],
        baseParams : {
            limit : 20,
            name :''
        },
        listeners:{
            load: function () {
                var contractNo = document.getElementById("contractNo").value;
                var proNo = document.getElementById("proNo").value;

                if (_isNull(contractNo)){
                    grid.getColumnModel().setHidden(0,false);
                }else {
                    grid.getColumnModel().setHidden(0,true);
                }
                if (_isNull(proNo)){
                    grid.getColumnModel().setHidden(1,false);
                }else {
                    grid.getColumnModel().setHidden(1,true);
                }

            }
        }
    });

    var grid = new com.custom.GridPanel({
        store : gridStore,
        region : 'center',
        frame : false,
        border : false,
        autoHeight:true,
        columns: [
            {width:1,header:'合同号', align:'left',sortable:false, dataIndex:'contractNo',hidden:false,renderer:function(val,cell,record){
                return val;
            }},
            {width:0.7,header:'公司货号', align:'left',sortable:false, dataIndex:'proNo',hidden:false},
            {width:1,header:'配件编号', align:'left',sortable:false, dataIndex:'partsNo',hidden:true},
            {width:1,header:'配件名称', align:'left',sortable:false, dataIndex:'partsName',renderer:function(val,cell,record){
                return '<pan title="合同号：'+record.data.contractNo+'；公司货号：'+record.data.proNo+'">'+val+'</pan>';
            }},
            {width:1,header:'配件图片', align:'center',sortable:false, dataIndex:'partsImg',renderer:function(val,cell,record){
                return '<img src="'+ (IMAGEURL + val) +'"  style="max-width: 75px;">';
            }},
            {width:1,header:'规格', align:'left',sortable:false, dataIndex:'partsFmt'},
            {width:0.7,header:'领用单位', align:'right',sortable:false, dataIndex:'units'},
            {width:0.7,header:'每款用量', align:'right',sortable:false, dataIndex:'yongliang'},
            {width:0.7,header:'本合同用量', align:'right',sortable:false, dataIndex:'hetongNum'},
            {width:0.7,header:'领用单位/斤', align:'right',sortable:false, dataIndex:'lingyong'},
            {width:0.7,header:'库存存量', align:'right',sortable:false, dataIndex:'kucunNum'},
            {width:0.7,header:'购买总量', align:'right',sortable:false, dataIndex:'buyNum'},

            {width:0.9,header:'收货', align:'right',sortable:false, dataIndex:'hetongNum',renderer:function(val,cell,record){
                return '<span style="color: blue;cursor:pointer" onclick="showLogWin(\''+record.data.partsNo+'\', 0)">'+record.data.receiveNum+'/'+val+'</span>';
            }},
            {width:0.9,header:'外发-发', align:'right',sortable:false, dataIndex:'hetongNum',renderer:function(val,cell,record){
                return '<span style="color: red;cursor:pointer" onclick="showLogWin(\''+record.data.partsNo+'\', 1)">'+record.data.sendoutNum+'/'+val+'</span>';
            }},
            {width:0.9,header:'外发-收', align:'right',sortable:false, dataIndex:'hetongNum',renderer:function(val,cell,record){
                return '<span style="color: green;cursor:pointer" onclick="showLogWin(\''+record.data.partsNo+'\', 2)">'+record.data.sendoutReceiveNum+'/'+val+'</span>';
            }},

            {width:1,header:'操作', align:'left',sortable:false, dataIndex:'partsNo',renderer:function(val,cell,record){
                var str = '';
                if (isPRIAddLogs){
                    str += '<input type="button" value="新增收发" class="Mybotton" onclick="addLog(\''+record.data.partsNo+'\')"><br/>';
                }
                if (isPRISendAndRecList){
                    str += '<input type="button" value="收发管理" class="Mybotton" onclick="sendAndRecList(\''+record.data.partsNo+'\')"><br/>';
                }
                if (isPRIEdit){
                    str += '<input type="button" value="修改配件" class="Mybotton" onclick="editParts(\''+record.data.partsNo+'\')"><br/>';
                }
                if(isPRISavePartImgs){
                    str += '<input type="button" value="更新图片" class="Mybotton" onclick="updateImgs(\''+record.data.partsNo+'\')"><br/>';
                }
                str += '<input type="button" value="收发详情" class="Mybotton" onclick="showLogWin(\''+record.data.partsNo+'\', -1)">';
                return str;
            }}
        ]
    });

    new Ext.Viewport({
        layout : 'border',
        items : [{
            region : 'north',
            title :  "产品配件",
            border : false,
            height : 75,
            keys : {
                key : Ext.EventObject.ENTER,
                fn : function(){
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

    addLongWindow.show();

    addLongWindow.hide();

    searchFunc();
});