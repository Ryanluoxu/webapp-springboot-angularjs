package io.ryanluoxu.customerManager.bean.vo;

import io.ryanluoxu.customerManager.bean.BaseBean;

public class OrderInfoVO extends BaseBean{
	private Long orderInfoId;
	private Long customerInfoId;
	private String customerName;
	private Long productInfoId;
	private String productName;
	private String paymentMode;
	private double unitPrice;
	private double quantity;
	private double profit;
	private String status;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Long getProductInfoId() {
		return productInfoId;
	}
	public void setProductInfoId(Long productInfoId) {
		this.productInfoId = productInfoId;
	}
	public Long getOrderInfoId() {
		return orderInfoId;
	}
	public void setOrderInfoId(Long orderInfoId) {
		this.orderInfoId = orderInfoId;
	}
	public Long getCustomerInfoId() {
		return customerInfoId;
	}
	public void setCustomerInfoId(Long customerInfoId) {
		this.customerInfoId = customerInfoId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public double getProfit() {
		return profit;
	}
	public void setProfit(double profit) {
		this.profit = profit;
	}
	@Override
	public String toString() {
		return "OrderInfoVO [orderInfoId=" + orderInfoId + ", customerInfoId=" + customerInfoId + ", productName="
				+ productName + ", paymentMode=" + paymentMode + ", unitPrice=" + unitPrice + ", quantity=" + quantity
				+ ", profit=" + profit + "]";
	}

}
