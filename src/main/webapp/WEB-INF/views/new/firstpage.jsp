<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <%-- IE浏览器兼容性 --%>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <%-- html页面自动适应调整 --%>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>新密市金诚耐材耐火材料有限公司</title>
    <%-- 关键字，告诉搜索引擎网页的关键字 --%>
    <meta name="keywords" content="耐火砖价格,耐火砖规格,河南耐火砖厂,耐火砖厂家,耐火砖生产厂家,高铝耐火砖">
    <%-- 网页描述，搜索引擎根据描述进行收录排名 --%>
    <meta name="description" content="河南超裕耐火材料是专业耐火砖生产厂家,耐火砖规格齐全,以高铝耐火砖为核心,专注浇注料,粘土砖,异型耐火砖,关于耐火砖价格,咨询电话:15517585977">

</head>
<%@include file="../base.jsp"%>

<body>
<div class="top">
    <div class="container">
        <span class="pull-left" id="inn"></span>
        <span class="pull-left">&nbsp;&nbsp;&nbsp;您好，欢迎来到郑州金诚耐材耐火材料有限公司官网！</span>
        <span class="pull-right">
            <a rel="nofollow" rel="nofollow" href="http://www.cynhz.com/about/" target="_blank">关于我们</a> |
            <a rel="nofollow" href="http://www.cynhz.com/contact/" target="_blank">联系我们</a></span>
    </div>
</div>


<div class="header">
    <div class="header-nav">
        <nav class="navbar navbar-default">
            <!-- top-nav -->
            <div class="container">
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li><a href="${basePath}/main/toTestIndex.do" class="active">网站首页</a></li>
                        <li><a href="about.html">金城耐材</a></li>
                        <li>
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                                产品中心
                            <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="icons.html">Web Icons</a></li>
                                <li><a href="codes.html">Short Codes</a></li>
                            </ul>
                        </li>
                        <li><a href="gallery.html">应用实例</a></li>
                        <li><a href="gallery.html">设备能力</a></li>
                        <li><a href="${basePath}/main/toContact.do">联系我们</a></li>
                    </ul>
                    <%-- 清除浮动 --%>
                    <div class="clearfix"> </div>
                </div>
            </div>
        </nav>
    </div>
</div>



<%-- 轮播效果图 --%>
<div id="myCarousel" class="carousel slide">
    <!-- 轮播（Carousel）指标 -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1" class=""></li>
        <li data-target="#myCarousel" data-slide-to="2" class=""></li>
    </ol>
    <!-- 轮播（Carousel）项目 -->
    <div class="carousel-inner">
        <div class="item active">
            <a href="#"><img src="${basePath}/resources/img/carousel/flash.jpg" border="0"></a>
        </div>
        <div class="item">
            <a href="#"><img src="${basePath}/resources/img/carousel/flash1.jpg" border="0"></a>
        </div>
        <div class="item">
            <a href="#"><img src="${basePath}/resources/img/carousel/flash2.jpg" border="0"></a>
        </div>
    </div>
</div>


<!-- footer -->
<div class="footer">
    <div class="container">
        <div class="col-md-3 col-sm-6 footer-grid">
            <h3>Useful Info</h3>
            <ul>
                <li>
                    <a href="single.html">
                        <img src="${basePath}/resources/img/icon/right-circle.png"/>
                        <i class="custom-footer" >Amet consectetur</i>
                    </a>
                </li>
                <li>
                    <a href="single.html">
                        <img src="${basePath}/resources/img/icon/right-circle.png"/>
                        <i class="custom-footer" >Donec ut lectus</i>
                    </a>
                </li>
                <li>
                    <a href="single.html">
                        <img src="${basePath}/resources/img/icon/right-circle.png"/>
                        <i class="custom-footer" >Iquam hendrerit</i>
                    </a>
                </li>
            </ul>
        </div>
        <div class="col-md-3 col-sm-6 footer-grid">
            <h3>Recent Posts</h3>
            <ul>
                <li><a href="single.html"><i class="glyphicon glyphicon-chevron-right"></i>Vestibulum felis</a></li>
                <li><a href="single.html"><i class="glyphicon glyphicon-chevron-right"></i>Mauris at tellus</a></li>
                <li><a href="single.html"><i class="glyphicon glyphicon-chevron-right"></i>Donec ut lectus</a></li>
                <li><a href="single.html"><i class="glyphicon glyphicon-chevron-right"></i>Vitae interdum</a></li>
            </ul>
        </div>
        <div class="col-md-3 col-sm-6 footer-grid footer-tags">
            <h3>Tag Cloud</h3>
            <ul>
                <li><a href="index.html">Home</a></li>
                <li><a href="about.html">About</a></li>
                <li><a href="codes.html">Codes</a></li>
                <li><a href="gallery.html">Gallery</a></li>
                <li><a href="contact.html">Contact Us</a></li>
            </ul>
        </div>
        <div class="col-md-3 col-sm-6 footer-grid footer-review">
            <h3>Review</h3>
            <p>Maecenas sodales tortor ac ligula ultrices dictum et quis urna. Etiam pulvinar metus neque eget porttitor massa.</p>
            <form action="#" method="post">
                <input type="search" name="Search" placeholder="Enter your search term..." required="">
                <button type="submit" class="btn btn-default" aria-label="Left Align">
                    <span class="glyphicon glyphicon-search"></span>
                </button>
            </form>
        </div>
        <div class="clearfix"> </div>
    </div>
</div>




<%@include file="../copyright.jsp"%>

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
    // 抬头日期
    function today1(){
        var inn=document.getElementById('inn');
        var date = new Date();
        var month = date.getMonth()+1;
        var year=date.getFullYear();
        var day=date.getDate();
        var week = date.getDay();
        var week1;
        switch(week)
        {
            case 0: week1='星期日'; break;
            case 1: week1='星期一'; break;
            case 2: week1='星期二'; break;
            case 3: week1='星期三'; break;
            case 4: week1='星期四'; break;
            case 5: week1='星期五'; break;
            case 6: week1='星期六'; break;
        }
        inn.innerHTML='今天是'+year+'年'+month+'月'+day+'日 '+week1;
    }
    today1();
</script>

</body>
</html>