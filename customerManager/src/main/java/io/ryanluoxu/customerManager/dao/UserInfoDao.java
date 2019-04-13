package io.ryanluoxu.customerManager.dao;

import java.util.List;

import io.ryanluoxu.customerManager.bean.entity.UserInfo;

public interface UserInfoDao extends GenericDao<UserInfo, Long>{

	UserInfo getActive(Long userInfoId);

	List<UserInfo> findByUserName(String userName);

	UserInfo get(String userName, String status);
 
}
