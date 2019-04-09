Ext.onReady(function(){
    Ext.QuickTips.init();
    
       
    var urlSaveDealer="saveDealer.do";
    
    //是否有权限
    var isPRIDel = isHavePRI("delDealer.do");
    var isPRIModify=isHavePRI("modifyDealer.do");
    
    
    
    //编辑窗口
	var pWindow = new com.custom.Window({
		width : 460,
		height : 400,
		contentEl : 'pWindow',
		buttons : [{
			text : '保存',
			handler : function(){
				var _id=document.getElementById("hidDealerIdEdit").value;
				var _dealerName = document.getElementById("wdealerName").value;
				var _wxID = document.getElementById("wxID").value;
				var _phone = document.getElementById("phone").value;
				var _highlevelID = document.getElementById("highlevelID").value;
				var _address = document.getElementById("address").value;
				
				if (_isNull(_dealerName)) {
					alert("请填写经销商姓名！");
					document.getElementById("dealerName").focus();
					return false;
				}
				if (_isNull(_wxID)) {
					alert("请填写微信号！");
					document.getElementById("wxID").focus();
					return false;
				}
				if (_isNull(_phone)) {
					alert("请填写手机号！");
					document.getElementById("phone").focus();
					return false;
				}
				
				var url = urlSaveDealer ;
					
				Ext.Ajax.request( {
					url : url,
					params:{
							id:_id,
							dealerName:_dealerName,
							wxID:_wxID,
							phone:_phone,
							highlevelID:_highlevelID,
							address:_address
					      },
					success : function(response){
						var resp = Ext.util.JSON.decode(response.responseText);
						if(resp.success){
							alert("操作成功！");
							pWindow.hide();
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
				pWindow.hide();
			}
		}]
	});
	
	this.reset = function(){
		document.getElementById("hidDealerIdEdit").value = 0;
		document.getElementById("wdealerName").value = '';
		document.getElementById("wxID").value = '';
		document.getElementById("phone").value = '';
		document.getElementById("highlevelID").value = 0;
		document.getElementById("address").value = '';
	};
	
	//新增
	this.addF = function(bt) {
		reset();
		pWindow.setTitle("新增经销商");
		pWindow.show(bt);
	};
	
	
	this.modifyF=function(bt,rowRecordJsonStr){
		var data=Ext.util.JSON.decode(rowRecordJsonStr);
		document.getElementById("hidDealerIdEdit").value = data.id;
		document.getElementById("wdealerName").value = data.dealerName;
		document.getElementById("wxID").value = data.wxId;
		document.getElementById("phone").value = data.telphone;
		document.getElementById("highlevelID").value = data.highlevelid;
		document.getElementById("address").value = data.address;
		
		pWindow.setTitle("修改经销商");
		pWindow.show(bt);
	}


    this.searchFunc=function(){
        gridStore.setBaseParam("dealerName", document.getElementById("dealerName").value);
        gridStore.load();
    };

    

    this.viewDetailDel=function(dealerName,dealerNameId){
        if (confirm("确定要删除经销商"+dealerName+"吗？")){
            Ext.Ajax.request({
                                 url : "delDealer.do?dealerNameId=" + dealerNameId
                                 ,
                                 success : function(response) {
                                     var resp = Ext.util.JSON.decode(response.responseText);
                                     if (resp.success || resp.success == 'true'){
                                         alert("删除经销商成功！");
                                         searchFunc();
                                     }else {
                                         alert(resp.msg);
                                     }
                                 }
                             });
        }
    };

  
    //列表数据
    var gridStore = new Ext.data.JsonStore({
        url : 'searchDealer.do',
        root : 'resultList',
        remoteSort: true,
        totalProperty:'total',
        fields: [
            {name:'id'},
            {name:'dealerName'},
            {name:'wxId'},
            {name:'telphone'},
            {name:'highlevelid'},
            {name:'address'}
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
            {width:1.5,header:'经销商姓名', align:'center',sortable:false, dataIndex:'dealerName',sortable:true,remoteSort: true},
           {width:1,header:'微信号', align:'center',sortable:false, dataIndex:'wxId'},
            {width:1,header:'手机号', align:'center',sortable:false, dataIndex:'telphone',sortable:true,remoteSort: true},
            {width:1,header:'上线', align:'left',sortable:false, dataIndex:'highlevelid',renderer:function(val,cell,record){
            	var allRecord= gridStore.getRange();
            	var str='';
            	for(var i=0;i<allRecord.length;i++){
            		if(allRecord[i].data.id==record.data.highlevelid){
            			str=allRecord[i].data.dealerName;
            			break;
            		}
            	}
            	if(str==''){
            		str="未知上线";
            	}
            	return str;
    		}},
            {width:1,header:'地址', align:'left',sortable:false, dataIndex:'address'},
            {width:1,header:'操作', align:'center',sortable:false, dataIndex:'dealerName',renderer:function(val, cell,record){
                var str ='';
                if(isPRIModify){
                	var myArray=gridStore.collect("dealerName");
                	
                	//str=str+'<input type="button" value="修改" class="Mybotton" onclick="modifyF(this)">';
                	
                	str=str+"<input type='button' value='修改' class='Mybotton' onclick=modifyF(this,\'"+Ext.util.JSON.encode(record.data)+"\')>";
                }
                if(isPRIDel){//权限
                    str=str+'<input type="button" value="删除" class="Mybotton" onclick="viewDetailDel(\''+record.data.dealerName+'\','+record.data.id+')">';
                }
               
                return str;
            }}
        ]
    });

    new Ext.Viewport({
        layout : 'border',
        items : [{
            region : 'north',
            title :  "经销商管理",
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