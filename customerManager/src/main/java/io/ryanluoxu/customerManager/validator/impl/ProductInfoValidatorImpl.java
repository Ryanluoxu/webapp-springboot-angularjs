package io.ryanluoxu.customerManager.validator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import io.ryanluoxu.customerManager.base.constant.ActionTypeConstant;
import io.ryanluoxu.customerManager.base.exception.CommonError;
import io.ryanluoxu.customerManager.base.exception.CommonException;
import io.ryanluoxu.customerManager.bean.entity.ProductInfo;
import io.ryanluoxu.customerManager.bean.input.ProductInfoInput;
import io.ryanluoxu.customerManager.service.ProductInfoService;
import io.ryanluoxu.customerManager.validator.ProductInfoValidator;

@Service
public class ProductInfoValidatorImpl implements ProductInfoValidator {
	
	@Autowired
	private ProductInfoService productInfoService;

	@Override
	public void validateMandatoryFields(ProductInfoInput productInfoInput, String actionType) throws CommonException {
		if (ActionTypeConstant.ACTION_TYPE_ADD.equals(actionType)) {
			checkMissingProductName(productInfoInput);
			checkMissingMinPrice(productInfoInput);
			checkMissingMaxPrice(productInfoInput);
			
		} else if (ActionTypeConstant.ACTION_TYPE_UPDATE.equals(actionType)) {
			checkMissingProductInfoId(productInfoInput);
			checkMissingMinPrice(productInfoInput);
			checkMissingMaxPrice(productInfoInput);
			
		} else if (ActionTypeConstant.ACTION_TYPE_FIND.equals(actionType)) {
			
		} else if (ActionTypeConstant.ACTION_TYPE_DELETE.equals(actionType)) {
			checkMissingProductInfoId(productInfoInput);
			
			
		} else {
			throw new CommonException(CommonError.INVALID_ACTION_TYPE);
		}
	}


	@Override
	public void validateInputValue(ProductInfoInput productInfoInput, String actionType) throws CommonException {
		if (ActionTypeConstant.ACTION_TYPE_ADD.equals(actionType)) {
			validateMinMaxPrice(productInfoInput);
			
		} else if (ActionTypeConstant.ACTION_TYPE_UPDATE.equals(actionType)) {
			validateProductInfoId(productInfoInput);
			validateMinMaxPrice(productInfoInput);
			
		} else if (ActionTypeConstant.ACTION_TYPE_FIND.equals(actionType)) {
			
		} else if (ActionTypeConstant.ACTION_TYPE_DELETE.equals(actionType)) {
			validateProductInfoId(productInfoInput);
			
		} else {
			throw new CommonException(CommonError.INVALID_PRODUCT_INFO_ID);
		}
	}
	
	/**
	 * check missing fields
	 */
	private void checkMissingProductName(ProductInfoInput productInfoInput) throws CommonException {
		if (StringUtils.isEmpty(productInfoInput.getProductName())) {
			throw new CommonException(CommonError.MISSING_PRODUCT_NAME);
		}
	}
	private void checkMissingProductInfoId(ProductInfoInput productInfoInput) throws CommonException {
		if (productInfoInput.getProductInfoId() == null) {
			throw new CommonException(CommonError.MISSING_PRODUCT_INFO_ID);
		}
	}
	private void checkMissingMaxPrice(ProductInfoInput productInfoInput) throws CommonException {
		if (productInfoInput.getMinPrice() <= 0.0) {
			throw new CommonException(CommonError.MISSING_PRODUCT_MIN_PRICE);
		}
	}
	private void checkMissingMinPrice(ProductInfoInput productInfoInput)  throws CommonException {
		if (productInfoInput.getMaxPrice() <= 0.0) {
			throw new CommonException(CommonError.MISSING_PRODUCT_MAX_PRICE);
		}
	}
	/**
	 * validate fields
	 */
	private void validateProductInfoId(ProductInfoInput productInfoInput) throws CommonException {
		ProductInfo productInfo = productInfoService.getActive(productInfoInput.getProductInfoId());
		if (productInfo == null) {
			throw new CommonException(CommonError.INVALID_PRODUCT_INFO_ID);
		}
	}
	private void validateMinMaxPrice(ProductInfoInput productInfoInput) throws CommonException {
		if (productInfoInput.getMinPrice() > productInfoInput.getMaxPrice()) {
			throw new CommonException(CommonError.INVALID_PRODUCT_MIN_MAX_PRICE);
		}
	}

}
