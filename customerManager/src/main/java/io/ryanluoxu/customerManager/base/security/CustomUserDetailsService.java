package io.ryanluoxu.customerManager.base.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.ryanluoxu.customerManager.base.constant.StatusConstant;
import io.ryanluoxu.customerManager.base.exception.CommonError;
import io.ryanluoxu.customerManager.bean.entity.UserInfo;
import io.ryanluoxu.customerManager.service.UserInfoService;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserInfoService userInfoService;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		UserInfo userInfo = userInfoService.get(userName, StatusConstant.ACTIVE);
		if (userInfo == null) {
			throw new UsernameNotFoundException(CommonError.INVALID_USERNAME_NOT_FOUND);
		}
		
		return new CustomUserDetails(userInfo);
	}

}
