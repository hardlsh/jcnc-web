package com.jcnc.common.shiro;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/** 
 * @ClassName: MyFormAuthenticationFilter 
 * @author: shihao.li
 * @Explain: 自定义shiro的authc,form过滤
 * @date: 2017年3月24日 下午2:25:39  
 */
public class MyFormAuthenticationFilter extends FormAuthenticationFilter{
	
	/**
	 * 重写方法, 实现登录成功后自动跳转到main页面
	 */
	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
			ServletResponse response) throws Exception {
		
		WebUtils.getAndClearSavedRequest(request);//后清理原来的地址
		WebUtils.redirectToSavedRequest(request, response, "/index/toUser.do");
		
		return false;
	}
	
}
