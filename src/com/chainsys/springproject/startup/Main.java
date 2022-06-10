package com.chainsys.springproject.startup;

import com.chainsys.springproject.test.TestAnnotationConfig;
import com.chainsys.springproject.test.TestCar;
import com.chainsys.springproject.test.TestClasspathXml;
import com.chainsys.springproject.test.TestXmlBeanFactory;


public class Main {

	public static void main(String[] args) {
		
//		TestAnnotationConfig.testA();
//		TestXmlBeanFactory.testA();
		TestClasspathXml.testLunchFactory();
		//TestCar.firsttest();
	
	}

}


// First JVM gets loaded
// main method gets executed
// ApplicationContent Is loaded
// ApplicationContent reads xml configuration file
// ApplicationContent pre-loads one object for each bean in the config file if the bean is not marked as lazy-init="true"
// Lazy-init="true" this informs springContainer not to pre-loaded ogbject for this bean
// By default springs early loads object in memory.
// For lazy-init beans objects is created only when the getBean() method is called
// For pre-init beans  getBean() returns the reference of the pre-loaded objects.
// By default only one object for every bean is created(singleton)
// singleton: Atleast one object for every class but not more than one object
// Spring for lazy-init beans creates a singleton objects the first call of getBeans() method and then
// users that objects for future getBean()  method calls.