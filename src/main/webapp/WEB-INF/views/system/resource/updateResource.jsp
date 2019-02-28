<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<%@include file="../../header.jsp"%>
<%@include file="../../basepath.jsp"%>

<%@ taglib prefix="jcnc" uri="/WEB-INF/jcnc" %>
<body>
<div class="row">
	<div class="col-md-12">
		<div class="portlet box grey-cascade">
			<div class="portlet-title">
				<div class="caption">
					<i class="fa fa-globe"></i>资源管理 / 修改资源
				</div>
				<div class="actions">
					<button id="goBackResource" class="btn btn-sm green" type="button">返回资源管理</button>
					<button id="goBack" class="btn btn-sm green" type="button">返回用户管理</button>
				</div>
			</div>
			<div class="portlet-body">
				<div class="table-toolbar">
					<div class="container">
						<form id="filter_from" method="post">
							<!-- 隐藏域 -->
							<input type="hidden" id="oldResourecId" value="${parentResouce.resourceId }">
							<div class="row">
								<div class="form-group">
									<label class="control-label col-md-3">资源名称</label>
									<div class="col-md-5">
										<input type="text" name="resourceName" value="${resource.resourceName }" class="form-control" placeholder="请输入资源名称"/>
									</div>
								</div>
							</div>
							<br/>
							<div class="row">
								<div class="form-group">
									<label class="control-label col-md-3">资源级别</label>
									<div class="col-md-5">
										<jcnc:selectTag name="level" id="level" dictCode="RESOURCE_LEVEL" value="${resource.level}"
														classes="bs-select form-control input-sm input-inline" hasAll="true" placeholder="请选择"/>
									</div>
								</div>
							</div>
							<br/>
							<div class="row">
								<div class="form-group">
									<label class="control-label col-md-3">父级资源</label>
									<input id="hideParentName" name="parentName" type="hidden"/>
									<div class="col-md-5">
										<div class="checkbox-list">
											<select class="bs-select form-control input-sm input-inline"
													id="parentId" name="parentId"> <option value="">请选择</option>
											</select>
										</div>
									</div>
								</div>
							</div>
							<div class="row" id="selectProductDiv">
								<br/>
								<div class="form-group">
									<label class="control-label col-md-3">对应产品</label>
									<input id="hideProductName" name="productName" type="hidden"/>
									<div class="col-md-5">
										<jcnc:productSelect name="productId" id="productId" value="${resource.productId}"
															classes="bs-select form-control input input-inline selectpicker show-tick" hasAll="true"
															dataLiveSearch="true" dataWidth="100%" placeholder="请选择"/>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
    var updateResourceHelper = {
        init : function () {
            var me = updateResourceHelper;
            $('#goBackResource').click(me.goBackResource);//返回资源管理
            $('#goBack').click(me.goBack);//返回用户管理按钮
            $('#level').change(me.levelChange);// 资源级别
        },
        //返回资源管理
        goBackResource : function () {
            location.href="${basePath}/user/toResource.do";
        },
        //返回用户管理
        goBack : function () {
            location.href="${basePath}/index/toUser.do";
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
                    url : "${basePath}/user/getResourceByLevel.do",
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
                            addResourceHelper.changeSelectProduct();
                        }
                    }
                });
            }
        }
    }

    $(function(){
        updateResourceHelper.init();
        // 页面初始化时,先执行
        updateResourceHelper.levelChange();
    });
</script>
</body>
</html>