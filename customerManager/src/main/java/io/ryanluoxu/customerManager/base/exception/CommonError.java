package io.ryanluoxu.customerManager.base.exception;

public class CommonError {

	public final static String INVALID_ACTION_TYPE = "Error : invalid action type: out of CURD.";

	// CUSTOMER_INFO
	public final static String MISSING_CUSTOMER_INFO_ID = "Error : missing customer info id.";
	public final static String MISSING_CUSTOMER_NAME = "Error : missing customer name.";
	public final static String MISSING_COMPANY_NAME = "Error : missing company name.";
	public final static String MISSING_COUNTRY = "Error : missing country.";
	public final static String MISSING_EMAIL = "Error : missing email.";
	public final static String MISSING_CONTACT_MOBILE = "Error : missing contact mobile.";
	public final static String MISSING_CONTACT_OFFICE = "Error : missing contact office.";
	public final static String MISSING_CONTACT_FAX = "Error : missing contact fax.";
	public final static String MISSING_ADDRESS = "Error : missing address.";

	public final static String INVALID_CUSTOMER_INFO_ID = "Error : invalid customer info id.";

	// COMPANY_INFO
	public final static String MISSING_COMPANY_INFO_ID = "Error : missing company info id.";

	public final static String INVALID_COMPANY_INFO_ID = "Error : invalid company info id.";

	// PRODUCT_INFO
	public final static String MISSING_PRODUCT_INFO_ID = "Error : missing product info id.";
	public final static String MISSING_PRODUCT_NAME = "Error : missing product name.";
	public final static String MISSING_PRODUCT_MAX_PRICE = "Error : missing min price.";
	public final static String MISSING_PRODUCT_MIN_PRICE = "Error : missing max price.";
	public final static String INVALID_PRODUCT_INFO_ID = "Error : invalid product info id.";
	public final static String INVALID_PRODUCT_MIN_MAX_PRICE = "Error : invalid product price: min price is larger than max price.";

	// ORDER_INFO
	public final static String MISSING_ORDER_INFO_ID = "Error : missing order info id.";

	public final static String INVALID_ORDER_INFO_ID = "Error : invalid order info id.";
	public final static String INVALID_ORDER_QUANTITY = "Error : invalid order quantity.";
	public final static String INVALID_ORDER_UNIT_PRICE = "Error : invalid order unit price.";

	// USER_INFO
	public final static String MISSING_USER_INFO_ID = "Error : missing user info id.";
	public final static String MISSING_USER_NAME = "Error : missing username.";
	public final static String MISSING_USER_PASSWORD = "Error : missing password.";

	public final static String INVALID_USER_INFO_ID = "Error : invalid user info id.";
	public final static String INVALID_USERNAME_EXISTING = "Error : username existing.";
	public final static String INVALID_USERNAME_NOT_FOUND = "Error : invalid username.";

}
