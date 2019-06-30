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
        <small>产品列表</small>
      </h1>
    </section>
    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
          <div class="box">
            <div class="box-body" id="main">
            
            <div class="col-lg-3 col-md-4 col-sm-6 col-xs-12" v-for="item in productList">
               <div class="small-box bg-green">
		            <div class="inner">
		            	<h3>1</h3>
		              <p>ProductKey:{{item.productKey}}</p>
		            </div>
		            <div class="icon">
		              <i class="ion ion-stats-bars"></i>
		            </div>
		            <a href="#" class="small-box-footer">
		              	{{item.name}}<i class="fa fa-gear"></i>
		            </a>
		          </div>  
            </div>
          
          
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
  
</body>
<jsp:include page="/js.jsp" />
<script type="text/javascript">
var product=new Vue({
	el:'#main',
	data:{
		productList:[]
	},
	created:function(){
		$.ajax({
			url:'<%=path%>/appProduct/listPageParams.do',
			data:{},
			type:'post',
			dataType:'json',
			success:function(json){
				if(json.code==0){
					product.productList=json.data;
				}
			}
		});
	}
});

</script>
</html>