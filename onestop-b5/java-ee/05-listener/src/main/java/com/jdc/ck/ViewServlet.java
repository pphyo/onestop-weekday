package com.jdc.ck;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({
	"/cookie-view", "/listener-view", "/filter-view"
})
public class ViewServlet extends HttpServlet {

	public static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		
		String view = null;
		
		if(path.equals("/cookie-view")) {
			view = "/views/cookies.jsp";
		} else if(path.equals("/listener-view")) {
			view = "/views/listener.jsp";
		} else {
			view = "/views/filter/home.jsp";
		}
		
		getServletContext().getRequestDispatcher(view).forward(req, resp);
	}
	
}
