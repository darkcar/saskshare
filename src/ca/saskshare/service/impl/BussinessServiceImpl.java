package ca.saskshare.service.impl;

import ca.saskshare.dao.UserDao;
import ca.saskshare.dao.impl.UserDaoImpl;
import ca.saskshare.domain.User;
import ca.saskshare.service.BusinessService;
import ca.saskshare.service.UserExistException;
import ca.saskshare.utils.ServiceUtils;

public class BussinessServiceImpl implements BusinessService{
	
	private UserDao userDao = new UserDaoImpl();
	
	@Override
	public void register(User user) throws UserExistException {
		boolean isExist = userDao.getUser(user.getUsername());
		if (isExist) {
			throw new UserExistException(); 
		} else {
			user.setPassword(ServiceUtils.md5(user.getPassword()));
			userDao.add(user);
		}
	}

	@Override
	public User login(String username, String password) {
		password = ServiceUtils.md5(password);
		return userDao.find(username, password);
	}
	
}
