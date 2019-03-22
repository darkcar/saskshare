package ca.saskshare.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import ca.saskshare.dao.DaoException;
import ca.saskshare.dao.GalleryDao;
import ca.saskshare.domain.Gallery;
import ca.saskshare.utils.JDBCUtils;

public class GalleryDaoImpl implements GalleryDao {
	
	@Override
	public void addGallery(Gallery gallery) {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtils.getConnection();
			String sql = "INSERT INTO Gallery "
					+ "(uuid, itemId, path, productId) "
					+ "VALUES(?, ?, ?, ?)";
			ps = connection.prepareStatement(sql);
			ps.setString(1, UUID.randomUUID().toString());
			ps.setLong(2, gallery.getItemId());
			ps.setString(3, gallery.getPath());
			ps.setLong(4, gallery.getProductId());
			ps.executeQuery();
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			JDBCUtils.free(resultSet, ps, connection);
		}
	}
	
	@Override
	public List<Gallery> findGalleries(long productId) {
		List<Gallery> galleries = new ArrayList<Gallery>();
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtils.getConnection();
			String sql = "SELECT path, productId FROM Gallery where productId = ?";
			ps = connection.prepareStatement(sql);
			ps.setLong(1, productId);
			resultSet = ps.executeQuery();
			while(resultSet.next()) {
				galleries.add(mappinGallery(resultSet));
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		}
		return galleries;
	}
	
	private Gallery mappinGallery(ResultSet resultSet) throws SQLException {
		Gallery gallery = new Gallery();
		gallery.setPath(resultSet.getString("path"));
		gallery.setProductId(resultSet.getLong("productId"));
		return gallery;
	}
}






