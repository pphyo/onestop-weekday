package com.jdc.ck;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/listener")
public class ListenerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var names = getServletContext().getAttributeNames();
		
		while(names.hasMoreElements()) {
			var ele = names.nextElement();
			if(ele.equals("message")) {
				getServletContext().removeAttribute(ele);
			}
		}
		
		resp.sendRedirect("/");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var context = getServletContext();
		context.setAttribute("message", "Attribute is added into servlet context");
		context.setAttribute("data", "Another Attribute is added into servlet context");
		
		context.getRequestDispatcher("/views/listener.jsp").forward(req, resp);
	}

}
