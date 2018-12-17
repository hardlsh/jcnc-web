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

    <!--引用百度地图API-->
    <style type="text/css">
        html,body{margin:0;padding:0;}
        .iw_poi_title {color:#CC5522;font-size:14px;font-weight:bold;overflow:hidden;padding-right:13px;white-space:nowrap}
        .iw_poi_content {font:12px arial,sans-serif;overflow:visible;padding-top:4px;white-space:-moz-pre-wrap;word-wrap:break-word}
    </style>
    <script type="text/javascript" src="http://api.map.baidu.com/api?key=&v=1.1&services=true"></script>
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
                        <li><a href="${basePath}/main/toTestIndex.do">网站首页</a></li>
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
                        <li><a class="active" href="${basePath}/main/toContact.do">联系我们</a></li>
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


<div class="contact agileits">
    <div class="container">
        <h3 class="agileits-title">Contact Us</h3>
        <div class="contact-agileinfo">
            <div class="col-md-7 contact-form wthree">
                <form action="#" method="post">
                    <input type="text" name="Name" placeholder="Name" required="">
                    <input class="email" type="email" name="Email" placeholder="Email" required="">
                    <textarea placeholder="Message" name="Message" required=""></textarea>
                    <input type="submit" value="SUBMIT">
                </form>
            </div>
            <div class="col-md-4 contact-right wthree">
                <div class="contact-text w3-agileits">
                    <h4>GET IN TOUCH :</h4>
                    <p><i class="fa fa-map-marker"></i> Broome St, NY 10002, Canada. </p>
                    <p><i class="fa fa-phone"></i> Telephone : +00 111 222 3333</p>
                    <p><i class="fa fa-fax"></i> FAX : +1 888 888 4444</p>
                    <p><i class="fa fa-envelope-o"></i> Email : <a href="mailto:example@mail.com">mail@example.com</a></p>
                </div>
            </div>
            <div class="clearfix"> </div>
        </div>
    </div>
</div>

<!--百度地图容器-->
<div class="contact agileits">
    <div class="container">
        <div style="width:697px;height:550px;border:#ccc solid 1px;" id="dituContent">
        </div>
    </div>
</div>

<!--百度地图容器-->

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

    /********  百度地图js方法 **********/
    //创建和初始化地图函数：
    function initMap(){
        createMap();//创建地图
        setMapEvent();//设置地图事件
        addMapControl();//向地图添加控件
        addMarker();//向地图中添加marker
    }

    //创建地图函数：
    function createMap(){
        var map = new BMap.Map("dituContent");//在百度地图容器中创建一个地图
        var point = new BMap.Point(113.366508,34.541115);//定义一个中心点坐标
        map.centerAndZoom(point,17);//设定地图的中心点和坐标并将地图显示在地图容器中
        window.map = map;//将map变量存储在全局
    }

    //地图事件设置函数：
    function setMapEvent(){
        map.enableDragging();//启用地图拖拽事件，默认启用(可不写)
        map.enableScrollWheelZoom();//启用地图滚轮放大缩小
        map.enableDoubleClickZoom();//启用鼠标双击放大，默认启用(可不写)
        map.enableKeyboard();//启用键盘上下左右键移动地图
    }

    //地图控件添加函数：
    function addMapControl(){
        //向地图中添加缩放控件
        var ctrl_nav = new BMap.NavigationControl({anchor:BMAP_ANCHOR_TOP_LEFT,type:BMAP_NAVIGATION_CONTROL_SMALL});
        map.addControl(ctrl_nav);
        //向地图中添加缩略图控件
        var ctrl_ove = new BMap.OverviewMapControl({anchor:BMAP_ANCHOR_BOTTOM_RIGHT,isOpen:1});
        map.addControl(ctrl_ove);
        //向地图中添加比例尺控件
        var ctrl_sca = new BMap.ScaleControl({anchor:BMAP_ANCHOR_BOTTOM_LEFT});
        map.addControl(ctrl_sca);
    }

    //标注点数组
    var markerArr = [{title:"金诚耐材",content:"地址：新密市大鸿路与西大街交叉口<br/>联系人：李佩丽<br/>电话：13526688888",point:"113.369876|34.541085",isOpen:1,icon:{w:23,h:25,l:46,t:21,x:9,lb:12}}
    ];
    //创建marker
    function addMarker(){
        for(var i=0;i<markerArr.length;i++){
            var json = markerArr[i];
            var p0 = json.point.split("|")[0];
            var p1 = json.point.split("|")[1];
            var point = new BMap.Point(p0,p1);
            var iconImg = createIcon(json.icon);
            var marker = new BMap.Marker(point,{icon:iconImg});
            var iw = createInfoWindow(i);
            var label = new BMap.Label(json.title,{"offset":new BMap.Size(json.icon.lb-json.icon.x+10,-20)});
            marker.setLabel(label);
            map.addOverlay(marker);
            label.setStyle({
                borderColor:"#808080",
                color:"#333",
                cursor:"pointer"
            });

            (function(){
                var index = i;
                var _iw = createInfoWindow(i);
                var _marker = marker;
                _marker.addEventListener("click",function(){
                    this.openInfoWindow(_iw);
                });
                _iw.addEventListener("open",function(){
                    _marker.getLabel().hide();
                })
                _iw.addEventListener("close",function(){
                    _marker.getLabel().show();
                })
                label.addEventListener("click",function(){
                    _marker.openInfoWindow(_iw);
                })
                if(!!json.isOpen){
                    label.hide();
                    _marker.openInfoWindow(_iw);
                }
            })()
        }
    }
    //创建InfoWindow
    function createInfoWindow(i){
        var json = markerArr[i];
        var iw = new BMap.InfoWindow("<b class='iw_poi_title' title='" + json.title + "'>" + json.title + "</b><div class='iw_poi_content'>"+json.content+"</div>");
        return iw;
    }
    //创建一个Icon
    function createIcon(json){
        var icon = new BMap.Icon("http://app.baidu.com/map/images/us_mk_icon.png", new BMap.Size(json.w,json.h),{imageOffset: new BMap.Size(-json.l,-json.t),infoWindowOffset:new BMap.Size(json.lb+5,1),offset:new BMap.Size(json.x,json.h)})
        return icon;
    }

    initMap();//创建和初始化地图
</script>

</body>
</html>