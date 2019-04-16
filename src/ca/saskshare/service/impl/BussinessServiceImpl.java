package ca.saskshare.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.saskshare.dao.ContactDao;
import ca.saskshare.dao.GalleryDao;
import ca.saskshare.dao.ProductDao;
import ca.saskshare.dao.ScheduleDao;
import ca.saskshare.dao.UserDao;
import ca.saskshare.dao.impl.ContactDaoImpl;
import ca.saskshare.dao.impl.GalleryDaoImpl;
import ca.saskshare.dao.impl.ProductDaoImpl;
import ca.saskshare.dao.impl.ScheduleDaoImpl;
import ca.saskshare.dao.impl.UserDaoImpl;
import ca.saskshare.domain.Contact;
import ca.saskshare.domain.Gallery;
import ca.saskshare.domain.Product;
import ca.saskshare.domain.Schedule;
import ca.saskshare.domain.User;
import ca.saskshare.service.BusinessService;
import ca.saskshare.service.UserExistException;
import ca.saskshare.utils.ServiceUtils;

public class BussinessServiceImpl implements BusinessService {

	private UserDao userDao = new UserDaoImpl();
	private ProductDao productDao = new ProductDaoImpl();
	private GalleryDao galleryDao = new GalleryDaoImpl();
	private ContactDao contactDao = new ContactDaoImpl();
	private ScheduleDao scheduleDao = new ScheduleDaoImpl();
	
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

	@Override
	public List<Product> getProducts() {
		return productDao.findProducts();
	}
	
	@Override
	public List<Gallery> getGalleries(long productId) {
		return galleryDao.findGalleries(productId);
	}
	
	
	@Override
	public Map<String, List<Gallery>> getGalleries(List<Product> products) {
		Map<String, List<Gallery>> galleryMap = new HashMap<String, List<Gallery>>();
		for (int i = 0; i < products.size(); i++) {
			long productId = products.get(i).getProductId();
			galleryMap.put(productId + "", getGalleries(productId));
		}
		return galleryMap;
	}
	
	@Override
	public Product findProduct(String urlTitle) {
		return productDao.find(urlTitle);
	}
	
	@Override
	public Contact findContact(Product product) {
		return contactDao.findContact(product);
	}
	
	@Override 
	public Gallery findGallery(Product product) {
		return galleryDao.findGallery(product);
	}
	
	@Override
	public List<Product> getProducts(String keywords) {
		return productDao.findProducts(keywords);
	}
	
	@Override
	public void AddSchedule(Schedule schedule) {
		scheduleDao.addSchedule(schedule);
	}
}
