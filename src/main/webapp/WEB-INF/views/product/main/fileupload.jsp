<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="../../base.jsp"%>

<div class="page-bar">
    <ul class="page-breadcrumb">
        <li>
            <i class="fa fa-cart-arrow-down"></i>
            <a >产品中心</a>
            <i class="fa fa-angle-right"></i>
        </li>
        <li>
            <a >lz-65高铝砖</a>
            <i class="fa"></i>
            <i class="fa fa-angle-right"></i>
        </li>
    </ul>
</div>

<!-- 展示区 -->
<div class="row">
    <div class="col-md-12">
        <div class="portlet box grey-cascade">
            <div class="portlet-title">
                <div class="caption">
                    <i class="fa fa-globe"></i>lz-65高铝砖
                </div>
            </div>
            <div class="portlet-body">
                <div class="table-toolbar">
                    <div class="col-md-12">
                        <form id="uploadForm" action="${basePath}/product/uploadPicture.do" class="form-horizontal" enctype="multipart/form-data" method="post">
                            <div class="form-group">
                                <label class="control-label col-md-1"/>
                                <div class="col-md-8">
                                    <input type="file" style="width:350px;" name="multipartFile" id="file_id">
                                </div>
                                <div class="col-md-2">
                                    <button type="button" id="uploadFileButton" onclick="doUpload()" onclass="btn blue">上传</button>
                                    <button type="reset" id="uploadFormReset" style="display: none;"></button>
                                </div>
                            </div>
                        </form>

                    </div>

                </div>

                <img src="${basePath}/product/tofindPic.do">
            </div>
        </div>
    </div>
</div>

<script>
    //上传文件
    function doUpload(){
        var file_id=$("#file_id").val();
        if(file_id == null || file_id == ""){
            bootbox.alert("上传文件不能为空！");
            return;
        }
        var ext = file_id.substr(file_id.lastIndexOf(".")+1).toLowerCase();
        if( ext !="png" && ext != "jpg" && ext != "gif"){
            bootbox.alert("请选择正确的图片类型!");
            return;
        }

        $("#uploadForm").ajaxSubmit({
            type:"post",
            dataType:"json",
            clearForm: true,
            resetForm: true,
            url:"${basePath}/product/uploadPicture.do",
            success : function(data){
                bootbox.alert(data.resultMsg);
            }
        });

    }
</script>