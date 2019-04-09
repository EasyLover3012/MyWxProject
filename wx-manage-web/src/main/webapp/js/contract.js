Ext.onReady(function(){
    Ext.QuickTips.init();
    //是否有权限
    var isPRIUpload = isHavePRI("fileUpload.do");
    var isPRIDel = isHavePRI("delContract.do");

    var pic = new FileUpLoadWindow(function(fp, response){
        if(response.result.success){
            alert("文件导入成功！");
            location.href = 'initContract.do';
        }else{
            alert(response.result.msg);
            pic.hide();
        }
    });

    this.importFunc=function(){
        pic.show();
    };

    this.searchFunc=function(){
        gridStore.setBaseParam("contractNo", document.getElementById("contractNo").value);
        gridStore.load();
    };

    this.viewDetail=function(contractNo){
//                alert(contractNo)
        location.href = "initPro.do?contractNo=" + contractNo;
    };

    this.viewDetailDel=function(contractNo){
        if (confirm("确定要删除合同"+contractNo+"吗？")){
            Ext.Ajax.request({
                                 url : "delContract.do?contractNo=" + contractNo
                                 ,
                                 success : function(response) {
                                     var resp = Ext.util.JSON.decode(response.responseText);
                                     if (resp.success || resp.success == 'true'){
                                         alert("删除合同成功！");
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
        url : 'searchContract.do',
        root : 'resultList',
        remoteSort: true,
        totalProperty:'total',
        fields: [
            {name:'id'},
            {name:'contractNo'},
            {name:'fileName'},
            {name:'remark'},
            {name:'createTime'},
            {name:'userName'},
            {name:'deliveryDate'},
            {name:'sort'},
            {name:'dir'},
            {name:'tabulationDate'}
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
            {width:1.5,header:'总合同号', align:'center',sortable:false, dataIndex:'contractNo',sortable:true,remoteSort: true},
            // {width:2,header:'合同名称', align:'center',sortable:false, dataIndex:'fileName'},
            {width:1,header:'制表日期', align:'center',sortable:false, dataIndex:'tabulationDate'},
            {width:1,header:'交货日期', align:'center',sortable:false, dataIndex:'deliveryDate',sortable:true,remoteSort: true},
            {width:1,header:'系统操作人', align:'left',sortable:false, dataIndex:'userName',renderer:function(val,m,rec){
                return val + '<br><span style="color: grey">' + Ext.util.Format.date(rec.data.createTime,'Y-m-d H:i') + '</span>';
            }},
            {width:1,header:'操作', align:'center',sortable:false, dataIndex:'contractNo',renderer:function(val, meta){
                var str ='<input type="button" value="合同详情" class="Mybotton" onclick="viewDetail(\''+val+'\')">';
                if(isPRIDel){//权限
                    str=str+'<br/><input type="button" value="删除合同" class="Mybotton" onclick="viewDetailDel(\''+val+'\')">';
                }
                return str;
            }}
        ]
    });

    new Ext.Viewport({
        layout : 'border',
        items : [{
            region : 'north',
            title :  "合同管理",
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

    if(!isPRIUpload){//权限
        document.getElementById("bt_div").style.display="none";
    }

    searchFunc();
});