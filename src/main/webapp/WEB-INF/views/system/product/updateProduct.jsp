<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<%@include file="../../header.jsp"%>
<%@include file="../../basepath.jsp"%>
<body>
<div class="row">
	<div class="col-md-12">
		<div class="portlet box grey-cascade">
			<div class="portlet-title">
				<div class="caption">
					<i class="fa fa-globe"></i>产品管理 / 修改产品
				</div>
				<div class="actions">
					<button id="goBackProduct" class="btn btn-sm green" type="button">返回产品管理</button>
					<button id="goBack" class="btn btn-sm green" type="button">返回用户管理</button>
				</div>
			</div>
			<div class="portlet-body">
				<div class="table-toolbar">
					<div class="container">
						<form id="filter_from" method="post">
							<!-- 隐藏域 -->
							<input type="hidden" id="productId" value="${product.productId }">
							<div class="row">
								<div class="form-group">
									<label class="control-label col-md-3">产品名称</label>
									<div class="col-md-5">
										<input type="text" name="productName" class="form-control" value="${product.productName}"/>
									</div>
								</div>
							</div>
							<br/>
							<div class="row">
								<div class="form-group">
									<label class="control-label col-md-3">产品状态</label>
									<div class="col-md-5">
										<select class="bs-select form-control input-inline" name="status">
											<option value="">请选择</option>
											<c:choose>
												<c:when test="${product.status == 0}">
													<option value="0" selected="selected">不可用</option>
													<option value="1">可用</option>
												</c:when>
												<c:otherwise>
													<option value="0">不可用</option>
													<option value="1" selected="selected">可用</option>
												</c:otherwise>
											</c:choose>
										</select>
									</div>
								</div>
							</div>
							<br/>
							<div class="row">
								<div class="form-group">
									<label class="control-label col-md-3">产品信息</label>
									<div class="col-md-9">
										<textarea name="productInfo" class="form-control" rows="3"
												  placeholder="请输入产品信息"></textarea>
									</div>
								</div>
							</div>
							<br/>
							<div class="row">
								<div class="form-group">
									<label class="control-label col-md-3">产品详细信息</label>
									<div class="col-md-9">
										<textarea name="productDetails" class="form-control" rows="5"
												  placeholder="请输入产品详细信息"></textarea>
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
    var updateProductHelper = {

        init : function () {
            var me = updateProductHelper;
            $('#goBackProduct').click(me.goBackProduct);//返回产品管理
            $('#goBack').click(me.goBack);//返回用户管理按钮
            $('#save').click(me.save);//保存按钮
            $('#cancel').click(me.cancel);//取消按钮
			$('#upImgBtn').click(me.upImgBtn);//上传产品图片
        },
        //返回产品管理
        goBackProduct : function () {
            location.href="${basePath}/user/toProduct.do";
        },
        //返回用户管理
        goBack : function () {
            location.href="${basePath}/user/toUser.do";
        },
        //取消, 返回产品管理
        cancel : function () {
            location.href="${basePath}/user/toProduct.do";
        },
        //保存
        save : function () {
            $('#save').attr({"disabled":"disabled"});
            var param = $("#filter_from").serialize();
            $.ajax({
                url : "${basePath}/user/updateSaveProduct.do",
                data : param,
                dataType: "json",
                type : "POST",
                success : function(data) {
                    $('#save').removeAttr("disabled");
                    if (data.resultCode != '0000') {
                        bootbox.alert(data.resultMsg);
                    } else {
                        $.alert(data.resultMsg);
                        $('#cancel').click();// 执行成功,返回产品管理页面
                    }
                }
            });
        }

    };

    $(function(){
        updateProductHelper.init();
    });

</script>
</body>
</html>
