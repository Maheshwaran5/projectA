package com.chainsys.springproject.appconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.chainsys.springproject.beans.Customer;
import com.chainsys.springproject.beans.Employee;
@Configuration
public class AppConfig {
	@Bean
	@Scope(value="prototype")
	public Employee employee() {
		return new Employee();
	}
	@Bean
	public Customer customer() {
		return new Customer();
	}
}