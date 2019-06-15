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
<jsp:include page="/css.jsp" />
</head>
<body>
    <section class="content-header">
      <h1>
       	 系统管理
        <small>用户管理</small>
      </h1>
    </section>
    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
          <div class="box">
            <div class="box-header">
            <!-- 
              <h3 class="box-title">Hover Data Table</h3>
               -->
             <a class="btn btn-primary btn-sm" id="add">
             <span class="glyphicon glyphicon-plus"></span>
                                添加</a>
            <a class="btn btn-danger btn-sm" id="delete">
             <span class="glyphicon glyphicon-trash"></span>
                                删除</a>
             <a class="btn btn-success btn-sm" id="edit">
             <span class="glyphicon glyphicon-pencil"></span>
                                修改</a>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <table id="example2" class="table table-bordered table-hover">
                <thead>
                <tr>
                  <th>id</th>
                  <th>手机号</th>
                  <th>昵称</th>
                  <th>名字</th>
                  <th>角色</th>
                  <th>登录ip</th>
                  <th>最后修改时间</th>
                  <th>创建时间</th>
                </tr>
                </thead>
                <tbody>
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
    
    <div class="modal fade" id="addUser">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">添加用户</h4>
              </div>
              <div class="modal-body">
                <form action="" class="userForm form-horizontal">
	                <div class="box-body">
	                	<input name="id" style="display:none;">
	                	<div class="form-group">
		                  <label for="name" class="col-sm-2 control-label">用户名</label>
		                  <div class="col-sm-10">
		                    <input name="name" type="text" class="form-control" placeholder="请输入用户名">
		                  </div>
		                </div>
		                
		                <div class="form-group">
		                  <label for="mobile" class="col-sm-2 control-label">手机号</label>
		                  <div class="col-sm-10">
		                    <input name="mobile" type="text" class="form-control" placeholder="请输入手机号">
		                  </div>
		                </div>
		                
		                <div class="form-group">
		                  <label for="nick" class="col-sm-2 control-label">昵称</label>
		                  <div class="col-sm-10">
		                    <input name="nick" type="text" class="form-control" placeholder="请输入昵称">
		                  </div>
		                </div>
		                <div class="form-group">
		                  <label for="password" class="col-sm-2 control-label">角色</label>
		                  <div class="col-sm-10">
		                  	<select name="roleId" class="form-control" >
		                  	</select>
		                  </div>
		                </div>
		                <div class="form-group">
		                  <label for="password" class="col-sm-2 control-label">密码</label>
		                  <div class="col-sm-10">
		                    <input name="password" type="password" class="form-control" placeholder="请输入昵称">
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
  
</body>
<jsp:include page="/js.jsp" />
<script type="text/javascript">
$(function () {
	var roleData={};
	$.ajax({
		url:'<%=path%>/sysRole/listPageParams.do',
		type:'post',
		dataType:'json',
		async:false,//设置成同步的方法
		success:function(json){
			if(json.code==0){
				roleData=json.data;
			}else{
				$.alert({message:json.message});
			}
		}
	});
	var option="";
	for(var i=0;i<roleData.length;i++){
		var item=roleData[i];
		option+="<option value='"+item.id+"'>"+item.roleName+"</option>";
	}
	$("select[name=roleId]").append(option);
    var $table=$('#example2').DataTable({
      'paging'      : true,
      'lengthChange': true,
      "aLengthMenu":[5,10,15,20,30,50,100],
      'pageLength'  : 10,
      'pageStart'   : 0,
      'searching'   : false,
      'serverSide': true,//分页，取数据等等的都放到服务端去
      'processing': true,////载入数据的时候是否显示“载入中”
      'ordering'    : true,//排序操作在服务端进行，所以可以关了。
      'info'        : true,
      'autoWidth'   : false,
      'stateSave': false,//开启后刷新会显示上一次的内容
      'ajax'        : {
    	  url:'<%=path%>/sysUser/listPageParams.do',
    	  type:'post',
    	  data:function(json){
    		  //参数设置
    		  var order=json.order[0].dir;
    		  var index=json.order[0].column;
    		  var orderName=json.columns[index].data;
    		  json.orderName=orderName;
    		  json.orderRole=order;
    		  return json;
    	  },
      },
      fnDrawCallback:function(n){
      },
      'columns' :[
      	  { "data": "id" },
    	  { "data": "mobile" },
    	  { "data": "nick" },
    	  { "data": "name" },
    	  { "data": "roleId",render:function(val, type, full, callback){
    		  console.log(JSON.stringify(roleData));
    		  for(var i=0;i<roleData.length;i++){
    			  if(roleData[i].id==val){
    				  return roleData[i].roleName;
    			  }
    		  }
    		  
    		  
    		  return "未知";
    	  }},
    	  { "data": "ip" },
    	  { "data": "modityTime" },
    	  { "data": "cTime" },
      ],
      "language": {
          "lengthMenu": "每页 _MENU_ 条记录",
          "zeroRecords": " ",
          "info": "当前 _START_ 条到 _END_ 条 共 _TOTAL_ 条",
          "infoEmpty": "无记录",
          "infoFiltered": "(从 _MAX_ 条记录过滤)",
          "search": "用户",
          "processing": "载入中",
          "paginate": {
              "first": "首页",
              "previous": "上一页",
              "next": "下一页",
              "last": "尾页"
          }
      }
    });
    $('#example2 tbody').on("click","tr",function(){
    	//多选的情况
    	//$(this).toggleClass("selected");
    	if($(this).hasClass("selected")){
    		$(this).removeClass("selected");
    	}else{
    		$(this).parent().find("tr").removeClass("selected");
    		$(this).addClass("selected");
    		console.log(JSON.stringify($table.rows(this).data()[0].id));
    	}
    });
    function getSelectRow(){
    	var selected=$('#example2 tbody tr.selected')[0];
    	if(selected==undefined){
    		return null;
    	}
    	return $table.rows(selected).data()[0];
    }
    $("#add").click(function(){
    	$("#addUser").modal('show');
    	$(".userForm")[0].reset();
    	$(".userForm")[0].action="<%=path%>/sysUser/insertSeletive.do";
    });
    $("#delete").click(function(){
    	//获取选中行数据
    	var row=getSelectRow();
    	if(row==null){
    		$.alert({message:"请先选中行"});
    	}
    	$.confirm({
            title: '提示框22',
            message: '你确定要删除该条记录？',
            callback: function(result) {
                if(result) {
	            	var id= row.id;
	            	$.ajax({
	            		url:'<%=path%>/sysUser/deleteByPrimaryKey.do',
	            		type:'post',
	            		dataType:'json',
	            		data:{id:id},
	            		success:function(json){
	            			if(json.code==0){
	            				$table.draw();
	            				$.alert({message:"删除成功"});
	            			}else{
	            				$.alert({message:json.message});
	            			}
	            		}
	            	});
                }
            }
        });
    	
    });
    
    $("#edit").click(function(){
    	//获取选中行数据
    	var row=getSelectRow();
    	if(row==null){
    		$.alert({massage:"请先选中行"});
    	}
    	//设备表单的action
    	$(".userForm")[0].action="<%=path%>/sysUser/updateByPrimaryKey.do";
    	$(".userForm")[0].reset();
    	$(".userForm").dataBind({jsonData:row});
    	$("#addUser").modal('show');
    });
    
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
    			//alert(json.message);
    			$table.draw();
    			$("#addUser").modal('hide');
    			if(json.code!=0){
    				$.alert({message:json.message});
    			}
    		},
    		error:function(){
    			$.alert({message:"请求错误"});
    		}
    	});
    });
  });
</script>
</html>