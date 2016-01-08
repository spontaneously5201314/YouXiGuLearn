<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/jsp/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>产品分类</title>

<script type="text/javascript">
$(document).ready(function(){
  	$(".click").click(function(){
  		$(".tip").fadeIn(200);
  	});
  
  	$(".tiptop a").click(function(){
  		$(".tip").fadeOut(200);
	});

  	$(".sure").click(function(){
  		$(".tip").fadeOut(100);
	});

  	$(".cancel").click(function(){
  		$(".tip").fadeOut(100);
	});

	$(".select3").uedSelect({
		width : 100
	});

});

</script>
<script type="text/javascript" src="js/jquery.js"></script>
 <script type="text/javascript">
        $(document).ready(function(){
            $("#sup").change(function(){
                $("#sup option").each(function(i,o){
                    if($(this).attr("selected"))
                    {
                        $(".sub").hide();
                        $(".sub").eq(i).show();
                    }
                });
            });
            $("#sup").change();
            
            
        });
 </script>

</head>


<body>
<form action="productCatagory.html" method="post" name="productCatagoryForm" id="productCatagoryForm">
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">合同管理</a></li>
    <li><a href="#">产品分类</a></li>
    </ul>
    </div>
 	
 	<div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="seachform">
    	
    		<li><label>父分类名：</label></li>
    		<li><select id="sup" class="select3" width=100 >
			    	<option value="null">--请选择--</option>
					<c:forEach items="${catagorySupList}" var="sup">
					<option value="productName">${sup.productName }</option>
				</c:forEach>
				</select>
    		</li>
    		<li><label>子分类名：</label></li>
    		<li><select id="sub" class="sub">
			    	<option>--请选择--</option>
					<c:forEach items="${catagorySubList}" var="sub">
					<option>${sub.productName }</option>
				</c:forEach>
				</select>
    		</li>
	    	<ul class="toolbar">
	        <li onclick="javascript:search();"><span><img src="images/t04.png" /></span>查询</li>
	        <li onclick="javascript:addProductCatagory();"><span><img src="images/t01.png" /></span>添加</li>
	        </ul>
    	</ul>
    </div>
    
    
    <table class="tablelist">
    	<thead>
    	<tr>
	        <th><input name="sltAll" id="sltAll" type="checkbox" value="" onclick="sltAllCatagory()"/></th>
	        <th>序号<i class="sort"><img src="images/px.gif" /></i></th>
	        <th>分类名称</th>
			<th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:choose>
			<c:when test="${not empty catagorySubList}">
				<c:forEach items="${catagorySubList}" var="catagory" varStatus="vs">
				<tr>
				<td><input type="checkbox" name="productIds" id="productIds" value="${productCatagory.productId }"/></td>
				<td>${vs.index+1}</td>
				<td id="CatagoryNameTd${productCatagory.productId }">${productCatagory.productName }</td>
				<td><a href="javascript:editCatagory(${productCatagory.productId });">修改</a> | <a href="javascript:delCatagory(${productCatagory.productId });">删除</a> 
				</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="7">没有相关数据</td>
				</tr>
			</c:otherwise>
		</c:choose>
        
        </tbody>
    </table>
    ${productCatagory.page.pageStr }
    </div>
 </form>   
    <script type="text/javascript">
    	function search(){
    		alert();
			$("#productCatagoryForm").submit();
		}
		$(document).ready(function(){
			$(".main_info:even").addClass("main_table_even");
		});
		</script>
	<script type="text/javascript">
		function addProductCatagory(){
			var dg = new $.dialog({
				title:'新增分类',
				id:'productCatagory_new',
				width:300,
				height:130,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				html:'<div style="width:100%;height:40px;line-height:40px;text-align:center;"><span style="color: #4f4f4f;font-size: 13px;font-weight: bolder;display:inline-block;vertical-align:middle;">分类名称：</span><input type="text" name="productName" id="productName" class="scinput"/></br>
				});
    		dg.ShowDialog();
    		dg.addBtn('ok','保存',function(){
    			var url = "productCatagory/save.html";
    			var postData = {productName:$("#productName").val()};
    			$.post(url,postData,function(data){
    				if(data=='success'){
    					dg.curWin.location.reload();
    					dg.cancel();
    				}else{
    					alert('分类名重复，保存失败！');
    					$("#productName").focus();
    					$("#productName").select();
    				}
    			});
    		});
		}
		</script>
		<script type="text/javascript">
		function editCatagory(productId){
			var roleName = $("#CatagoryNameTd"+productId).text();
			var dg = new $.dialog({
				title:'修改分类',
				id:'role_edit',
				width:300,
				height:130,
				iconTitle:false,
				cover:true,
				maxBtn:false,
				xButton:true,
				resize:false,
				html:'<div style="height:40px;line-height:40px;text-align:center;"><span style="color: #4f4f4f;font-size: 13px;font-weight: bold;display:inline-block;vertical-align:middle;">角色名称：</span><input type="text" name="productName" id="productName" value="'+productName+'" class="scinput"/></div>'
				});
    		dg.ShowDialog();
    		dg.addBtn('ok','保存',function(){
    			var url = "productCatagory/save.html";
    			var postData = {productId:productId,productName:$("#productName").val()};
    			$.post(url,postData,function(data){
    				if(data=='success'){
    					dg.curWin.location.reload();
    					dg.cancel();
    				}else{
    					alert('分类名重复，保存失败！');
    					$("#productName").focus();
    					$("#productName").select();
    				}
    			});
    		});
		}
		</script>
		<script type="text/javascript">
		
	function sltAllCatagory(){
		if($("#sltAll").attr("checked")){
			$("input[name='productIds']").attr("checked",true);
		}else{
			$("input[name='productIds']").attr("checked",false);
		}
	}
	</script>

</body>

</html>
