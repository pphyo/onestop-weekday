package com.jdc.ck.listener;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class ApplicationScopeListener implements ServletContextListener, ServletContextAttributeListener {
	
	private DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:ss:mm a");
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Context is initialized at " + LocalDateTime.now().format(DTF));
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Context is destroyed at " + LocalDateTime.now().format(DTF));
	}
	
	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		System.out.println("Attribute is added at " + LocalDateTime.now().format(DTF));
	}
	
	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		System.out.println("Attribute is removed at " + LocalDateTime.now().format(DTF));
	}
	
	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		System.out.println("Attribute is replaced at " + LocalDateTime.now().format(DTF));
	}

}
