<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<%@include file="../header.jsp"%>
<jsp:include page="../basepath.jsp"/>
<body>
	<div class="row">
		<div class="col-md-12">
			<div class="portlet box grey-cascade">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-globe"></i>用户管理
					</div>
					<div class="actions">
						<a class="ajaxify btn green" href="${basePath}/index/logout.do">退出登录</a>
					</div>
				</div>
				<div class="portlet-body">
					<a class="ajaxify btn btn-primary" href="${basePath}/user/toProduct.do">产品管理</a>
					<br/>
					<br/>
					<a class="ajaxify btn btn-primary" href="${basePath}/user/toResource.do">资源管理</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>