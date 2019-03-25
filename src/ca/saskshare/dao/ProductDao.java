package ca.saskshare.dao;

import java.util.List;

import ca.saskshare.domain.Product;

public interface ProductDao {

	// Add New Product
	void addProduct(Product newProduct);

	Product find(String productUrlTitle);

	public List<Product> findProducts();
	
	List<Product> findProducts(String keyWords);
}