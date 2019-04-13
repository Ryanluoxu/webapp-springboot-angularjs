package io.ryanluoxu.customerManager.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, ID extends Serializable> {
	/**
	 * use JpaUtil
	 */
	T add(T t);
	/**
	 * use SessionFactory
	 * @param t
	 * @return
	 */
	T addOrUpdate(T t);
	
	/**
	 * Find
	 */
	List<T> findAll();
	List<T> findActive();
	T getById(ID id);
	
	/**
	 * Update
	 */
	T update(T t);
	
	/**
	 * Delete
	 */
	T deleteById(ID id);	
	
}
