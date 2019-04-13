package io.ryanluoxu.customerManager.service;

import java.util.List;

import io.ryanluoxu.customerManager.bean.entity.OrderInfo;

public interface OrderInfoService extends BaseService<OrderInfo, Long>{

	List<OrderInfo> findByCustomerInfoId(Long customerInfoId);

}
