package by.academy.dao;

import java.util.List;

import javax.persistence.EntityTransaction;
import by.academy.dao.DaoException;
import by.academy.pojos.User;

public class UserDao  extends AbstractHDao<User> implements CustomUserDao {
	//@PersistenceContext
	//protected EntityManager entityManager;
	
	public UserDao() {
	}

	public User getUserByNameAndPassword(User user) throws DaoException {
		EntityTransaction tx = super.entityManager.getTransaction();
		tx.begin();
		String QUERY =
				"SELECT u " +
				"FROM User u " +
				"WHERE u.username = :name AND u.password = :pass";
		List<User> res = super.entityManager.createQuery(QUERY)
				.setParameter("name", user.getUserName())
				.setParameter("pass", user.getPassword())
				.getResultList();
		
		tx.commit();
		return res.get(0);

	//		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
	//		CriteriaQuery<User> query = builder.createQuery(User.class);
	//		Root<User> t = query.from(User.class);
	//		TypedQuery<User> q = entityManager.createQuery(query);
	//		List<User> result = q.getResultList();
			
	}
	
	public User getUserByName(String userName) throws DaoException {
		EntityTransaction tx = super.entityManager.getTransaction();
		tx.begin();
		String QUERY =
				"SELECT u " +
				"FROM User u " +
				"WHERE u.username = :name";
		List res = super.entityManager.createQuery(QUERY)
				.setParameter("name", userName)
				.getResultList();
		tx.commit();
		return (User)res.get(0);
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
