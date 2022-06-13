package com.chainsys.springproject.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Scanner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chainsys.springproject.commanutil.ExceptionManager;
import com.chainsys.springproject.commanutil.InvalidInputDataException;
import com.chainsys.springproject.commanutil.Validator;
import com.chainsys.springproject.dao.Employee;
import com.chainsys.springproject.dao.EmployeeDao;


public class EmployeeSprings {
	
	private Scanner sc;
	private ConfigurableApplicationContext apcontext;
	public Scanner getSc() {
		return sc;
	}

	public void setSc(Scanner sc) {
		this.sc = sc;
	}

	public ConfigurableApplicationContext getApcontext() {
		return apcontext;
	}

	public void setApcontext(ConfigurableApplicationContext apcontext) {
		this.apcontext = apcontext;
	}

	public void GetEmplyeeById() {
//		apcontext = new ClassPathXmlApplicationContext("Employee.xml");
//		sc=new Scanner(System.in);// TODO 
		String source = "GetEmployee";
		String message = "Error while " + source + " ";
		System.out.println("Enter the Employee id:");
		int emp_id=0;
		try {
			emp_id=sc.nextInt();
			apcontext.getBean(Validator.class).CheckNumberForGreaterThanZero(emp_id);
		}catch(InvalidInputDataException e) {
			message += "\n Error in Employee id input ";
			apcontext.getBean(ExceptionManager.class).handleException(e, source, message);
			System.out.println(message);
			close();
			return;
		}
//		Employee emp=EmployeeDao.getEmployeeById(emp_id);
		
		EmployeeDao empdao=apcontext.getBean(EmployeeDao.class);
		Employee emp=empdao.getEmployeeById(emp_id);
		System.out.println("Employee id:"+emp.getEmp_id());
		System.out.println("Employee First Name:"+emp.getFirst_name());
		System.out.println("Employee last Name :"+emp.getLast_name());
		System.out.println("Employee hired date:"+emp.getHire_date());
		System.out.println("Employee job_id:"+emp.getJob_id());
		System.out.println("Employee Salary:"+emp.getSalary());
		close();
	}

	public void addNewEmployee() {
		sc= new Scanner(System.in);
			String source = "AddNewEmployee";
			String message = "Error while " + source + " ";
			//apcontext = new ClassPathXmlApplicationContext("Employee.xml");
			Employee emp = apcontext.getBean(Employee.class);
			Validator val=apcontext.getBean(Validator.class);
			ExceptionManager exM=apcontext.getBean(ExceptionManager.class);
			System.out.println("Enter the Employee id: ");
			try {
            String id = sc.nextLine();
				try {
					val.checkStringForParse(id);
				} catch (InvalidInputDataException e) {
					message += "\n Error in Employee id input ";
					exM.handleException(e, source, message);
					System.out.println(message);
					close();
					 ;
					return; // It terminates the Code execution beyond this point
				}
				int id1 = Integer.parseInt(id);
				try {
					val.CheckNumberForGreaterThanZero(id1);
				} catch (InvalidInputDataException e) {
					message += "\n Error in Employee id input ";
					exM.handleException(e, source, message);
					System.out.print(message);
					close();
					return;
				}
				emp.setEmp_id(id1);
				System.out.println("Enter the First Name of the Employee:");
				String emp_Firstname=sc.nextLine();
				try {
					val.checkStringOnly(emp_Firstname);
				} catch (InvalidInputDataException e) {
					message += "\n Error in First Name input ";
					exM.handleException(e, source, message);
					System.out.print(message);
					close();
					return;
				}
				emp.setFirst_name(emp_Firstname);
				System.out.println("Enter the Last Name of the Employee:");
				String emp_LastName = sc.nextLine();
				try {
					val.checkStringOnly(emp_LastName);
				} catch (InvalidInputDataException e) {
					message += "\n Error in Last Name input ";
					exM.handleException(e, source, message);
					System.out.print(message);
					close();
					return;
				}
				emp.setLast_name(emp_LastName);
				System.out.println("Enter email:");
				String emp_email = sc.nextLine();
				try {
					val.checkMail(emp_email);
				} catch (InvalidInputDataException e) {
					message += "\\n Error in email input ";
					exM.handleException(e, source, message);
					System.out.print(message);
					close();
					return;
				}
				emp.setEmail(emp_email);
				SimpleDateFormat hire_dateFormate = new SimpleDateFormat("dd/MM/yyyy");
				System.out.println("Enter the Hire Date:");
				String emp_HireDate = sc.nextLine();
				// Date hire_date=hire_dateFormate.parse(emp_HireDate);

				try {
					val.checkDateFormat(emp_HireDate);
				} catch (InvalidInputDataException e) {
					message += "\n Error in Hire Date input ";
					exM.handleException(e, source, message);
					System.out.print(message);
					close();
					return;
				}
				try {
					emp.setHire_date(hire_dateFormate.parse(emp_HireDate));
				} catch (ParseException e) {
					message += "\n Error in Hire Date input ";
					exM.handleException(e, source, message);
					System.out.print(message);
					close();
					return;
				}
				System.out.println("Enter Job Id: ");
				String emp_Job_id =sc.nextLine();
				try {
					val.checkjob(emp_Job_id);
				} catch (InvalidInputDataException e) {
					message += "\n Error in Job Id input ";
					exM.handleException(e, source, message);
					System.out.print(message);
					close();
					return;
				}
				emp.setJob_id(emp_Job_id);
				System.out.println("Enter salary");
				String emp_salary = null;
				try {
					emp_salary = sc.nextLine();
					val.checkStringForParse(emp_salary);
				} catch (InvalidInputDataException e) {
					message += "\n Error in Salary input ";
					exM.handleException(e, source, message);
					System.out.print(message);
					close();
					return;
				}
				float salary = Float.parseFloat(emp_salary);
				emp.setSalary(salary);
				EmployeeDao empdao= apcontext.getBean(EmployeeDao.class);
				int result = empdao.insertEmployee(emp);
				System.out.println(result + "row inserted");
			} catch (Exception e) {
				message += "\n Error while inserting record ";
				exM.handleException(e, source, message);
				System.out.print(message);
				e.printStackTrace();
				return;
			}
			close();
			
		} 

	public void UpdateEmployee() {
		sc= new Scanner(System.in);
		String source = "UpdateEmployee";
		String message = "Error while " + source + " ";
	//	apcontext = new ClassPathXmlApplicationContext("Employee.xml");
		Employee emp = apcontext.getBean(Employee.class);
		Validator val=apcontext.getBean(Validator.class);
		ExceptionManager exM=apcontext.getBean(ExceptionManager.class);
		System.out.println("Enter the Employee Id: ");
		try {
			String emp_id = sc.nextLine();
			try {
				val.checkStringForParse(emp_id);
			} catch (InvalidInputDataException e) {
				message += "\n Error in Employee id input ";
				exM.handleException(e, source, message);
				System.out.print(message);
				close();
				return;

			}
			int id = Integer.parseInt(emp_id);
			try {
				val.CheckNumberForGreaterThanZero(id);
			} catch (InvalidInputDataException e) {
				message += " Error in Employee id input </p>";
				exM.handleException(e, source, message);
				System.out.print(message);
				close();
				return;
			}
			emp.setEmp_id(id);
			System.out.println("Enter the First name of Employee: ");
			String emp_Firstname = sc.nextLine();
			try {
				val.checkStringOnly(emp_Firstname);
			} catch (InvalidInputDataException e) {
				message += "\n Error in First Name input ";
				exM.handleException(e, source, message);
				System.out.print(message);
				close();
				return;
			}
			emp.setFirst_name(emp_Firstname);
			System.out.println("Enter the Last Name of Employee: ");
			String emp_LastName = sc.nextLine();
			try {
				val.checkStringOnly(emp_LastName);
			} catch (InvalidInputDataException e) {
				message += "\n Error in Last Name input ";
				exM.handleException(e, source, message);
				System.out.print(message);
				close();
				return;
			}
			emp.setLast_name(emp_LastName);
			System.out.println("Enter Email: ");
			String emp_email = sc.nextLine();
			try {
				val.checkMail(emp_email);
			} catch (InvalidInputDataException e) {
				message += "\n Error in email input ";
				exM.handleException(e, source, message);
				System.out.print(message);
				close();
				return;
			}
			emp.setEmail(emp_email);
			SimpleDateFormat hire_dateFormate = new SimpleDateFormat("dd/MM/yyyy");
			System.out.println("Enter Hire Date: ");
			String emp_HireDate = sc.nextLine();
			// Date hire_date=hire_dateFormate.parse(emp_HireDate);

			try {
				val.checkDateFormat(emp_HireDate);
			} catch (InvalidInputDataException e) {
				message += "\n Error in Hire Date input ";
				exM.handleException(e, source, message);
				System.out.print(message);
				close();
				return;
			}
			try {
				emp.setHire_date(hire_dateFormate.parse(emp_HireDate));
			} catch (ParseException e) {
				message += "\n Error in Hire Date input ";
				exM.handleException(e, source, message);
				System.out.print(message);
				close();
				return;
			}
			System.out.println("Enter Job Id: ");
			String emp_Job_id = sc.nextLine();
			try {
				val.checkjob(emp_Job_id);
			} catch (InvalidInputDataException e) {
				message += "\n Error in Job Id input ";
				exM.handleException(e, source, message);
				System.out.print(message);
				close();
				return;

			}
			emp.setJob_id(emp_Job_id);
			System.out.println("Enter Salary");
			String emp_salary = sc.nextLine();
			try {
				val.checkStringForParse(emp_salary);
			} catch (InvalidInputDataException e) {
				message += "\n Error in salary input ";
				exM.handleException(e, source, message);
				System.out.print(message);
				close();
				return;

			}
			float salary = Float.parseFloat(emp_salary);
			emp.setSalary(salary);
			EmployeeDao empdao=apcontext.getBean(EmployeeDao.class);
			int result = empdao.updateEmployee(emp);
			System.out.println(result + "row Updated");
		} catch (Exception e) {
			message += "\n Error while inserting record ";
			exM.handleException(e, source, message);
			System.out.print(message);
			e.printStackTrace();
			return;
		}
		close();
	}

	public void DeleteEmployee(){
		sc=new Scanner(System.in);
		String source = "DeleteEmployee";
	//	apcontext = new ClassPathXmlApplicationContext("Employee.xml");
		String message = " Error while " + source + " ";
		System.out.println("Enter Employee Id: ");
		String emp_id = sc.nextLine();
		try {
			apcontext.getBean(Validator.class).checkStringForParse(emp_id);
		} catch (InvalidInputDataException e) {
			message += "\n Error in Employee id input ";
			apcontext.getBean(ExceptionManager.class).handleException(e, source, message);
			System.out.print(message);
			close();
			return;
		}
		int id = Integer.parseInt(emp_id);
		EmployeeDao empdao= apcontext.getBean(EmployeeDao.class);
		int result = empdao.deleteEmployee(id);
		System.out.println(result + "row deleted");
		empdao=null;
		close();
	}
	public void close() {
		sc.close();
		apcontext.close();
	}
	
}