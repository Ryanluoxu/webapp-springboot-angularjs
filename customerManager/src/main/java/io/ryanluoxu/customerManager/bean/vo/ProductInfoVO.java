package io.ryanluoxu.customerManager.bean.vo;

import io.ryanluoxu.customerManager.bean.BaseBean;

public class ProductInfoVO extends BaseBean {

	private Long productInfoId;
	private Long companyInfoId;
	private String companyName;
	private String productName;
	private String status;
	private double minPrice;
	private double maxPrice;
	
	public double getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}
	public double getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}
	public Long getProductInfoId() {
		return productInfoId;
	}
	public void setProductInfoId(Long productInfoId) {
		this.productInfoId = productInfoId;
	}
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
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ProductInfoVO [productInfoId=" + productInfoId + ", companyInfoId=" + companyInfoId + ", companyName="
				+ companyName + ", productName=" + productName + "]";
	}

}
