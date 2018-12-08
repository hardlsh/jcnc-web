<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>新密市金诚耐材耐火材料有限公司</title>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
</head>
<%@include file="base.jsp"%>

<script>
    <!--
    /*第一种形式 第二种形式 更换显示样式*/
    function setTab(name,cursel,n){
        for(i=1;i<=n;i++){
            var menu=document.getElementById(name+i);
            var con=document.getElementById("con_"+name+"_"+i);
            menu.className=i==cursel?"hover":"";
            con.style.display=i==cursel?"block":"none";}}
    //-->
</script>

<body>
<div class="headbox">
    <ul>
        <li style="float:left; line-height:31px;">你好，欢迎来到新密市金诚耐材耐火材料有限公司</li>
    </ul>
</div>
<div class="topall">
    <div class="top"></div>
</div>
<div class="nav">
    <div class="memu">
        <ul>
            <li><a href="${basePath}/main/toFirst.do">网站首页</a></li>
            <li><a href="${basePath}/main/toBrief.do">走进金诚耐材</a></li>
            <li><a href="${basePath}/main/toProductCenter.do">产品中心</a></li>
            <li><a href="${basePath}/main/toExamples.do">应用实例</a></li>
            <li><a href="${basePath}/main/toEquipment.do">设备能力</a></li>
            <li><a href="${basePath}/main/toAptitudeHonor.do">资质荣誉</a></li>
            <li><a href="${basePath}/main/toContact.do">联系我们</a></li>
        </ul>
    </div>
</div>

<div style=" height:562px; width:100%; background:#e6e6e6; border-bottom:1px solid #d5d5d5">
    <div id="box_banner">
        <div xmlns="" class="columnSpace" id="elem-FrontPublic_slideShow01-1414119352530" name="公用幻灯">
            <div id="FrontPublic_slideShow01-1414119352530" class="FrontPublic_slideShow01-d3_c1">
                <div id="yc-mod-slider">
                    <div class="wrapper">
                        <div id="slideshow" class="box_skitter fn-clear">
                            <ul style="display: none;">
                                <li><img alt="" class="cubeRandom" src="${basePath}/resources/img/flash.jpg"></li>
                                <li><img alt="" class="cubeRandom" src="${basePath}/resources/img/flash1.jpg"></li>
                                <li><img alt="" class="cubeRandom" src="${basePath}/resources/img/flash2.jpg"></li>
                            </ul>
                            <a href="#" class="prev_button">prev</a>
                            <a href="#" class="next_button">next</a>
                            <span class="info_slide" style="display: none;">
                                    <span class="image_number image_number_select" rel="0" id="image_n_1_0" style="background-color: rgb(204, 51, 51); color: rgb(255, 255, 255);">1</span>
                                    <span class="image_number" rel="1" id="image_n_2_0" style="background-color: rgb(51, 51, 51); color: rgb(255, 255, 255);">2</span>
                                    <span class="image_number" rel="2" id="image_n_3_0" style="background-color: rgb(51, 51, 51); color: rgb(255, 255, 255);">3</span>
                            </span>
                            <div class="container_skitter" style="width: 1440px; height: 500px;">
                                <div class="image">
                                    <a href="javascript:void(0)">
                                        <img class="image_main" src="${basePath}/resources/img/flash.jpg" style="display: inline;">
                                    </a>
                                    <div class="label_skitter" style="width: 1440px; bottom: 0px; left: 0px;"></div>
                                </div>
                                <div class="box_clone" style="left: 0px; top: 0px; width: 90px; height: 500px; display: block;">
                                    <a href="javascript:void(0)">
                                        <img src="${basePath}/resources/img/flash.jpg" style="left: 0px; top: 0px;">
                                    </a>
                                </div>
                                <div class="box_clone" style="left: 90px; top: 0px; width: 90px; height: 500px; display: block;">
                                    <a href="javascript:void(0)">
                                        <img src="${basePath}/resources/img/flash.jpg" style="left: -90px; top: 0px;">
                                    </a>
                                </div>
                                <div class="box_clone" style="left: 180px; top: 0px; width: 90px; height: 500px; display: block;">
                                    <a href="javascript:void(0)">
                                        <img src="${basePath}/resources/img/flash.jpg" style="left: -180px; top: 0px;">
                                    </a>
                                </div>
                                <div class="box_clone" style="left: 270px; top: 0px; width: 90px; height: 500px; display: block;">
                                    <a href="javascript:void(0)">
                                        <img src="${basePath}/resources/img/flash.jpg" style="left: -270px; top: 0px;">
                                    </a>
                                </div>
                                <div class="box_clone" style="left: 360px; top: 0px; width: 90px; height: 500px; display: block;">
                                    <a href="javascript:void(0)">
                                        <img src="${basePath}/resources/img/flash.jpg" style="left: -360px; top: 0px;">
                                    </a>
                                </div>
                                <div class="box_clone" style="left: 450px; top: 0px; width: 90px; height: 500px; display: block;">
                                    <a href="javascript:void(0)">
                                        <img src="${basePath}/resources/img/flash.jpg" style="left: -450px; top: 0px;">
                                    </a>
                                </div>
                                <div class="box_clone" style="left: 540px; top: 0px; width: 90px; height: 500px; display: block;">
                                    <a href="javascript:void(0)">
                                        <img src="${basePath}/resources/img/flash.jpg" style="left: -540px; top: 0px;">
                                    </a>
                                </div>
                                <div class="box_clone" style="left: 630px; top: 0px; width: 90px; height: 500px; display: block;">
                                    <a href="javascript:void(0)">
                                        <img src="${basePath}/resources/img/flash.jpg" style="left: -630px; top: 0px;">
                                    </a>
                                </div>
                                <div class="box_clone" style="left: 720px; top: 0px; width: 90px; height: 500px; display: block;">
                                    <a href="javascript:void(0)">
                                        <img src="${basePath}/resources/img/flash.jpg" style="left: -720px; top: 0px;">
                                    </a>
                                </div>
                                <div class="box_clone" style="left: 810px; top: 0px; width: 90px; height: 500px; display: block;">
                                    <a href="javascript:void(0)">
                                        <img src="${basePath}/resources/img/flash.jpg" style="left: -810px; top: 0px;">
                                    </a>
                                </div>
                                <div class="box_clone" style="left: 900px; top: 0px; width: 90px; height: 500px; display: block;">
                                    <a href="javascript:void(0)">
                                        <img src="${basePath}/resources/img/flash.jpg" style="left: -900px; top: 0px;">
                                    </a>
                                </div>
                                <div class="box_clone" style="left: 990px; top: 0px; width: 90px; height: 500px; display: block;">
                                    <a href="javascript:void(0)">
                                        <img src="${basePath}/resources/img/flash.jpg" style="left: -990px; top: 0px;">
                                    </a>
                                </div>
                                <div class="box_clone" style="left: 1080px; top: 0px; width: 90px; height: 500px; display: block;">
                                    <a href="javascript:void(0)">
                                        <img src="${basePath}/resources/img/flash.jpg" style="left: -1080px; top: 0px;">
                                    </a>
                                </div>
                                <div class="box_clone" style="left: 1170px; top: 0px; width: 90px; height: 500px; display: block;">
                                    <a href="javascript:void(0)">
                                        <img src="${basePath}/resources/img/flash.jpg" style="left: -1170px; top: 0px;">
                                    </a>
                                </div>
                                <div class="box_clone" style="left: 1260px; top: 0px; width: 90px; height: 500px; display: block;">
                                    <a href="javascript:void(0)">
                                        <img src="${basePath}/resources/img/flash.jpg" style="left: -1260px; top: 0px;">
                                    </a>
                                </div>
                                <div class="box_clone" style="left: 1350px; top: 0px; width: 90px; height: 500px; display: block;">
                                    <a href="javascript:void(0)">
                                        <img src="${basePath}/resources/img/flash.jpg" style="left: -1350px; top: 0px;">
                                    </a>
                                </div>
                            </div>
                        </div>
                        <%-- HTML:target=_blank 在新窗口打开链接--%>
                        <script type="text/javascript">
                            function getOpenType(){
                                return '_blank';
                            }
                        </script>
                        <%-- 两个js文件里的方法重名，最后引用的会把之前引用的给覆盖--%>
                        <script type="text/javascript" src="${basePath}/resources/js/slideshow.js"></script>
                        <script type="text/javascript">
                            var jQuery_144 = $.noConflict();
                            jQuery_144('#FrontPublic_slideShow01-1414119352530 #slideshow').skitter({ width: 980, height: 318, animation: 'random', structure: '<a href="#" class="prev_button">prev</a>' +
                            '<a href="#" class="next_button">next</a>' + '<span class="info_slide"></span>' +
                            '<div class="container_skitter">' + '<div class="image">' +
                            '<a href="/"><img class="image_main" /></a>' +
                            '<div class="label_skitter"></div>' + '</div>' +
                            '</div>', velocity: 1.3, interval: 3500, thumb_width: '70px', thumb_height: '40px', caption: 'bottom', caption_width: '250', navigation: 1, fullscreen: false })
                        </script>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div style="width:1100px; margin:0 auto;height:59px; line-height:59px;">
        <ul>
            <li style="float:left; line-height:59px">热门关键词：
                <a href="http://china-gangtai.com/cp.asp?classid=309">耐火纤维可塑料</a> |
                <a href="http://china-gangtai.com/cp.asp?classid=308">氧化铝空心球浇注料</a> |
                <a href="http://china-gangtai.com/cp.asp?classid=307">超轻质浇注料</a> |
                <a href="http://china-gangtai.com/cp.asp?classid=306">轻质浇注料</a> |
                <a href="http://china-gangtai.com/cp.asp?classid=305">高纯度低水泥浇注料</a> |
            </li>
            <li style=" float: right">
                <form action="cp.asp" method="post" name="form1" id="form1">
                    <%-- 此处缺一个搜索的类似放大镜的图片 --%>
                    <div style="background:url(images/ss_bg.jpg) no-repeat; height:41px; float:left; width:240px; padding-left:10px; border:0px;   margin-top:10px;; padding:1px 0 0 45px;">
                        <input name="key" id="key" value="请输入产品关键字"
                               style=" height:35px;border:1px; line-height:35px; margin:0 auto" type="text"
                               height="41">
                    </div>
                    <div style="float:left; height:41px; width:67px; margin-top:10px;">
                        <input src="${basePath}/resources/img/search.jpg" value="搜索" title="产品搜索" type="image">
                    </div>
                </form>
            </li>
        </ul>
    </div>
    <div class="clear"></div>
</div>


<div class="bodymain">
    <div class="leftframe">
        <div class="leftframe">
            <div class="cplist">
                <div class="head">产品分类</div>
                <div class="content">
                    <a href="http://china-gangtai.com/product.asp?classid=291#showpro" class="nlist">GM系列轻质隔热砖</a>
                    <a href="http://china-gangtai.com/product.asp?classid=292#showpro" class="nlist">莫来石制品</a>
                    <a href="http://china-gangtai.com/product.asp?Product_ID=2181&amp;classid=293#showpro" class="nlist">高铝轻质砖</a>
                    <a href="http://china-gangtai.com/product.asp?Product_ID=2182&amp;classid=294#showpro" class="nlist">高铝重质砖</a>
                    <a href="http://china-gangtai.com/product.asp?Product_ID=2183&amp;classid=295#showpro" class="nlist">粘土轻质砖</a>
                    <a href="http://china-gangtai.com/product.asp?Product_ID=2185&amp;classid=297#showpro" class="nlist">抗渗碳砖</a>
                    <a href="http://china-gangtai.com/product.asp?Product_ID=2186&amp;classid=298#showpro" class="nlist">漂珠砖、莫来石聚轻砖</a>
                    <a href="http://china-gangtai.com/product.asp?Product_ID=2187&amp;classid=299#showpro" class="nlist">刚玉砖</a>
                    <a href="http://china-gangtai.com/product.asp?Product_ID=2188&amp;classid=300#showpro" class="nlist">磷酸盐结合刚玉-莫来石</a>
                    <a href="http://china-gangtai.com/product.asp?Product_ID=2189&amp;classid=301#showpro" class="nlist">耐火胶泥</a>
                    <a href="http://china-gangtai.com/product.asp?Product_ID=2190&amp;classid=302#showpro" class="nlist">防腐密封胶泥</a>
                    <a href="http://china-gangtai.com/product.asp?Product_ID=2191&amp;classid=303#showpro" class="nlist">刚玉耐磨浇注料</a>
                    <a href="http://china-gangtai.com/product.asp?Product_ID=2192&amp;classid=304#showpro" class="nlist">高铝浇注料，粘土浇注料</a>
                    <a href="http://china-gangtai.com/product.asp?Product_ID=2193&amp;classid=305#showpro" class="nlist">高纯度低水泥浇注料</a>
                    <a href="http://china-gangtai.com/product.asp?Product_ID=2184&amp;classid=306#showpro" class="nlist">轻质浇注料</a>
                    <a href="http://china-gangtai.com/product.asp?Product_ID=2195&amp;classid=307#showpro" class="nlist">超轻质浇注料</a>
                    <a href="http://china-gangtai.com/product.asp?Product_ID=2196&amp;classid=308#showpro" class="nlist">氧化铝空心球浇注料</a>
                    <a href="http://china-gangtai.com/product.asp?Product_ID=2194&amp;classid=309#showpro" class="nlist">耐火纤维可塑料</a>
                </div>
            </div>
        </div>
    </div>

    <div class="maincont right">
        <div class="head">
            <p>资质荣誉</p>
            <span>网站当前位置：<a href="http://china-gangtai.com/index.asp">网站首页</a> &gt; 资质荣誉</span>
        </div>
        <div class="cont">
            <a href="http://china-gangtai.com/news_show.asp?ID=1097&amp;wz=%D7%CA%D6%CA%C8%D9%D3%FE" class="proimg_bb">
                <img src="${basePath}/resources/img/honor/1097.jpg" alt="" title="国家级高新技术企业证书" width="180" height="150">
                <span>国家级高新技术企业证书</span>
            </a>
            <a href="http://china-gangtai.com/news_show.asp?ID=1098&amp;wz=%D7%CA%D6%CA%C8%D9%D3%FE" class="proimg_bb">
                <img src="${basePath}/resources/img/honor/1098.jpg" alt="" title="江苏省高新技术产品证书" width="180" height="150">
                <span>江苏省高新技术产品证书</span>
            </a>
            <a href="http://china-gangtai.com/news_show.asp?ID=1099&amp;wz=%D7%CA%D6%CA%C8%D9%D3%FE" class="proimg_bb">
                <img src="${basePath}/resources/img/honor/1099.jpg" alt="" title="江苏省名牌产品证书" width="180" height="150">
                <span>江苏省名牌产品证书</span>
            </a>
            <a href="http://china-gangtai.com/news_show.asp?ID=1100&amp;wz=%D7%CA%D6%CA%C8%D9%D3%FE" class="proimg_bb">
                <img src="${basePath}/resources/img/honor/1100.jpg" alt="" title="质量管理体系认证证书" width="180" height="150">
                <span>质量管理体系认证证书</span>
            </a>
            <a href="http://china-gangtai.com/news_show.asp?ID=1101&amp;wz=%D7%CA%D6%CA%C8%D9%D3%FE" class="proimg_bb">
                <img src="${basePath}/resources/img/honor/1101.jpg" alt="" title="环境体系认证证书" width="180" height="150">
                <span>环境体系认证证书</span>
            </a>
            <a href="http://china-gangtai.com/news_show.asp?ID=1102&amp;wz=%D7%CA%D6%CA%C8%D9%D3%FE" class="proimg_bb">
                <img src="${basePath}/resources/img/honor/1102.jpg" alt="" title="职业健康安全管理体系证书" width="180" height="150">
                <span>职业健康安全管理体系证书</span>
            </a>
            <div class="clear"></div>
            <div style="padding:10px 0" align="center">
                总共有 6 条 1页  当前在第[1]页 <a href="http://china-gangtai.com/pic.asp?wz=%D7%CA%D6%CA%C8%D9%D3%FE&amp;page=1">首页</a>
                | <a href="http://china-gangtai.com/pic.asp?wz=%D7%CA%D6%CA%C8%D9%D3%FE&amp;page=1"> 尾页</a>
            </div>
        </div>
    </div>
    <div class="clear"></div>
</div>

<%@include file="footer.jsp"%>

</body>
</html>