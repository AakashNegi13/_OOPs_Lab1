package com.greatlearning.app;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.greatlearning.model.Employee;
import com.greatlearning.service.EmployeServiceImpl;

public class DriverApp {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your First Name");
		String fName = sc.next();
		System.out.println("Enter your Last Name");
		String lName = sc.next();
		
		
		Employee emp = new Employee();
		emp.setFirstName(fName);
		emp.setLastName(lName);
		EmployeServiceImpl esi = new EmployeServiceImpl();
		
		System.out.println("Please enter the department from the following:");
		System.out.println("1. Technical");
		System.out.println("2. Admin");
		System.out.println("3. HR"); 
		System.out.println("4. Legal");
		int department = sc.nextInt();
		String genEmail = "";
		String genPassword = "";
		
		switch(department){
		
		case 1 : genEmail = esi.generateUserEmail(emp.getFirstName().toLowerCase(), emp.getLastName().toLowerCase(), "tech");
			break;
		case 2 : genEmail = esi.generateUserEmail(emp.getFirstName().toLowerCase(), emp.getLastName().toLowerCase(), "admin");
			break;
		case 3 : genEmail = esi.generateUserEmail(emp.getFirstName().toLowerCase(), emp.getLastName().toLowerCase(), "hr");
			break;
		case 4 : genEmail = esi.generateUserEmail(emp.getFirstName().toLowerCase(), emp.getLastName().toLowerCase(), "legal");
			break;
			default: System.out.println("Please Enter valid department");
		 }
		
		genPassword = esi.genetrateUserPassword();
		emp.setUserEmail(genEmail);
		emp.setUserPassword(genPassword);
		esi.displayEmployeeDetails(emp);
		
		String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)"+"(?=.*[-+_!@#$%^&*.,?]).+$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(genPassword);
		
		if (m.matches())
			System.out.println("Valid Password");
		else
			System.out.println("Invalid Password");
			}
}
