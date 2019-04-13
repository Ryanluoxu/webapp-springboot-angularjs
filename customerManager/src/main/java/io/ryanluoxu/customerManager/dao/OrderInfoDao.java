package io.ryanluoxu.customerManager.dao;

import java.util.List;

import io.ryanluoxu.customerManager.bean.entity.OrderInfo;

public interface OrderInfoDao extends GenericDao<OrderInfo, Long>{

	OrderInfo getActive(Long companyInfoId);

	List<OrderInfo> findByCustomerInfoId(Long customerInfoId);

}
