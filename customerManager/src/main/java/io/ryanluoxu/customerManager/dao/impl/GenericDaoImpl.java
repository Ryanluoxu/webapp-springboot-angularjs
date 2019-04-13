package io.ryanluoxu.customerManager.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import io.ryanluoxu.customerManager.base.constant.CompanyInfoConstant;
import io.ryanluoxu.customerManager.base.util.ClassUtil;
import io.ryanluoxu.customerManager.base.util.JpaUtil;
import io.ryanluoxu.customerManager.bean.input.QueryInput;
import io.ryanluoxu.customerManager.dao.GenericDao;

public class GenericDaoImpl<T, ID extends Serializable> implements GenericDao<T, ID> {

	@SuppressWarnings("rawtypes")
	protected Class targetClass;
	
	protected String QUERY_TYPE_EQUAL = "equal";
	protected String STATUS = "status";

	@Autowired
	private SessionFactory sessionFactory;

	public GenericDaoImpl() {
		this.targetClass = ClassUtil.getTypeArguments(GenericDaoImpl.class, this.getClass()).get(0);
	}

	protected final Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	protected CriteriaQuery<T> getCriteriaQuery(String queryType, String param, String value) {
		//**creating CriteriaBuilder**
		CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(targetClass);
		Root<T> root = criteriaQuery.from(targetClass);
		criteriaQuery.select(root);

		//**Adding where clause**
		if (QUERY_TYPE_EQUAL.equals(queryType)) {
			criteriaQuery.where(criteriaBuilder.equal(root.get(param), value));			
		}
		
		return criteriaQuery;
	}
	
	@SuppressWarnings({ "unchecked" })
	protected CriteriaQuery<T> getCriteriaQuery(List<QueryInput> queryInputs) {
		//**creating CriteriaBuilder**
		CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(targetClass);
		Root<T> root = criteriaQuery.from(targetClass);
		criteriaQuery.select(root);

		//**Adding where clause**
		if (!CollectionUtils.isEmpty(queryInputs)) {
			for (QueryInput queryInput : queryInputs) {
				if (QUERY_TYPE_EQUAL.equals(queryInput.getQueryType())) {
					criteriaQuery.where(criteriaBuilder.equal(root.get(queryInput.getParam()), queryInput.getValue()));			
				}				
			}
		}
		
		return criteriaQuery;
	}
	

	@Override
	public T add(T t) {
		EntityManager em = JpaUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(t);
		tx.commit();
		em.close();
		return t;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		EntityManager em = JpaUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query query  = em.createQuery("select t from " + targetClass.getName() + " t");
		List<T> list = query.getResultList();
		tx.commit();
		em.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getById(ID id) {
		EntityManager em = JpaUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		T t = (T) em.find(targetClass, id);
		tx.commit();
		em.close();
		return t;
	}

	@Override
	public T update(T t) {
		EntityManager em = JpaUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(t);
		tx.commit();
		em.close();
		return t;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T deleteById(ID id) {
		EntityManager em = JpaUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		T t = (T) em.find(targetClass, id);
		em.remove(t);
		tx.commit();
		em.close();
		return t;
	}

	@Override
	public List<T> findActive() {
		CriteriaQuery<T> criteriaQuery = getCriteriaQuery(QUERY_TYPE_EQUAL, STATUS, CompanyInfoConstant.STATUS_ACTIVE);
		return getSession().createQuery(criteriaQuery).getResultList();		
	}

}
