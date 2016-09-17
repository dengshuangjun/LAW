package com.yc.law.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletContextListenerImpl implements ServletContextListener{

	public static String xmlPath;
	public static String footerXmlPath;
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		xmlPath = arg0.getServletContext().getRealPath("xml/style.xml");
		footerXmlPath = arg0.getServletContext().getRealPath("xml/footer.xml");
	}
}
