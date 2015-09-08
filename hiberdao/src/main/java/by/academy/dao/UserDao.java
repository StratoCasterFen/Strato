package by.academy.dao;

import java.util.List;
import java.util.ResourceBundle;

import javax.persistence.EntityTransaction;

import org.apache.log4j.Logger;
import by.academy.dao.DaoException;
import by.academy.hbutil.ReadProperty;
import by.academy.pojos.User;

public class UserDao  extends AbstractHDao<User> implements CustomUserDao {
	static Logger logger= Logger.getLogger(UserDao.class.getName());
	
	public UserDao() {
	}

	public User getUserByNameAndPassword(User user) throws DaoException {
		logger.info("+getUserByNameAndPassword");
		EntityTransaction tx = super.entityManager.getTransaction();
		tx.begin();
		ReadProperty.setPfilename("queries");
		String QUERY = ReadProperty.getValue("UserByNameAndPassword");
		try {
			List<User> res = super.entityManager.createQuery(QUERY)
					.setParameter("name", user.getUserName())
					.setParameter("pass", user.getPassword()).getResultList();
			tx.commit();
			logger.info("commit successfuly");
			if (res.size() > 0) {
				return res.get(0);
			} else {
				logger.info("not found");
				return null;
			}
		} catch (IllegalArgumentException e) {
			tx.rollback();
			logger.error("rollback transaction. error in JPQL", e);
			throw new DaoException("error in JPQL", e);			
		}	

	//		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
	//		CriteriaQuery<User> query = builder.createQuery(User.class);
	//		Root<User> t = query.from(User.class);
	//		TypedQuery<User> q = entityManager.createQuery(query);
	//		List<User> result = q.getResultList();
			
	}
	
	public User getUserByName(String userName) throws DaoException  {
		logger.info("+getUserByName");
		EntityTransaction tx = super.entityManager.getTransaction();
		tx.begin();
		String QUERY = ReadProperty.getValue("UserByName");
		try {
			List res = super.entityManager.createQuery(QUERY).setParameter("name", userName).getResultList();
			tx.commit();
			logger.info("commit successfuly");
			return (User)res.get(0);
		} catch (IllegalArgumentException e) {
			tx.rollback();
			logger.error("rollback transaction. error in JPQL", e);
			throw new DaoException("error in JPQL", e);			
		}	
	}

	@Override
	public List getRolesForUser(User user) {
		EntityTransaction tx = super.entityManager.getTransaction();
		tx.begin();
//		String QUERY =
//				"SELECT u " +
//				"FROM User u " +
//				"WHERE u.username = :name";
//		List res = super.entityManager.createQuery(QUERY)
//				.setParameter("name", userName)
//				.getResultList();
		tx.commit();
		return null;
	}

}
