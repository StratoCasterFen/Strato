package by.academy.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import by.academy.dao.exception.DaoException;
import by.academy.hbutil.ReadProperty;
import by.academy.pojos.Role;
import by.academy.pojos.User;

public class UserDao  extends AbstractHDao<User> implements CustomUserDao {
	static Logger logger= Logger.getLogger(UserDao.class.getName());
	
	public UserDao() {
	}

	public User getUserByNameAndPassword(User user) throws DaoException {
		logger.info("+getUserByNameAndPassword");
		ReadProperty.setPfilename("queries");
		String QUERY = ReadProperty.getValue("UserByNameAndPassword");
		try {
			Query query = super.entityManager
					.createQuery(QUERY)
					.setParameter("name", user.getUserName())
					.setParameter("pass", user.getPassword());
			try {
				Object res = query.getSingleResult();
				return (User) res;
			} catch (NoResultException e) {
				logger.info("not found");
				return null;
			}
		} catch (IllegalArgumentException e) {
			logger.error("rollback transaction. error in JPQL", e);
			throw new DaoException("error in JPQL", e);
		}
	}

	public User getUserByName(String userName) throws DaoException  {
		logger.info("+getUserByName");
		ReadProperty.setPfilename("queries");
		String QUERY = ReadProperty.getValue("UserByName");
		try {
			Query query = super.entityManager
					.createQuery(QUERY)
					.setParameter("name", userName);
			try {
				Object res = query.getSingleResult();
				return (User) res;
			} catch (NoResultException e) {
				logger.info("No user with that name!");
				return null;
			}

		} catch (IllegalArgumentException e) {
			logger.error("rollback transaction. error in JPQL", e);
			throw new DaoException("error in JPQL", e);
		}
	}

	@Override
	public List getRolesForUser(User user) throws DaoException {
		logger.info("+getRolesForUser");
		ReadProperty.setPfilename("queries");
		String QUERY = ReadProperty.getValue("RolesForUser");
		try {
			List<Role> res = super.entityManager.createQuery(QUERY).setParameter("user", user).getResultList();
			return res;
		} catch (IllegalArgumentException e) {
			logger.error("rollback transaction. error in JPQL", e);
			throw new DaoException("error in JPQL", e);			
		}	
	}

}
