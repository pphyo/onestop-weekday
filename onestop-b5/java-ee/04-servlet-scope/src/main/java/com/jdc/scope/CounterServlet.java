package com.jdc.scope;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/counter")
public class CounterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		
		Counter c = new Counter();
		getServletContext().setAttribute("counter", c);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		session.invalidate();
		getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// request scope
		Object obj1 = req.getAttribute("counter");

		if(obj1 != null) {
			Counter c = (Counter) obj1;
			c.countUp();
		} else {
			Counter c = new Counter();
			c.countUp();
			req.setAttribute("counter", c);
		}
		
		// session scope
		HttpSession session = req.getSession(true);
		
		Object obj2 = session.getAttribute("counter");
		
		if(obj2 != null) {
			Counter c = (Counter) obj2;
			c.countUp();
		} else {
			Counter c = new Counter();
			c.countUp();
			session.setAttribute("counter", c);
		}
		
		// application scope
		Object obj3 = getServletContext().getAttribute("counter");
		Counter c = (Counter) obj3;
		c.countUp();
		
		getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
		
	}

}
