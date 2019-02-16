<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="../../basepath.jsp"%>

<div class="page-bar" id="qualityDesignatedSpot">
    <ul class="page-breadcrumb">
        <li>
            <i class="fa fa-cart-arrow-down"></i>
            <a >产品中心</a>
            <i class="fa fa-angle-right"></i>
        </li>
        <li>
            <i class="fa fa-cart-arrow-down"></i>
            <a >品质产品</a>
            <i class="fa fa-angle-right"></i>
        </li>
        <li>
            <a >${product.productName}</a>
            <i class="fa"></i>
        </li>
    </ul>
    <button style="display: none;" id="qualityGangplank"/>
</div>

<!-- 展示区 -->
<div class="row">
    <div class="col-md-12">
        <div class="portlet box grey-cascade">
            <div class="portlet-title">
                <div class="caption">
                    <i class="fa fa-globe"></i>${product.productName}
                </div>
            </div>
            <div class="portlet-body">
                <div class="table-toolbar">
                    <div class="col-md-12">
                        <div class="col-md-4">
                            <a class="thumbnail">
                                <img src="${basePath}/resources/img/product/quality/${product.imageName}" alt="${product.productName}" title="${product.productName}" />
                            </a>
                        </div>
                        <div class="col-md-8 img-info">
                            <h1>${product.productName}</h1>
                                <p style="font-size:13px; line-height:26px;">
                                    ${product.productInfo}
                                </p>
                            <span class="img-tel"><span>订购热线：</span> 15838055811</span>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="product-detail">
                            <h3>产品详情</h3>
                        </div>
                        <div class="mt30 clearfix ">
                            <div class="copywriting">
                                ${product.productDetails}
                                <br>
                                    <img alt=""
                                         src="${basePath}/resources/img/product/quality/${product.detailsImageName}"
                                         style="width: 790px; height: 475px;"/>
                                <br>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(document).ready(function() {
        $("#qualityGangplank").click(function() {
            $("html, body").animate({
                scrollTop: $("#qualityDesignatedSpot").offset().top }, {duration: 300,easing: "swing"});
            return false;
        });

        $("#qualityGangplank").trigger("click");
    });
</script>