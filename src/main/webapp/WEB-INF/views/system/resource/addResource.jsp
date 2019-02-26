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
					<i class="fa fa-globe"></i>资源管理 / 新增资源
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
							<input type="hidden" id="oldResourecId" value="${resource.resourceId }">
							<div class="row">
								<div class="form-group">
									<label class="control-label col-md-3">资源名称</label>
									<div class="col-md-5">
										<input type="text" name="resourceName" class="form-control" placeholder="请输入资源名称"/>
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
									<div class="col-md-5">
										<div class="checkbox-list">
											<select class="bs-select form-control input-sm input-inline"
													id="parentId" name="parentId"> <option value="">请选择</option>
											</select>
										</div>
									</div>
								</div>
							</div>
							<br/>
							<div class="row">
								<div class="form-group">
									<label class="control-label col-md-3">对应产品</label>
									<div class="col-md-5">
										<jcnc:productSelect name="productId" id="productId"
															classes="bs-select form-control input input-inline selectpicker show-tick" hasAll="true"
															dataLiveSearch="true" dataWidth="100%" placeholder="请选择产品"/>
									</div>
								</div>
							</div>
							<br/>
							<div class="row">
								<div class="form-group">
									<label class="control-label col-md-3">资源顺序</label>
									<div class="col-md-5">
										<input type="text" name="sequence" class="form-control" placeholder="请输入资源顺序(数字)"/>
									</div>
								</div>
							</div>
							<br/>
							<div class="row">
								<div class="form-group">
									<label class="control-label col-md-3">资源顺序</label>
									<div class="col-md-5">
										<input type="text" name="sequence" class="form-control" placeholder="请输入资源顺序(数字)"/>
									</div>
								</div>
							</div>
							<br/>
							<div class="row">
								<div class="form-group">
									<label class="control-label col-md-3">备注</label>
									<div class="col-md-5">
										<textarea name="productInfo" class="form-control" rows="3"></textarea>
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
    var addResourceHelper = {
        init : function () {
            var me = addResourceHelper;
            $('#goBackResource').click(me.goBackResource);//返回资源管理
            $('#goBack').click(me.goBack);//返回用户管理按钮
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
            $('#save').attr({"disabled":"disabled"});
            var param = $("#filter_from").serialize();
            $.ajax({
                url : "${basePath}/user/addSaveResource.do",
                data : param,
                dataType: "json",
                type : "POST",
                success : function(data) {
                    $('#save').removeAttr("disabled");
                    bootbox.alert(data.resultMsg);
                }
            });
        }
	}
    $(function(){
        addResourceHelper.init();
    });

</script>
</body>
</html>