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

<script type="text/javascript">
	var productHelper = {
        availStatusEnum : '${availStatusEnum}',

        init : function () {
			var me = productHelper;
			$('#addProduct').click(me.addProduct);//新增产品按钮
			$('#goBack').click(me.goBack);//返回用户管理按钮
			
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
						return'<div style="min-width:110px;"><a class="ajaxify btn default btn-xs purple " ' +
							'href="${basePath}/user/toUpdateProduct.do?productId='+e.productId+'">修改</a></div>';
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
            location.href="${basePath}/user/toUser.do";
        }
	};

	$(function() {
		productHelper.init();
	});
	
</script>

</body>
</html>