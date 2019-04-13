package io.ryanluoxu.customerManager.dao.impl;

import org.springframework.stereotype.Repository;

import io.ryanluoxu.customerManager.bean.entity.AuditTrail;
import io.ryanluoxu.customerManager.dao.AuditTrailDao;

@Repository
public class AuditTrailDaoImpl extends GenericDaoImpl<AuditTrail, Long> implements AuditTrailDao {

}
