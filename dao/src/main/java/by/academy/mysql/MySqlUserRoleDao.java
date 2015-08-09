package by.academy.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import by.academy.domain.Role;
import by.academy.domain.User;
import by.academy.domain.UserRole;
import by.academy.mydao.AbstractDao;
import by.academy.mydao.DaoException;
import by.academy.mydao.DaoFactory;

public class MySqlUserRoleDao extends AbstractDao<UserRole, Integer>{
	
	private class PersistUserRole extends UserRole {
        public void setId(int id) {
            super.setId(id);
        }
    }
	
	public MySqlUserRoleDao(Connection connection) {
		super(connection);
	}

	@Override
	public UserRole create() throws DaoException {
        UserRole ur = new UserRole();
        return persist(ur);
	}

	
	@Override
	public String getSelectQuery() {
		return ResourceBundle.getBundle("queries").getString("SelectUserRole");
	}

	@Override
	public String getCreateQuery() {
		return ResourceBundle.getBundle("queries").getString("CreateUserRole");
	}

	@Override
	public String getUpdateQuery() {
		return ResourceBundle.getBundle("queries").getString("UpdateUserRole");
	}

	@Override
	public String getDeleteQuery() {
		return ResourceBundle.getBundle("queries").getString("DeleteUserRole");
	}

	@Override
	protected List<UserRole> parseResultSet(ResultSet rs) throws DaoException {
		LinkedList<UserRole> result = new LinkedList<UserRole>();
        try {
            while (rs.next()) {
                PersistUserRole userRole = new PersistUserRole();
                userRole.setId(rs.getInt("IdUR"));
                userRole.setUserId(rs.getInt("UserId"));
                userRole.setRoleId(rs.getInt("RoleId"));
                result.add(userRole);
            }
        } catch (Exception e) {
            throw new DaoException(e);
        }
        return result;
	}

	@Override
	protected void prepareStatementForUpdate(PreparedStatement statement, UserRole object) throws DaoException {
        try {
            statement.setInt(1, object.getUserId());
            statement.setInt(2, object.getRoleId());
            statement.setInt(2, object.getId());
        } catch (Exception e) {
            throw new DaoException(e);
        }
	}

	@Override
	protected void prepareStatementForInsert(PreparedStatement statement, UserRole object) throws DaoException {
        try {
            statement.setInt(1, object.getUserId());
            statement.setInt(2, object.getRoleId());
        } catch (Exception e) {
            throw new DaoException(e);
        }
		
	}

}
