package io.ryanluoxu.customerManager.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.ryanluoxu.customerManager.base.constant.StatusConstant;
import io.ryanluoxu.customerManager.bean.entity.ProductInfo;
import io.ryanluoxu.customerManager.dao.ProductInfoDao;
import io.ryanluoxu.customerManager.service.ProductInfoService;

@Service
@Transactional
public class ProductInfoServiceImpl implements ProductInfoService {

	@Autowired
	private ProductInfoDao productInfoDao;

	@Override
	public ProductInfo add(ProductInfo productInfo) {
		productInfo.setCreatedDate(new Date());
		productInfo.setCreatedBy(SecurityContextHolder.getContext().getAuthentication().getName());
		productInfo.setStatus(StatusConstant.ACTIVE);
		return productInfoDao.add(productInfo);
	}

	@Override
	public ProductInfo update(ProductInfo productInfo) {
		productInfo.setUpdatedDate(new Date());
		productInfo.setUpdatedBy(SecurityContextHolder.getContext().getAuthentication().getName());
		return productInfoDao.update(productInfo);
	}

	@Override
	public ProductInfo deleteById(Long productInfoId) {
		return productInfoDao.deleteById(productInfoId);
	}

	@Override
	public List<ProductInfo> findAll() {
		return productInfoDao.findAll();
	}

	@Override
	public ProductInfo getById(Long productInfoId) {
		return productInfoDao.getById(productInfoId);
	}

	@Override
	public List<ProductInfo> findActive() {
		return productInfoDao.findActive();
	}

	@Override
	public ProductInfo getActive(Long productInfoId) {
		return productInfoDao.getActive(productInfoId);
	}

	@Override
	public List<ProductInfo> findByCompanyInfoId(Long companyInfoId) {
		return productInfoDao.findByCompanyInfoId(companyInfoId);
	}

}
