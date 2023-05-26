package com.jdc.ck;

import java.io.IOException;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet({"/filter/auth/auth-view", "/filter/login", "/filter/logout"})
public class FilterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = req.getServletPath();
		
		String view = null;
		
		if(path.equals("/filter/login"))
			view = "/views/filter/login.jsp";
		else if(path.equals("/filter/auth/auth-view"))
			view = "/views/filter/auth-view.jsp";
		else {
			HttpSession session = req.getSession(true);
			session.invalidate();
			view = "/filter-view";
		}
		
		getServletContext().getRequestDispatcher(view).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		var session = req.getSession(true);
		
		session.setAttribute("user", Arrays.asList(username, password));
		
		resp.sendRedirect("/filter/auth/auth-view");
	}

}
