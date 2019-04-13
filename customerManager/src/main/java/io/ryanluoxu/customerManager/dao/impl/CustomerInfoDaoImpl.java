package io.ryanluoxu.customerManager.dao.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import io.ryanluoxu.customerManager.base.constant.StatusConstant;
import io.ryanluoxu.customerManager.bean.entity.CustomerInfo;
import io.ryanluoxu.customerManager.dao.CustomerInfoDao;

@Repository
public class CustomerInfoDaoImpl extends GenericDaoImpl<CustomerInfo, Long> implements CustomerInfoDao {

	private static String CUSTOMER_INFO_ID = "customerInfoId";

	@Override
	public CustomerInfo getActive(Long id) {
		CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
		CriteriaQuery<CustomerInfo> criteriaQuery = criteriaBuilder.createQuery(CustomerInfo.class);
		Root<CustomerInfo> root = criteriaQuery.from(CustomerInfo.class);
		criteriaQuery.select(root);

		criteriaQuery.where(
				criteriaBuilder.and(
						criteriaBuilder.equal(root.get(CUSTOMER_INFO_ID), id),
						criteriaBuilder.equal(root.get(STATUS), StatusConstant.ACTIVE)
				));		
		
		return getSession().createQuery(criteriaQuery).getSingleResult();	
	}

}
