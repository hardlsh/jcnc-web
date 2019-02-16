<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<%@include file="../header.jsp"%>
<jsp:include page="../basepath.jsp"/>
<link href="${basePath}/resources/css/login.css" rel="stylesheet" type="text/css"/>
<body class="login">
	<br/>
	<br/>
	<br/>
	<br/>
	<div class="content">
		<form class="login-form" action="${basePath}/index/login.do" method="post">
			<h3 class="form-title">北海金诚耐材</h3>
			<div class="alert alert-danger display-hide">
				<button class="close" data-close="alert"></button>
				<span>请输入用户名和密码！</span>
			</div>
			<div class="alert alert-danger display-hide" id="alertId">
				<button class="close" data-close="alert"></button>
				<span id="msgId"></span>
			</div>
			<div class="form-group">
				<label class="control-label visible-ie8 visible-ie9">用户名</label>
				<input class="form-control form-control-solid placeholder-no-fix" type="text" autocomplete="off" placeholder="用户名" name="userName"/>
			</div>
			<div class="form-group">
				<label class="control-label visible-ie8 visible-ie9">密码</label>
				<input class="form-control form-control-solid placeholder-no-fix" type="password" autocomplete="off" placeholder="密码" name="password"/>
			</div>
			<div class="form-actions">
				<button type="submit" class="btn btn-success uppercase">登录</button>
			</div>
		</form>
	</div>

	<div class="copyright">
		2019 © 亲情树-李豪.
	</div>

	<script src="${basePath}/resources/js/jquery.validate.min.js" type="text/javascript"></script>
	<script>
        jQuery(document).ready(function() {
            Metronic.init(); // init metronic core components
            Layout.init(); // init current layout

            if('${result.resultCode}' != '0000' && '${result.resultCode}' != ''){
                $("#msgId").html("${result.data}");
                $("#alertId").show();
            }
        });

	</script>
</body>
</html>