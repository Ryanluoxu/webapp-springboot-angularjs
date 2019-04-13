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
@Table(name="audit_trail")
public class AuditTrail implements Serializable{

	private static final long serialVersionUID = -3963219881372554331L;

	@Id
	@Column(name="audit_trail_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "audit_trail_seq_gen")
	@SequenceGenerator(name = "audit_trail_seq_gen", sequenceName = "audit_trail_id_seq", initialValue = 1, allocationSize = 1)
	private Long auditTrailId;

	@Column(name="action")
	private String action;
	@Column(name="action_type")
	private String actionType;
	@Column(name="created_date")
	private Date createdDate;
	@Column(name="user_name")
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
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
}
