package io.ryanluoxu.customerManager.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.ryanluoxu.customerManager.base.constant.ActionTypeConstant;
import io.ryanluoxu.customerManager.base.constant.CustomerInfoConstant;
import io.ryanluoxu.customerManager.base.exception.CommonException;
import io.ryanluoxu.customerManager.base.util.DateTimeUtil;
import io.ryanluoxu.customerManager.bean.entity.AuditTrail;
import io.ryanluoxu.customerManager.bean.entity.CustomerInfo;
import io.ryanluoxu.customerManager.bean.entity.ProductInfo;
import io.ryanluoxu.customerManager.bean.input.CustomerInfoInput;
import io.ryanluoxu.customerManager.bean.vo.CustomerInfoVO;
import io.ryanluoxu.customerManager.controller.CustomerInfoController;
import io.ryanluoxu.customerManager.service.CustomerInfoService;
import io.ryanluoxu.customerManager.validator.CustomerInfoValidator;

@Service
public class CustomerInfoControllerImpl extends BaseControllerImpl<CustomerInfo, CustomerInfoVO, CustomerInfoInput> implements CustomerInfoController {

	@Autowired
	private CustomerInfoValidator customerInfoValidator;

	@Autowired
	private CustomerInfoService customerInfoService;

	@Override
	public CustomerInfoVO add(CustomerInfoInput customerInfoInput) {
		CustomerInfoVO customerInfoVO = convertToVO(customerInfoService.add(convertToBean(customerInfoInput)));
		createAuditTrailForAdd(customerInfoInput, customerInfoVO);
		return customerInfoVO;
	}

	@Override
	public CustomerInfoVO delete(CustomerInfoInput customerInfoInput) {
		CustomerInfo customerInfo = customerInfoService.getById(customerInfoInput.getCustomerInfoId());
		customerInfo.setStatus(CustomerInfoConstant.STATUS_INACTIVE);
		CustomerInfoVO customerInfoVO = convertToVO(customerInfoService.update(customerInfo));
		createAuditTrailForDelete(customerInfoInput, customerInfoVO);
		return customerInfoVO;
	}

	@Override
	public CustomerInfoVO update(CustomerInfoInput customerInfoInput) {
		CustomerInfo customerInfo = customerInfoService.getById(customerInfoInput.getCustomerInfoId());
		customerInfo.setAddress(customerInfoInput.getAddress());
		customerInfo.setCompanyName(customerInfoInput.getCompanyName());
		customerInfo.setContactFax(customerInfoInput.getContactFax());
		customerInfo.setContactMobile(customerInfoInput.getContactMobile());
		customerInfo.setContactOffice(customerInfoInput.getContactOffice());
		customerInfo.setCountry(customerInfoInput.getCountry());
		customerInfo.setCustomerName(customerInfoInput.getCustomerName());
		customerInfo.setEmail(customerInfoInput.getEmail());
		customerInfo.setFunction(customerInfoInput.getFunction());
		CustomerInfoVO customerInfoVO = convertToVO(customerInfoService.update(customerInfo));
		createAuditTrailForUpdate(customerInfoInput, customerInfoVO);
		return customerInfoVO;
	}

	@Override
	public List<CustomerInfoVO> findAll() {
		List<CustomerInfoVO> customerInfoVOs = new ArrayList<>();
		List<CustomerInfo> customerInfos = customerInfoService.findActive();
		for (CustomerInfo customerInfo : customerInfos) {
			CustomerInfoVO customerInfoVO = convertToVO(customerInfo);
			customerInfoVO.setCreatedDate(DateTimeUtil.getString(customerInfo.getCreatedDate()));
			customerInfoVO.setUpdatedDate(DateTimeUtil.getString(customerInfo.getUpdatedDate()));
			customerInfoVOs.add(customerInfoVO);
		}
		return customerInfoVOs;
	}

	@Override
	public void validate(CustomerInfoInput input, String actionType) throws CommonException {
		customerInfoValidator.validateMandatoryFields(input, actionType);
		customerInfoValidator.validateInputValue(input, actionType);
	}

	private AuditTrail createAuditTrailForAdd(CustomerInfoInput input, CustomerInfoVO tVO) {
		return auditTrailService.add(ActionTypeConstant.ACTION_TYPE_ADD, ProductInfo.class.getName(), tVO.getCustomerInfoId(), getLoginUserName());
	}
	private AuditTrail createAuditTrailForUpdate(CustomerInfoInput input, CustomerInfoVO tVO) {
		return auditTrailService.add(ActionTypeConstant.ACTION_TYPE_UPDATE, ProductInfo.class.getName(), tVO.getCustomerInfoId(), getLoginUserName());
	}
	private AuditTrail createAuditTrailForDelete(CustomerInfoInput input, CustomerInfoVO tVO) {
		return auditTrailService.add(ActionTypeConstant.ACTION_TYPE_DELETE, ProductInfo.class.getName(), tVO.getCustomerInfoId(), getLoginUserName());
	}

}
