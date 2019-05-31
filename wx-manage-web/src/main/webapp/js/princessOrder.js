Ext.onReady(function(){
    Ext.QuickTips.init();
    
       
    var urlSaveDealer="saveDealer.do";
    
    //是否有权限
    var isPRIDel = isHavePRI("delDealer.do");
    var isPRIModify=isHavePRI("modifyDealer.do");
    
    	var closeBtn=new Ext.Button({
    	text:'关闭',
    	width:100,
    	handler:function(){
    		
    	}});
	
    var saveBtn=new Ext.Button({
    	text:'保存',
    	minWidth:80,
    	width:100,
    	handler:function(){
    		
    	}
    
    });
    
    
    //编辑窗口
	var pWindow = new com.custom.Window({
		width : 460,
		height : 500,
		items: [{
	            layout:'form',
	             bodyStyle: "padding-left:10px ;padding-top:10px",
		      items:[
	                {
	                    xtype:'datetimefield',
	                    fieldLabel: '下单时间',
	                    name: 'startTime',
	                    anchor:'95%'
	                },{
	                    xtype:'textfield',
	                    fieldLabel: '店铺名字',
	                    name: 'shopNameId',
	                    anchor:'95%'
	                },{
	                    xtype:'textfield',
	                    fieldLabel: '客户姓名',
	                    anchor:'95%'
	                },{
	                    xtype:'textfield',
	                    fieldLabel: '客户手机号',
	                    anchor:'95%'
	                },{
	                    xtype:'textarea',
	                    fieldLabel: '客户地址',
	                    anchor:'95%'
	                },{
	                    xtype:'textarea',
	                    fieldLabel: '买的物品',
	                    anchor:'95%'
	                },{
	                    xtype:'textfield',
	                    fieldLabel: '发的授权号',
	                    anchor:'95%'
	                },{
	                    xtype:'textfield',
	                    fieldLabel: '利润',
	                    anchor:'95%'
	                },{
	                    xtype:'textarea',
	                    fieldLabel: '备注',
	                    anchor:'95%'
	                }
	                ]
	       }],
		buttons : [saveBtn,closeBtn]
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
		//reset();
		pWindow.setTitle("新增公主家订单");
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
    
     this.btn1=function(){
    		Ext.Msg.alert('系统提示', '你点击了该Button');
    	}

    this.btn2=new com.custom.Button({
    	text:'新增',
    	width:100,
    	handler:function(){
    		pWindow.setTitle("新增公主家订单");
			pWindow.show();
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
    
//      String startTime = request.getParameter("startTime");
//        String endTime = request.getParameter("endTime");
//        String shopNameId = request.getParameter("shopNameId");
//        String sellCode = request.getParameter("sellCode");
//        String customerPhone = request.getParameter("customerPhone");
    
    	 var top = new Ext.FormPanel({
	        labelAlign:'left',
            title :  "公主家订单管理",
	        frame:true,
	        bodyStyle:'padding:5px 5px 0',
	        region : 'north',
	        height: 150,
	        items: [{
	            layout:'form',
	          items:[{
	                layout: 'column',
	                items: [{
	                	 columnWidth:.3,
	                	 layout: 'form',
	                	 items:[{
	                	 	xtype:'datetimefield',
		                    fieldLabel: '开始时间',
		                    name: 'startTime',
		                    anchor:'95%'}]
	                   
	                }, {
	                	 columnWidth:.3,
	                	 layout: 'form',
	                	 items:[{
	                	 xtype:'datetimefield',
	                    fieldLabel: '结束时间',
	                    name: 'endTime',
	                    anchor:'95%'
	                    }]
	                    
	                }
	                ]
	            },{
	                layout: 'column',
	                items: [{
	                	 columnWidth:.3,
	                	 layout: 'form',
	                	 items:[{
	                	 	 xtype:'textfield',
		                    fieldLabel: '授权码',
		                    anchor:'95%'
	                	 }]
	                   
	                },{
	                	 columnWidth:.3,
	                	 layout: 'form',
	                	 items:[{
	                	 	 xtype:'textfield',
		                    fieldLabel: '手机号',
		                    anchor:'95%'
	                	 }]
	                   
	                },{
	                	 columnWidth:.3,
	                	 layout: 'form',
	                	 items:[{
	                	 	 xtype:'textfield',
		                    fieldLabel: '店铺号',
		                    anchor:'95%'
	                	 }]
	                   
	                }]
	            }

	        ]
	        }],
	        buttons:[
	        	{
		        text:'查询',
		        width:100,
		        handler:function(){
		        	Ext.Msg.alert('系统提示', '你点击了该Button');
		        	}
		        },
		       btn2
	        ]
	        
	    });

    new Ext.Viewport({
        layout : 'border',
        items : [top,
        	{
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

  
   // searchFunc();
});