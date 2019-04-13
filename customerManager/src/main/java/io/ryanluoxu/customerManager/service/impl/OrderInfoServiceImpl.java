package io.ryanluoxu.customerManager.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.ryanluoxu.customerManager.base.constant.StatusConstant;
import io.ryanluoxu.customerManager.bean.entity.OrderInfo;
import io.ryanluoxu.customerManager.dao.OrderInfoDao;
import io.ryanluoxu.customerManager.service.OrderInfoService;

@Service
@Transactional
public class OrderInfoServiceImpl implements OrderInfoService {

	@Autowired
	private OrderInfoDao orderInfoDao;

	@Override
	public OrderInfo add(OrderInfo orderInfo) {
		orderInfo.setCreatedDate(new Date());
		orderInfo.setCreatedBy(SecurityContextHolder.getContext().getAuthentication().getName());
		orderInfo.setStatus(StatusConstant.ACTIVE);
		return orderInfoDao.add(orderInfo);
	}

	@Override
	public OrderInfo update(OrderInfo orderInfo) {
		orderInfo.setUpdatedDate(new Date());
		orderInfo.setUpdatedBy(SecurityContextHolder.getContext().getAuthentication().getName());
		return orderInfoDao.update(orderInfo);
	}

	@Override
	public OrderInfo deleteById(Long orderInfoId) {
		return orderInfoDao.deleteById(orderInfoId);
	}

	@Override
	public List<OrderInfo> findAll() {
		return orderInfoDao.findAll();
	}

	@Override
	public OrderInfo getById(Long orderInfoId) {
		return orderInfoDao.getById(orderInfoId);
	}

	@Override
	public List<OrderInfo> findActive() {
		return orderInfoDao.findActive();
	}

	@Override
	public OrderInfo getActive(Long orderInfoId) {
		return orderInfoDao.getActive(orderInfoId);
	}

	@Override
	public List<OrderInfo> findByCustomerInfoId(Long customerInfoId) {
		return orderInfoDao.findByCustomerInfoId(customerInfoId);
	}

}
