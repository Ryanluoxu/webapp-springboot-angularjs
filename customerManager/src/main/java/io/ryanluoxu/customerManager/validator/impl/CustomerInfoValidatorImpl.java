package io.ryanluoxu.customerManager.validator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import io.ryanluoxu.customerManager.base.constant.ActionTypeConstant;
import io.ryanluoxu.customerManager.base.exception.CommonError;
import io.ryanluoxu.customerManager.base.exception.CommonException;
import io.ryanluoxu.customerManager.base.exception.CustomerInfoError;
import io.ryanluoxu.customerManager.base.exception.CustomerInfoException;
import io.ryanluoxu.customerManager.bean.entity.CustomerInfo;
import io.ryanluoxu.customerManager.bean.input.CustomerInfoInput;
import io.ryanluoxu.customerManager.service.CustomerInfoService;
import io.ryanluoxu.customerManager.validator.CustomerInfoValidator;

@Service
public class CustomerInfoValidatorImpl implements CustomerInfoValidator {

	@Autowired
	private CustomerInfoService customerInfoService;

	@Override
	public void validateMandatoryFields(CustomerInfoInput customerInfoInput, String actionType) throws CommonException {
		if (ActionTypeConstant.ACTION_TYPE_ADD.equals(actionType)) {
			checkMissingCustomerName(customerInfoInput);

		} else if (ActionTypeConstant.ACTION_TYPE_UPDATE.equals(actionType)) {
			checkMissingCustomerInfoId(customerInfoInput);
			checkMissingCustomerName(customerInfoInput);

		} else if (ActionTypeConstant.ACTION_TYPE_FIND.equals(actionType)) {

		} else if (ActionTypeConstant.ACTION_TYPE_DELETE.equals(actionType)) {
			checkMissingCustomerInfoId(customerInfoInput);

		} else {
			throw new CommonException(CommonError.INVALID_ACTION_TYPE);
		}
	}
	@Override
	public void validateInputValue(CustomerInfoInput customerInfoInput, String actionType) throws CommonException {
		if (ActionTypeConstant.ACTION_TYPE_ADD.equals(actionType)) {

		} else if (ActionTypeConstant.ACTION_TYPE_UPDATE.equals(actionType)) {
			validateCustomerInfoId(customerInfoInput);

		} else if (ActionTypeConstant.ACTION_TYPE_FIND.equals(actionType)) {

		} else if (ActionTypeConstant.ACTION_TYPE_DELETE.equals(actionType)) {
			validateCustomerInfoId(customerInfoInput);

		} else {
			throw new CommonException(CommonError.INVALID_PRODUCT_INFO_ID);
		}
	}

	/**
	 * check missing fields
	 */
	private void checkMissingCustomerName(CustomerInfoInput customerInfoInput) throws CustomerInfoException {
		if (StringUtils.isEmpty(customerInfoInput.getCustomerName())) {
			throw new CustomerInfoException(CustomerInfoError.MISSING_CUSTOMER_NAME);
		}
	}
	private void checkMissingCustomerInfoId(CustomerInfoInput customerInfoInput) throws CustomerInfoException {
		if (customerInfoInput.getCustomerInfoId() == null) {
			throw new CustomerInfoException(CustomerInfoError.MISSING_CUSTOMER_INFO_ID);
		}
	}

	/**
	 * validate fields
	 */
	private void validateCustomerInfoId(CustomerInfoInput customerInfoInput) throws CustomerInfoException {
		CustomerInfo customerInfo = customerInfoService.getActive(customerInfoInput.getCustomerInfoId());
		if (customerInfo == null) {
			throw new CustomerInfoException(CustomerInfoError.INVALID_CUSTOMER_INFO_ID);
		}
	}


}
