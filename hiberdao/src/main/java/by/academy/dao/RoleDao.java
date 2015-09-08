package by.academy.dao;

import java.util.List;

import javax.persistence.EntityTransaction;

import org.apache.log4j.Logger;

import by.academy.hbutil.ReadProperty;
import by.academy.pojos.Role;
import by.academy.pojos.User;

public class RoleDao extends AbstractHDao<Role> implements CustomRoleDao{
	static Logger logger= Logger.getLogger(RoleDao.class.getName());
	
	public RoleDao(){
		
	}

	@Override
	public Role getRoleByName(String name) throws DaoException {
		logger.info("+getRoleByName");
		EntityTransaction tx = super.entityManager.getTransaction();
		tx.begin();
		ReadProperty.setPfilename("queries");
		String QUERY = ReadProperty.getValue("RoleByName");
		try {
			List<Role> res = super.entityManager.createQuery(QUERY).setParameter("name", name).getResultList();
			tx.commit();
			logger.info("commit successfuly");
			return res.get(0);
		} catch (IllegalArgumentException e) {
			tx.rollback();
			logger.error("rollback transaction. error in JPQL", e);
			throw new DaoException("error in JPQL", e);
		}
	}

	@Override
	public List<User> getUsersByRole() {
		// TODO Auto-generated method stub
		return null;
	}



}
