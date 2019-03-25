package ca.saskshare.web.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.saskshare.domain.Schedule;
import ca.saskshare.service.BusinessService;
import ca.saskshare.service.impl.BussinessServiceImpl;

@WebServlet("/bookit")
public class BookProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long productId = Long.parseLong(request.getParameter("productId"));
		long userId = request.getParameter("userId") == "" ? 0 
				: Long.parseLong(request.getParameter("userId"));
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date fromDate = simpleDateFormat.parse(request.getParameter("fromDate"));
			Date endDate = simpleDateFormat.parse(request.getParameter("endDate"));
			String note = "Will add it later";
			Schedule schedule = new Schedule();
			schedule.setProductId(productId);
			schedule.setUserId(userId);
			schedule.setFromDate(fromDate);
			schedule.setEndDate(endDate);
			schedule.setNote(note);
			BusinessService businessService = new BussinessServiceImpl();
			businessService.AddSchedule(schedule);
			request.setAttribute("message", "You've booked the product, and will be confirmed by the owner.");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			return;
		} catch (ParseException e) {
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
