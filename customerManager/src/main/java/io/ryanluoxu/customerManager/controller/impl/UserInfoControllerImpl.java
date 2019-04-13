package io.ryanluoxu.customerManager.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import io.ryanluoxu.customerManager.base.constant.ActionTypeConstant;
import io.ryanluoxu.customerManager.base.constant.StatusConstant;
import io.ryanluoxu.customerManager.base.exception.CommonException;
import io.ryanluoxu.customerManager.base.util.AppEncoder;
import io.ryanluoxu.customerManager.base.util.DateTimeUtil;
import io.ryanluoxu.customerManager.bean.entity.UserInfo;
import io.ryanluoxu.customerManager.bean.input.UserInfoInput;
import io.ryanluoxu.customerManager.bean.vo.UserInfoVO;
import io.ryanluoxu.customerManager.controller.UserInfoController;

@Service
public class UserInfoControllerImpl extends BaseControllerImpl<UserInfo, UserInfoVO, UserInfoInput> implements UserInfoController {

	@Override
	public List<UserInfoVO> findAll() {
		List<UserInfoVO> userInfoVOs = new ArrayList<>();
		List<UserInfo> userInfos = userInfoService.findActive();
		for (UserInfo userInfo : userInfos) {
			UserInfoVO userInfoVO = convertToVO(userInfo);
			userInfoVO.setCreatedDate(DateTimeUtil.getString(userInfo.getCreatedDate()));
			userInfoVOs.add(userInfoVO);
		}
		return userInfoVOs;
	}

	@Override
	public UserInfoVO add(UserInfoInput userInfoInput) {
		passwordEncode(userInfoInput);
		UserInfoVO userInfoVO = convertToVO(userInfoService.add(convertToBean(userInfoInput)));
		auditTrailService.add(ActionTypeConstant.ACTION_TYPE_ADD, userInfoVO.toString());
		return userInfoVO;
	}

	private void passwordEncode(UserInfoInput userInfoInput) {
		userInfoInput.setPassword(AppEncoder.bCryptPasswordEncode(userInfoInput.getPassword()));
	}

	@Override
	public UserInfoVO update(UserInfoInput userInfoInput) {
		UserInfo userInfo = userInfoService.getById(userInfoInput.getUserInfoId());
		userInfo.setUserName(userInfoInput.getUserName());
		passwordEncode(userInfoInput);
		UserInfoVO userInfoVO = convertToVO(userInfoService.update(userInfo));
		auditTrailService.add(ActionTypeConstant.ACTION_TYPE_UPDATE, userInfoVO.toString());
		return userInfoVO;
	}

	@Override
	public UserInfoVO delete(UserInfoInput userInfoInput) {
		UserInfo userInfo = userInfoService.getById(userInfoInput.getUserInfoId());
		userInfo.setStatus(StatusConstant.INACTIVE);
		UserInfoVO userInfoVO = convertToVO(userInfoService.update(userInfo));
		auditTrailService.add(ActionTypeConstant.ACTION_TYPE_DELETE, userInfoVO.toString());
		return userInfoVO;
	}

	@Override
	public void validate(UserInfoInput input, String actionType) throws CommonException {
		userInfoValidator.validateMandatoryFields(input, actionType);
		userInfoValidator.validateInputValue(input, actionType);
	}


}
