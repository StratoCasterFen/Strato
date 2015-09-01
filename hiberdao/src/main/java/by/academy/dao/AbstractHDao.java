package by.academy.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;

import by.academy.pojos.User;



public abstract class AbstractHDao<T> implements GenericHDao<T> {
	static Logger logger= Logger.getLogger(AbstractHDao.class.getName());
	
	@PersistenceContext
	protected EntityManager entityManager;
	protected Class<T> entityClass;
	
	public AbstractHDao() {	
		ParameterizedType gSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<T>) gSuperclass.getActualTypeArguments()[0];
	}
	
	@Override
	public T persist(T object) throws DaoException {
		this.entityManager.persist(object);
		return null;
	}
	@Override
	public T update(T object) throws DaoException {
		return this.entityManager.merge(object);
	}

	@Override
	public void delete(T object) throws DaoException {
		object = this.entityManager.merge(object);
		this.entityManager.remove(object);
	}
	@Override
	public T getByPK(Integer key) throws DaoException {
		return this.entityManager.find(entityClass, key);
	}
	
	@Override
	public List getAll() throws DaoException {
		return null;
//		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
//		CriteriaQuery<T> query = builder.createQuery(entityClass);
//		Root<T> t = query.from(entityClass);  
//		TypedQuery<T> q=entityManager.createQuery(query);   
//		List<T> result = q.getResultList();
//		return result;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
