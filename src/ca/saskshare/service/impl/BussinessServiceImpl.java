package ca.saskshare.service.impl;

import ca.saskshare.dao.ContactDao;
import ca.saskshare.dao.GalleryDao;
import ca.saskshare.dao.ProductDao;
import ca.saskshare.dao.UserDao;
import ca.saskshare.dao.impl.ContactDaoImpl;
import ca.saskshare.dao.impl.GalleryDaoImpl;
import ca.saskshare.dao.impl.ProductDaoImpl;
import ca.saskshare.dao.impl.UserDaoImpl;
import ca.saskshare.domain.Contact;
import ca.saskshare.domain.Gallery;
import ca.saskshare.domain.Product;
import ca.saskshare.domain.User;
import ca.saskshare.service.BusinessService;
import ca.saskshare.service.UserExistException;
import ca.saskshare.utils.ServiceUtils;

public class BussinessServiceImpl implements BusinessService{
	
	private UserDao userDao = new UserDaoImpl();
	private ProductDao productDao = new ProductDaoImpl();
	private GalleryDao galleryDao = new GalleryDaoImpl();
	private ContactDao contactDao = new ContactDaoImpl();
	
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
	
	@Override
	public void addProduct(Product product) {
		productDao.addProduct(product);
	}
	
	
	@Override
	public void addGallery(Gallery gallery) {
		galleryDao.addGallery(gallery);
	}
	
	@Override
	public void addContact(Contact contact) {
		contactDao.addContact(contact);
	}
}
