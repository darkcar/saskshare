package junit.test;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import ca.saskshare.dao.ProductDao;
import ca.saskshare.dao.impl.ProductDaoImpl;
import ca.saskshare.domain.Product;

public class ProductDaoTest {
	
	@Test
	public void testAddProduct() {
		Product product = new Product();
		product.setDescription("Here is the description, nice product, but free. You will like it");
		product.setFromDate(new Date());
		product.setEndDate(new Date());
		product.setNote("nothing I need to mention now.");
		product.setOwnerId(100000);
		product.setProductId(100000221);
		product.setSummary("Here is the summary");
		product.setTitle("The product title");
		product.setUrlTitle("the-phone-you-will-like");
		ProductDao productDaoImpl = new ProductDaoImpl();
		productDaoImpl.addProduct(product);
	}
	
	@Test
	public void testFindProduct() {
		String urlTitle = "the-phone-you-will-like";
		ProductDao productDaoImpl = new ProductDaoImpl();
		Product product = productDaoImpl.find(urlTitle);
		System.out.println(product);
	}
	
	@Test
	public void testFindAllProducts() {
		ProductDao productDao = new ProductDaoImpl();
		List<Product> products = productDao.findProducts();
		System.out.println(products);
	}
}
