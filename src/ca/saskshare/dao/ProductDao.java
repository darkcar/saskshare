package ca.saskshare.dao;

import ca.saskshare.domain.Product;

public interface ProductDao {

	// Add New Product
	void addProduct(Product newProduct);

	Product find(String productUrlTitle);

}