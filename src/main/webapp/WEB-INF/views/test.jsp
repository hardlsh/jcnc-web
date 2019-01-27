<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312"/>
    <title>折叠展开的菜单</title>
</head>
<body>
<style type="text/css">
    .oneLevel {
        display: inline-block;
        width: 200px;
        line-height: 32px;
        border-bottom: 1px solid #ccc;
        background: #9d9d9d;
        cursor: pointer;
    }

    .oneLevel > span {
        margin-left: 10px;
    }

    .oneLevelList {
        display: none;
    }
</style>
<script type="text/javascript" src="${basePath}/resources/js/jquery.min.js" ></script>
<script type="text/javascript">
    $(document).ready(function(){
        $('.bMenuTitle').on('click',function(){
            $(this).children('ul').slideDown();
            // 收起其他未点击菜单
            // $(this).siblings().children('ul').slideUp();

        })
        $('.bMenuTitle').trigger("click");
    });

</script>
<!-- Keep all menus within menuDiv-->
<ul id="menuDiv" class="bMenuList">
    <li class="bMenuTitle">
        <span class="oneLevel" >概要信息</span>
        <ul class="oneLevelList" id="sub1">
            <li><a href="#">概要信息</a></li>
        </ul>
    </li>
    <li class="bMenuTitle"><span class="oneLevel">我的费用</span>
        <ul class="oneLevelList" id="sub2">
            <li><a href="#">缴费</a></li>
            <li><a href="#">缴费记录查询</a></li>
        </ul>
    </li>
    <li class="bMenuTitle"><span class="oneLevel" >我的档案</span>
        <ul class="oneLevelList" id="sub3">
            <li><a href="#">仪表信息</a></li>
            <li><a href="#">挂表</a></li>
        </ul>
    </li>
    <li class="bMenuTitle"><span class="oneLevel">我的报表</span>
        <ul class="oneLevelList" id="sub4">
            <li><a href="">收费月报表</a></li>
            <li><a href="">收费年报表</a></li>
        </ul>
    </li>
</ul>
</body>

</html>