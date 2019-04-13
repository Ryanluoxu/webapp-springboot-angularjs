package io.ryanluoxu.customerManager.validator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.ryanluoxu.customerManager.base.constant.ActionTypeConstant;
import io.ryanluoxu.customerManager.base.exception.CommonError;
import io.ryanluoxu.customerManager.base.exception.CommonException;
import io.ryanluoxu.customerManager.bean.entity.CustomerInfo;
import io.ryanluoxu.customerManager.bean.entity.OrderInfo;
import io.ryanluoxu.customerManager.bean.input.OrderInfoInput;
import io.ryanluoxu.customerManager.service.CustomerInfoService;
import io.ryanluoxu.customerManager.service.OrderInfoService;
import io.ryanluoxu.customerManager.validator.OrderInfoValidator;

@Service
public class OrderInfoValidatorImpl implements OrderInfoValidator {
	
	@Autowired
	private OrderInfoService orderInfoService;
	
	@Autowired
	private CustomerInfoService customerInfoService;

	@Override
	public void validateMandatoryFields(OrderInfoInput orderInfoInput, String actionType) throws CommonException {
		if (ActionTypeConstant.ACTION_TYPE_ADD.equals(actionType)) {
			
		} else if (ActionTypeConstant.ACTION_TYPE_UPDATE.equals(actionType)) {
			checkMissingOrderInfoId(orderInfoInput);
			
		} else if (ActionTypeConstant.ACTION_TYPE_FIND.equals(actionType)) {
			checkMissingCustomerInfoId(orderInfoInput);
			
		} else if (ActionTypeConstant.ACTION_TYPE_DELETE.equals(actionType)) {
			checkMissingOrderInfoId(orderInfoInput);
			
		} else {
			throw new CommonException(CommonError.INVALID_CUSTOMER_INFO_ID);
		}
	}



	@Override
	public void validateInputValue(OrderInfoInput orderInfoInput, String actionType) throws CommonException {
		if (ActionTypeConstant.ACTION_TYPE_ADD.equals(actionType)) {
			validatePrice(orderInfoInput);
			validateQuantity(orderInfoInput);
			
		} else if (ActionTypeConstant.ACTION_TYPE_UPDATE.equals(actionType)) {
			validateOrderInfoId(orderInfoInput);
			
		} else if (ActionTypeConstant.ACTION_TYPE_FIND.equals(actionType)) {
			validateCustomerInfoId(orderInfoInput);
			
		} else if (ActionTypeConstant.ACTION_TYPE_DELETE.equals(actionType)) {
			validateOrderInfoId(orderInfoInput);
			
		} else {
			throw new CommonException(CommonError.INVALID_CUSTOMER_INFO_ID);
		}
	}



	/**
	 * check missing fields
	 */
	private void checkMissingOrderInfoId(OrderInfoInput orderInfoInput) throws CommonException {
		if (orderInfoInput.getOrderInfoId() == null) {
			throw new CommonException(CommonError.MISSING_ORDER_INFO_ID);
		}
	}
	
	private void checkMissingCustomerInfoId(OrderInfoInput orderInfoInput) throws CommonException {
		if (orderInfoInput.getCustomerInfoId() == null) {
			throw new CommonException(CommonError.MISSING_CUSTOMER_INFO_ID);
		}
	}
	
	
	/**
	 * validate fields
	 */
	private void validateOrderInfoId(OrderInfoInput orderInfoInput) throws CommonException {
		OrderInfo orderInfo = orderInfoService.getActive(orderInfoInput.getOrderInfoId());
		if (orderInfo == null) {
			throw new CommonException(CommonError.INVALID_ORDER_INFO_ID);
		}
	}
	
	private void validateCustomerInfoId(OrderInfoInput orderInfoInput) throws CommonException {
		CustomerInfo bean = customerInfoService.getActive(orderInfoInput.getCustomerInfoId());
		if (bean == null) {
			throw new CommonException(CommonError.INVALID_CUSTOMER_INFO_ID);
		}
	}

	private void validateQuantity(OrderInfoInput orderInfoInput) throws CommonException {
		if (orderInfoInput.getQuantity() <= 0.0) {
			throw new CommonException(CommonError.INVALID_ORDER_QUANTITY);
		}
	}

	private void validatePrice(OrderInfoInput orderInfoInput) throws CommonException {
		if (orderInfoInput.getUnitPrice() <= 0.0) {
			throw new CommonException(CommonError.INVALID_ORDER_UNIT_PRICE);
		}
	}


}
