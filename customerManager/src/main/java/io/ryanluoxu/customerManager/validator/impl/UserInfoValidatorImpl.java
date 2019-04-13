package io.ryanluoxu.customerManager.validator.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import io.ryanluoxu.customerManager.base.constant.ActionTypeConstant;
import io.ryanluoxu.customerManager.base.exception.CommonError;
import io.ryanluoxu.customerManager.base.exception.CommonException;
import io.ryanluoxu.customerManager.bean.entity.UserInfo;
import io.ryanluoxu.customerManager.bean.input.UserInfoInput;
import io.ryanluoxu.customerManager.service.UserInfoService;
import io.ryanluoxu.customerManager.validator.UserInfoValidator;

@Service
public class UserInfoValidatorImpl implements UserInfoValidator {
	
	@Autowired
	private UserInfoService userInfoService;

	@Override
	public void validateMandatoryFields(UserInfoInput userInfoInput, String actionType) throws CommonException {
		if (ActionTypeConstant.ACTION_TYPE_ADD.equals(actionType)) {
			checkMissingUserName(userInfoInput);
			checkMissingPassword(userInfoInput);
			
		} else if (ActionTypeConstant.ACTION_TYPE_UPDATE.equals(actionType)) {
			checkMissingUserInfoId(userInfoInput);
			checkMissingUserName(userInfoInput);
			checkMissingPassword(userInfoInput);
			
		} else if (ActionTypeConstant.ACTION_TYPE_FIND.equals(actionType)) {
			
		} else if (ActionTypeConstant.ACTION_TYPE_DELETE.equals(actionType)) {
			checkMissingUserInfoId(userInfoInput);
			
		} else {
			throw new CommonException(CommonError.INVALID_ACTION_TYPE);
		}
	}




	@Override
	public void validateInputValue(UserInfoInput userInfoInput, String actionType) throws CommonException {
		if (ActionTypeConstant.ACTION_TYPE_ADD.equals(actionType)) {
			validateUserName(userInfoInput);
			
		} else if (ActionTypeConstant.ACTION_TYPE_UPDATE.equals(actionType)) {
			validateUserInfoId(userInfoInput);
			validateUserName(userInfoInput);
			
		} else if (ActionTypeConstant.ACTION_TYPE_FIND.equals(actionType)) {
			
		} else if (ActionTypeConstant.ACTION_TYPE_DELETE.equals(actionType)) {
			validateUserInfoId(userInfoInput);
			
		} else {
			throw new CommonException(CommonError.INVALID_PRODUCT_INFO_ID);
		}
	}
	
	/**
	 * check missing fields
	 */
	private void checkMissingUserName(UserInfoInput userInfoInput) throws CommonException {
		if (StringUtils.isEmpty(userInfoInput.getUserName())) {
			throw new CommonException(CommonError.MISSING_USER_NAME);
		}
	}
	private void checkMissingUserInfoId(UserInfoInput userInfoInput) throws CommonException {
		if (userInfoInput.getUserInfoId() == null) {
			throw new CommonException(CommonError.MISSING_USER_INFO_ID);
		}
	}
	private void checkMissingPassword(UserInfoInput userInfoInput) throws CommonException {
		if (userInfoInput.getPassword() == null) {
			throw new CommonException(CommonError.MISSING_USER_PASSWORD);
		}
	}

	
	/**
	 * validate fields
	 */
	private void validateUserInfoId(UserInfoInput userInfoInput) throws CommonException {
		UserInfo userInfo = userInfoService.getActive(userInfoInput.getUserInfoId());
		if (userInfo == null) {
			throw new CommonException(CommonError.INVALID_USER_INFO_ID);
		}
	}
	private void validateUserName(UserInfoInput userInfoInput) throws CommonException {
		List<UserInfo> userInfos = userInfoService.findByUserName(userInfoInput.getUserName());
		if (!CollectionUtils.isEmpty(userInfos) 
				&& userInfoInput.getUserInfoId() != userInfos.get(0).getUserInfoId()) {	// for edit - except current Id
			throw new CommonException(CommonError.INVALID_USERNAME_EXISTING);
		}
	}

}
