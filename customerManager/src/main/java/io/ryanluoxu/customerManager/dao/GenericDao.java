package io.ryanluoxu.customerManager.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, ID extends Serializable> {
	/**
	 * use JpaUtil
	 * 
	T add(T t);
	T update(T t);
	 */

	/**
	 * use SessionFactory
	 * @param t
	 * @return
	 */
	T addOrUpdate(T t);
	T deleteById(ID id);	
	T getById(ID id);
	
	/**
	 * Find
	 */
	List<T> findAll();
	List<T> findActive();
	
}
