package ca.saskshare.dao;

import java.util.List;

import ca.saskshare.domain.Gallery;

public interface GalleryDao {

	void addGallery(Gallery gallery);

	List<Gallery> findGalleries(long productId);

}