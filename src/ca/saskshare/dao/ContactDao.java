package ca.saskshare.dao;

import ca.saskshare.domain.Contact;
import ca.saskshare.domain.Product;

public interface ContactDao {

	void addContact(Contact contact);

	Contact findContact(long productId);
	Contact findContact(Product product);
}