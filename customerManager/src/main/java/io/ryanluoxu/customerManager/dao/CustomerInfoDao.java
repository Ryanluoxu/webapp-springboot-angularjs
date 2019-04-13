package io.ryanluoxu.customerManager.dao;

import io.ryanluoxu.customerManager.bean.entity.CustomerInfo;

public interface CustomerInfoDao extends GenericDao<CustomerInfo, Long>{

	CustomerInfo getActive(Long customerInfoId);

}
