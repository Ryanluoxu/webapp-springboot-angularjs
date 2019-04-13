package io.ryanluoxu.customerManager.controller.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import io.ryanluoxu.customerManager.base.exception.CommonException;
import io.ryanluoxu.customerManager.base.util.DateTimeUtil;
import io.ryanluoxu.customerManager.bean.entity.AuditTrail;
import io.ryanluoxu.customerManager.bean.vo.AuditTrailVO;
import io.ryanluoxu.customerManager.controller.AuditTrailController;

@Service
public class AuditTrailControllerImpl extends BaseControllerImpl<AuditTrail, AuditTrailVO, String> implements AuditTrailController {

	@Override
	public List<AuditTrailVO> findAll() {
		List<AuditTrailVO> auditTrailVOs = new ArrayList<>();
		List<AuditTrail> auditTrails = auditTrailService.findAll();
		for (AuditTrail auditTrail : auditTrails) {
			AuditTrailVO auditTrailVO = convertToVO(auditTrail);
			auditTrailVO.setCreatedDate(DateTimeUtil.getString(auditTrail.getCreatedDate()));
			auditTrailVOs.add(auditTrailVO);
		}
		Collections.reverse(auditTrailVOs);
		return auditTrailVOs;
	}

	@Override
	public void validate(String input, String actionType) throws CommonException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AuditTrailVO add(String input) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AuditTrailVO update(String input) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AuditTrailVO delete(String input) {
		// TODO Auto-generated method stub
		return null;
	}

}
