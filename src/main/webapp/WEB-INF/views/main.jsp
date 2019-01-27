<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<%@include file="base.jsp"%>
<body>
<jsp:include page="basebody.jsp"/>

<div class="clearfix">
</div>

<%-- 产品菜单展示 --%>
<section class="core-value-area">
    <div class="custom-container">
        <div class="page-sidebar-wrapper">
            <div class="page-sidebar navbar-collapse collapse">
                <ul class="page-sidebar-menu" data-slide-speed="200" data-auto-scroll="false" data-auto-scroll="false" data-slide-speed="200">
                    <c:forEach items="${menus }" var="item" varStatus="status">
                        <c:if test="${status.index==0}">
                            <li class="open">
                            <a href="javascript:;">
                                <i class="icon-credit-card"></i>
                                <span class="title">${item.menu.getResourceName() }</span>
                                <span class="selected"></span>
                                <span class="arrow open"></span>
                            </a>
                        </c:if>
                        <c:if test="${status.index!=0}">
                            <li class="my-sidebar-menu">
                            <a href="javascript:;">
                                <i class="icon-credit-card"></i>
                                <span class="title">${item.menu.getResourceName() }</span>
                                <span class="arrow open"></span>
                            </a>
                        </c:if>
                        <c:if test="${fn:length(item.getChildren())>0}">
                            <ul class="sub-menu">
                                <c:forEach items="${item.getChildren() }" var="child" varStatus="stat">
                                    <c:if test="${stat.index==0 && status.index==0}">
                                        <li class="active">
                                            <a class="ajaxify start" href="${basePath}/${child.getResourcePath() }">
                                                <i class="icon-credit-card"></i>
                                                    ${child.getResourceName() }</a>
                                        </li>
                                    </c:if>
                                    <c:if test="${stat.index!=0 || status.index!=0}">
                                        <li>
                                            <a class="ajaxify" href="${basePath}/${child.getResourcePath() }">
                                                <i class="icon-credit-card"></i>
                                                    ${child.getResourceName()}</a>
                                        </li>
                                    </c:if>
                                </c:forEach>
                            </ul>
                        </c:if>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>

        <div class="page-content-wrapper">
            <div class="page-content" id = "body1">
                <div class="page-content-body" id = "body2">

                </div>
            </div>
        </div>
    </div>
</section>

<%@include file="copyright.jsp"%>

<script type="text/javascript">
    var mainHelper = {
        mainMenu: '${mainMenu}',
        init: function () {
            $('[name="custom_menu"]').each(function (index, entity) {
                $(entity).removeClass();
            });

            $('#' + mainHelper.mainMenu).addClass("active");
        }

    }

    $(function() {
        mainHelper.init();
    });
</script>

<script type="text/javascript">
    jQuery(document).ready(function () {
        Metronic.init(); // init metronic core components
        Layout.init(); // init current layout
        $('.page-sidebar .ajaxify.start').click() // load the content for the dashboard page.
        $body_cache = $("body");
    });
    // 模拟点击其他一级菜单
    $('.my-sidebar-menu').on('click',function(){
        $(this).children('ul').slideDown();
    })
    $('.my-sidebar-menu').trigger("click");
</script>

<%-- 百度商桥 --%>
<script>
    var _hmt = _hmt || [];
    (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?39c68affd1a9a95efb7fd697cb674ea8";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
</script>
</body>
</html>