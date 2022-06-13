package com.chainsys.springproject.commanutil;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExceptionManager {
	public void handleException(Exception e,String source,String message) {
		ConfigurableApplicationContext apcontext = new ClassPathXmlApplicationContext("Employee.xml");
		apcontext.getBean(LogManager.class).logException(e,source,message);
		message +="Message: "+e.getMessage();
		apcontext.close();
//		String errorPage=HTMLHelper.getHTMLTemplate("ERROR",message);
//		return errorPage;
	}
}