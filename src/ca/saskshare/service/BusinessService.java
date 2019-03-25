package ca.saskshare.service;

import java.util.List;
import java.util.Map;

import ca.saskshare.domain.Contact;
import ca.saskshare.domain.Gallery;
import ca.saskshare.domain.Product;
import ca.saskshare.domain.Schedule;
import ca.saskshare.domain.User;

public interface BusinessService {
	public void register(User user) throws UserExistException;
	public User login(String username, String password);
	public void addProduct(Product product);
	public void addGallery(Gallery gallery);
	public void addContact(Contact contact);
	List<Product> getProducts();
	List<Product> getProducts(String keywords);
	List<Gallery> getGalleries(long productId);
	Map<String, List<Gallery>> getGalleries(List<Product> products); 
	
	Product findProduct(String urlTitle);
	Contact findContact(Product product);
	Gallery findGallery(Product product);
	void AddSchedule(Schedule schedule);
}
