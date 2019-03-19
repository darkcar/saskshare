package ca.saskshare.service;

import ca.saskshare.domain.User;

public interface BusinessService {
	public void register(User user) throws UserExistException;
	public User login(String username, String password);
}
