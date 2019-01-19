<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="../base.jsp"%>


<div class="contact agileits">
    <h3 class="agileits-title">联系我们</h3>
    <div class="contact-agileinfo">
        <div class="col-md-7 contact-form wthree">
            <form id="filter_form" action="#" method="post">
                <input type="text" name="Name" placeholder="姓名" required="">
                <input class="email" type="email" name="Email" placeholder="邮箱" required="">
                <input type="text" class="mobile" type="mobile" name="Mobile" placeholder="电话" required="">
                <textarea placeholder="留言记录" name="Message" required=""></textarea>
                <button id="btnSave" class="custom-submit" type="button">提交留言</button>
            </form>
        </div>
        <div class="col-md-4 contact-right wthree">
            <div class="contact-text w3-agileits">
                <h4>联系方式 :</h4>
                <p>
                    <img src="${basePath}/resources/img/icon/locate.png"/>
                    <i class="custom-footer">地址：河南省郑州市新密市青屏街办事处嵩山大道青屏公寓905室</i>
                </p>
                <p>
                    <img src="${bathPath}/resources/img/icon/mbile.png"/>
                    <i class="custom-footer">电话：15093218658</i>
                </p>
                <p>
                    <img src="${bathPath}/resources/img/icon/email.png"/>
                    <i class="custom-footer">电子邮箱：beihaijincheng@163.com</i>
                </p>
            </div>
        </div>
        <div class="clearfix"> </div>
    </div>
</div>

<!--百度地图容器-->
<div class="contact agileits">
    <div class="custom-map" id="dituContent">
    </div>
</div>
<!--百度地图容器-->

<script type="text/javascript">
    var mainMenu = '${mainMenu}';
    $('[name="custom_menu"]').each(function (index, entity) {
        $(entity).removeClass();
    });

    $('#' + mainMenu).addClass("active");

    var contactHelper = {
        init : function() {
            var me = contactHelper;

            $('#btnSave').click(me.btnSave);
        },
        btnSave : function() {
            $.ajax({
                url : "${basePath}/visitor/saveMessage.do",
                data : $("#filter_form").serialize(),
                dataType: "json",
                type : "POST",
                success : function(data) {
                    if (data.resultCode == '0000') {
                        bootbox.alert(data.resultMsg);
                    } else {
                        bootbox.alert(data.resultMsg);
                    }
                }
            });
        }
    }
    $(function() {
        contactHelper.init();
    });
</script>

<script type="text/javascript">
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
        var point = new BMap.Point(113.38621,34.538877);//定义一个中心点坐标
        map.centerAndZoom(point,17);//设定地图的中心点和坐标并将地图显示在地图容器中
        window.map = map;//将map变量存储在全局
    }

    //地图事件设置函数：
    function setMapEvent(){
        map.enableDragging();//启用地图拖拽事件，默认启用(可不写)
        map.disableScrollWheelZoom();//禁用地图滚轮放大缩小，默认禁用(可不写)
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
    var markerArr = [{title:"北海金诚耐材",content:"地址：郑州市新密市嵩山大道青屏公寓905室<br/>联系人：李沛丽<br/>电话：15093218658",point:"113.386417|34.537955",isOpen:1,icon:{w:21,h:21,l:46,t:0,x:6,lb:5}}
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
