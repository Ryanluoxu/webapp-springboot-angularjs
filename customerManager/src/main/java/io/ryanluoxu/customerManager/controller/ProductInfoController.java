package io.ryanluoxu.customerManager.controller;

import io.ryanluoxu.customerManager.bean.entity.ProductInfo;
import io.ryanluoxu.customerManager.bean.input.ProductInfoInput;
import io.ryanluoxu.customerManager.bean.vo.ProductInfoVO;

public interface ProductInfoController extends BaseController<ProductInfo, ProductInfoVO, ProductInfoInput>{
	void deleteByCompanyInfoId(Long companyInfoId);
}
