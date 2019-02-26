<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<%@include file="../../header.jsp"%>
<jsp:include page="../../basepath.jsp"/>
<body>
<div class="row">
	<div class="col-md-12">
		<div class="portlet box grey-cascade">
			<div class="portlet-title">
				<div class="caption">
					<i class="fa fa-globe"></i>产品管理
				</div>
				<div class="actions">
					<button id="addProduct" class="btn btn-sm blue" type="button">新增产品</button>
					<button id="goBack" class="btn btn-sm green" type="button">返回用户管理</button>
				</div>
			</div>
			<div class="portlet-body">
				<form id='filter_form' href="##"><!-- 空form --></form>
				<table class="table table-striped table-bordered table-hover"
					id="productTable">
					<thead>
						<tr>
							<th>产品ID</th>
							<th>产品名称</th>
							<th>产品图片名</th>
							<th>产品详情图片名</th>
							<th>产品状态</th>
							<th>操作</th>
						</tr>
					</thead>
				</table>
			</div>
		</div>
	</div>
</div>

<%-- 上传产品图片弹窗 --%>
<div class="modal" id="upImgModal" role="dialog" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true"></button>
				<h4 class="modal-title">上传产品图片</h4>
			</div>
			<div class="modal-body">
				<div class="table-toolbar">
					<form id="upImgForm" action="${basePath}/user/uploadImage.do"
						  class="form-horizontal" enctype="multipart/form-data" method="post">
						<!-- 隐藏域,存储productId, type-->
						<input type="hidden" name="productId" id="upImgProductId">
						<input type="hidden" name="type" id="imgType" value="1">
						<div class="col-md-4">
							<input type="file" style="width:350px;" name="multipartFile" id="imgId">
						</div>
						<button type="reset" id="upImgReset" style="display: none;"></button>
					</form>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn blue" id="upImgSave">上传</button>
				<button type="button" class="btn default" data-dismiss="modal">关闭</button>
			</div>
		</div>
	</div>
</div>

<%-- 上传产品详情图片弹窗 --%>
<div class="modal" id="upDetailImgModal" role="dialog" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true"></button>
				<h4 class="modal-title">上传产品详情图片</h4>
			</div>
			<div class="modal-body">
				<div class="table-toolbar">
					<form id="upDetailImgForm" action="${basePath}/user/uploadDetailImage.do"
						  class="form-horizontal" enctype="multipart/form-data" method="post">
						<!-- 隐藏域,存储productId, type-->
						<input type="hidden" name="productId" id="upDetailImgProductId">
						<input type="hidden" name="type" id="detailImgType" value="2">
						<div class="col-md-4">
							<input type="file" style="width:350px;" name="multipartFile" id="detailImgId">
						</div>
						<button type="reset" id="upDetailImgReset" style="display: none;"></button>
					</form>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn blue" id="upDetailImgSave">上传</button>
				<button type="button" class="btn default" data-dismiss="modal">关闭</button>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	var productHelper = {
        availStatusEnum : '${availStatusEnum}',

        init : function () {
			var me = productHelper;
			$('#addProduct').click(me.addProduct);//新增产品按钮
			$('#goBack').click(me.goBack);//返回用户管理按钮
			$('#upImgSave').click(me.upImgSave);// 保存产品图片
            $('#upDetailImgSave').click(me.upDetailImgSave);// 保存产品详情图片

            //初始化产品Table
			me.productTable();
		},
		//初始化用户Table,加载表格
		productTable : function () {
			var me = productHelper;
			var url = "${basePath}/user/getProductList.do"; //表格数据远程地址
			var colArray = [
				{"data" : "productId",
					"bSortable" : false},
				{"data" : "productName",
						"bSortable" : false},
				{"data" : "imageName",
						"bSortable" : false},
                {"data" : "detailsImageName",
                    "bSortable" : false},
                {"data" : function(e) {
						return myJson.getText(e.status, me.availStatusEnum);
					},"bSortable" : false
                },
				{"data" : function(e) {
				    var html = '<a class="ajaxify btn btn-sm purple " ' +
                        'href="${basePath}/user/toUpdateProduct.do?productId=' + e.productId + '">修改产品</a></div>' +
                        '<button type="button" onclick ="productHelper.btnUpImg(\'' + e.productId + '\',\'' + e.imageName + '\')" class="btn btn-sm ';
                    if (e.imageName != null && e.imageName != "") {
                        html += 'red">修改图片</button> <button type="button" onclick ="productHelper.btnUpDetailImg(\'' + e.productId + '\',\'' + e.detailsImageName + '\')" class="btn btn-sm ';
                    } else {
                        html += 'green">上传图片</button> <button type="button" onclick ="productHelper.btnUpDetailImg(\'' + e.productId + '\',\'' + e.detailsImageName + '\')" class="btn btn-sm ';
                    }
                    if (e.detailsImageName != null && e.detailsImageName != "") {
                        html += 'red">修改详情图片</button>';
					} else {
                        html += 'green">上传详情图片</button>';
					}
                    return html;
					},
					"bSortable" : false}
			];
			TablePaginationSort.initCustom(url, colArray, "productTable", "filter_form");//最后一个参数为form的Id,此处为空form
		},
		//新增产品
		addProduct : function () {
            location.href="${basePath}/user/toAddProduct.do";
		},
		//返回用户管理
        goBack : function () {
            location.href="${basePath}/index/toUser.do";
        },
		// 上传图片按钮
        btnUpImg : function (productId, imageName) {
            if (imageName == "" || imageName == "null") {
                $("#upImgReset").click();
                $('#upImgProductId').val(productId);
                $('#upImgModal').modal('show');
			} else {
                bootbox.confirm("修改图片将覆盖原来的产品图片，是否确认上传？",function (result){
                    if (result) {
                        $("#upImgReset").click();
                        $('#upImgProductId').val(productId);
                        $('#upImgModal').modal('show');
                    }
                })
			}
        },
		// 保存图片
		upImgSave : function (coverFlag) {
            var file_id=$("#imgId").val();
            if(file_id == null || file_id == ""){
                bootbox.alert("上传图片不能为空！");
                return;
            }
            var ext = file_id.substr(file_id.lastIndexOf(".")+1).toLowerCase();
            if( ext !="png" && ext != "jpg" && ext != "gif" && ext != "jpeg"){
                bootbox.alert("请选择正确的图片类型!");
                return;
            }
            var productId = $('#upImgProductId').val();
            var type = $('#imgType').val();
            $('#upImgSave').attr({"disabled":"disabled"});
            $("#upImgForm").ajaxSubmit({
                type:"post",
                dataType:"json",
                url:"${basePath}/user/upImg.do?productId=" + productId + "&coverFlag=" + coverFlag + '&type=' + type,
                success : function(data){
                    $('#upImgSave').removeAttr("disabled");
                    if (data.resultCode == '0000') {
                        bootbox.alert(data.resultMsg);
                        $('#upDetailImgReset').trigger("click");
                        $('#upImgModal').modal('hide');
                    } else if (data.resultCode == '2001') {
                        bootbox.confirm("上传图片与服务器图片重名，是否确认覆盖服务器图片？",function (result){
                            if (result) {
                                productHelper.upImgSave(true);
                            }
                        })
					} else if (data.resultCode == '2002') {
                        bootbox.confirm("上传图片与服务器图片重名且大小一致，是否确认覆盖服务器图片？",function (result){
                            if (result) {
                                productHelper.upImgSave(true);
                            }
                        })
                    } else {
                        bootbox.alert(data.resultMsg);
					}
                }
            });
        },
        // 上传详情图片按钮
        btnUpDetailImg : function (productId, detailsImageName) {
            if (detailsImageName == "" || detailsImageName == "null") {
                $("#upDetailImgReset").click();
                $('#upDetailImgProductId').val(productId);
                $('#upDetailImgModal').modal('show');
            } else {
                bootbox.confirm("修改详情图片将覆盖原来的产品详情图片，是否确认上传？",function (result){
                    if (result) {
                        $("#upDetailImgReset").click();
                        $('#upDetailImgProductId').val(productId);
                        $('#upDetailImgModal').modal('show');
                    }
                })
            }
        },
		// 保存详情图片
        upDetailImgSave : function (coverFlag) {
            var file_id=$("#detailImgId").val();
            if(file_id == null || file_id == ""){
                bootbox.alert("上传详情图片不能为空！");
                return;
            }
            var ext = file_id.substr(file_id.lastIndexOf(".")+1).toLowerCase();
            if( ext !="png" && ext != "jpg" && ext != "gif" && ext != "jpeg"){
                bootbox.alert("请选择正确的图片类型!");
                return;
            }
            var productId = $('#upDetailImgProductId').val();
            var type = $('#detailImgType').val();
            $('#upDetailImgSave').attr({"disabled":"disabled"});
            $("#upDetailImgForm").ajaxSubmit({
                type:"post",
                dataType:"json",
                url:"${basePath}/user/upImg.do?productId=" + productId + "&coverFlag=" + coverFlag + '&type=' + type,
                success : function(data){
                    $('#upDetailImgSave').removeAttr("disabled");
                    if (data.resultCode == '0000') {
                        bootbox.alert(data.resultMsg);
                        $('#upDetailImgReset').trigger("click");
                        $('#upDetailImgModal').modal('hide');
                    } else if (data.resultCode == '2001') {
                        bootbox.confirm("上传产品详情图片与服务器图片重名，是否确认覆盖服务器图片？",function (result){
                            if (result) {
                                productHelper.upDetailImgSave(true);
                            }
                        })
                    } else if (data.resultCode == '2002') {
                        bootbox.confirm("上传产品详情图片与服务器图片重名且大小一致，是否确认覆盖服务器图片？",function (result){
                            if (result) {
                                productHelper.upDetailImgSave(true);
                            }
                        })
                    } else {
                        bootbox.alert(data.resultMsg);
                    }
                }
            });
        }

	};

	$(function() {
		productHelper.init();
	});
	
</script>

</body>
</html>