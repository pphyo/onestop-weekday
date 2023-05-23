package com.jdc.app;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "controller", urlPatterns = "/servlet")
public class ServletController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/absolute.html").forward(req, resp);
//		req.getRequestDispatcher("relative.html").include(req, resp);
//		resp.getWriter().append("<h1>Hello from Servlet Controller</h1>");
	}

}
