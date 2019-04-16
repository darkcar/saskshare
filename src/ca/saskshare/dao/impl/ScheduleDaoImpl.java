package ca.saskshare.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.UUID;

import ca.saskshare.dao.DaoException;
import ca.saskshare.dao.ScheduleDao;
import ca.saskshare.domain.Schedule;
import ca.saskshare.utils.JDBCUtils;

public class ScheduleDaoImpl implements ScheduleDao {
	
	
	@Override
	public void addSchedule(Schedule schedule) {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtils.getConnection();
			String sql = "INSERT INTO Schedule (uuid, scheduleId, productId, userId, "
					+ "fromDate, endDate, note) VALUES (?, ?, ?, ?, ?, ?, ?"
					+ ")";
			ps = connection.prepareStatement(sql);
			ps.setString(1, UUID.randomUUID().toString());
			ps.setLong(2, new Random().nextLong());
			ps.setLong(3, schedule.getProductId());
			ps.setLong(4, schedule.getUserId());
			ps.setDate(5, new Date(schedule.getFromDate().getTime()));
			ps.setDate(6, new Date(schedule.getEndDate().getTime()));
			ps.setString(7, schedule.getNote());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			JDBCUtils.free(resultSet, ps, connection);
		}
	}
}
