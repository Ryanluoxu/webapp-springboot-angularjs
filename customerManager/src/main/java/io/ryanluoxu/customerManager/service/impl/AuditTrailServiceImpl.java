package io.ryanluoxu.customerManager.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.ryanluoxu.customerManager.base.util.ActionUtil;
import io.ryanluoxu.customerManager.bean.entity.AuditTrail;
import io.ryanluoxu.customerManager.dao.AuditTrailDao;
import io.ryanluoxu.customerManager.service.AuditTrailService;

@Service
@Transactional
public class AuditTrailServiceImpl implements AuditTrailService {

	@Autowired
	private AuditTrailDao auditTrailDao;

	@Override
	public AuditTrail add(AuditTrail auditTrail) {
		auditTrail.setCreatedDate(new Date());
//		return auditTrailDao.add(auditTrail);
		return auditTrailDao.addOrUpdate(auditTrail);
	}

	@Override
	public List<AuditTrail> findAll() {
		return auditTrailDao.findAll();
	}

	@Override
	public AuditTrail getById(Long auditTrailId) {
		return auditTrailDao.getById(auditTrailId);
	}

	@Override
	public AuditTrail add(String actionType, String action) {
		AuditTrail auditTrail = new AuditTrail();
		auditTrail.setAction(action);
		auditTrail.setActionType(actionType);
		return add(auditTrail);
	}

	@Override
	public AuditTrail update(AuditTrail t) {
		return null;
	}

	@Override
	public AuditTrail deleteById(Long id) {
		return null;
	}

	@Override
	public List<AuditTrail> findActive() {
		return null;
	}

	@Override
	public AuditTrail getActive(Long id) {
		return null;
	}

	@Override
	public AuditTrail add(String actionType, String action, String loginUserName) {
		AuditTrail auditTrail = new AuditTrail();
		auditTrail.setAction(action);
		auditTrail.setActionType(actionType);
		auditTrail.setUserName(loginUserName);
		return add(auditTrail);
	}

	@Override
	public AuditTrail add(String actionType, String className, Long companyInfoId, String loginUserName) {
		String action = ActionUtil.getString(actionType, className, companyInfoId, loginUserName);
		return add(actionType, action, loginUserName);
	}

}
