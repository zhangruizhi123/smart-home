<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=path %>/admin-lte/bower_components/jquery-treeTable/css/jquery.treetable.css">

<link rel="stylesheet" href="<%=path %>/admin-lte/bower_components/jquery-treeTable/css/jquery.treetable.theme.default.css">

<link rel="stylesheet" href="<%=path %>/admin-lte/bower_components/fontIconPicker-2.0.0/css/jquery.fonticonpicker.min.css">
<link rel="stylesheet" href="<%=path %>/admin-lte/bower_components/fontIconPicker-2.0.0/themes/bootstrap-theme/jquery.fonticonpicker.bootstrap.min.css">

 <!-- iCheck for checkboxes and radio inputs -->
<link rel="stylesheet" href="<%=path %>/admin-lte/plugins/iCheck/all.css">
<style type="text/css">
td{
	font-size:16px;
}
</style>
<jsp:include page="/css.jsp" />
</head>
<body>
    <section class="content-header">
      <h1>
       	 系统管理
        <small>角色</small>
      </h1>
    </section>
    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
          <div class="box">
            <div class="box-header">
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <table id="treeTable" class="table table-striped table-bordered table-hover">
	    		<thead>
	    			<tr>
	    				<td>id</td>
	    				<td>名称</td>
	    				<td>连接</td>
	    				<td>排序</td>
	    				<td>图标</td>
	    				<td>操作
	    					<button class="btn btn-xs btn-primary" onclick="add(-1,this)">
		    						<i class="glyphicon glyphicon-plus"></i>
		    						添加
		    					</button>
	    				</td>
	    			</tr>
	    		</thead>
	    		<tbody>
	    		
	    			<template v-for="parentMenu in menuList">
	    				<tr v-bind:data-tt-id="parentMenu.id">
		    				<td>{{parentMenu.id}}</td>
		    				<td>{{parentMenu.name}}</td>
		    				<td>{{parentMenu.url}}</td>
		    				<td>{{parentMenu.number}}</td>
		    				<td><i v-bind:class="parentMenu.icon"></i></td>
		    				<td>
		    					
		    					<button class="btn btn-xs btn-success" v-bind:data="parentMenu.id" onclick="edit(0,this)">
		    						<i class="glyphicon glyphicon-pencil"></i>
		    						修改
		    					</button>
		    					<button class="btn btn-xs btn-danger" v-bind:data="parentMenu.id" onclick="del(0,this)">
		    						<i class="glyphicon glyphicon-trash"></i>
		    						删除
		    					</button>
		    					<button class="btn btn-xs btn-info" v-bind:data="parentMenu.id" onclick="pows(0,this)">
		    						<i class="fa fa-database"></i>
		    						授权
		    					</button>
		    					<button class="btn btn-xs btn-primary" v-bind:data="parentMenu.id" onclick="add(0,this)">
		    						<i class="glyphicon glyphicon-plus"></i>
		    						添加
		    					</button>
		    				</td>
		    			</tr>
		    			<template v-if="parentMenu.subMenu.length>0">
		    				<template v-for="child in parentMenu.subMenu">
		    					<tr v-bind:data-tt-id="child.id" v-bind:data-tt-parent-id="parentMenu.id">
				    				<td>{{child.id}}</td>
				    				<td>{{child.name}}</td>
				    				<td>{{child.url}}</td>
				    				<td>{{child.number}}</td>
				    				<td><i v-bind:class="child.icon"></i></td>
				    				<td>
				    					<button class="btn btn-xs btn-success" v-bind:data="child.id" onclick="edit(1,this)" >
				    						<i class="glyphicon glyphicon-pencil"></i>
				    						修改
				    					</button>
				    					<button class="btn btn-xs btn-danger" v-bind:data="child.id" onclick="del(1,this)">
				    						<i class="glyphicon glyphicon-trash"></i>
				    						删除
				    					</button>
				    					
				    					<button class="btn btn-xs btn-info" v-bind:data="child.id" onclick="pows(1,this)">
				    						<i class="fa fa-database"></i>
				    						授权
				    					</button>
				    				</td>
				    			</tr>
		    				</template>
		    			</template>
	    			</template>
	    			
	    		</tbody>
	    	</table>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->    
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
    </section>
    <!-- /.content -->
    
    <div class="modal fade" id="addMenu">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">添加菜单</h4>
              </div>
              <div class="modal-body">
                <form action="" class="userForm form-horizontal">
	                <div class="box-body">
	                	<input name="id" style="display:none;">
	                	<input name="pid" style="display:none;">
	                	<div class="form-group">
		                  <label for="name" class="col-sm-2 control-label">名称</label>
		                  <div class="col-sm-10">
		                    <input name="name" type="text" class="form-control" placeholder="请输入名称">
		                  </div>
		                </div>
		                
		                <div class="form-group">
		                  <label for="name" class="col-sm-2 control-label">菜单url</label>
		                  <div class="col-sm-10">
		                    <input name="url" type="text" class="form-control" placeholder="请输入名称">
		                  </div>
		                </div>
		                
		                <div class="form-group">
		                  <label for="name" class="col-sm-2 control-label">排序</label>
		                  <div class="col-sm-10">
		                    <input id="number" name="number" type="text" class="form-control" placeholder="请输入排序">
		                  </div>
		                </div>
		                
		                <div class="form-group">
		                  <label for="name" class="col-sm-2 control-label">图标</label>
		                  <div class="col-sm-10">
		                    <select id="icon"  class="form-control" name="icon">
							</select>
		                  </div>
		                </div>
		                
	                </div>
                </form>
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-default pull-left" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="save">保存</button>
              </div>
            </div>
            <!-- /.modal-content -->
          </div>
          <!-- /.modal-dialog -->
        </div>
        <!-- /.modal -->
        
        <div class="modal fade" id="addRole">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">角色授权</h4>
              </div>
              <div class="modal-body">
                <form action="" class="userForm2 form-horizontal">
	                <div class="box-body">
	                	<input name="id" id="menuId" style="display:none;">
	                	<div class="form-group" id="icheckd">
		                  <label for="name" class="col-sm-3 control-label">超级管理员</label>
		                  <div class="col-sm-2">
		                    <input type="checkbox" class="flat-red checkbox">
		                  </div>
		                  
		                  <label for="name" class="col-sm-3 control-label">超级管理员</label>
		                  <div class="col-sm-2">
		                    <input type="checkbox" class="flat-red checkbox">
		                  </div>
		                  
		                </div>
	                	
	                	
	                	
	                </div>
                </form>
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-default pull-left" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="menusave">保存</button>
              </div>
            </div>
            <!-- /.modal-content -->
          </div>
          <!-- /.modal-dialog -->
        </div>
        <!-- /.modal -->
  
</body>
<jsp:include page="/js.jsp" />
<script type="text/javascript" src="<%=path%>/admin-lte/bower_components/jquery-treeTable/jquery.treetable.js" ></script>
<script type="text/javascript" src="<%=path%>/admin-lte/bower_components/fontIconPicker-2.0.0/jquery.fonticonpicker.min.js" ></script>
<!-- iCheck 1.0.1 -->
<script src="<%=path%>/admin-lte/plugins/iCheck/icheck.min.js"></script>
<script type="text/javascript">
function loadData(){
	var treeTb=null;
	var data={};
	$.ajax({
		url:'<%=path%>/sysMenu/list.do',
		dataType:'json',
		type:'post',
		async:false,
		success:function(json){
			if(json.code==0){
				data=json.data;
			}
		}
	});
	return data;
}

var menuTable=new Vue({
	el:'#treeTable',
	data:{
		menuList:[]
	},
	methods:{
	},
	created:function(){
		data=loadData();
		this.menuList=data;
	},
});

function add(type,e){
	var id=$(e).attr("data");
	$(".userForm")[0].reset();
	if(type==2){
		$("#addMenu").find("input[name=pid]").val(0);
	}else{
		$("#addMenu").find("input[name=pid]").val(id);
	}
	$("#addMenu").modal('show');
	$(".userForm")[0].action="<%=path%>/sysMenu/insertSeletive.do";
}

function del(type,e){
	var id=$(e).attr("data");
	$.ajax({
		url:'<%=path%>/sysMenu/deleteByPrimaryKey.do',
		dataType:'json',
		type:'post',
		data:{id:id},
		success:function(json){
			if(json.code==0){
				$.alert({message:"删除成功"});
				data=loadData();
				menuTable.menuList=data;
			}else{
				$.alert({message:json.message});
			}
		}
	});
}
$("#save").click(function(){
	var url=$(".userForm").attr("action");
	var data=$(".userForm").serializeArray();
	var js={};
	$.each(data,function(){
		js[this.name]=this.value;
	});
	$.ajax({
		url:url,
		data:JSON.stringify(js),
		type:'post',
		headers: {
		      "Content-Type": "application/json;charset=utf-8"
		},
		dataType:'json',
		success:function(json){
			
			data=loadData();
			menuTable.menuList=data;
			$("#treeTable").treetable("loadBranch",null,this.rootRows);
			//$("#treeTable").treetable(true)
			$("#addMenu").modal('hide');
			if(json.code!=0){
				$.alert({message:json.message});
			}
		},
		error:function(){
			$.alert({message:"请求错误"});
		}
	});
});

$("#menusave").click(function(){
	var ids=[];
	var ids2=[];
	$("#icheckd").find("input[type=checkbox]").each(function(){
		if($(this).is(":checked")){
			ids.push($(this).attr("did"));
		}else{
			ids2.push($(this).attr("did"));
		}
	});
	var menuId=$("#menuId").val();
	$.ajax({
		url:'<%=path%>/sysRoleMenu/updateRoleMenus.do',
		data:{roles:ids,uroles:ids2,menuId:menuId},
		type:"post",
		dataType:'json',
		success:function(json){
			$("#addRole").modal('hide');
			if(json.code==0){
				$.alert({message:'授权成功'});
			}else{
				$.alert({message:json.message});
			}
		}
	});
});
function edit(type,e){
	var id=$(e).attr("data");
	$("#addMenu").find("input[name=pid]").val(id);
	$(".userForm")[0].action="<%=path%>/sysMenu/updateByPrimaryKey.do";
	
	$(".userForm")[0].reset();
	$.ajax({
		url:'<%=path%>/sysMenu/findByPrimaryKey.do',
		data:{id:id},
		type:"post",
		dataType:'json',
		success:function(json){
			$(".userForm").dataBind({jsonData:json.data});
			$("#number").val(json.data.number);
			$("#addMenu").modal('show');
		}
	});
	
	
}

function pows(type,e){
	var id=$(e).attr("data");
	$("#icheckd").find("input[type=checkbox]").iCheck('uncheck');
	$.ajax({
		url:'<%=path%>/sysRoleMenu/findByMenuId.do',
		async:false,
		type:'post',
		data:{menuId:id},
		dataType:'json',
		success:function(json){
			if(json.code==0){
				$("#menuId").val(id);
				for(var i=0;i<json.data.length;i++){
					var item=json.data[i];
					$("#icheckd").find("input[did="+item.roleId+"]").iCheck('check');
				}
			}else{
				$.alert(json.message);
			}
		}
	});
	$("#addRole").modal('show');
}
$(function () {
	var $icheckd=$("#icheckd");
	//对角色初始化
	$.ajax({
		url:'<%=path%>/sysRole/listPageParams.do',
		async:false,
		type:'post',
		dataType:'json',
		success:function(json){
			if(json.code==0){
				var div="";
				for(var i=0;i<json.data.length;i++){
					var item=json.data[i];
					var ii='<label class="col-sm-3 control-label">'+item.roleName+'</label>'
	                  +'<div class="col-sm-1">'
	                    +'<input type="checkbox" vaue="'+item.id+'" did="'+item.id+'" class="flat-red checkbox">'
	                  +'</div>';
					div+=ii;
				}
				$icheckd.empty();
				$icheckd.append(div);
			}
		}
	});
	$('input[type="checkbox"].flat-red, input[type="radio"].flat-red').iCheck({
	      checkboxClass: 'icheckbox_flat-green',
	      radioClass   : 'iradio_flat-green'
	 })
	$.ajax({
		url:'<%=path%>/sysIcon/listPageParams.do',
		async:false,
		type:'post',
		dataType:'json',
		success:function(json){
			if(json.code==0){
				var option="";
				for(var i=0;i<json.data.length;i++){
					var item=json.data[i];
					option+="<option value='"+item.name+"'>"+item.name+"</option>";
				}
				$("#icon").append(option);
			}
		}
	});
	$('#icon').fontIconPicker({
	    hasSearch: true,
	    theme: 'fip-bootstrap'
	});
	treeTb=$("#treeTable").treetable({ 
		expandable: true ,
		initialState:'expanded'
	});
  });
</script>
</html>