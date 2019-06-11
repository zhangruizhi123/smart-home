;(function($){
	 /*
    flagName:标识绑定字段元素的属性，如：
    data-bind是寻找绑定字段的属性：
    <input data-bind='Time' type='text' />
    <input data-bind='User.Time' type='text' />
    注意区分大小写，与对象名相同即可
    jsonData:json数据对象，根据其中的属性名，绑定到对应属性名的字段上
    */
    var JsonBind = function (ele, opt) {
        this.$element = $(ele),
        this.defaults = {
            flagName: 'name'
        },
        /*
        当给extend方法传递一个以上的参数时，它会将所有参数对象合并到第一个里。
        同时，如果对象中有同名属性时，合并的时候后面的会覆盖前面的。
        将一个新的空对象做为$.extend的第一个参数，defaults和用户传递的参数对象紧随其后，
        这样做的好处是所有值被合并到这个空对象上，保护了插件里面的默认值。
        */
        this.options = $.extend({}, this.defaults, opt)
    };
    //取值方法，可以单独以实体属性名进行取值，如：UserName，也可以复合实体取值，如：UserInfo.UserName，注意区分大小写
    JsonBind.getValue = function (key, data) {
        if (key.split('.').length == 1) {
            return data[key];
        }
        else if (key.split('.').length == 2) {
            var keys = key.split('.');
            //数据有值时获取
            if (data[keys[0]]) {
                //先判断数组后判断object，因为数组也是object
                if (Array.isArray(data[keys[0]])) {
                    return data[keys[0]][0][keys[1]];
                }
                else if (typeof (data[keys[0]]) == 'object') {
                    return data[keys[0]][keys[1]];
                }
                else {
                    return console.error("对象类型错误，无法解析");
                }
            }
        }
        else {
            return console.error("实体对象层级过多，最多支持两级，如：test.name");
        }
    };
    JsonBind.prototype = {
        bind: function () {
            if (this.options.jsonData) {
                if (this.options.jsonData == 'string') {
                    this.options.jsonData = JSON.parse(this.options.jsonData);
                }
            }
            //获得触发事件的元素
            var dom = this.$element;
            var name = this.options.flagName;
            var data = this.options.jsonData;
            //遍历元素内所有含有name属性的元素
            dom.find("[" + name + "]").each(function () {
                //取出json中对应name属性的值
                var key = $.trim($(this).attr(name));
                var val = JsonBind.getValue(key, data);
                if (val != '') {
                    //检查当前元素标签，并根据不同标签进行赋值操作
                    if ($(this).is("input")) {
                        //检查当前元素类型，并根据不同类型进行赋值操作
                        switch ($(this).attr("type")) {
                            case "radio":
                                $(dom).find("input:radio[" + name + "='" + key + "'][value='" + val + "']").prop("checked", true);
                                break;
                            case "checkbox":
                                $(dom).find("input:checkbox[" + name + "='" + key + "'][value='" + val + "']").prop("checked", true);
                                //$(this).siblings("[value='" + val + "']").prop("checked", true);
                                break;
                            default:
                                $(this).val(val);
                                break;
                        }
                    }
                    else {
                        //如：select、textarea
                        $(this).val(val);
                    }
                }
            });
        }
    };
    //将方法增加到jQuery扩展方法中
    $.fn.extend({
        dataBind: function (options) {
            var jsBind = new JsonBind(this, options);
            jsBind.bind();
        }
    });
    /***
     * 弹出提示
     */
    $.alert=function(options){
    	 var defaults={
    			title: '提示',
	            message: '系提示信息',
	            type: BootstrapDialog.TYPE_WARNING, 
	            closable: true, 
	            draggable: true, 
	            buttonLabel: '确定',
    	 };
    	 var endOptions=$.extend(defaults,options);
    	BootstrapDialog.alert(endOptions);
    };
    
    /**
     * 确认对话框
     */
    $.confirm=function(options){
    	var defaults={
    			title: '提示框',
                message: '你确定要删除该条记录？',
                type: BootstrapDialog.TYPE_WARNING, // <-- Default value is BootstrapDialog.TYPE_PRIMARY
                closable: true, // <-- Default value is false
                draggable: true, // <-- Default value is false
                btnCancelLabel: '取消', // <-- Default value is 'Cancel',
                btnOKLabel: '确定', // <-- Default value is 'OK',
                btnOKClass: 'btn-warning', // <-- If you didn't specify it, dialog type will be used,
                callback:function(){},
    	};
    	var endOptions=$.extend(defaults,options);
    	BootstrapDialog.confirm(endOptions);
    };
    $.fn.BaseTable=function(options){
    	var defaults={
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
		      'ajax'        : {},
		      'columns' :[],
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
    	};
    	var endOptions=$.extend(defaults,options);
    	//返回this对象
    	return this.DataTable(endOptions);
    };
	
})(jQuery);