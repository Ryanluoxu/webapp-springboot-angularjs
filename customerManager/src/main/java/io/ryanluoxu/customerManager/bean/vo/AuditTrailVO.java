package io.ryanluoxu.customerManager.bean.vo;

public class AuditTrailVO{

	private Long auditTrailId;
	private String action;
	private String actionType;
	private String createdDate;
	private String userName;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getAuditTrailId() {
		return auditTrailId;
	}
	public void setAuditTrailId(Long auditTrailId) {
		this.auditTrailId = auditTrailId;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	
}
