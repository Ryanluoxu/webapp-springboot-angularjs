package io.ryanluoxu.customerManager.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import io.ryanluoxu.customerManager.base.constant.StatusConstant;
import io.ryanluoxu.customerManager.bean.entity.ProductInfo;
import io.ryanluoxu.customerManager.dao.ProductInfoDao;

@Repository
public class ProductInfoDaoImpl extends GenericDaoImpl<ProductInfo, Long> implements ProductInfoDao {

	private static String PRODUCT_INFO_ID = "productInfoId";
	private static String COMPANY_INFO_ID = "companyInfoId";

	@Override
	public ProductInfo getActive(Long id) {
		CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
		CriteriaQuery<ProductInfo> criteriaQuery = criteriaBuilder.createQuery(ProductInfo.class);
		Root<ProductInfo> root = criteriaQuery.from(ProductInfo.class);
		criteriaQuery.select(root);

		criteriaQuery.where(
				criteriaBuilder.and(
						criteriaBuilder.equal(root.get(PRODUCT_INFO_ID), id),
						criteriaBuilder.equal(root.get(STATUS), StatusConstant.ACTIVE)
				));		
		
		return getSession().createQuery(criteriaQuery).getSingleResult();	
	}

	@Override
	public List<ProductInfo> findByCompanyInfoId(Long companyInfoId) {
		CriteriaQuery<ProductInfo> criteriaQuery = getCriteriaQuery(QUERY_TYPE_EQUAL, COMPANY_INFO_ID, String.valueOf(companyInfoId));
		return getSession().createQuery(criteriaQuery).getResultList();
	}

}
