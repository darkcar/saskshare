package ca.saskshare.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import ca.saskshare.dao.ContactDao;
import ca.saskshare.dao.DaoException;
import ca.saskshare.domain.Contact;
import ca.saskshare.domain.Product;
import ca.saskshare.utils.JDBCUtils;

public class ContactDaoImpl implements ContactDao {
	
	@Override
	public void addContact(Contact contact) {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			connection = JDBCUtils.getConnection();
			String sql = "INSERT INTO Contact "
					+ "(uuid, id, productId, email, phoneNumber, address) "
					+ "VALUES (?, ?, ?, ?, ?, ?)";
			ps = connection.prepareStatement(sql);
			ps.setString(1, UUID.randomUUID().toString());
			ps.setLong(2, contact.getId());
			ps.setLong(3, contact.getProductId());
			ps.setString(4, contact.getEmail());
			ps.setString(5, contact.getPhoneNumber());
			ps.setString(6, contact.getAddress());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			JDBCUtils.free(resultSet, ps, connection);
		}
	}
	
	@Override
	public Contact findContact(long productId) {
		Contact contact = null;
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			connection = JDBCUtils.getConnection();
			String sql = "SELECT id, productId, email, phoneNumber, address FROM Contact "
					+ "WHERE productId = ?";
			ps = connection.prepareStatement(sql);
			ps.setLong(1, productId);
			resultSet = ps.executeQuery();
			while(resultSet.next()) {
				contact = mappingContact(resultSet);
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			JDBCUtils.free(resultSet, ps, connection);
		}
		return contact;
	}
	
	@Override
	public Contact findContact(Product product) {
		return findContact(product.getProductId());
	}
	
	private Contact mappingContact(ResultSet resultSet) throws SQLException {
		Contact contact = new Contact();
		contact.setId(resultSet.getLong("id"));
		contact.setProductId(resultSet.getLong("productId"));
		contact.setEmail(resultSet.getString("email"));
		contact.setPhoneNumber(resultSet.getString("phoneNumber"));
		contact.setAddress(resultSet.getString("address"));
		return contact;
	}
}
