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
@Table(name="customer_info")
public class CustomerInfo implements Serializable{
	private static final long serialVersionUID = 1200796892383975865L;

	@Id
	@Column(name="customer_info_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_info_seq_gen")
	@SequenceGenerator(name = "customer_info_seq_gen", sequenceName = "customer_info_id_seq", initialValue = 1, allocationSize = 1)
	private Long customerInfoId;

	@Column(name="customer_name")
	private String customerName;
	@Column(name="function")
	private String function;
	@Column(name="company_name")
	private String companyName;
	@Column(name="country")
	private String country;
	@Column(name="email")
	private String email;
	@Column(name="contact_mobile")
	private String contactMobile;
	@Column(name="contact_office")
	private String contactOffice;
	@Column(name="contact_fax")
	private String contactFax;
	@Column(name="address")
	private String address;
	@Column(name="status")
	private String status;
	@Column(name="created_by")
	private String createdBy;
	@Column(name="created_date")
	private Date createdDate;
	@Column(name="updated_by")
	private String updatedBy;
	@Column(name="updated_date")
	private Date updatedDate;
	
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
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
	public Long getCustomerInfoId() {
		return customerInfoId;
	}
	public void setCustomerInfoId(Long customerInfoId) {
		this.customerInfoId = customerInfoId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getFunction() {
		return function;
	}
	public void setFunction(String function) {
		this.function = function;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactMobile() {
		return contactMobile;
	}
	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}
	public String getContactOffice() {
		return contactOffice;
	}
	public void setContactOffice(String contactOffice) {
		this.contactOffice = contactOffice;
	}
	public String getContactFax() {
		return contactFax;
	}
	public void setContactFax(String contactFax) {
		this.contactFax = contactFax;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
