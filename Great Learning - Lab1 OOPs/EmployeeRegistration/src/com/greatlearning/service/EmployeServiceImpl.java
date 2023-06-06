package com.greatlearning.service;

import java.util.Random;

import com.greatlearning.model.Employee;

public class EmployeServiceImpl implements EmployeeService {

	@Override
	public String generateUserEmail(String firstName, String lastName, String departmentName) {
		// TODO Auto-generated method stub
		return firstName + lastName + "@" + departmentName + ".gl.com";
	}

	@Override
	public String genetrateUserPassword() {
		// TODO Auto-generated method stub
		String capital = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lower = "abcdefghijklmnopqrstuvwxyz";
		String numb = "0123456789";
		String splChar = "!@#$%^&*()";
		String combined = capital + lower + numb + splChar;
		System.out.println(combined.length());
		//72
		String gPassword = "";
		Random random = new Random();
		
		for(int i=1; i<=8; i++) {
			gPassword += String.valueOf(combined.charAt(random.nextInt(combined.length())));
		}
		
		return gPassword;
	}

	@Override
	public void displayEmployeeDetails(Employee e1) {
		// TODO Auto-generated method stub
		System.out.println("Employee First Name : "+ e1.getFirstName());
		System.out.println("Employee Last Name : "+ e1.getLastName());
		System.out.println("Employee User Email : "+e1.getUserEmail());
		System.out.println("Employee User Password : "+e1.getUserPassword());
	}
	

}
