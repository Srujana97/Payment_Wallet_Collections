package com.cg.pp.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.cg.pp.dto.Customer;
import com.cg.pp.dto.WalletApplicationData;
import com.cg.pp.service.WalletApplicationDataValidate;
import com.cg.pp.service.WalletApplicationService;





public class WalletApplicationUi {
	static long accNo = 0;
	static int n = 0;
	
	public static void create() {
		List<WalletApplicationData> list = new ArrayList<WalletApplicationData>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		WalletApplicationData bean = new WalletApplicationData();
		Customer cust = new Customer();
		WalletApplicationDataValidate validate = new WalletApplicationDataValidate();
		WalletApplicationService service = new WalletApplicationService();
		try {
			System.out.println("Enter your first name");
			String firstName = br.readLine();
			
			System.out.println("Enter your last name");
			String lastName = br.readLine();
			
			System.out.println("Enter your gender");
			String gender = br.readLine();
			
			System.out.println("Enter your age");
			String age = br.readLine();
			
			System.out.println("Enter your contact");
			String contact = br.readLine();
			
			System.out.println("Enter your email-id");
			String email = br.readLine();
			
			//System.out.println("Enter your aadhar");
			//String aadharNo = br.readLine();
			
			System.out.println("Enter your username");
			String userName = br.readLine();
			
			System.out.println("Enter your password");
			String password = br.readLine();
			
			accNo =  (long)(Math.random()*123456789) + 999999999;
			System.out.println("your account number: " +accNo);
			
			LocalDate date = LocalDate.now();
			
			System.out.println("Enter the amount");
			String amount = br.readLine();
			
			cust.setFirstName(firstName);
			cust.setLastName(lastName);
			cust.setGender(gender);
			cust.setAge(Integer.parseInt(age));
			cust.setContact(contact);
			cust.setEmail(email);
			//cust.setAadharNo(aadharNo);
			cust.setUserName(userName);
			cust.setPassword(password);
			
			bean.setAccNo(accNo);
			bean.setDate(date);
			bean.setCustomer(cust);
			bean.setAmount(Double.parseDouble(amount));
			bean.setIfsc("32465");
			bean.setBranch("Pune");
			
			boolean isValidFirstName = validate.validateFirstName(firstName);
			boolean isValidLastName = validate.validateLastName(lastName);
			boolean isValidGender = validate.validateGender(gender);
			boolean isValidContact = validate.validateContact(contact);
			boolean isValidEmail = validate.validateEmail(email);
			boolean isValidUserName = validate.validateUserName(userName);
			boolean isValidPassword = validate.validatePassword(password);
			
			if(isValidFirstName && isValidLastName && isValidGender &&  isValidContact &&  isValidEmail && isValidUserName && isValidPassword)
				n = service.createAccount(bean);
			if(n==1) {
				System.out.println("Your account is successfully created");
			}
			else {
				System.out.println("Account is not created");
			}
				
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void signin() {
		WalletApplicationService service = new WalletApplicationService();
		WalletApplicationData bean = new WalletApplicationData();
		int ch = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your username");
		String userName = sc.next();
		System.out.println("Enter your password");
		String password = sc.next();
		boolean valid = service.login(userName, password);
		do {
		if(valid) {
			System.out.println("Logged in succesfully");
			System.out.println("1.show balance");
			System.out.println("2.deposit");
			System.out.println("3.withdraw");
			System.out.println("4.fund transfer");
			System.out.println("5.print transaction");
			System.out.println("enter your choice");
		}
		else {
			System.out.println("Enter valid details");
		}
		ch = sc.nextInt();
		switch(ch) {
		case 1:
			
			System.out.println(service.showBalance());
			break;
		case 2:
			System.out.println("Enter the amount to be deposited");
			double dep_amount = sc.nextDouble();
			System.out.println(dep_amount);
			service.deposit(dep_amount);
			break;
		case 3:
			System.out.println("Enter the amount to be withdrawn");
			double withdraw_amount = sc.nextDouble();
			service.withdraw(withdraw_amount);
			break;
		case 4:
			System.out.println("Enter the account Number");
			long accNo = sc.nextLong();
			System.out.println("Enter the amount to transfer");
			double amount = sc.nextDouble();
			service.fundTransfer(accNo, amount);
			break;
		case 5:
			List<WalletApplicationData> list = new ArrayList<WalletApplicationData>();
			list = service.printTransaction();
			
			
		}
		}while(ch != 5);
	    
			

		
	}
	
	public static void main(String[] args) {
		int choice = 0;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("Welcome to payment wallet application");
			System.out.println("Enter your choice");
			System.out.println("1.create account");
			System.out.println("2.login");
			System.out.println("3.exit");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter your choice");
			choice = sc.nextInt();
			switch(choice) {
			case 1:
			    create();
				break;
			case 2:
				signin();
				break;
			case 3:
				System.out.println("Thank you");
				System.exit(0);
				break;
				
			
			}
			
			
		}while(choice !=3);
	
	}

}
