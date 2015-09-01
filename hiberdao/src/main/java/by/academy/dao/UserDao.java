package by.academy.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import by.academy.pojos.User;

public class UserDao  extends AbstractHDao<User> {

//	@Override
//	public List getAll() throws DaoException {
//		
//		return null;
//	}
//	@PersistenceContext
//	protected EntityManager entityManager;
//
//	@Override
//	public User persist(User user) throws DaoException {
//		this.entityManager.persist(user);
//		return user;
//	}
//
//	@Override
//	public User update(User user) throws DaoException {
//		return this.entityManager.merge(user);
//	}
//
//	@Override
//	public void delete(User user) throws DaoException {
//		user = this.entityManager.merge(user);
//		this.entityManager.remove(user);
//	}
//
//	@Override
//	public List getAll() throws DaoException {
//		List users = this.entityManager.createQuery("SELECT u FROM User u")
//				.getResultList();
//		return users;
//	}
//
//	@Override
//	public User getByPK(Integer key) throws DaoException {
//		return this.entityManager.find(User.class, key);
//	}
//
//	public EntityManager getEntityManager() {
//		return entityManager;
//	}
//
//	public void setEntityManager(EntityManager entityManager) {
//		this.entityManager = entityManager;
//	}
}
