package io.ryanluoxu.customerManager.bean.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="user_info")
public class UserInfo implements Serializable{
	private static final long serialVersionUID = 8166649907505952003L;

	@Id
	@Column(name="user_info_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_info_seq_gen")
	@SequenceGenerator(name = "user_info_seq_gen", sequenceName = "user_info_id_seq", initialValue = 1, allocationSize = 1)
	private Long userInfoId;

	@Column(name="user_name")
	private String userName;
	@Column(name="password")
	private String password;
	@Column(name="status")
	private String status;
	@Column(name="created_date")
	private Date createdDate;
	@Column(name="role")
	private String role;
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
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
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
}
