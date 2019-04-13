package io.ryanluoxu.customerManager.service;

import java.util.List;

import io.ryanluoxu.customerManager.bean.entity.UserInfo;

public interface UserInfoService extends BaseService<UserInfo, Long>{

	List<UserInfo> findByUserName(String userName);

	UserInfo get(String userName, String status);

}
