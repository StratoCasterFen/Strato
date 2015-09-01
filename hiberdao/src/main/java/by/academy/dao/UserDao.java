package by.academy.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import by.academy.pojos.User;

public class UserDao  implements GenericHDao<User> {
	    @PersistenceContext
	    protected EntityManager emf;

	    public List getAll(){
	        return emf.createQuery("from Users u").getResultList();
	    }

		@Override
		public User create() throws DaoException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public User persist(User object) throws DaoException {
			// TODO Auto-generated method stub
			return null;
		}

//		@Override
//		public User getByPK(PK key) throws DaoException {
//			// TODO Auto-generated method stub
//			return null;
//		}

		@Override
		public void update(User object) throws DaoException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void delete(User object) throws DaoException {
			// TODO Auto-generated method stub
			
		}

}
