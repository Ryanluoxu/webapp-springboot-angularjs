package io.ryanluoxu.customerManager.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.ryanluoxu.customerManager.base.constant.StatusConstant;
import io.ryanluoxu.customerManager.bean.entity.CompanyInfo;
import io.ryanluoxu.customerManager.dao.CompanyInfoDao;
import io.ryanluoxu.customerManager.service.CompanyInfoService;

@Service
@Transactional
public class CompanyInfoServiceImpl implements CompanyInfoService {

	@Autowired
	private CompanyInfoDao companyInfoDao;

	@Override
	public CompanyInfo add(CompanyInfo companyInfo) {
		companyInfo.setCreatedDate(new Date());
		companyInfo.setCreatedBy(SecurityContextHolder.getContext().getAuthentication().getName());
		companyInfo.setStatus(StatusConstant.ACTIVE);
		return companyInfoDao.add(companyInfo);
	}

	@Override
	public CompanyInfo update(CompanyInfo companyInfo) {
		companyInfo.setUpdatedDate(new Date());
		companyInfo.setUpdatedBy(SecurityContextHolder.getContext().getAuthentication().getName());
		return companyInfoDao.update(companyInfo);
	}

	@Override
	public CompanyInfo deleteById(Long companyInfoId) {
		return companyInfoDao.deleteById(companyInfoId);
	}

	@Override
	public List<CompanyInfo> findAll() {
		return companyInfoDao.findAll();
	}

	@Override
	public CompanyInfo getById(Long companyInfoId) {
		return companyInfoDao.getById(companyInfoId);
	}

	@Override
	public List<CompanyInfo> findActive() {
		return companyInfoDao.findActive();
	}

	@Override
	public CompanyInfo getActive(Long companyInfoId) {
		return companyInfoDao.getActive(companyInfoId);
	}

}
