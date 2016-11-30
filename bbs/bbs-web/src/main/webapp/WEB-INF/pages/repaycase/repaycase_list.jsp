<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if !IE]><!-->
<html lang="zh">
<!--<![endif]-->
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<head>
    <meta charset="utf-8" />
    <title>待经理分配案件</title>
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
    <meta content="" name="description" />
    <meta content="" name="author" />
    <!-- ================== BEGIN BASE CSS STYLE ================== -->
    <jsp:include page="../common/header.jsp"></jsp:include>
    <%@include file="../common/taglib.jsp"%>
    <!-- ================== END BASE CSS STYLE ================== -->
    
    <!-- ================== 单独作用于本页表格td ================== -->
    <style>
        .table>tbody>tr>td {
            padding: 10px 15px;
            padding-top: 7px;
            padding-right: 15px;
            padding-bottom: 7px;
            padding-left: 15px;
        }
    </style>
    <!-- ================== 单独作用于本页表格td ================== -->

</head>
<body>
<!-- begin #page-loader -->
<div id="page-loader" class="fade in"><span class="spinner"></span></div>
<!-- end #page-loader -->

<!-- begin #page-container -->
<div id="page-container" class="fade page-sidebar-fixed page-header-fixed">
    <jsp:include page="../common/top.jsp"/>

    <!-- begin #sidebar -->
    <jsp:include page="../common/sitebar.jsp"/>
    <div class="sidebar-bg"></div>
    <!-- end #sidebar -->

    <!-- begin #content -->
    <div id="content" class="content">       
        <div class="row">
            <!-- begin col-12 -->
            <div class="col-md-12">
                <!-- begin panel -->
                <div class="panel panel-inverse">
                    <div class="panel-heading">
                        <div class="panel-heading-btn">
                            <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-default" data-click="panel-expand"><i class="fa fa-expand"></i></a>
                            <a href="javascript:search();" class="btn btn-xs btn-icon btn-circle btn-success"><i class="fa fa-repeat"></i></a>
                            <a href="javascript:;" class="btn btn-xs btn-icon btn-circle btn-danger" data-click="panel-remove"><i class="fa fa-times"></i></a>
                        </div>
                        <h4 class="panel-title"> 经理分配 </h4>
                    </div>                 
                    <div class="panel-body">
                        <div class="table-responsive">
             <table width="994" height="154" border="0">
  <tr>
  <input type="hidden" id="flowStatus1" name="flowStatus" value="${flowStatus}"/>
  <input type="hidden" id="caseStatus1" name="caseStatus" value="${caseStatus}"/>
    <td width="98" height="32">案件编号：</td>
    <td width="156">
      <label>
        <input id="caseid" name="caseid" type="text" size="20" />
        </label>
     </td>
    <td width="76">订单编号：</td>
    <td width="154"><input id="orderId" name="orderId" type="text" size="20" /></td>
    <td width="73">资金方：</td>
    <td width="140">
      <label>
        <select id="capital" name="capital">
          <option value="">--请选择--</option>
        </select>
        </label>
     </td>
    <td width="105">逾期催收状态：</td>
    <td width="140">
      <label>
      <select id="repayState" name="repayState">
        <option value="">--请选择--</option>
            </select>
      </label>
    </td>    
  </tr>
  <tr>   
     <td width="105">逾期天数：</td>
     <td width="154"><input id="lateDays" name="lateDays" type="text" size="20" /></td>
      <td height="27">业务地区：</td>
    <td><select id="businessArea" name="businessArea">
        <option value="">--请选择--</option>
    </select></td>
    <td>产品线：</td>
    <td><select id="productLine" name="productLine">
        <option value="">--请选择--</option>
    </select></td>
    <td>产品类型：</td>
    <td><input id="productType" name="productType" type="text" size="20" /></td>
  </tr>
  <tr>   
    <td>催收员：</td>
    <td><select  id="sysuserId" name="sysuserId">
        <option value="">--请选择--</option>
    </select></td>
     <td>账龄：</td>
    <td><select id="aging" name="aging">
        <option value="">--请选择--</option>
    </select></td>
    <td height="23">客户姓名：</td>
    <td>
        <label>
        <input id="customerName" name="customerName" type="text" size="20" />
        </label>
    </td>
     <td>客户类型：</td>
    <td>
        <label>
        <select id="customerType" name="customerType">
          <option value="">--请选择--</option>
        </select>
        </label>
    </td>
    
  </tr>
  <tr>   
    <td>手机号码：</td>
    <td><input id="phoneNumber" name="phoneNumber" type="text" size="20" /></td>
     <td height="32">更新时间：</td>
    <td colspan="6"><input  id="lastUpdateTime" name="lastUpdateTime" type="text" size="20" />
      -
      <input id="lastUpdateTimeEnd" name="lastUpdateTimeEnd" type="text" size="20" /></td>
      
  </tr>
  <tr>
    <td height="29">今日应还总额：</td>
    <td colspan="3">
    <input id="todayTotalAmount" name="todayTotalAmount" type="text" size="20" onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"/>
      -
      <input id="todayTotalAmountEnd" name="todayTotalAmountEnd" type="text" size="20" onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"/></td>
    <td height="29">借据金额：</td>
    <td colspan="3"><input id="iouAmount" name="iouAmount" type="text" size="20" onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"/>
      -
      <input id="iouAmountEnd" name="iouAmountEnd" type="text" size="20" onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"/></td>
  </tr>
  <tr>   
    <td colspan="8">
     <button type="button" class="btn btn-info btn-sm" onclick="search()" >查询</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     <input type="button" class="btn btn-info btn-sm" onclick="caseAllocation(1,0)" value="手动分配到主管" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     <input type="button" class="btn btn-info btn-sm" onclick="" value="自动分配到主管" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     <input type="button" class="btn btn-info btn-sm" onclick="outSourcing(0,4)" value="委外" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     <input type="button" class="btn btn-info btn-sm" onclick="" value="导入案件" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

     <input type="button" class="btn btn-info btn-sm" onclick="caseReset(0,0)" value="重置到待经理分配" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     <input type="button" class="btn btn-info btn-sm" onclick="caseReset(1,0)" value="重置到待主管分配" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

        <input type="button" class="btn btn-info btn-sm" onclick="caseReset(1,0)" value="重置到待主管分配" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     <input type="button" class="btn btn-info btn-sm" onclick="" value="导出Excel" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     <input type="button" class="btn btn-info btn-sm" onclick="" value="审核通过" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     <input type="button" class="btn btn-info btn-sm" onclick="" value="拒绝" />
    </td>
  </tr>
</table>

                           
                            
                            <table id="gadtable" class="table table-striped table-bordered">
                                <thead>
                                <tr>
                                    <th>
                                    <input type="checkbox" class="checkall" />
                                    </th>
                                    <th>案件编号</th>
                                    <th>订单编号</th>
                                    <th >资金方</th>
                                    <th >逾期催收状态</th>
                                    <th >业务地区</th>
                                    <th >客户姓名</th>
                                    <th >客户类型</th>
                                    <th >手机号码</th>
                                    <th >帐龄</th>
                                    <th >逾期天数</th>
                                    <th >今日应还总额</th>
                                    <th>产品线</th>
                                    <th>产品类型</th>
                                    <th>借据金额</th>
                                    <th>催收员</th>
                                    <th>最后更新时间</th>
                                </tr>
                                </thead>                            
                            </table>
                            
                        </div>
                    </div>
                </div>
                <!-- end panel -->
            </div>
            <!-- end col-12 -->
        </div>
        <!-- end row -->
    </div>
    <!-- end #content -->
    
    <!-- manager start -->
    
    <div class="modal fade" id="collectionModalId" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <form role="form" action="" method="get" data-parsley-validate="true" id="dialogForm">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                    <h4 class="modal-title" id="myModalLabel1">选择催收主管</h4>
                </div>
                <div class="modal-body">

                    <div class="form-group">
                        <table width="450" height="140" border="0">
							  <tr>
							    <td width="120" height="40"><div align="center"><strong>请选择催收主管：</strong></div></td>
							    <td width="337">
							      <label>
							       <input type="hidden" value="" id="uids" name="uids"/>
							       <input type="hidden" value="1" id="flowStatus" name="flowStatus"/>
							       <input type="hidden" value="0" id="caseStatus" name="caseStatus"/>
							      <select name="select" id="reminder" name="reminder">
							        <option value="">--请选择--</option>
							        <option value="1">张三</option>
							        <option value="2">李四</option>
							        <option value="3">王五</option>
							        </select>
							        </label>
							    </form>    </td>
							  </tr>
							</table>
				  </div>                    
                </div>
                <div class="modal-footer">                    
                    <button type="button" class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>取消</button>
                    <button type="button" onclick="confirm_allocation()" class="btn btn-primary"><span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>确认分配</button>
                </div>
            </div>
        </div>
    </form>
</div>

    <!-- manager end -->
    
    <!--outsourcing start -->
    
    <div class="modal fade" id="outsourcingid" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <form role="form" action="" method="get" data-parsley-validate="true" id="dialogForm">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                    <h4 class="modal-title" id="myModalLabel1">选择催收公司</h4>
                </div>
                <div class="modal-body">

                    <div class="form-group">
                        <table width="450" height="140" border="0">
							  <tr>
							    <td width="120" height="40"><div align="center"><strong>请选择催收公司：</strong></div></td>
							    <td width="337">
							      <label>
							       <input type="hidden" value="" id="wids" name="wids"/>
							       <input type="hidden" value="0" id="flowStatus" name="flowStatus"/>
							       <input type="hidden" value="4" id="caseStatus" name="caseStatus"/>
							      <select name="companyName" id="companyName">
							        <option value="">--请选择--</option>
							        <option value="0">--百度--</option>
							        <option value="1">--阿里--</option>
							        <option value="2">--网易--</option>
							        </select>
							        </label>
							    </form>    </td>
							  </tr>
							</table>
				  </div>                    
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>取消</button>
                     <button type="button" onclick="confirm_outSourcing()" class="btn btn-primary"><span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>确认委外</button>
                </div>
            </div>
        </div>
    </form>
</div>

    <!-- outsourcing end -->
    

</div>
<!-- end page container -->
<jsp:include page="../common/footer.jsp"/>
<!-- ================== END PAGE LEVEL JS ================== -->
<script src="/static/js/case/case_list.js"></script>
<script>
//确认分配
function confirm_allocation(){
var uids=$('#uids').val();
var reminder=$('#reminder').val();
var flowStatus=$('#flowStatus').val();
var caseStatus=$('#caseStatus').val();
if(reminder==''){
	alert("请选择催收人！");
	return;
}
Ewin.confirm({message: "确认要分配吗？"}).on(function (e) {
	   if (!e) {
	       return;
	   }
	   jQuery.ajax({
	   type: "GET",
	   url: "<%=path%>/repay/allocation/?uids=" + uids+"&reminder="+reminder+"&flowStatus="+flowStatus+"&caseStatus="+caseStatus,
	   dataType: "json",
	   success: function (data) {
	      alert(data.result);
	   //location.reload();
	   window.parent.location.reload();
               }
           });
       });
   } 
//确认委外
function confirm_outSourcing(){
	var wids=$('#wids').val();
	var companyName=$('#companyName').val();
	var flowStatus=$('#flowStatus').val();
	var caseStatus=$('#caseStatus').val();
	if(companyName==''){
		alert("请选择催收公司！");
		return;
	}
	Ewin.confirm({message: "确认要委外吗？"}).on(function (e) {
		   if (!e) {
		       return;
		   }
		   jQuery.ajax({
		   type: "GET",
		   url: "<%=path%>/repay/ourSourcing/?uids=" + wids+"&companyName="+companyName+"&flowStatus="+flowStatus+"&caseStatus="+caseStatus,
		   dataType: "json",
		   success: function (data) {
		      alert(data.result);
		      window.parent.location.reload();
	               }
	           });
	       });
	   } 

</script>
</body>
</html>
