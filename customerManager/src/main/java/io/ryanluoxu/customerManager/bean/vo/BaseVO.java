package io.ryanluoxu.customerManager.bean.vo;

import io.ryanluoxu.customerManager.bean.BaseBean;

public class BaseVO extends BaseBean{
	private Long id;
	private String name;
	private String status;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
