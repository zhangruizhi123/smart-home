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
<title>产品管理</title>
<jsp:include page="/css.jsp" />
</head>
<body>
    <section class="content-header">
      <h1>
       	 功能管理
        <small>设备管理</small>
      </h1>
    </section>
    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
          <div class="box">
            <div class="box-header">
             <a class="btn btn-primary btn-sm" id="add">
             <span class="glyphicon glyphicon-plus"></span>
                                添加</a>
            <a class="btn btn-danger btn-sm" id="delete">
             <span class="glyphicon glyphicon-trash"></span>
                                删除</a>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <table id="example2" class="table table-bordered table-hover">
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
                <h4 class="modal-title">添加设备</h4>
              </div>
              <div class="modal-body">
                <form action="" class="userForm form-horizontal">
	                <div class="box-body">
	                	<input name="id" style="display:none;">
	                	<input name="userId" style="display:none;" value="${user_loginedd.id}">
	                	
		                <div class="form-group">
		                  <label for="name" class="col-sm-2 control-label">所属项目</label>
		                  <div class="col-sm-10">
		                   <select class="form-control" id="projectId" name="projectId">
		                   </select>
		                  </div>
		                </div>
		                
		                <div class="form-group">
		                  <label for="name" class="col-sm-2 control-label">所属产品</label>
		                  <div class="col-sm-10">
		                   <select class="form-control" id="productId" name="projectId">
		                   </select>
		                  </div>
		                </div>
		                
		                <div class="form-group">
		                  <label for="name" class="col-sm-2 control-label">设备名称</label>
		                  <div class="col-sm-10">
		                    <input name="name" type="text" class="form-control" placeholder="请输入设备名称">
		                  </div>
		                </div>
		                
		                <div class="form-group">
		                  <label for="name" class="col-sm-2 control-label">mac地址</label>
		                  <div class="col-sm-10">
		                    <input name="mac" type="text" class="form-control" placeholder="请输入mac地址">
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
	//需要传入的参数(查询项目信息)
	var param={
			or:[{
					and:[{
						value:"${user_loginedd.id}",
						name:'userId',
						opt:'='
					}]
				}]
	};
	var proJectList={};
	//加载自己的产品信息
	$.ajax({
		url:'<%=path%>/appProject/listPageParams.do',
		data:{param:JSON.stringify(param)},
		type:'post',
		async:false,
		dataType:'json',
		success:function(json){
			if(json.code==0){
				proJectList=json.data;
			}
		}
	});
	//加载项目
	var option="<option value='-1'>--请选择项目--</option>";
	for(var i=0;i<proJectList.length;i++){
		var item=proJectList[i];
		option+="<option value='"+item.id+"'>"+item.projectName+"</option>";
	}
	$("#projectId").append(option);
	
	$("#projectId").change(function(){
		var projectId=$(this).val();
		//加载自己的产品信息
		var param={
				or:[{
						and:[{
							value:"${user_loginedd.id}",
							name:'userId',
							opt:'='
						},{
							value:projectId,
							name:'projectId',
							opt:'='
						}]
					}]
		};
		$.ajax({
			url:'<%=path%>/appProduct/listPageParams.do',
			data:{param:JSON.stringify(param)},
			type:'post',
			dataType:'json',
			success:function(json){
				if(json.code==0){
					var productList=json.data;
					//
					var option="";
					for(var i=0;i<productList.length;i++){
						var item=productList[i];
						option+="<option value='"+item.id+"'>"+item.name+"</option>";
					}
					$("#productId").empty().append(option);
				}
			}
		});
		
		
	});
	
    var $table=$('#example2').BaseTable({
    	'selected':1,
      'head':[
    	  {'name':'编号'},
    	  {'name':'项目名称'},
    	  {'name':'产品名称'},
    	  {'name':'设备名称'},
    	  {'name':'mac地址'},
    	  {'name':'deviceSecret'},
    	  {'name':'状态'},
    	  {'name':'创建时间'},
    	  {'name':'最近上线时间'},
      ],
      'ajax'        : {
    	  url:'<%=path%>/appDevice/listPageParams.do',
    	  type:'post',
    	  data:function(json){
    		  //参数设置
    		  var order=json.order[0].dir;
    		  var index=json.order[0].column;
    		  var orderName=json.columns[index].data;
    		  json.orderName=orderName;
    		  json.orderRole=order;
    		  //条件查询
    		  //json.param=JSON.stringify(param);
    		  return json;
    	  },
      },
      fnDrawCallback:function(n){
    	  adjustmentHeight();
      },
      'columns' :[
      	  { "data": "id" },
    	  { "data": "name" },
    	  { "data": "projectId",render:function(val, type, full, callback){
    		  for(var i=0;i<proJectList.length;i++){
    			  var item=proJectList[i];
    			  if(item.id==val){
    				  return item.projectName;
    			  }
    		  }
    		  return "未知";
    	  }},
    	  { "data": "name" },
    	  { "data": "mac" },
    	  { "data": "deviceSecret" },
    	  { "data": "state" ,render:function(val, type, full, callback){
    		  if(val==0){
    			  return "未激活";
    		  }else if(val==1){
    			  return "已激活";
    		  }else if(val==2){
    			  return "离线";
    		  }else if(val==3){
    			  return "上线";
    		  }else{
    			  return "未知";
    		  }
    	  }},
    	  { "data": "cTime" },
    	  { "data": "modifyTime" },
      ],
    });
    function getSelectRow(){
    	var selected=$('#example2 tbody tr.selected');
    	if(selected.length<1){
    		return null;
    	}
    	var rows=[];
    	for(var i=0;i<selected.length;i++){
    		var data=$table.rows(selected[i]).data()[0];
    		rows[i]=data;
    	}
    	return rows;
    }
    $("#add").click(function(){
    	$("#addUser").modal('show');
    	$(".userForm")[0].reset();
    	$(".userForm")[0].action="<%=path%>/appDevice/insertSeletive.do";
    });
    $("#delete").click(function(){
    	//获取选中行数据
    	var row=getSelectRow()[0];
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
	            		url:'<%=path%>/appDevice/deleteByPrimaryKey.do',
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
    	var row=getSelectRow()[0];
    	if(row==null){
    		$.alert({massage:"请先选中行"});
    	}
    	//设备表单的action
    	$(".userForm")[0].action="<%=path%>/appDevice/updateByPrimaryKey.do";
    	$(".userForm")[0].reset();
    	$(".userForm").dataBind({jsonData:row});
    	$("#addUser").modal('show');
    });
    $("#seach").click(function(){
    	param={or:[
    		{and:[
    			{name:'roleName',opt:'like',value:'%管理员'}
    		]}
    	]};
    	$table.draw();
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