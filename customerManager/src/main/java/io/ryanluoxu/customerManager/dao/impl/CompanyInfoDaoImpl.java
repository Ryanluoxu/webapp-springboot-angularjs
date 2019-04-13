package io.ryanluoxu.customerManager.dao.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import io.ryanluoxu.customerManager.base.constant.StatusConstant;
import io.ryanluoxu.customerManager.bean.entity.CompanyInfo;
import io.ryanluoxu.customerManager.dao.CompanyInfoDao;

@Repository
public class CompanyInfoDaoImpl extends GenericDaoImpl<CompanyInfo, Long> implements CompanyInfoDao {

	private static String COMPANY_INFO_ID = "companyInfoId";

	@Override
	public CompanyInfo getActive(Long id) {
		CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
		CriteriaQuery<CompanyInfo> criteriaQuery = criteriaBuilder.createQuery(CompanyInfo.class);
		Root<CompanyInfo> root = criteriaQuery.from(CompanyInfo.class);
		criteriaQuery.select(root);

		criteriaQuery.where(
				criteriaBuilder.and(
						criteriaBuilder.equal(root.get(COMPANY_INFO_ID), id),
						criteriaBuilder.equal(root.get(STATUS), StatusConstant.ACTIVE)
				));		
		
		return getSession().createQuery(criteriaQuery).getSingleResult();	
	}

}