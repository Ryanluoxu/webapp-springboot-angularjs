package io.ryanluoxu.customerManager.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import io.ryanluoxu.customerManager.base.constant.StatusConstant;
import io.ryanluoxu.customerManager.bean.entity.OrderInfo;
import io.ryanluoxu.customerManager.dao.OrderInfoDao;

@Repository
public class OrderInfoDaoImpl extends GenericDaoImpl<OrderInfo, Long> implements OrderInfoDao {

	private static String ORDER_INFO_ID = "orderInfoId";
	private static String CUSTOMER_INFO_ID = "customerInfoId";

	@Override
	public OrderInfo getActive(Long id) {
		CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
		CriteriaQuery<OrderInfo> criteriaQuery = criteriaBuilder.createQuery(OrderInfo.class);
		Root<OrderInfo> root = criteriaQuery.from(OrderInfo.class);
		criteriaQuery.select(root);

		criteriaQuery.where(
				criteriaBuilder.and(
						criteriaBuilder.equal(root.get(ORDER_INFO_ID), id),
						criteriaBuilder.equal(root.get(STATUS), StatusConstant.ACTIVE)
				));		
		
		return getSession().createQuery(criteriaQuery).getSingleResult();	
	}

	@Override
	public List<OrderInfo> findByCustomerInfoId(Long customerInfoId) {
		CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
		CriteriaQuery<OrderInfo> criteriaQuery = criteriaBuilder.createQuery(OrderInfo.class);
		Root<OrderInfo> root = criteriaQuery.from(OrderInfo.class);
		criteriaQuery.select(root);

		criteriaQuery.where(
				criteriaBuilder.and(
						criteriaBuilder.equal(root.get(CUSTOMER_INFO_ID), customerInfoId),
						criteriaBuilder.equal(root.get(STATUS), StatusConstant.ACTIVE)
				));		
		
		return getSession().createQuery(criteriaQuery).getResultList();	
	}

}