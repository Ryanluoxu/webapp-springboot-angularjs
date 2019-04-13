package io.ryanluoxu.customerManager.dao;

import java.util.List;

import io.ryanluoxu.customerManager.bean.entity.ProductInfo;

public interface ProductInfoDao extends GenericDao<ProductInfo, Long>{

	ProductInfo getActive(Long productInfoId);

	List<ProductInfo> findByCompanyInfoId(Long companyInfoId);

}
