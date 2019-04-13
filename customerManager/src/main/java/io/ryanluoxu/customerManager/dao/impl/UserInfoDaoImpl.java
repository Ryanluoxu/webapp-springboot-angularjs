package io.ryanluoxu.customerManager.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import io.ryanluoxu.customerManager.base.constant.StatusConstant;
import io.ryanluoxu.customerManager.bean.entity.UserInfo;
import io.ryanluoxu.customerManager.dao.UserInfoDao;

@Repository
public class UserInfoDaoImpl extends GenericDaoImpl<UserInfo, Long> implements UserInfoDao {

	private static String USER_INFO_ID = "userInfoId";
	private static String USER_NAME = "userName";

	@Override
	public UserInfo getActive(Long id) {
		CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
		CriteriaQuery<UserInfo> criteriaQuery = criteriaBuilder.createQuery(UserInfo.class);
		Root<UserInfo> root = criteriaQuery.from(UserInfo.class);
		criteriaQuery.select(root);

		criteriaQuery.where(
				criteriaBuilder.and(
						criteriaBuilder.equal(root.get(USER_INFO_ID), id),
						criteriaBuilder.equal(root.get(STATUS), StatusConstant.ACTIVE)
				));		
		
		return getSession().createQuery(criteriaQuery).getSingleResult();	
	}

	@Override
	public List<UserInfo> findByUserName(String userName) {
		CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
		CriteriaQuery<UserInfo> criteriaQuery = criteriaBuilder.createQuery(UserInfo.class);
		Root<UserInfo> root = criteriaQuery.from(UserInfo.class);
		criteriaQuery.select(root);

		criteriaQuery.where(
				criteriaBuilder.and(
						criteriaBuilder.equal(root.get(USER_NAME), userName)
				));	
		
		return getSession().createQuery(criteriaQuery).getResultList();				
	}

	@Override
	public UserInfo get(String userName, String status) {
		CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
		CriteriaQuery<UserInfo> criteriaQuery = criteriaBuilder.createQuery(UserInfo.class);
		Root<UserInfo> root = criteriaQuery.from(UserInfo.class);
		criteriaQuery.select(root);

		criteriaQuery.where(
				criteriaBuilder.and(
						criteriaBuilder.equal(root.get(USER_NAME), userName),
						criteriaBuilder.equal(root.get(STATUS), status)
				));		
		List<UserInfo> userInfos = getSession().createQuery(criteriaQuery).getResultList();
		return CollectionUtils.isEmpty(userInfos)? null : userInfos.get(0);
	}

	@Override
	public UserInfo deleteById(Long userInfoId) {
		// TODO Auto-generated method stub
		return null;
	}


}
