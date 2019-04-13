package io.ryanluoxu.customerManager.controller;

import java.util.List;

import io.ryanluoxu.customerManager.bean.entity.OrderInfo;
import io.ryanluoxu.customerManager.bean.input.OrderInfoInput;
import io.ryanluoxu.customerManager.bean.vo.OrderInfoVO;

public interface OrderInfoController extends BaseController<OrderInfo, OrderInfoVO, OrderInfoInput> {

	List<OrderInfoVO> findByCustomerInfoId(Long customerInfoId);

}
