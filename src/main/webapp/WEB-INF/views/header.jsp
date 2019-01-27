<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <%-- IE浏览器兼容性 --%>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <%-- html页面自动适应调整 --%>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>郑州北海金诚耐材有限公司</title>
    <%-- 关键字，告诉搜索引擎网页的关键字 --%>
    <meta name="keywords" content="耐火砖价格,耐火砖规格,河南耐火砖厂,耐火砖厂家,耐火砖生产厂家,高铝耐火砖">
    <%-- 网页描述，搜索引擎根据描述进行收录排名 --%>
    <meta name="description" content="郑州北海金诚耐材是专业耐火砖生产厂家,耐火砖规格齐全,以高铝耐火砖为核心,专注浇注料,粘土砖,异型耐火砖,关于耐火砖价格,咨询电话:15838055811">
    <link rel="icon" href="${basePath}/resources/img/logo/favicon.ico" type="image/x-icon">
    <!--引用百度地图API-->
    <style type="text/css">
        html,body{margin:0;padding:0;}
        .iw_poi_title {color:#CC5522;font-size:14px;font-weight:bold;overflow:hidden;padding-right:13px;white-space:nowrap}
        .iw_poi_content {font:12px arial,sans-serif;overflow:visible;padding-top:4px;white-space:-moz-pre-wrap;word-wrap:break-word}
    </style>
    <script type="text/javascript" src="http://api.map.baidu.com/api?key=&v=1.1&services=true"></script>
</head>
<%@include file="base.jsp"%>

<%-- move-top start --%>
<script type="text/javascript" src="${basePath}/resources/js/move-top.js" ></script>
<script type="text/javascript">
    $(window).load(function(){
        $('.flexslider').flexslider({
            animation: "slide",
            start: function(slider){
                $('body').removeClass('loading');
            }
        });
    });
</script>
<script type="text/javascript">
    jQuery(document).ready(function($) {
        $(".scroll").click(function(event){
            event.preventDefault();
            $('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
        });
    });
</script>
<script type="text/javascript">
    $(document).ready(function() {
        $().UItoTop({ easingType: 'easeOutQuart' });
    });
</script>
<%-- move-top end --%>

<script type="text/javascript">
    // 设置轮播速度
    $(function(){
        $('#myCarousel').carousel({interval:3000});
    })
</script>

