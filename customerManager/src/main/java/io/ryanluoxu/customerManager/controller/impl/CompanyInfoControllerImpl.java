package io.ryanluoxu.customerManager.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.ryanluoxu.customerManager.base.constant.ActionTypeConstant;
import io.ryanluoxu.customerManager.base.constant.CompanyInfoConstant;
import io.ryanluoxu.customerManager.base.exception.CommonException;
import io.ryanluoxu.customerManager.base.util.DateTimeUtil;
import io.ryanluoxu.customerManager.bean.entity.AuditTrail;
import io.ryanluoxu.customerManager.bean.entity.CompanyInfo;
import io.ryanluoxu.customerManager.bean.input.CompanyInfoInput;
import io.ryanluoxu.customerManager.bean.vo.CompanyInfoVO;
import io.ryanluoxu.customerManager.controller.CompanyInfoController;
import io.ryanluoxu.customerManager.controller.ProductInfoController;

@Service
public class CompanyInfoControllerImpl extends BaseControllerImpl<CompanyInfo, CompanyInfoVO, CompanyInfoInput> implements CompanyInfoController {

	@Autowired
	private ProductInfoController productInfoController;

	@Override
	public List<CompanyInfoVO> findAll() {
		List<CompanyInfoVO> companyInfoVOs = new ArrayList<>();
		List<CompanyInfo> companyInfos = companyInfoService.findActive();
		for (CompanyInfo companyInfo : companyInfos) {
			CompanyInfoVO companyInfoVO = convertToVO(companyInfo);
			companyInfoVO.setCreatedDate(DateTimeUtil.getString(companyInfo.getCreatedDate()));
			companyInfoVO.setUpdatedDate(DateTimeUtil.getString(companyInfo.getUpdatedDate()));
			companyInfoVOs.add(companyInfoVO);
		}
		return companyInfoVOs;
	}

	@Override
	public CompanyInfoVO add(CompanyInfoInput companyInfoInput) {
		CompanyInfoVO companyInfoVO = convertToVO(companyInfoService.add(convertToBean(companyInfoInput)));
		createAuditTrailForAdd(companyInfoInput, companyInfoVO);
		return companyInfoVO;
	}

	@Override
	public CompanyInfoVO update(CompanyInfoInput companyInfoInput) {
		CompanyInfo companyInfo = companyInfoService.getById(companyInfoInput.getCompanyInfoId());
		companyInfo.setCompanyName(companyInfoInput.getCompanyName());
		companyInfo.setCountry(companyInfoInput.getCountry());
		CompanyInfoVO companyInfoVO = convertToVO(companyInfoService.update(companyInfo));
		createAuditTrailForUpdate(companyInfoInput, companyInfoVO);
		return companyInfoVO;
	}

	@Override
	public CompanyInfoVO delete(CompanyInfoInput companyInfoInput) {
		CompanyInfo companyInfo = companyInfoService.getById(companyInfoInput.getCompanyInfoId());
		companyInfo.setStatus(CompanyInfoConstant.STATUS_INACTIVE);
		CompanyInfoVO companyInfoVO = convertToVO(companyInfoService.update(companyInfo));
		createAuditTrailForDelete(companyInfoInput, companyInfoVO);
		deleteUnderlyingProductInfo(companyInfoVO);
		return companyInfoVO;
	}

	private void deleteUnderlyingProductInfo(CompanyInfoVO companyInfoVO) {
		productInfoController.deleteByCompanyInfoId(companyInfoVO.getCompanyInfoId());
	}

	@Override
	public void validate(CompanyInfoInput input, String actionType) throws CommonException {
		companyInfoValidator.validateMandatoryFields(input, actionType);
		companyInfoValidator.validateInputValue(input, actionType);
	}

	private AuditTrail createAuditTrailForAdd(CompanyInfoInput input, CompanyInfoVO tVO) {
		return auditTrailService.add(ActionTypeConstant.ACTION_TYPE_ADD, CompanyInfo.class.getName(), tVO.getCompanyInfoId(), getLoginUserName());
	}
	private AuditTrail createAuditTrailForUpdate(CompanyInfoInput input, CompanyInfoVO tVO) {
		return auditTrailService.add(ActionTypeConstant.ACTION_TYPE_UPDATE, CompanyInfo.class.getName(), tVO.getCompanyInfoId(), getLoginUserName());
	}
	private AuditTrail createAuditTrailForDelete(CompanyInfoInput input, CompanyInfoVO tVO) {
		return auditTrailService.add(ActionTypeConstant.ACTION_TYPE_DELETE, CompanyInfo.class.getName(), tVO.getCompanyInfoId(), getLoginUserName());
	}

}
