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

<div class="cpall">
    <div class="cptop">
        <div class="cpleft">
            <div class="title">产品展示</div>
            <div class="content">
                <div class="gg"><a href="http://china-gangtai.com/product.asp?classid=291">GM系列轻质隔热砖</a></div>
                <div class="gg"><a href="http://china-gangtai.com/product.asp?classid=292">莫来石制品</a></div>
                <div class="gg"><a href="http://china-gangtai.com/product.asp?classid=293">高铝轻质砖</a></div>
                <div class="gg"><a href="http://china-gangtai.com/product.asp?classid=294">高铝重质砖</a></div>
                <div class="gg"><a href="http://china-gangtai.com/product.asp?classid=295">粘土轻质砖</a></div>
                <div class="gg"><a href="http://china-gangtai.com/product.asp?classid=297">抗渗碳砖</a></div>
                <div class="gg"><a href="http://china-gangtai.com/product.asp?classid=298">漂珠砖、莫来石聚轻砖</a></div>
                <div class="gg"><a href="http://china-gangtai.com/product.asp?classid=299">刚玉砖</a></div>
                <div class="gg"><a href="http://china-gangtai.com/product.asp?classid=300">磷酸盐结合刚玉-莫来石</a></div>
                <div class="gg"><a href="http://china-gangtai.com/product.asp?classid=301">耐火胶泥</a></div>
                <div class="gg"><a href="http://china-gangtai.com/product.asp?classid=302">防腐密封胶泥</a></div>
                <div class="gg"><a href="http://china-gangtai.com/product.asp?classid=303">刚玉耐磨浇注料</a></div>
                <div class="gg"><a href="http://china-gangtai.com/product.asp?classid=304">高铝浇注料，粘土浇注料</a></div>
                <div class="gg"><a href="http://china-gangtai.com/product.asp?classid=305">高纯度低水泥浇注料</a></div>
                <div class="gg"><a href="http://china-gangtai.com/product.asp?classid=306">轻质浇注料</a></div>
                <div class="gg"><a href="http://china-gangtai.com/product.asp?classid=307">超轻质浇注料</a></div>
                <div class="gg"><a href="http://china-gangtai.com/product.asp?classid=308">氧化铝空心球浇注料</a></div>
                <div class="gg"><a href="http://china-gangtai.com/product.asp?classid=309">耐火纤维可塑料</a></div>
            </div>
        </div>
        <div class="cpright">
            <div class="title">
                <div class="Menuboa">
                    <ul>
                        <li id="a1" onmouseover="setTab('a',1,2)" class="hover">热门产品</li>
                        <li id="a2" onmouseover="setTab('a',2,2)">最新产品</li>
                    </ul></div>
            </div>
            <div id="con_a_1" style="overflow:hidden; ">
                <div class="content">
                    <div class="tit">定型制品类</div>
                    <a href="http://china-gangtai.com/product.asp?Product_ID=2202&amp;classid=291" class="proimg_b">
                        <img src="${basePath}/resources/img/2202.jpg" alt="GM-30-32" width="168" height="146" border="0"><br>
                        GM-30-32</a>

                    <a href="http://china-gangtai.com/product.asp?Product_ID=2201&amp;classid=291" class="proimg_b">
                        <img src="${basePath}/resources/img/2201.jpg" alt="GM-28" width="168" height="146" border="0"><br>
                        GM-28</a>

                    <a href="http://china-gangtai.com/product.asp?Product_ID=2200&amp;classid=291" class="proimg_b">
                        <img src="${basePath}/resources/img/2200.jpg" alt="GM-26" width="168" height="146" border="0"><br>
                        GM-26</a>

                    <a href="http://china-gangtai.com/product.asp?Product_ID=2199&amp;classid=291" class="proimg_b">
                        <img src="${basePath}/resources/img/2199.jpg" alt="GM-23" width="168" height="146" border="0"><br>
                        GM-23</a>

                    <a href="http://china-gangtai.com/product.asp?Product_ID=2187&amp;classid=299" class="proimg_b">
                        <img src="${basePath}/resources/img/2187.jpg" alt="刚玉砖" width="168" height="146" border="0"><br>
                        刚玉砖</a>

                    <a href="http://china-gangtai.com/product.asp?Product_ID=2185&amp;classid=297" class="proimg_b">
                        <img src="${basePath}/resources/img/945.jpg" alt="抗渗碳砖" width="168" height="146" border="0"><br>
                        抗渗碳砖</a>

                    <a href="http://china-gangtai.com/product.asp?Product_ID=2181&amp;classid=293" class="proimg_b">
                        <img src="${basePath}/resources/img/2181.jpg" alt="高铝轻质砖" width="168" height="146" border="0"><br>
                        高铝轻质砖</a>

                    <a href="http://china-gangtai.com/product.asp?Product_ID=2180&amp;classid=292" class="proimg_b">
                        <img src="${basePath}/resources/img/940.jpg" alt="莫来石制品" width="168" height="146" border="0"><br>
                        莫来石制品</a>
                    <div class="clear"></div>
                    <div class="tit">不定型类</div>

                    <a href="http://china-gangtai.com/product.asp?Product_ID=2189&amp;classid=301" class="proimg_b">
                        <img src="${basePath}/resources/img/949.jpg" alt="耐火胶泥" width="168" height="146" border="0"><br>
                        耐火胶泥</a>

                    <a href="http://china-gangtai.com/product.asp?Product_ID=2191&amp;classid=303" class="proimg_b">
                        <img src="${basePath}/resources/img/951.jpg" alt="刚玉耐磨浇注料" width="168" height="146" border="0"><br>
                        刚玉耐磨浇注料</a>

                    <a href="http://china-gangtai.com/product.asp?Product_ID=2195&amp;classid=307" class="proimg_b">
                        <img src="${basePath}/resources/img/955.jpg" alt="超轻质浇注料" width="168" height="146" border="0"><br>
                        超轻质浇注料</a>

                    <a href="http://china-gangtai.com/product.asp?Product_ID=2196&amp;classid=308" class="proimg_b">
                        <img src="${basePath}/resources/img/956.jpg" alt="氧化铝空心球浇注料" width="168" height="146" border="0"><br>
                        氧化铝空心球浇注料</a>
                </div>
            </div>

            <div id="con_a_2" style="overflow:hidden; display:none">
                <div class="content">
                    <div class="tit">定型制品类</div>

                    <a href="http://china-gangtai.com/product.asp?Product_ID=2207&amp;classid=292" class="proimg_b">
                        <img src="${basePath}/resources/img/2207.jpg" alt="莫来石异型砖" width="168" height="146" border="0"><br>
                        莫来石异型砖</a>

                    <a href="http://china-gangtai.com/product.asp?Product_ID=2206&amp;classid=292" class="proimg_b">
                        <img src="${basePath}/resources/img/2206.jpg" alt="冶金行业用异型砖" width="168" height="146" border="0"><br>
                        冶金行业用异型砖</a>

                    <a href="http://china-gangtai.com/product.asp?Product_ID=2205&amp;classid=292" class="proimg_b">
                        <img src="${basePath}/resources/img/2205.jpg" alt="轻质异型砖" width="168" height="146" border="0"><br>
                        轻质异型砖</a>

                    <a href="http://china-gangtai.com/product.asp?Product_ID=2204&amp;classid=292" class="proimg_b">
                        <img src="${basePath}/resources/img/2204.JPG" alt="莫来石孔砖" width="168" height="146" border="0"><br>
                        莫来石孔砖</a>

                    <a href="http://china-gangtai.com/product.asp?Product_ID=2203&amp;classid=292" class="proimg_b">
                        <img src="${basePath}/resources/img/2203.JPG" alt="莫来石钩砖、吊顶砖" width="168" height="146" border="0"><br>
                        莫来石钩砖、吊顶砖</a>

                    <a href="http://china-gangtai.com/product.asp?Product_ID=2194&amp;classid=309" class="proimg_b">
                        <img src="${basePath}/resources/img/957.jpg" alt="耐火纤维可塑料" width="168" height="146" border="0"><br>
                        耐火纤维可塑料</a>

                    <a href="http://china-gangtai.com/product.asp?Product_ID=2184&amp;classid=306" class="proimg_b">
                        <img src="${basePath}/resources/img/954.jpg" alt="轻质浇注料" width="168" height="146" border="0"><br>
                        轻质浇注料</a>

                    <a href="http://china-gangtai.com/product.asp?Product_ID=2183&amp;classid=295" class="proimg_b">
                        <img src="${basePath}/resources/img/943.jpg" alt="粘土轻质砖" width="168" height="146" border="0"><br>
                        粘土轻质砖</a>
                    <div class="clear"></div>
                    <div class="tit">不定型类</div>

                    <a href="http://china-gangtai.com/product.asp?Product_ID=2188&amp;classid=300" class="proimg_b">
                        <img src="${basePath}/resources/img/948.jpg" alt="磷酸盐结合刚玉-莫来石" width="168" height="146" border="0"><br>
                        磷酸盐结合刚玉-莫来石</a>

                    <a href="http://china-gangtai.com/product.asp?Product_ID=2190&amp;classid=302" class="proimg_b">
                        <img src="${basePath}/resources/img/950.jpg" alt="防腐密封胶泥" width="168" height="146" border="0"><br>
                        防腐密封胶泥</a>

                    <a href="http://china-gangtai.com/product.asp?Product_ID=2192&amp;classid=304" class="proimg_b">
                        <img src="${basePath}/resources/img/952.jpg" alt="高铝浇注料，粘土浇注料" width="168" height="146" border="0"><br>
                        高铝浇注料，粘土浇注料</a>

                    <a href="http://china-gangtai.com/product.asp?Product_ID=2193&amp;classid=305" class="proimg_b">
                        <img src="${basePath}/resources/img/953.jpg" alt="高纯度低水泥浇注料" width="168" height="146" border="0"><br>
                        高纯度低水泥浇注料</a>
                </div>
            </div>
        </div>
    </div>
    <div class="clear"></div>
</div>

<div class="ban"></div>
<div class="advall">
    <div class="adv">
        <div class="title">
            <div class="title1">金诚耐材<span>3</span>大核心优势</div>
            <div class="title2">为您提供省钱、省心、省力的高品质耐火材料</div>
        </div>
        <div class="body1">
            <div class="wenzi">
                <strong style="font-size:19px">实力品牌--行业领跑</strong><br>
                1、主产品为江苏省名牌产品、高新技术产品<br>
                2、GM系列隔热材料在中石化装置上首次取代进口；<br>
                3、独立和联合研发的高温涂层材料、碳化硅捣打料、超高强度浇注<br>
                　 料填补了国内空白。<br>
            </div>
            <div class="num">01<br>
                公司</div>
            <div class="tupian"></div>
        </div>
        <div class="body2">
            <div class="tu"></div>
            <div class="num1">02<br>管理</div>
            <div class="wenzi1"><strong style="font-size:19px">一流团队--现代管理</strong> <br>
                1、国家级高新技术企业；<br>
                2、拥有博士2名、工程师16名的研发团队；<br>
                3、通过了质量、环境、职业健康安全、计量保证4个体系认证。<br></div>
        </div>
        <div class="body3">
            <div class="wenzi">
                <strong style="font-size:19px">销售市场--多行业覆盖</strong><br>
                1、中石化、中石油的合格供应商<br>
                2、陶瓷、热处理、冶金、电力等行业长期协作供应商<br>
                3、美国、德国、荷兰、俄罗斯等十多个国家30多家客户的出口保证<br>
                4、销售、施工与一体的配套功能，成为客户选择的先决条件<br>
            </div>
            <div class="num">03<br>
                售后</div>
            <div class="tupian"></div>
        </div>
    </div>
    <div class="clear"></div>
</div>

<div class="about">
    <div class="title"><div class="aa">公司简介</div></div>
    <div class="content"><div class="tu"></div>
        <div class="zi"><strong style="font-size:17px">东台市港泰耐火材料有限公司</strong><br>
            东台市港泰耐火材料有限公司创建于1993年，是一家专业从事轻质耐火材料设计、制造、研发、销售、施工于一体的实体企业，注册资本2100万元，占地面
            积67000平方米，建筑面积35000平方，职工总人数216人（其中：建造师6人、高级工程师1人，工程师12人，A、B、C三类安全员持证人员17
            人），年生产能力为25000吨，其中：耐火制品（砖）的年生产能力为12000吨；不定型耐火浇注料的年生产能力...... <br>
            <a href="http://china-gangtai.com/about.asp">查看更多</a></div>
    </div>
</div>

<div class="newsall">
    <div class="news">
        <div class="newsleft">
            <div class="zlzs">
                <div class="title">专利证书</div>
                <div class="content"> <a href="http://china-gangtai.com/pic.asp?wz=%D7%A8%C0%FB%D6%A4%CA%E9"><img src="${basePath}/resources/img/zz_tu.gif" width="346" height="299"></a></div>
            </div>
            <div class="xwdt">
                <div class="title">新闻动态</div>
                <div class="content">

                    <div class="newslist1">
                        <div class="tit"><a href="http://china-gangtai.com/news_show.asp?id=1109&amp;wz=%D0%C2%CE%C5%B6%AF%CC%AC" title="耐火材料原料、不定形、隔热制品等基础耐火材料国家标准">【新闻动态】<span>耐火材料原料、不定形</span></a></div>
                        <div class="nr">
                            一、基础标准
                        </div>
                    </div>
                    <div class="newslist1">
                        <div class="tit"><a href="http://china-gangtai.com/news_show.asp?id=1108&amp;wz=%D0%C2%CE%C5%B6%AF%CC%AC" title="公司微信公众号正式上线！">【新闻动态】<span>公司微信公众号正式上</span></a></div>
                        <div class="nr">
                            即日起，公司微信公众号已正式上线，扫下方二维码可关注我们，获取更多信息。
                        </div>
                    </div>
                    <div class="newslist1">
                        <div class="tit"><a href="http://china-gangtai.com/news_show.asp?id=1107&amp;wz=%D0%C2%CE%C5%B6%AF%CC%AC" title="耐火纤维制品的生产发展趋势及国外耐火纤维企业一览">【新闻动态】<span>耐火纤维制品的生产发</span></a></div>
                        <div class="nr">
                            耐火纤维在20世纪70年代的一次全球性的石油危机后，越来越</div>
                    </div>
                    <div class="newslist1">
                        <div class="tit"><a href="http://china-gangtai.com/news_show.asp?id=1105&amp;wz=%D0%C2%CE%C5%B6%AF%CC%AC" title="耐火材料的应用">【新闻动态】<span>耐火材料的应用</span></a></div>
                        <div class="nr">
                            经常使用的特殊材料有AZS砖、刚玉砖、直接结合镁铬砖、碳化硅砖、氮化硅结合</div>
                    </div>
                </div>
            </div>
        </div>
        <div class="newsright">
            <div class="title"><img src="${basePath}/resources/img/wtjd.gif" width="214" height="55"></div>
            <div class="content">
                <div style="width:230px; padding-top:10px"><img src="${basePath}/resources/img/icon2.gif" width="16" height="16"> <a href="http://china-gangtai.com/news_show.asp?id=1078" title="耐火材料性能" target="_blank" style="color:#036eb4; font-weight:bold">耐火材料性能</a>
                    <div style="width:230px; border-bottom:1px dashed #CCC; padding-bottom:10px; padding-left:10px">
                        耐火材料的物理性能包括结构性能、热学性能、力学性能、使用性能和作...</div>
                </div>
                <div style="width:230px; padding-top:10px"><img src="${basePath}/resources/img/icon2.gif" width="16" height="16"> <a href="http://china-gangtai.com/news_show.asp?id=1077" title="耐火材料分类" target="_blank" style="color:#036eb4; font-weight:bold">耐火材料分类</a>
                    <div style="width:230px; border-bottom:1px dashed #CCC; padding-bottom:10px; padding-left:10px">
                        耐火材料图展
                        耐火材料品种繁多、用途各异，有必要对耐...</div>
                </div>
                <div style="width:230px; padding-top:10px"><img src="${basePath}/resources/img/icon2.gif" width="16" height="16"> <a href="http://china-gangtai.com/news_show.asp?id=1076" title="耐火材料作用" target="_blank" style="color:#036eb4; font-weight:bold">耐火材料作用</a>
                    <div style="width:230px; border-bottom:1px dashed #CCC; padding-bottom:10px; padding-left:10px">
                        耐火材料应用于钢铁、有色金属、玻璃、水泥、陶瓷、石化、机械、锅炉...</div>
                </div>
                <div style="width:230px; padding-top:10px"><img src="${basePath}/resources/img/icon2.gif" width="16" height="16"> <a href="http://china-gangtai.com/news_show.asp?id=1075" title="耐火材料" target="_blank" style="color:#036eb4; font-weight:bold">耐火材料</a>
                    <div style="width:230px; border-bottom:1px dashed #CCC; padding-bottom:10px; padding-left:10px">
                        耐火度不低于1580℃的一类无机非金属材料。耐火度是指耐火材料锥...</div>
                </div>
            </div>
        </div>
    </div><div class="clear"></div>
</div>

<%@include file="footer.jsp"%>

</body>
</html>