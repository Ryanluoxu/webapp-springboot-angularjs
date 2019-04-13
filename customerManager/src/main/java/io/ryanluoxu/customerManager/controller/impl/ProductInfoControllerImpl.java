package io.ryanluoxu.customerManager.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import io.ryanluoxu.customerManager.base.constant.ActionTypeConstant;
import io.ryanluoxu.customerManager.base.constant.StatusConstant;
import io.ryanluoxu.customerManager.base.exception.CommonException;
import io.ryanluoxu.customerManager.base.util.DateTimeUtil;
import io.ryanluoxu.customerManager.bean.entity.AuditTrail;
import io.ryanluoxu.customerManager.bean.entity.CompanyInfo;
import io.ryanluoxu.customerManager.bean.entity.ProductInfo;
import io.ryanluoxu.customerManager.bean.input.ProductInfoInput;
import io.ryanluoxu.customerManager.bean.vo.ProductInfoVO;
import io.ryanluoxu.customerManager.controller.ProductInfoController;

@Service
public class ProductInfoControllerImpl extends BaseControllerImpl<ProductInfo, ProductInfoVO, ProductInfoInput> implements ProductInfoController {

	@Override
	public List<ProductInfoVO> findAll() {
		List<ProductInfoVO> productInfoVOs = new ArrayList<>();
		List<ProductInfo> productInfos = productInfoService.findActive();
		for (ProductInfo productInfo : productInfos) {
			CompanyInfo companyInfo = companyInfoService.getById(productInfo.getCompanyInfoId());
			ProductInfoVO productInfoVO = convertToVO(productInfo);
			productInfoVO.setCompanyName(companyInfo.getCompanyName());
			productInfoVO.setCreatedDate(DateTimeUtil.getString(productInfo.getCreatedDate()));
			productInfoVO.setUpdatedDate(DateTimeUtil.getString(productInfo.getUpdatedDate()));
			productInfoVOs.add(productInfoVO);
		}
		return productInfoVOs;
	}

	@Override
	public ProductInfoVO add(ProductInfoInput productInfoInput) {
		ProductInfoVO productInfoVO = convertToVO(productInfoService.add(convertToBean(productInfoInput)));
		createAuditTrailForAdd(productInfoInput, productInfoVO);
		return productInfoVO;
	}

	@Override
	public ProductInfoVO update(ProductInfoInput productInfoInput) {
		ProductInfo productInfo = productInfoService.getById(productInfoInput.getProductInfoId());
		productInfo.setCompanyInfoId(productInfoInput.getCompanyInfoId());
		productInfo.setProductName(productInfoInput.getProductName());
		ProductInfoVO productInfoVO = convertToVO(productInfoService.update(productInfo));
		createAuditTrailForUpdate(productInfoInput, productInfoVO);
		return productInfoVO;
	}

	@Override
	public ProductInfoVO delete(ProductInfoInput productInfoInput) {
		ProductInfo productInfo = productInfoService.getById(productInfoInput.getProductInfoId());
		productInfo.setStatus(StatusConstant.INACTIVE);
		ProductInfoVO productInfoVO = convertToVO(productInfoService.update(productInfo));
		createAuditTrailForDelete(productInfoInput, productInfoVO);
		return productInfoVO;
	}

	@Override
	public void validate(ProductInfoInput input, String actionType) throws CommonException {
		productInfoValidator.validateMandatoryFields(input, actionType);
		productInfoValidator.validateInputValue(input, actionType);
	}

	@Override
	public void deleteByCompanyInfoId(Long companyInfoId) {
		List<ProductInfo> productInfos = productInfoService.findByCompanyInfoId(companyInfoId);
		for (ProductInfo productInfo : productInfos) {
			delete(convertToInput(productInfo));
		}
	}

	private AuditTrail createAuditTrailForAdd(ProductInfoInput input, ProductInfoVO tVO) {
		return auditTrailService.add(ActionTypeConstant.ACTION_TYPE_ADD, ProductInfo.class.getName(), tVO.getProductInfoId(), getLoginUserName());
	}
	private AuditTrail createAuditTrailForUpdate(ProductInfoInput input, ProductInfoVO tVO) {
		return auditTrailService.add(ActionTypeConstant.ACTION_TYPE_UPDATE, ProductInfo.class.getName(), tVO.getProductInfoId(), getLoginUserName());
	}
	private AuditTrail createAuditTrailForDelete(ProductInfoInput input, ProductInfoVO tVO) {
		return auditTrailService.add(ActionTypeConstant.ACTION_TYPE_DELETE, ProductInfo.class.getName(), tVO.getProductInfoId(), getLoginUserName());
	}

}
