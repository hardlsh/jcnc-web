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
							<input type="hidden" id="oldResourecId" value="${parentResouce.resourceId }"/>
							<input type="hidden" id="oldResourcePath" vale="${resource.resourcePath }"/>
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
									<label class="control-label col-md-3">资源状态</label>
									<div class="col-md-5">
										<jcnc:selectTag name="status" id="status" dictCode="AVAIL_STATUS" value="${resource.status}"
														classes="bs-select form-control input-inline" hasAll="true" placeholder="请选择"/>
									</div>
								</div>
							</div>
							<br/>
							<div class="row">
								<div class="form-group">
									<label class="control-label col-md-3">资源级别</label>
									<div class="col-md-5">
										<jcnc:selectTag id="level" disabled="disabled" dictCode="RESOURCE_LEVEL" value="${resource.level}"
														classes="bs-select form-control input-inline" hasAll="true" placeholder="请选择"/>
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
											<select class="bs-select form-control input-inline"
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
							<br/>
							<div class="row">
								<div class="form-group">
									<label class="control-label col-md-3">资源顺序</label>
									<div class="col-md-5">
										<input type="text" name="sequence" class="form-control" oninput = "value=value.replace(/[^\d]/g,'')"
											   value="${resource.sequence}" placeholder="请输入资源顺序(数字)"/>
									</div>
								</div>
							</div>
							<br/>
							<div class="row">
								<div class="form-group">
									<label class="control-label col-md-3">备注</label>
									<div class="col-md-5">
										<textarea name="remark" value="${resource.remark}" class="form-control" rows="3">${resource.remark}</textarea>
									</div>
								</div>
							</div>
							<br/>
							<div class="row">
								<div class="form-group">
									<label class="control-label col-md-3"></label>
									<div class="col-md-5">
										<button type="button" id="save" class="btn blue">保  存</button>
										<button type="button" id="cancel" class="btn btn-default ">取  消</button>
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
            $('#save').click(me.save);//保存按钮
            $('#cancel').click(me.cancel);//取消按钮

            $('.selectpicker').selectpicker({
                'selectedText': 'cat'
            });
        },
        //返回资源管理
        goBackResource : function () {
            location.href="${basePath}/user/toResource.do";
        },
        //返回用户管理
        goBack : function () {
            location.href="${basePath}/index/toUser.do";
        },
        //取消, 返回资源管理
        cancel : function () {
            location.href="${basePath}/user/toResource.do";
        },
        //保存
        save : function () {
            var resourcePath = $('#oldResourcePath').val();
            var productId = $('#productId').val();
            if (resourcePath != null && resourcePath != "" && (productId == null || productId == "")) {
                bootbox.alert("具体产品资源，必须选择对应产品！");
                return;
            }
            var parentName = $("#parentId").find("option:selected").text();
            if (parentName != "请选择") {
                $('#hideParentName').val(parentName);
            }
            var productName = $('#productId').find("option:selected").text();
            if (productName != "请选择") {
                $('#hideProductName').val(productName);
            }

            $('#save').attr({"disabled":"disabled"});
            var param = $("#filter_from").serialize();
            $.ajax({
                url : "${basePath}/user/updateSaveResource.do",
                data : param,
                dataType: "json",
                type : "POST",
                success : function(data) {
                    $('#save').removeAttr("disabled");
                    if (data.resultCode != '0000') {
                        bootbox.alert(data.resultMsg);
                    } else {
                        $.alert(data.resultMsg);
                        $('#cancel').click();
                    }
                }
            });
        },
        // 资源级别
        levelChange : function() {
            var level = $("#level").val();
            var oldResourecId = $("#oldResourecId").val();
            if (level == null || level == "") {
                return;
            }
            $("#parentId option").remove();
            $("#parentId").append('<option value="">请选择</option>');
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
        },
        changeSelectProduct : function () {
            var resourcePath = $('#oldResourcePath').val();
            if (resourcePath == null || resourcePath == "") {
                $("#selectProductDiv").hide();
            } else {
                $("#selectProductDiv").show();
            }
        }
    }

    $(function(){
        updateResourceHelper.init();
        // 页面初始化时,先执行
        updateResourceHelper.levelChange();
        updateResourceHelper.changeSelectProduct();
    });
</script>
</body>
</html>