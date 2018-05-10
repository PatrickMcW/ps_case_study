package com.cdw.runner;

import java.util.Scanner;

import com.cdw.dao.CustomerDAO;
import com.cdw.resources.Prompter;

public class CustomerRunner {
	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
//		1) To check the existing account details of a customer. 
//		2) To modify the existing account details of a customer  
//		3) To generate monthly bill for a credit card number for a given month and year. 
//		4) To display the transactions made by a customer between two dates. Order by year, month, and day in descending order
		System.out.println("Which customer report would you like to run?");
		System.out.println("1. Account details of a particular customer by SSN. ");
		System.out.println("2. Modify account details of a particular customer by SSN.");
		System.out.println("3. Generate monthly bill for a credit card number for a given month and year.");
		System.out.println("4. Display the transactions made by a customer between two dates.");
		int input = scanner.nextInt();
		switch (input) {
			case 1: {
				getCustomerBySsn();
			}
			break;
			case 2: {
				updateCustomerInfoBySsn();
			}
			break;
			case 3: {
//				generateBillByMonthYearForCcn(scanner);
				generateBillByMonthYearForCcn();
			}
			break;
			case 4: {
				
			}
			break;
			default: {
				System.out.println("Somehow reached default case in customer runner switch");
			}
		}
	}
	public static void getCustomerBySsn() {
		
		CustomerDAO cDao = new CustomerDAO();
		//1) To check the existing account details of a customer.
		//@int ssn
		int ssn = Prompter.staging("getCust").outputInt;
		
		System.out.println(
				cDao.getCustomerBySsn(ssn)
				);
		
	}
	public static void updateCustomerInfoBySsn() {
		CustomerDAO cDao = new CustomerDAO();
		//2) To modify the existing account details of a customer 
		// @string table_name, @string column_name, @string/@int (depending) new_value, @int ssn
		String t_name, c_name;
		System.out.println("determine what field they're chaning and what var type to use there");
		//take input as string, and then convert later?
	}
	
	public static void generateBillByMonthYearForCcn(/*Scanner scanner*/) {
		CustomerDAO cDao = new CustomerDAO();
		// @int month, @int year, @string ccn
		int m = Prompter.staging("month").outputInt;
		int y = Prompter.staging("year").outputInt;
		String ccn = Prompter.staging("ccn").outputString;
		System.out.println();
		
		System.out.println(
				cDao.getBillByMonthAndYearForCcn(m, y, ccn)
				);
		
		
	}
//	4) To display the transactions made by a customer between two dates. 
	//Order by year, month, and day in descending order
	// note: this may not account for the fact that a single customer could have more than 
	// one cc since the customer table has a compound primary key of ssn and ccn, unless we're
	// specifically looking for all transactions rather than transactions on a given card
	public static void custTransBetweenTwoDates() {
		CustomerDAO cDao = new CustomerDAO();
	}
}