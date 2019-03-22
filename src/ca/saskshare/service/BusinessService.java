package ca.saskshare.service;

import ca.saskshare.domain.Contact;
import ca.saskshare.domain.Gallery;
import ca.saskshare.domain.Product;
import ca.saskshare.domain.User;

public interface BusinessService {
	public void register(User user) throws UserExistException;
	public User login(String username, String password);
	public void addProduct(Product product);
	public void addGallery(Gallery gallery);
	public void addContact(Contact contact);
}
