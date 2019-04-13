package io.ryanluoxu.customerManager.service;

import java.util.List;

public interface BaseService<T, ID> {
	T add(T t);
	T update(T t);
	T deleteById(ID id);

	List<T> findAll();
	List<T> findActive();
	T getById(ID id);
	T getActive(ID id);
}
