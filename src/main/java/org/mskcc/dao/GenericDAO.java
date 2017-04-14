package org.mskcc.dao;

import java.util.List;

/**
 * Created by gedionz on 4/13/17.
 */
public interface GenericDAO<T> {
	List<T> findAll();
	T find(long id);
	void save(T entity);
	T update(T entity);
	void delete(long id);
	void delete(T entity);
}
