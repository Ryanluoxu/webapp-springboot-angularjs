package io.ryanluoxu.customerManager.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import io.ryanluoxu.customerManager.base.constant.ActionTypeConstant;
import io.ryanluoxu.customerManager.base.constant.StatusConstant;
import io.ryanluoxu.customerManager.base.exception.CommonException;
import io.ryanluoxu.customerManager.base.util.DateTimeUtil;
import io.ryanluoxu.customerManager.bean.entity.AuditTrail;
import io.ryanluoxu.customerManager.bean.entity.CustomerInfo;
import io.ryanluoxu.customerManager.bean.entity.OrderInfo;
import io.ryanluoxu.customerManager.bean.entity.ProductInfo;
import io.ryanluoxu.customerManager.bean.input.OrderInfoInput;
import io.ryanluoxu.customerManager.bean.vo.OrderInfoVO;
import io.ryanluoxu.customerManager.controller.OrderInfoController;

@Service
public class OrderInfoControllerImpl extends BaseControllerImpl<OrderInfo, OrderInfoVO, OrderInfoInput> implements OrderInfoController {

	@Override
	public List<OrderInfoVO> findAll() {
		List<OrderInfoVO> orderInfoVOs = new ArrayList<>();
		List<OrderInfo> orderInfos = orderInfoService.findActive();
		for (OrderInfo orderInfo : orderInfos) {
			orderInfoVOs.add(populateVO(orderInfo));
		}
		return orderInfoVOs;
	}

	@Override
	public OrderInfoVO add(OrderInfoInput orderInfoInput) {
		OrderInfoVO orderInfoVO = convertToVO(orderInfoService.add(convertToBean(orderInfoInput)));
		createAuditTrailForAdd(orderInfoInput, orderInfoVO);
		return orderInfoVO;
	}

	@Override
	public OrderInfoVO update(OrderInfoInput orderInfoInput) {
		OrderInfo orderInfo = orderInfoService.getById(orderInfoInput.getOrderInfoId());
		orderInfo.setCustomerInfoId(orderInfoInput.getCustomerInfoId());
		orderInfo.setProductInfoId(orderInfoInput.getProductInfoId());
		orderInfo.setPaymentMode(orderInfoInput.getPaymentMode());
		orderInfo.setProfit(orderInfoInput.getProfit());
		orderInfo.setQuantity(orderInfoInput.getQuantity());
		orderInfo.setUnitPrice(orderInfoInput.getUnitPrice());
		OrderInfoVO orderInfoVO = convertToVO(orderInfoService.update(orderInfo));
		createAuditTrailForUpdate(orderInfoInput, orderInfoVO);
		return orderInfoVO;
	}

	@Override
	public OrderInfoVO delete(OrderInfoInput orderInfoInput) {
		OrderInfo orderInfo = orderInfoService.getById(orderInfoInput.getOrderInfoId());
		orderInfo.setStatus(StatusConstant.INACTIVE);
		OrderInfoVO orderInfoVO = convertToVO(orderInfoService.update(orderInfo));
		createAuditTrailForDelete(orderInfoInput, orderInfoVO);
		return orderInfoVO;
	}

	@Override
	public void validate(OrderInfoInput input, String actionType) throws CommonException {
		orderInfoValidator.validateMandatoryFields(input, actionType);
		orderInfoValidator.validateInputValue(input, actionType);
	}

	@Override
	public List<OrderInfoVO> findByCustomerInfoId(Long customerInfoId) {
		List<OrderInfoVO> orderInfoVOs = new ArrayList<>();
		List<OrderInfo> orderInfos = orderInfoService.findByCustomerInfoId(customerInfoId);
		for (OrderInfo orderInfo : orderInfos) {
			orderInfoVOs.add(populateVO(orderInfo));
		}
		return orderInfoVOs;
	}

	private OrderInfoVO populateVO(OrderInfo orderInfo) {
		OrderInfoVO orderInfoVO = convertToVO(orderInfo);
		ProductInfo productInfo = productInfoService.getById(orderInfo.getProductInfoId());
		CustomerInfo customerInfo = customerInfoService.getById(orderInfo.getCustomerInfoId());
		orderInfoVO.setCustomerName(customerInfo.getCustomerName());
		orderInfoVO.setProductName(productInfo.getProductName());
		orderInfoVO.setCreatedDate(DateTimeUtil.getString(orderInfo.getCreatedDate()));
		orderInfoVO.setUpdatedDate(DateTimeUtil.getString(orderInfo.getUpdatedDate()));
		return orderInfoVO;
	}
	private AuditTrail createAuditTrailForAdd(OrderInfoInput input, OrderInfoVO tVO) {
		return auditTrailService.add(ActionTypeConstant.ACTION_TYPE_ADD, ProductInfo.class.getName(), tVO.getOrderInfoId(), getLoginUserName());
	}
	private AuditTrail createAuditTrailForUpdate(OrderInfoInput input, OrderInfoVO tVO) {
		return auditTrailService.add(ActionTypeConstant.ACTION_TYPE_UPDATE, ProductInfo.class.getName(), tVO.getOrderInfoId(), getLoginUserName());
	}
	private AuditTrail createAuditTrailForDelete(OrderInfoInput input, OrderInfoVO tVO) {
		return auditTrailService.add(ActionTypeConstant.ACTION_TYPE_DELETE, ProductInfo.class.getName(), tVO.getOrderInfoId(), getLoginUserName());
	}

}
