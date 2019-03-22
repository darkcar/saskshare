package ca.saskshare.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import ca.saskshare.dao.DaoException;
import ca.saskshare.dao.ProductDao;
import ca.saskshare.domain.Product;
import ca.saskshare.utils.JDBCUtils;

public class ProductDaoImpl implements ProductDao {
	
	// Add New Product
	@Override
	public void addProduct(Product newProduct) {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtils.getConnection();
			String sql = "INSERT INTO Product "
					+ "(uuid, productId, title, abstract, description, fromDate, endDate, note, ownerId, urlTitle) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = connection.prepareStatement(sql);
			ps.setString(1, UUID.randomUUID().toString());
			ps.setLong(2, newProduct.getProductId());
			ps.setString(3, newProduct.getTitle());
			ps.setString(4, newProduct.getSummary());
			ps.setString(5, newProduct.getDescription());
			ps.setDate(6, new Date(newProduct.getFromDate().getTime()));
			ps.setDate(7, new Date(newProduct.getEndDate().getTime()));
			ps.setString(8, newProduct.getNote());
			ps.setLong(9, newProduct.getOwnerId());
			ps.setString(10, newProduct.getUrlTitle());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			JDBCUtils.free(resultSet, ps, connection);
		}
	}
	
	@Override
	public Product find(String productUrlTitle) {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		Product product = null;
		try {
			connection = JDBCUtils.getConnection();
			String sql = "SELECT title, abstract, description, fromDate, endDate, note, ownerId, urlTitle"
					+ " FROM Product WHERE urlTitle = ?";
			ps = connection.prepareStatement(sql);
			ps.setString(1, productUrlTitle);
			resultSet = ps.executeQuery();
			while(resultSet.next()) {
				product = mappingProduct(resultSet);
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			JDBCUtils.free(resultSet, ps, connection);
		}
		return product;
	}
	
	private Product mappingProduct(ResultSet resultSet) throws SQLException {
		Product product = new Product();
		product.setTitle(resultSet.getString("title"));
		product.setSummary(resultSet.getString("abstract"));
		product.setDescription(resultSet.getString("description"));
		product.setFromDate(resultSet.getDate("fromDate"));
		product.setEndDate(resultSet.getDate("endDate"));
		product.setNote(resultSet.getString("note"));
		product.setOwnerId(resultSet.getLong("ownerId"));
		product.setUrlTitle(resultSet.getString("urlTitle"));
		return product;
	}
}
