package com.jcnc.common.shiro;

import com.jcnc.common.constant.Constants;
import com.jcnc.services.resource.enums.AvailStatusEnum;
import com.jcnc.services.resource.model.customized.ResourceModel;
import com.jcnc.services.resource.service.ResourceService;
import com.jcnc.services.user.enums.ResourceTypeEnum;
import com.jcnc.services.user.model.generated.User;
import com.jcnc.services.user.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/** 
 * 自定义Realm,重写登录认证和授权方法
 * @author: shihao.li
 * @date: 2019-2-17
 */
public class UserRealm extends AuthorizingRealm{
	//创建日志对象
	private static final Logger logger = LoggerFactory.getLogger(UserRealm.class);
	
	@Autowired
	private UserService userService;
	@Autowired
	private ResourceService resourceService;

	/**
	 * shiro自定义登录认证
	 * @param token
	 * @return
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String userName = (String) token.getPrincipal();
		
		if (userName == null) {
			userName = "";
		}
		User user;
		try {
			user = userService.queryUserByName(userName);
		} catch (Exception e) {
			logger.error("【shiro登录认证】报错,错误原因:", e);
			throw new AuthenticationException("登录报错,请联系管理员");
		}
		
		//账号不存在
		if (user == null) {
			 throw new UnknownAccountException();
		}

		logger.info("【shiro登录认证】当前用户为:"+ userName);
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user,
				user.getPassword(), ByteSource.Util.bytes(Constants.SALT), getName());
		return authenticationInfo;
	}

	/**
	 * shiro自定义授权,暂时没有授权操作
	 * @param principals
	 * @return
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		List<String> permissions = new ArrayList<>();
		// 查到权限数据,返回授权信息
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		// 把查询到的权限信息添加到simpleAuthorizationInfo对象中
		simpleAuthorizationInfo.addStringPermissions(permissions);
		return simpleAuthorizationInfo;
	}
	
}
