package com.jdc.commu;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/include")
public class IncludeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Content Type: " + req.getContentType());
		System.out.println("Context Path: " + req.getContextPath());
		System.out.println("Local Port: " + req.getLocalPort());
		System.out.println("Servlet Path: " + req.getServletPath());
		System.out.println();
		
		System.out.println("Context Path: " + getServletContext().getContextPath());
		System.out.println("Character Encoding: " + getServletContext().getRequestCharacterEncoding());
		System.out.println("Servlet Info: " + getServletContext().getServerInfo());
		System.out.println("Context Name: " + getServletContext().getServletContextName());
		System.out.println("Real Path: " + getServletContext().getRealPath("/index.html"));
		
		// include header from name dispatcher
		var nameDisp = getServletContext().getNamedDispatcher("header");
		nameDisp.include(req, resp);
		
		// include body with absolute path
		nameDisp = getServletContext().getRequestDispatcher("/body");
		nameDisp.include(req, resp);
		
		// include footer with relative path
		nameDisp = req.getRequestDispatcher("./footer");
		nameDisp.include(req, resp);
		
		resp.getWriter().append("""
				<p>This is include servlet.</p>
				<a href="/index.html">Home</a>""");
		
	}

}
