<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="../../base.jsp"%>

<div class="page-bar">
	<ul class="page-breadcrumb">
		<li>
			<i class="fa fa-cart-arrow-down"></i>
			<a >产品中心</a>
			<i class="fa fa-angle-right"></i>
		</li>
		<li>
			<a >主打产品</a>
			<i class="fa"></i>
			<i class="fa fa-angle-right"></i>
		</li>
	</ul>
</div>

<!-- 展示区 -->
<div class="row">
	<div class="col-md-12">
		<div class="portlet box grey-cascade">
			<div class="portlet-title">
				<div class="caption">
					<i class="fa fa-globe"></i>主打产品展示
				</div>
			</div>
			<div class="portlet-body">
				<div class="table-toolbar">
					<c:forEach begin="0" end="${rowNum}" step="1" varStatus="item">
						<div class="col-md-12">
							<div class="row main-con-product">
								<c:forEach items="${productList}" begin="${item.index * columnNum}"
										   end="${((item.index + 1) * columnNum) -1}" step="1" var="product">
									<div class="col-md-3 main-product-list">
										<a data-id="${product.productId}" target="_blank" onclick="mainProductsHelper.goToURL(this)">
											<img src="${basePath}/resources/img/product/main/${product.productImgName}"
												 class="img-responsive" alt="${product.productName}" title="${product.productName}"/>
											<span class="text-center center-block">
													${product.productName}
											</span>
										</a>
									</div>
								</c:forEach>
							</div>
						</div>
					</c:forEach>
				</div>

			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	var mainProductsHelper = {
        jumpPath : '${jumpPath}',
        init : function() {

		},
		goToURL : function (product) {
            alert("${basePath}" + mainProductsHelper.jumpPath);

            $('#body2').load("${basePath}" + mainProductsHelper.jumpPath + $(product).data('id'));
        }

	}

    $(function() {
        mainProductsHelper.init();
    });
</script>



