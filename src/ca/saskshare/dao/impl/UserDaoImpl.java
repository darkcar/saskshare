package ca.saskshare.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import ca.saskshare.dao.DaoException;
import ca.saskshare.dao.UserDao;
import ca.saskshare.domain.User;
import ca.saskshare.utils.JDBCUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public void add(User user) {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCUtils.getConnection();
			String sql = "INSERT INTO User "
					+ "(uuid, id, username, realname, password, lastAccess, registerDate, isActive) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			ps = connection.prepareStatement(sql);
			ps.setString(1, UUID.randomUUID().toString());
			ps.setLong(2, user.getId());
			ps.setString(3, user.getUsername());
			ps.setString(4, user.getRealname());
			ps.setString(5, user.getPassword());
			ps.setDate(6, new Date(user.getLastAccessDate().getTime()));
			ps.setDate(7, new Date(user.getRegisterDate().getTime()));
			ps.setBoolean(8, user.isActive());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException();
		} finally {
			JDBCUtils.free(resultSet, ps, connection);
		}

	}

	/* (non-Javadoc)
	 * @see ca.saskshare.dao.impl.UserDao#find(java.lang.String, java.lang.String)
	 */
	@Override
	public User find(String username, String password) {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		User user = null;
		try {
			connection = JDBCUtils.getConnection();
			String sql = "SELECT id, username, realname, lastAccess, registerDate, isActive"
					+ " from User where username = ? and password = ?";
			ps = connection.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			resultSet = ps.executeQuery();
			while(resultSet.next()) {
				user = mappingUser(resultSet);
			}
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			JDBCUtils.free(resultSet, ps, connection);
		}
		return user;
	}

	@Override
	public boolean getUser(String username) {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		User user = null;
		try {
			connection = JDBCUtils.getConnection();
			String sql = "SELECT id, username, realname, lastAccess, registerDate, isActive"
					+ " from User where username = ?";
			ps = connection.prepareStatement(sql);
			ps.setString(1, username);
			resultSet = ps.executeQuery();
			while(resultSet.next()) {
				user = mappingUser(resultSet);
			}
			if (user != null) {
				return true;
			}
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		}
		return false;
	}
	
	
	private User mappingUser(ResultSet resultSet) throws SQLException{
		User user = new User();
		user.setId(resultSet.getLong("id"));
		user.setUsername(resultSet.getString("username"));
		user.setRealname(resultSet.getString("realname"));
		user.setLastAccessDate(resultSet.getDate("lastAccess"));
		user.setRegisterDate(resultSet.getDate("registerDate"));
		user.setActive(resultSet.getBoolean("isActive"));
		return user;
	}
	
}
