<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<%@include file="../../header.jsp"%>
<jsp:include page="../../basepath.jsp"/>
<link rel="stylesheet" type="text/css" href="${basePath}/resources/plugins/bootstrap-tree/css/style.min.css"/>
<script src="${basePath}/resources/plugins/bootstrap-tree/jstree.min.js"></script>
<body>
<div class="row">
	<div class="col-md-12">
		<div class="portlet box grey-cascade">
			<div class="portlet-title">
				<div class="caption">
					<i class="fa fa-globe"></i>资源列表
				</div>
				<div class="actions">
					<button id="addResource" class="btn btn-sm blue" type="button">新增资源</button>
					<button id="goBack" class="btn btn-sm green" type="button">返回用户管理</button>
					<input id="hideResourceId" name="resourceId" type="hidden"/>
				</div>
			</div>
			<div class="portlet-body" style="float:left;">
				<div id="resourceTree" class="tree-demo" style="width:400px; float:left; display:inline" >
				</div>
				<div id="contextText" class="tree-demo" style="width:600px; float:left; display:inline" >

				</div>

			</div>


		</div>
	</div>
</div>

<script type="text/javascript">
    var resourceHelper = {
        availStatusEnum : '${availStatusEnum}',
        resourceTypeEnum : '${resourceTypeEnum}',
        resourceLevelEnum : '${resourceLevelEnum}',

        init : function () {
            var me = resourceHelper;
            $('#addResource').click(me.addResource);// 新增资源按钮
            $('#goBack').click(me.goBack);//返回用户管理按钮

        },
        // 新增资源
        addResource : function () {
            var resourceId = $("#hideResourceId").val();
            if (resourceId == null || resourceId == "") {
                bootbox.alert("请选择上级菜单,再新增资源");
                return;
            }
            location.href="${basePath}/user/toAddResource.do?resourceId=" + resourceId;
        },
        //返回用户管理
        goBack : function () {
            location.href="${basePath}/index/toUser.do";
        },
    };

    $(function() {
        resourceHelper.init();

        //为jsTree节点绑定单击事件    双击事件,苹果电脑不支持
        $("#resourceTree").bind("click", function (e, data){
            var resourceId = $(e.target).parents('li').attr('id');
            $("#hideResourceId").val(resourceId);//为隐藏域赋值
            $.ajax({
                url : "${basePath}/user/getResourceById.do",
                data : {resourceId : resourceId},
                dataType : "json",
                type : "POST",
                success : function (data) {
                    if(data.resultCode!='0000') {
                        bootbox.alert(data.resultMsg);
                    } else {
                        var resource = data.data;
                        var tableT = '<table class="table table-striped table-bordered table-hover table-condensed table-responsive">'+
                            '<tr>'+
                            '<th>操作</th>'+
                            '<th>ID</th>'+
                            '<th>资源名称</th>'+
                            '<th>资源类型</th>'+
                            '<th>父级名称</th>'+
                            '<th>对应产品</th>'+
                            '<th>资源级别</th>'+
                            '<th>顺序</th>'+
                            '<th>状态</th>'+
                            '</tr>'+
                            '<tr class="warning">'+
                            '<td>'+
                            '<a class="ajaxify btn default btn-xs purple" href="${basePath}/user/toUpdateResource.do?resourceId='+resource.resourceId+'">修改</a>'+
                            '</td>'+
                            '<td>'+ resource.resourceId +'</td>'+
                            '<td>'+ resource.resourceName +'</td>'+
                            '<td>'+ myJson.getText(resource.resourceType, resourceHelper.resourceTypeEnum) +'</td>'+
                            '<td>'+ resource.parentName +'</td>'+
                            '<td>'+ resource.productName +'</td>'+
                            '<td>'+ myJson.getText(resource.level, resourceHelper.resourceLevelEnum) +'</td>'+
                            '<td>'+ resource.sequence +'</td>'+
                            '<td>'+ myJson.getText(resource.status, resourceHelper.availStatusEnum) +'</td>'+
                            '</tr>'+
                            '</table>'
                        ;
                        $("#contextText").html(tableT);
                    }
                }
            });

        });

        var data = JSON.parse('${nodes}');
        $('#resourceTree').jstree({
            'plugins': ["wholerow", "types"],
            'core': {
                "themes" : {
                    "responsive": false
                },
                'data': data
            },
            "types" : {
                "default" : {
                    "icon" : "fa fa-folder icon-state-warning icon-lg"
                },
                "file" : {
                    "icon" : "fa fa-file icon-state-warning icon-lg"
                }
            }
        });

    });

</script>
</body>
</html>
