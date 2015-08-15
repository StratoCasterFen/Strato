package by.academy.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import by.academy.domain.Role;
import by.academy.domain.User;
import by.academy.mydao.AbstractDao;
import by.academy.mydao.DaoException;
import by.academy.mydao.DaoFactory;


public class MySqlRoleDao extends AbstractDao<Role, Integer>{
	
	private class PersistRole extends Role {
        public void setId(int id) {
            super.setId(id);
        }
    }

	public MySqlRoleDao(Connection connection) {
		super(connection);

	}

	@Override
	public Role create() throws DaoException {
        Role r = new Role();
        return persist(r);
	}

	
	@Override
	public String getSelectQuery() {
		return ResourceBundle.getBundle("queries").getString("SelectRole");
	}

	@Override
	public String getCreateQuery() {
		return ResourceBundle.getBundle("queries").getString("CreateRole");
	}

	@Override
	public String getUpdateQuery() {
		return ResourceBundle.getBundle("queries").getString("UpdateRole");
	}

	@Override
	public String getDeleteQuery() {
		return ResourceBundle.getBundle("queries").getString("DeleteRole");
	}

	@Override
	protected List<Role> parseResultSet(ResultSet rs) throws DaoException {
		LinkedList<Role> result = new LinkedList<Role>();
        try {
            while (rs.next()) {
                PersistRole role = new PersistRole();
                role.setId(rs.getInt("id"));
                role.setRoleName(rs.getString("RoleName"));
                result.add(role);
            }
        } catch (Exception e) {
            throw new DaoException(e);
        }
        return result;
	}

	@Override
	protected void prepareStatementForUpdate(PreparedStatement statement, Role object) throws DaoException {
        try {
            statement.setString(1, object.getRoleName());
            statement.setInt(2, object.getId());
        } catch (Exception e) {
            throw new DaoException(e);
        }
	}

	@Override
	protected void prepareStatementForInsert(PreparedStatement statement, Role object) throws DaoException {
		try {
            statement.setString(1, object.getRoleName());
        } catch (Exception e) {
            throw new DaoException(e);
        }
	}

}
