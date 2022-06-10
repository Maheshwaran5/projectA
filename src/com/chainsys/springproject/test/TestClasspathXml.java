package com.chainsys.springproject.test;

import org.springframework.context.ApplicationContext; //parent
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext; //child

import com.chainsys.springproject.beans.Actor;
import com.chainsys.springproject.beans.Calendar;
import com.chainsys.springproject.beans.Customer;
import com.chainsys.springproject.beans.Employee;
import com.chainsys.springproject.beans.Lunch;
import com.chainsys.springproject.beans.Movie;

import com.chainsys.springproject.beans.Scoreboard;
import com.chainsys.springproject.lifecycle.AnnotationLc;
import com.chainsys.springproject.lifecycle.InitDesposeBean;
import com.chainsys.springproject.lifecycle.LifeCycleBean;
public class TestClasspathXml {
	public static void testA() {
    	Employee emp=new Employee();
    	emp.setId(101);
    	emp.setName("Maheshwaran");
    	emp.print();
    }
    public static void testB() {
    	ApplicationContext apcontext=new ClassPathXmlApplicationContext("beans.xml");
    	//Employee emp=apcontext.getBean(Employee.class);
    	Employee emp=(Employee)apcontext.getBean("emp");
    	emp.setId(101);
    	emp.setName("Maheshwaran");
    	emp.print();
    	Customer c1=(Customer)apcontext.getBean("c1");
    	c1.setId(324);
    	c1.setName("Ayyanar");
    	c1.print();
    }
    public static void testLazy_init() {
    	ApplicationContext apcontext=new ClassPathXmlApplicationContext("beans.xml");
    	// when we use lazy init into that class in beans.xml 
    	// it does not create new object it will use always one object reference
    	// otherwise when we call more times AppContext it will create new object  
    	ApplicationContext apcontext2=new ClassPathXmlApplicationContext("beans.xml");
    	Employee emp=(Employee)apcontext.getBean("emp");
    	Employee emp2=(Employee)apcontext.getBean("emp");
    	//how many times getbean is called is not matter it will always use single object reference
    	Customer c1=(Customer)apcontext.getBean("c1");
    	Customer c2=(Customer)apcontext.getBean("c1");
    	System.out.println(emp.hashCode());
    	System.out.println(emp2.hashCode());
    	System.out.println(c1.hashCode());
    	System.out.println(c2.hashCode());
    	
    	// why it is create only one object even getbeans method calls more than 1 time?
    }
    public static void testPrototype() {
    	ApplicationContext apcontext=new ClassPathXmlApplicationContext("beans.xml");
//    	Actor hero=(Actor)apcontext.getBean("act");
//    	Actor heroine=(Actor)apcontext.getBean("act");
//    	Actor comedian=(Actor)apcontext.getBean("act");
//    	Actor villan=(Actor)apcontext.getBean("act");
////    	System.out.println("");
    }
    public static void testBeanWithConstructors() {
    	ApplicationContext apcontext=new ClassPathXmlApplicationContext("beans.xml");
    }
    public static void testFactory() {
    	ApplicationContext apcontext=new ClassPathXmlApplicationContext("beans.xml");
    	Movie m= new Movie("samayapuram","pri");
    	Scoreboard sb1=(Scoreboard)apcontext.getBean("sb1",Scoreboard.class);
    	Scoreboard sb2=(Scoreboard)apcontext.getBean("sb2",Scoreboard.class);
    	sb1.targetScore=183;
    	System.out.println(sb1.targetScore);
    	
    }
    public static void testcalenderFactory() {
    	ApplicationContext apcontext=new ClassPathXmlApplicationContext("beans.xml");
    	Calendar today=apcontext.getBean (Calendar.class); today.day=9;
    	today.month="june";
    	today.year=2022;
    	System.out.println(today.day);
    	System.out.println(today.month);
    	System.out.println(today.year);
    }
    public static void testLunchFactory() { 
        ApplicationContext ac = new ClassPathXmlApplicationContext("Lunch.xml"); 
        Lunch nilunch=ac.getBean("nilunch", Lunch.class); 
        Lunch chlunch=ac.getBean("chlunch", Lunch.class);
        Lunch nvsilunch=ac.getBean("nvsilunch", Lunch.class);
        Lunch vsilunch=ac.getBean("vsilunch", Lunch.class);
        System.out.println("-----");
        nvsilunch.serve(); 
        System.out.println("-----");
        vsilunch.serve(); 
        System.out.println("-----");
        nilunch.serve(); 
        System.out.println("-----");
        chlunch.serve();
        }
    public static void testSetterDi() {
        ApplicationContext ac1 = new ClassPathXmlApplicationContext("beans.xml");
        Employee emp = ac1.getBean("emp2",Employee.class);
    }
    public static void testLifeCycle() {
    	 ConfigurableApplicationContext ac1 = new ClassPathXmlApplicationContext("Lc.xml");
    	 LifeCycleBean life= ac1.getBean(LifeCycleBean.class);
    	 life.print();
    	 life=null;
//    	 System.gc();
    	 ac1.close();
    	 ac1=null;
    	
    }
    public static void testInitDestroyBean() {
    	ConfigurableApplicationContext ac1 = new ClassPathXmlApplicationContext("Lc.xml");
    	InitDesposeBean init=ac1.getBean(InitDesposeBean.class);
    	init.print();
    	
    }
    public static void testAnnotationLc() {
    	ConfigurableApplicationContext ac1 = new ClassPathXmlApplicationContext("Lc.xml");
    	AnnotationLc ann=ac1.getBean(AnnotationLc.class);
    	ann.print();
    	ann=null;
    	ac1.close();
    }
	
}