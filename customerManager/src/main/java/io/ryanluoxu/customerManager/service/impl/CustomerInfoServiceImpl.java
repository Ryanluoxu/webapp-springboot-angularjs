package io.ryanluoxu.customerManager.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.ryanluoxu.customerManager.base.constant.CustomerInfoConstant;
import io.ryanluoxu.customerManager.bean.entity.CustomerInfo;
import io.ryanluoxu.customerManager.dao.CustomerInfoDao;
import io.ryanluoxu.customerManager.service.CustomerInfoService;

@Service
@Transactional
public class CustomerInfoServiceImpl implements CustomerInfoService {

	@Autowired
	private CustomerInfoDao customerInfoDao;

	@Override
	public CustomerInfo add(CustomerInfo customerInfo) {
		customerInfo.setCreatedDate(new Date());
		customerInfo.setCreatedBy(SecurityContextHolder.getContext().getAuthentication().getName());
		customerInfo.setStatus(CustomerInfoConstant.STATUS_ACTIVE);
		return customerInfoDao.addOrUpdate(customerInfo);
	}

	@Override
	public CustomerInfo update(CustomerInfo customerInfo) {
		customerInfo.setUpdatedBy(SecurityContextHolder.getContext().getAuthentication().getName());
		customerInfo.setUpdatedDate(new Date());
		return customerInfoDao.addOrUpdate(customerInfo);
	}

	@Override
	public CustomerInfo deleteById(Long customerInfoId) {
		return customerInfoDao.deleteById(customerInfoId);
	}

	@Override
	public List<CustomerInfo> findAll() {
		return customerInfoDao.findAll();
	}

	@Override
	public CustomerInfo getById(Long customerInfoId) {
		return customerInfoDao.getById(customerInfoId);
	}

	@Override
	public List<CustomerInfo> findActive() {
		return customerInfoDao.findActive();
	}

	@Override
	public CustomerInfo getActive(Long customerInfoId) {
		return customerInfoDao.getActive(customerInfoId);
	}

}
