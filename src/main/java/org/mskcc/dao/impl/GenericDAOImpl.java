package org.mskcc.dao.impl;

import org.mskcc.dao.GenericDAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by gedionz on 4/13/17.
 */
public class GenericDAOImpl<T> implements GenericDAO<T>{
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	protected Class<T> daoType;
	
	public void setDaoType(Class<T> daoType) {
		this.daoType = daoType;
	}
	
	@Override
	public List findAll() {
		return entityManager
				.createQuery(" from " + daoType.getName())
				.getResultList();
	}
	
	@Override
	public T find(long id) {
		return entityManager.find(daoType, id);
	}
	
	@Override
	public void save(T entity) {
		entityManager.persist(entity);
	}
	
	@Override
	public T update(T entity) {
		return entityManager.merge(entity);
	}
	
	@Override
	public void delete(long id) {
		T entity = find(id);
		delete(entity);
	}
	
	@Override
	public void delete(T entity) {
		entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
	}
}
