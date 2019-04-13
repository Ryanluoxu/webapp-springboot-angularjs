package io.ryanluoxu.customerManager.base.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import io.ryanluoxu.customerManager.base.constant.AuthorityConstant;
import io.ryanluoxu.customerManager.base.constant.RoleConstant;
import io.ryanluoxu.customerManager.base.constant.StatusConstant;
import io.ryanluoxu.customerManager.bean.entity.UserInfo;

public class CustomUserDetails implements UserDetails {

	private static final long serialVersionUID = -5770284918220758529L;
	
	private Long userInfoId;
	private String userName;
	private String role;
	private String password;
	private String status;
	
	public CustomUserDetails(UserInfo userInfo) {
		super();
		this.userInfoId = userInfo.getUserInfoId();
		this.userName = userInfo.getUserName();
		this.role = userInfo.getRole();
		this.password = userInfo.getPassword();
		this.status = userInfo.getStatus();
	}

	/*
	 * convert userInfo.role to authorities
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		if (RoleConstant.ADMIN.equals(role)) {
			grantedAuthorities.add(new SimpleGrantedAuthority(AuthorityConstant.ADMIN));			
		} else {
			grantedAuthorities.add(new SimpleGrantedAuthority(AuthorityConstant.USER));
		}
		return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		/*
		 * enable when user status is active
		 */
		return StatusConstant.ACTIVE.equals(this.status);
	}

	public Long getUserInfoId() {
		return userInfoId;
	}

}
