package com.jdc.ck.filter;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class SecurityFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		
		HttpSession session = request.getSession();
		
		@SuppressWarnings("unchecked")
		var info = (List<String>) session.getAttribute("user");
		
		String sesUsername = null;
		String sesPassword = null;
		
		if(null != info) {
			sesUsername = info.get(0);
			sesPassword = info.get(1);
		}
		
		String initUsername = req.getServletContext().getFilterRegistration("security").getInitParameter("name");
		String initPassword = req.getServletContext().getFilterRegistration("security").getInitParameter("pass");
		
		if(initUsername.equals(sesUsername) && initPassword.equals(sesPassword)) {
			chain.doFilter(request, resp);
		} else {
			
			if(null == sesUsername) {
				request.setAttribute("info", "You don't have permission to access this page. Please Log In First!");
				request.getServletContext().getRequestDispatcher("/views/filter/no-auth.jsp").forward(request, resp);
			} else {
				request.setAttribute("info", "Your Login Information is wrong!");
				request.getRequestDispatcher("./../login").forward(request, resp);
			}
			
		}
		
		
	}

}
