package ca.saskshare.dao;

import ca.saskshare.domain.User;

public interface UserDao {

	void add(User user);

	User find(String username, String password);

	boolean getUser(String username);

}