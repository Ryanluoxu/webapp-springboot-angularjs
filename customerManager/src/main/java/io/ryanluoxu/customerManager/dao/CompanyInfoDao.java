package io.ryanluoxu.customerManager.dao;

import io.ryanluoxu.customerManager.bean.entity.CompanyInfo;

public interface CompanyInfoDao extends GenericDao<CompanyInfo, Long>{

	CompanyInfo getActive(Long companyInfoId);

}
