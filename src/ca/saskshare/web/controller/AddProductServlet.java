package ca.saskshare.web.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import ca.saskshare.domain.Contact;
import ca.saskshare.domain.Gallery;
import ca.saskshare.domain.Product;
import ca.saskshare.service.BusinessService;
import ca.saskshare.service.impl.BussinessServiceImpl;

@WebServlet("/addProduct")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isMultiPart = ServletFileUpload.isMultipartContent(request);
		String galleryPath = "";
		Gallery gallery = new Gallery();
		Contact contact = new Contact();
		Product product = new Product();
		long productId = new Random().nextLong();
		gallery.setItemId(new Random().nextLong());
		contact.setId(new Random().nextLong());
		product.setProductId(productId);
		product.setSummary("");
		product.setNote("");
		gallery.setProductId(productId);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		if (isMultiPart) {
			// Upload files 
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			try {
				List<FileItem> items = upload.parseRequest(request);
				Iterator<FileItem> iterator = items.iterator();
				
				while(iterator.hasNext()) {
					FileItem item = iterator.next();
					if (!item.isFormField()) {
						galleryPath = item.getName();
						String root = getServletContext().getRealPath("/");
						File path = new File(root + "/uploads");
						if (!path.exists()) {
							path.mkdirs();
						}
						File uploadedFile = new File(path + "/" + galleryPath);
						item.write(uploadedFile);
					} else {
						String fieldName = item.getFieldName();
						String value = item.getString();
						switch (fieldName) {
						case "title":
							product.setTitle(value);
							break;
						case "fromDate":
							product.setFromDate(simpleDateFormat.parse(value));
							break;
						case "endDate":
							product.setEndDate(simpleDateFormat.parse(value));
							break;
						case "realname":
							System.out.println("realname");
							break;
						case "ownerId":
							product.setOwnerId(value.equals("") ? 0 : Long.parseLong(value));
							break;
						case "email":
							contact.setEmail(value);
							break;
						case "phone":
							contact.setPhoneNumber(value);
							break;
						case "address":
							contact.setAddress(value);
							break;
						case "description":
							product.setDescription(value);
							break;
						default:
							break;
						}
					}
				}
				gallery.setPath(galleryPath);
				BusinessService businessService = new BussinessServiceImpl();
				businessService.addContact(contact);
				businessService.addGallery(gallery);
				businessService.addProduct(product);
				request.setAttribute("message", "Thanks for your sharing! You will be redirected to the explore page in 3 seconds... <meta http-equiv='refresh' content='3;url="
				+ request.getContextPath() + "'>");
				request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
				return;
			} catch (Exception e) {
				e.printStackTrace();
				response.sendRedirect(request.getContextPath() + "/share");
			}
		}
		response.sendRedirect(request.getContextPath() + "/share");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
