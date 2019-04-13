package io.ryanluoxu.customerManager.bean.vo;

public class UserInfoVO {

	private Long userInfoId;
	private String userName;
	private String password;
	private String status;
	private String createdDate;
	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	/*
	 * public UserInfoVO(UserInfo userInfo) { this.userInfoId =
	 * userInfo.getUserInfoId(); this.userName = userInfo.getUserName();
	 * this.password = userInfo.getPassword(); this.status = userInfo.getStatus(); }
	 */

	public Long getUserInfoId() {
		return userInfoId;
	}

	public void setUserInfoId(Long userInfoId) {
		this.userInfoId = userInfoId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

}
