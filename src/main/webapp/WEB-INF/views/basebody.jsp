<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="top hidden-xs">
    <div class="container">
        <span class="pull-left" id="inn"></span>
        <span class="pull-left">&nbsp;&nbsp;&nbsp;您好，欢迎来到郑州北海金诚耐材有限公司官网！</span>
        <span class="pull-right">
            <a onclick="toAbout()" >关于我们</a> |
            <a onclick="toContact()" >联系我们</a>
            &nbsp;&nbsp;&nbsp;&nbsp;<a href="${basePath}/index/toLogin.do" style="color:#DEDEDE">逗你玩</a>
        </span>
    </div>
</div>

<div class="navbar-default">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="http://www.jinchengnaicai.com/" title="郑州北海金诚耐材有限公司">
                <img src="${basePath}/resources/img/logo/logo-top.png"/>
            </a>
            <div class="tel navbar-right hidden-xs">
                <div class="tu"></div>
                <b>15838055811</b>
            </div>
        </div>
    </div>
</div>


<div class="header">
    <div class="header-nav">
        <nav class="navbar navbar-default">
            <!-- top-nav -->
            <div class="container">
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li>
                            <a name="custom_menu" id="index" href="${basePath}/main/toMain.do" class="active">
                                网站首页
                            </a>
                        </li>
                        <li>
                            <a name="custom_menu" id="about" onclick="toAbout()">金诚耐材</a>
                        </li>
                        <li>
                            <a name="custom_menu" id="product" onclick="toProduct()">产品中心</a>
                        </li>
                        <%--<li>
                            <a name="custom_menu" href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                                产品中心
                                <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="icons.html">Web Icons</a></li>
                                <li><a href="codes.html">Short Codes</a></li>
                            </ul>
                        </li>--%>
                        <li>
                            <a name="custom_menu" href="gallery.html">应用实例</a>
                        </li>
                        <li>
                            <a name="custom_menu" href="${basePath}/main/toTest.do">设备能力</a>
                        </li>
                        <li>
                            <a name="custom_menu" id="contact" onclick="toContact()">联系我们</a>
                        </li>
                    </ul>
                    <%-- 清除浮动 --%>
                    <div class="clearfix"> </div>
                </div>
            </div>
        </nav>
    </div>
</div>

<%-- 轮播效果图 --%>
<div class="slider-banner">
    <div id="myCarousel" class="carousel slide">
        <!-- 轮播（Carousel）指标 -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1" class=""></li>
        </ol>
        <!-- 轮播（Carousel）项目 -->
        <div class="carousel-inner">
            <div class="item active">
                <div align="center">
                    <a href="#"><img src="${basePath}/resources/img/carousel/flash.jpg" border="0"></a>
                </div>
            </div>
            <div class="item">
                <div align="center">
                    <a href="#"><img src="${basePath}/resources/img/carousel/flash1.jpg" border="0"></a>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
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
        inn.innerHTML=year+'年'+month+'月'+day+'日 '+week1;
    }
    today1();

    // 跳转到公司介绍页
    function toAbout() {
        $('#body2').load("${basePath}/main/toAbout.do");
    }
    // 跳转到联系我们页
    function toContact() {
        $('#body2').load("${basePath}/main/toContact.do");
    }
    // 跳转到主打产品页
    function toProduct() {
        $('#body2').load("${basePath}/product/toMainProduct.do");
    }
</script>

<script type="text/javascript">
    // 设置轮播速度
    $(function(){
        $('#myCarousel').carousel({interval:3000});
    })
</script>

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