package io.ryanluoxu.customerManager.bean.vo;

import io.ryanluoxu.customerManager.bean.BaseBean;

public class CompanyInfoVO extends BaseBean{

	private Long companyInfoId;
	private String companyName;
	private String country;
	private String status;

	public Long getCompanyInfoId() {
		return companyInfoId;
	}
	public void setCompanyInfoId(Long companyInfoId) {
		this.companyInfoId = companyInfoId;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CompanyInfoVO [companyInfoId=" + companyInfoId + ", companyName=" + companyName + ", country=" + country
				+ "]";
	}

}
