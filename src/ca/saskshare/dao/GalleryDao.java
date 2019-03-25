package ca.saskshare.dao;

import java.util.List;

import ca.saskshare.domain.Gallery;
import ca.saskshare.domain.Product;

public interface GalleryDao {

	void addGallery(Gallery gallery);

	List<Gallery> findGalleries(long productId);
	
	Gallery findGallery(Product product);
}