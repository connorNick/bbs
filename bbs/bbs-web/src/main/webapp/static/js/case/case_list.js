$(document).ready(function() {
        App.init();
        TableManageFixedHeader.init();      
        datainit();
 });   
//时间控件
function datainit(){
   $("#lastUpdateTime,#lastUpdateTimeEnd").datepicker({
		language: "zh-CN",
		format:"yyyy-mm-dd",
		autoclose: true,
	    todayHighlight: true,
	    endDate : new Date(), 
	    todayBtn:'linked'	    
	});
 }  
//分页展示
var table;
$(document).ready(function() {
       table = $("#gadtable").DataTable( {   
       	"bAutoWidth" : false,
         "order": [[ 1, 'desc' ]],
           "pagingType": "simple_numbers",//设置分页控件的模式
           searching: false,//屏蔽datatales的查询框
           aLengthMenu:[5],//设置一页展示10条记录
           "bLengthChange": false,//屏蔽tables的一页展示多少条记录的下拉列表
           "oLanguage": {  //对表格国际化
               "sLengthMenu": "每页显示 _MENU_条",
               "sZeroRecords": "没有找到符合条件的数据",
               "sInfo": "当前第 _START_ - _END_ 条　共计 _TOTAL_ 条",
               "sInfoEmpty": "木有记录",
               "sInfoFiltered": "(从 _MAX_ 条记录中过滤)",
               "sSearch": "搜索：",
               "oPaginate": {
                   "sFirst": "首页",
                   "sPrevious": "前一页",
                   "sNext": "后一页",
                   "sLast": "尾页"
               }
           },
           "processing": true, //打开数据加载时的等待效果
           "serverSide": true,//打开后台分页
           "ajax": {
               "url": "/repay/queryTableData",
               "dataSrc": "aaData",
               "data": function ( params ) {
                   params.caseId=$('#caseid').val();//案件编号
                   params.orderId=$('#orderId').val();//订单编号
                   params.capital=$('#capital').val();//资金方
                   params.repayState=$('#repayState').val();//催收状态
                   params.businessArea=$('#businessArea').val();//业务地区
                   params.customerName=$('#customerName').val();//客户姓名
                   params.customerType=$('#customerType').val();//客户类型
                   params.phoneNumber=$('#phoneNumber').val();//手机号码
                   params.aging=$('#aging').val();//账龄
                   params.lateDays=$('#lateDays').val();//逾期天数
                   params.todayTotalAmount=$('#todayTotalAmount').val();//应还总额开始
                   params.todayTotalAmountEnd=$('#todayTotalAmountEnd').val();//应还总额结束                    
                   params.iouAmount=$('#iouAmount').val();//借据金额
                   params.iouAmountEnd=$('#iouAmountEnd').val();//借据金额截止
                   params.lastUpdateTime=$('#lastUpdateTime').val();//最后更新时间
                   params.lastUpdateTimeEnd=$('#lastUpdateTimeEnd').val();//最后更新时间截止
                   params.caseStatus=$('#caseStatus1').val();
                   params.flowStatus=$('#flowStatus1').val();
               }
           },            
           "columns": [     
              {
                  "sClass": "text-center",
                   "data": "id",
                   "render": function (data, type, full, meta) {
                  	 return '<input type="checkbox" name="id" id="ids"  class="checkchild"  value="'+ data + '" />'
                    },
                    "bSortable": false
                },
               { "data": "caseId" },
               { "data": "orderId" },
               { "data": "capital" },
               { "data": "repayState" },
               { "data": "businessArea"},               
               { "data": "customerName" },
               { "data": "customerType" },
               { "data": "phoneNumber" },
               { "data": "aging" },
               { "data": "lateDays" },
               { "data": "todayTotalAmount" },
               { "data": "productLine" },
               { "data": "productType" },
               { "data": "iouAmount"},
               { "data": "sysuserId" },
               { "data": "lastUpdateTime"}
           ]

       } );
   } );
//查询
function search(){
   table.ajax.reload();
 }
//案件分配
function caseAllocation() {
   	var str="";
   	var ids="";
   	$("input[name='id']:checkbox").each(function(){
   		if(true == $(this).is(':checked')){
   			str+=$(this).val()+",";
   		}
   	});
   	if(str.substr(str.length-1)== ','){
   		ids = str.substr(0,str.length-1);
   	}
   	if(ids.length==0){
   		alert("请选择要进行分配的案件！");
   		return;
   	}
   	$("#uids").val(ids);
       $('#collectionModalId').modal();
   }
   
//委外
function outSourcing(){
   	var str="";
   	var ids="";
   	$("input[name='id']:checkbox").each(function(){
   		if(true == $(this).is(':checked')){
   			str+=$(this).val()+",";
   		}
   	});
   	if(str.substr(str.length-1)== ','){
   		ids = str.substr(0,str.length-1);
   	}
   	if(ids.length==0){
   		alert("请选择要进行委外的案件！");
   		return;
   	}
   	$("#wids").val(ids);
   	$('#outsourcingid').modal();
   }
//多选
$(".checkall").click(function () {
   var check = $(this).prop("checked");
   $(".checkchild").prop("checked", check);
});

//重置
function caseReset(flowStatus,caseStatus){
    var str="";
    var ids="";
    $("input[name='id']:checkbox").each(function(){
        if(true == $(this).is(':checked')){
            str+=$(this).val()+",";
        }
    });
    if(str.substr(str.length-1)== ','){
        ids = str.substr(0,str.length-1);
    }
    if(ids.length==0){
        alert("请选择要进行重置的案件！");
        return;
    }

    Ewin.confirm({message: "确认要重置吗？"}).on(function (e) {
        if (!e) {
            return;
        }
        jQuery.ajax({
            type: "GET",
            url: "/repay/caseReset/?ids=" + ids+"&flowStatus="+flowStatus+"&caseStatus="+caseStatus,
            dataType: "json",
            success: function (data) {
                alert(data.result);
                window.parent.location.reload();
            }
        });
    });
}