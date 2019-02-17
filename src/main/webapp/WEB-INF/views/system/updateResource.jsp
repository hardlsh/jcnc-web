<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<%@include file="../header.jsp"%>
<jsp:include page="../basepath.jsp"/>
<body>
	<div class="row">
		<div class="row col-md-12">
			<div class="portlet box grey-cascade">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-globe"></i>修改资源
					</div>
					<div class="actions">
						<button id="goBack" class="btn btn-sm green" type="button">返回上一级</button>
					</div>
				</div>
			</div>
			<form id="filter_form" action="###" class="form-horizontal">
				<!-- 隐藏域 -->
				<input type="hidden" id="oldResourecId" value="${parentResouce.resourceId }">
				<div class="form-group">
					<label class="control-label col-md-3">资源名称</label>
					<div class="col-md-5">
						<input type="text" name="resourceName" class="form-control" value="${resource.resourceName}">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3">资源级别</label>
					<div class="col-md-9">
						<div class="checkbox-list">
							<select class="bs-select form-control input-inline input-sm" id="level" name="level">
								<option value="">请选择</option>
								<option value="1">一级菜单</option>
								<option value="2">二级菜单</option>
							</select>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3">上级资源</label>
					<div class="col-md-9">
						<div class="checkbox-list">
							<select class="bs-select form-control input-inline input-sm"
									id="parentId" name="parentId"> <option value="">请选择</option>
							</select>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3">资源地址</label>
					<div class="col-md-9">
						<input id="resourcePath" name="resourcePath" value="${resource.resourcePath}"  class="form-control"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3">状态</label>
					<div class="col-md-9">
						<select class="bs-select form-control input-inline input-sm" id="status" name="status">
							<option value="">请选择</option>
							<option value="0">不可用</option>
							<option value="1">可用</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3">备注</label>
					<div class="col-md-9">
						<input id="remark" name="remark" value="${resource.remark}" class="form-control"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3"></label>
					<div class="col-md-9">
						<!-- 隐藏域 -->
						<input type="hidden" name="resourceId" value="${resource.resourceId}"/>
						<button type="button" id="save" class="btn blue">保  存</button>
						<button type="button" id="cancel" class="btn btn-default ">取  消</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript">
        var updateResourceHelper = {
            init : function (){
                var me = updateResourceHelper;
                $('#resourceType').change(me.resourceTypeChange);// 资源类型
                $('#level').change(me.levelChange);// 资源级别
                $('#cancel').click(me.cancel);// 取消按钮
                $('#save').click(me.save);// 保存按钮
            },
            // 资源级别
            levelChange : function() {
                var level = $("#level").val();
                var oldResourecId = $("#oldResourecId").val();
                if (level == null || level == "") {
                    return;
                }
                $("#parentId option").remove();
                $("#parentId").append('<option value="">请选择上级资源</option>');
                if (String(level) != "") {
                    $.ajax({
                        url : "${basePath}/resource/getResourceByLevel.do",
                        data : {
                            level : level
                        },
                        dataType : "json",
                        type : "POST",
                        success : function(data) {
                            if (data.resultCode != '0000') {
                                bootbox.alert(data.resultMsg);
                            } else {
                                if (data.data.length > 0) {
                                    $.each(data.data, function(index, entity) {
                                        if (oldResourecId == entity.resourceId) {
                                            $("#parentId").append(
                                                '<option selected = "selected" value="' + entity.resourceId + '">'
                                                + entity.resourceName
                                                + '</option>');//赋值
                                        } else {
                                            $("#parentId").append(
                                                '<option value="' + entity.resourceId + '">'
                                                + entity.resourceName
                                                + '</option>');//赋值
                                        }
                                    });
                                }
                            }
                        }
                    });
                }
            },
            // 资源类型
            resourceTypeChange : function () {
                var resourceType = $("#resourceType").val();
                var oldResourecId = $("#oldResourecId").val();
                if (resourceType == null || resourceType == "") {
                    bootbox.alert("请选择资源类型");
                    return;
                }
                $("#parentId option").remove();
                $("#parentId").append('<option value="">请选择上级资源</option>');
                if (String(resourceType) != "") {
                    $.ajax({
                        url : "${basePath}/resource/getResourceByType.do",
                        data : {
                            resourceType : resourceType
                        },
                        dataType : "json",
                        type : "POST",
                        success : function(data) {
                            if (data.resultCode != '0000') {
                                bootbox.alert(data.resultMsg);
                            } else {
                                if (data.data.length > 0) {
                                    $.each(data.data, function(index, entity) {
                                        if (oldResourecId == entity.resourceId) {
                                            $("#parentId").append(
                                                '<option selected = "selected" value="' + entity.resourceId + '">'
                                                + entity.resourceName
                                                + '</option>');//赋值
                                        } else{
                                            $("#parentId").append(
                                                '<option value="' + entity.resourceId + '">'
                                                + entity.resourceName
                                                + '</option>');//赋值
                                        }
                                    });
                                }
                            }
                        }
                    });
                }
            },
            //保存按钮
            save : function () {
                debugger;
                var parentId = $('#parentId').val();
                var resourcePath = $('#resourcePath').val();
                var param = $("#filter_form").serialize();
                $.ajax({
                    url : "${basePath}/resource/updateResource.do",
                    data : param,
                    dataType : "json",
                    type : "POST",
                    success : function(data) {
                        if(data.resultCode =='0000'){
                            $('#cancel').click();
                        }
                        bootbox.alert(data.resultMsg);
                    }
                });
            },
            // 取消按钮
            cancel : function () {
                $('#body2').load("${basePath}/resource/toResource.do");
            }

        }
        $(function () {
            updateResourceHelper.init();
            updateResourceHelper.levelChange();
        });
	</script>
</body>
</html>