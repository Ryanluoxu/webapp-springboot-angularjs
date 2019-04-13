package io.ryanluoxu.customerManager.service;

import java.util.List;

import io.ryanluoxu.customerManager.bean.entity.ProductInfo;

public interface ProductInfoService extends BaseService<ProductInfo, Long>{
	List<ProductInfo> findByCompanyInfoId(Long companyInfoId);

}
