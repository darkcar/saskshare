package ca.saskshare.dao;

import ca.saskshare.domain.Contact;

public interface ContactDao {

	void addContact(Contact contact);

	Contact findContact(long productId);

}