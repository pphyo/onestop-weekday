package com.jdc.ck;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/cookies")
public class CookieServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cookies = req.getCookies();
		for(Cookie ck : cookies) {
			if(ck.getName().equals("myCookie")) {
				req.setAttribute("value", ck.getValue());
			}
		}
		
		getServletContext().getRequestDispatcher("/views/cookies.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		Cookie ck = new Cookie("myCookie", username);
		ck.setMaxAge(30);
		resp.addCookie(ck);
		resp.sendRedirect("/cookies");
	}

}
