package com.jdc.hello;

import java.io.IOException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/", loadOnStartup = 1)
public class HelloServlet extends GenericServlet {

	private static final long serialVersionUID = 1L;

	public HelloServlet() {
		System.out.println("Constructor");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("init()");
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy()");
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		System.out.println("service()");
		resp.getWriter().append("<h1>Hello Servlet</h1>");
	}

}
