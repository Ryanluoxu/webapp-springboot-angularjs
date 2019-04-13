package io.ryanluoxu.customerManager.base.exception;

public class CommonException extends Exception {
	private static final long serialVersionUID = 7996938116570928536L;
	private String errorMsg;

	public CommonException(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
}
