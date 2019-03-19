package junit.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import org.junit.jupiter.api.Test;

import ca.saskshare.dao.impl.UserDaoImpl;
import ca.saskshare.domain.User;
import ca.saskshare.utils.JDBCUtils;

public class UserDaoTest {
	
	@Test
	public void testConnection() {
		try {
			Connection connection = JDBCUtils.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * from User");
			if (resultSet == null) {
				System.out.println("No result");
			}
			while(resultSet.next()) {
				System.out.println(resultSet.getLong("id"));
			}
			JDBCUtils.free(resultSet, statement, connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
	}

	@Test
	public void testAddUser() {
		User user = new User();
		user.setId(1);
		user.setUsername("frankwang");
		user.setRealname("Frank Wang");
		user.setPassword("123456");
		user.setActive(true);
		user.setRegisterDate(new Date());
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		userDaoImpl.add(user);
	}
	
	@Test
	public void testFindUser() {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		User user = userDaoImpl.find("frankwang", "123456");
		System.out.println(user);
	}
	
	@Test
	public void testFindUserByName() {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		boolean isFound = userDaoImpl.getUser("frankwang");
		System.out.println(isFound);
	}
	
}
