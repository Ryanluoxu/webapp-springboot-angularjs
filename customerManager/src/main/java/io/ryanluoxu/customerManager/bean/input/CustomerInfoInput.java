package io.ryanluoxu.customerManager.bean.input;

import io.ryanluoxu.customerManager.bean.BaseBean;

public class CustomerInfoInput extends BaseBean{
	private Long customerInfoId;
	private String customerName;
	private String function;
	private String companyName;
	private String country;
	private String email;
	private String contactMobile;
	private String contactOffice;
	private String contactFax;
	private String address;
	
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
