// First JVM gets loaded
	// Main method gets executed
	// ApplicationContext is loaded
	// ApplicationContext reads xml configuration file
	// ApplicationContext pre-loads one object for each bean in the config file
	// lazy-init="true" This informs springContainer not to pre-load object for this bean // By default Spring early loads objects in memory.
	// For lazy-init beans object is created only when the getBean() method is called.
	// For pre-init beans getBean() returns the reference of the pre-loaded object
	// By default only one object for every bean is created (singleton)
	// singleton: Atleast one object for every class but not more than one object
	// Spring for lazy-init beans creates a singleton object on firstcall of getBeans() method
	// and then uses that object for future getBean() method calls 
	
	depends-on="mrf,fourstroke" (here mrf first instantiated and then fourstroke instantiated)
	   depends-on should not be used with prototype
	   depends-on are suitable for singleton Beans
	   The depends-on attribute can explicitly force one or more beans to be initialized before the bean using this element is initialized.
	   To express a dependency on multiple beans, supply a list of bean names as the value of the depends-on attribute, with commas, whitespace and semicolons, used as valid delimiters.
LifeCycleMethods:  
	1. init-method is post object creation 
	2. destroy-method is pre object destruction
	init-method="" this method is executed immediately after the constructor.
	  -This method can be used to setup the object before it is ready for service calls
	destroy=method is only working with singleton.
	destroy-method is executed before garbage collector call
	when an object start init-method runs then it will run destroy-method when set to null.
	
	Spring does not manage the complete lifecycle of a prototype bean: the container instantiates,
	configures, decorates and otherwise assembles a prototype object, hands it to the client and
	then has no further knowledge of that prototype instance. 
	For releasing resources try to implement a custom bean post processor.