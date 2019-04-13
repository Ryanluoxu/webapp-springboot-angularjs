package io.ryanluoxu.customerManager.validator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import io.ryanluoxu.customerManager.base.constant.ActionTypeConstant;
import io.ryanluoxu.customerManager.base.exception.CommonError;
import io.ryanluoxu.customerManager.base.exception.CommonException;
import io.ryanluoxu.customerManager.bean.entity.CompanyInfo;
import io.ryanluoxu.customerManager.bean.input.CompanyInfoInput;
import io.ryanluoxu.customerManager.service.CompanyInfoService;
import io.ryanluoxu.customerManager.validator.CompanyInfoValidator;

@Service
public class CompanyInfoValidatorImpl implements CompanyInfoValidator {
	
	@Autowired
	private CompanyInfoService companyInfoService;

	@Override
	public void validateMandatoryFields(CompanyInfoInput companyInfoInput, String actionType) throws CommonException {
		if (ActionTypeConstant.ACTION_TYPE_ADD.equals(actionType)) {
			checkMissingCompanyName(companyInfoInput);
			
		} else if (ActionTypeConstant.ACTION_TYPE_UPDATE.equals(actionType)) {
			checkMissingCompanyInfoId(companyInfoInput);
			checkMissingCompanyName(companyInfoInput);
			
		} else if (ActionTypeConstant.ACTION_TYPE_FIND.equals(actionType)) {
			
		} else if (ActionTypeConstant.ACTION_TYPE_DELETE.equals(actionType)) {
			checkMissingCompanyInfoId(companyInfoInput);
			
		} else {
			throw new CommonException(CommonError.INVALID_CUSTOMER_INFO_ID);
		}
	}
	
	@Override
	public void validateInputValue(CompanyInfoInput companyInfoInput, String actionType) throws CommonException {
		if (ActionTypeConstant.ACTION_TYPE_ADD.equals(actionType)) {
			
		} else if (ActionTypeConstant.ACTION_TYPE_UPDATE.equals(actionType)) {
			validateCompanyInfoId(companyInfoInput);
			
		} else if (ActionTypeConstant.ACTION_TYPE_FIND.equals(actionType)) {
			
		} else if (ActionTypeConstant.ACTION_TYPE_DELETE.equals(actionType)) {
			validateCompanyInfoId(companyInfoInput);
			
		} else {
			throw new CommonException(CommonError.INVALID_CUSTOMER_INFO_ID);
		}
	}
	
	/**
	 * check missing fields
	 */
	private void checkMissingCompanyName(CompanyInfoInput companyInfoInput) throws CommonException {
		if (StringUtils.isEmpty(companyInfoInput.getCompanyName())) {
			throw new CommonException(CommonError.MISSING_COMPANY_NAME);
		}
	}
	private void checkMissingCompanyInfoId(CompanyInfoInput companyInfoInput) throws CommonException {
		if (companyInfoInput.getCompanyInfoId() == null) {
			throw new CommonException(CommonError.MISSING_COMPANY_INFO_ID);
		}
	}
	
	/**
	 * validate fields
	 */
	private void validateCompanyInfoId(CompanyInfoInput companyInfoInput) throws CommonException {
		CompanyInfo companyInfo = companyInfoService.getActive(companyInfoInput.getCompanyInfoId());
		if (companyInfo == null) {
			throw new CommonException(CommonError.INVALID_PRODUCT_INFO_ID);
		}
	}


}
