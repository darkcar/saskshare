package ca.saskshare.web.UI;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.saskshare.domain.Contact;
import ca.saskshare.domain.Gallery;
import ca.saskshare.domain.Product;
import ca.saskshare.service.impl.BussinessServiceImpl;

@WebServlet("/explore")
public class ExploreUIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter("title");
		String q = request.getParameter("q");
		BussinessServiceImpl bussinessServiceImpl = new BussinessServiceImpl();
		if (title != null) {
			request.setAttribute("pageTitle", title);
			Product product = bussinessServiceImpl.findProduct(title);
			Contact contact = bussinessServiceImpl.findContact(product);
			Gallery gallery = bussinessServiceImpl.findGallery(product);
			request.setAttribute("product", product);
			request.setAttribute("contact", contact);
			request.setAttribute("gallery", gallery);
			request.getRequestDispatcher("/WEB-INF/jsp/detail.jsp").forward(request, response);
			return;
		}
		
		List<Product> products = null;
		
		if (q != null) {
			products = bussinessServiceImpl.getProducts(q);
		} else {
			products = bussinessServiceImpl.getProducts();
		}
		Map<String, List<Gallery>> galleryMap = bussinessServiceImpl.getGalleries(products);
		request.setAttribute("pageTitle", "Explore Local");
		request.setAttribute("products", products);
		request.setAttribute("gallery", galleryMap);
		request.getRequestDispatcher("/WEB-INF/jsp/explore.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
