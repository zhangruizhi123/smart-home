<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%>

<!-- jQuery 3 -->
<script type="text/javascript" src="<%=path %>/admin-lte/bower_components/jquery/dist/jquery.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script type="text/javascript" src="bower_components/jquery-ui/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button);
</script>
<!-- Bootstrap 3.3.7 -->
<script type="text/javascript" src="<%=path %>/admin-lte/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- Morris.js charts -->
<script type="text/javascript" src="<%=path %>/admin-lte/bower_components/raphael/raphael.min.js"></script>
<script type="text/javascript" src="<%=path %>/admin-lte/bower_components/morris.js/morris.min.js"></script>
<!-- Sparkline -->
<script type="text/javascript" src="<%=path %>/admin-lte/bower_components/jquery-sparkline/dist/jquery.sparkline.min.js"></script>
<!-- jvectormap -->
<script type="text/javascript" src="<%=path %>/admin-lte/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script type="text/javascript" src="<%=path %>/admin-lte/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<!-- jQuery Knob Chart -->
<script type="text/javascript" src="<%=path %>/admin-lte/bower_components/jquery-knob/dist/jquery.knob.min.js"></script>
<!-- daterangepicker -->
<script type="text/javascript" src="<%=path %>/admin-lte/bower_components/moment/min/moment.min.js"></script>
<script type="text/javascript" src="<%=path %>/admin-lte/bower_components/bootstrap-daterangepicker/daterangepicker.js"></script>
<!-- datepicker -->
<script type="text/javascript" src="<%=path %>/admin-lte/bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
<!-- Bootstrap WYSIHTML5 -->
<script type="text/javascript" src="<%=path %>/admin-lte/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<!-- Slimscroll -->
<script type="text/javascript" src="<%=path %>/admin-lte/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>

<script type="text/javascript" src="<%=path %>/admin-lte/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=path %>/admin-lte/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<!-- FastClick -->
<script type="text/javascript" src="<%=path %>/admin-lte/bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script type="text/javascript" src="<%=path %>/admin-lte/dist/js/adminlte.min.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script type="text/javascript" src="<%=path %>/admin-lte/dist/js/pages/dashboard.js"></script>
<!-- Select2 -->
<script src="<%=path %>/admin-lte/bower_components/select2/dist/js/select2.full.min.js"></script>
<script src="<%=path %>/admin-lte/bower_components/bootstrap3-dialog/dist/js/bootstrap-dialog.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script type="text/javascript" src="<%=path %>/admin-lte/dist/js/demo.js"></script>
<script type="text/javascript" src="<%=path%>/js/vue.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery.formFill.js"></script>
<script type="text/javascript" src="<%=path%>/js/base.js"></script>

<script>

function adjustmentHeight(){
	var currentHeight=$(document).height();
	$('#content', window.parent.document).height(currentHeight);
}

$(function(){
	adjustmentHeight();
});
</script>
