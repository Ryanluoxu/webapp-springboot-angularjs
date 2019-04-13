package io.ryanluoxu.customerManager.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.ryanluoxu.customerManager.base.constant.RoleConstant;
import io.ryanluoxu.customerManager.base.constant.StatusConstant;
import io.ryanluoxu.customerManager.bean.entity.UserInfo;
import io.ryanluoxu.customerManager.dao.UserInfoDao;
import io.ryanluoxu.customerManager.service.UserInfoService;

@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoDao userInfoDao;

	@Override
	public UserInfo add(UserInfo userInfo) {
		userInfo.setCreatedDate(new Date());
		userInfo.setStatus(StatusConstant.ACTIVE);
		userInfo.setRole(RoleConstant.USER);
		return userInfoDao.add(userInfo);
	}

	@Override
	public UserInfo update(UserInfo userInfo) {
		return userInfoDao.update(userInfo);
	}

	@Override
	public UserInfo deleteById(Long userInfoId) {
		return userInfoDao.deleteById(userInfoId);
	}

	@Override
	public List<UserInfo> findAll() {
		return userInfoDao.findAll();
	}

	@Override
	public UserInfo getById(Long userInfoId) {
		return userInfoDao.getById(userInfoId);
	}

	@Override
	public List<UserInfo> findActive() {
		return userInfoDao.findActive();
	}

	@Override
	public UserInfo getActive(Long userInfoId) {
		return userInfoDao.getActive(userInfoId);
	}

	@Override
	public List<UserInfo> findByUserName(String userName) {
		return userInfoDao.findByUserName(userName);
	}

	@Override
	public UserInfo get(String userName, String status) {
		return userInfoDao.get(userName, status);
	}

}
