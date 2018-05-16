package com.cdw.runner;

import java.util.Arrays;
import java.util.Scanner;

import com.cdw.dao.CustomerDAO;
import com.cdw.model.Customer;
import com.cdw.resources.CustTransBetweenDates;
import com.cdw.resources.Formats;
import com.cdw.resources.Output;
import com.cdw.resources.Prompter;

public class CustomerRunner {
	public static void Run(Scanner scanner) {
		
//		1) To check the existing account details of a customer. 
//		2) To modify the existing account details of a customer  
//		3) To generate monthly bill for a credit card number for a given month and year. 
//		4) To display the transactions made by a customer between two dates. Order by year, month, and day in descending order
		System.out.println("Which customer report would you like to run?");
		System.out.println("1. Account details of a particular customer by SSN. ");
		System.out.println("2. Modify account details of a particular customer by SSN.");
		System.out.println("3. Generate monthly bill for a credit card number for a given month and year.");
		System.out.println("4. Display the transactions made by a customer between two dates.");
		System.out.println("0 to re-choose category");
		select(scanner);	
//		return;
	}
	public static void select(Scanner scanner) {
		int input = scanner.nextInt();
		while(input!=0) {
			switch (input) {
				case 1: {
					getCustomerBySsn(scanner);
					return;
				}
				case 2: {
					updateCustomerInfoBySsn(scanner);
					return;
				}
				case 3: {
					generateBillByMonthYearForCcn(scanner);
					return;
				}
				case 4: {
					custTransBetweenTwoDates(scanner);
					return;
				}
				default: {
					System.out.println("Somehow reached default case in customer runner switch");
					input = 0;
				}
			}		
			System.out.println();
		}
		System.out.println();
		System.out.println("You have exited the Customer category");
		ChooseRunner.select(scanner);
	}
	public static void getCustomerBySsn(Scanner scanner) {
		
		CustomerDAO cDao = new CustomerDAO();
		//1) To check the existing account details of a customer.
		//@int ssn
		int ssn = Prompter.staging("ssn").outputInt;
		//13 columns
		System.out.printf(Formats.customerLayout, 
				"First Name", "Middle Name","Last Name","SSN","Credit Card No.", 
				"Apt No", "Street", "City","State","Country","Zip","Phone","Email");
		System.out.println();
		for(Customer e: cDao.getCustomerBySsn(ssn)) {
			System.out.println(e);
		}
		
	}
	public static void updateCustomerInfoBySsn(Scanner scanner) {
		CustomerDAO cDao = new CustomerDAO();
		//2) To modify the existing account details of a customer 

		int ssn = Prompter.staging("ssn").getOutputInt();
		String ccn = Prompter.staging("ccn").getOutputString();
		
		//display customer info,
		System.out.printf(Formats.customerLayout, 
				"First Name", "Middle Name","Last Name","SSN","Credit Card No.", 
				"Apt No", "Street", "City","State","Country","Zip","Phone","Email");
		for(Customer e: cDao.getCustomerBySsn(ssn)) {
			System.out.println(e);
		}
		
		//ask use what they want to change
		Output newVal;
		
	//  @string column_name, @string/@int (depending) new_value, @int ssn, @String ccn
		String cName = Prompter.staging("column").outputString; 
				
		//can check here for col dtype to newval dtype.
//		String[] useStrings = new String[] {"FIRST_NAME", "MIDDLE_NAME", "LAST_NAME", 
//				 "CREDIT_CARD_NO", "APT_NO", "STREET_NAME", "CUST_CITY",
//				"CUST_STATE", "CUST_COUNTRY", "CUST_ZIP", "CUST_EMAIL"}; //leaving this here in case we need to check for string columns after any DB changes
		String[] useInts = new String[] {"SSN", "CUST_PHONE"};
		
		if(Arrays.asList(useInts).contains(cName)) {
//			String newVal = Prompter.staging("newStringVal").outputString;
			newVal = new Output(Prompter.staging("newIntVal").outputInt);
			
		} else {
			newVal = new Output(Prompter.staging("newStringVal").outputString);
		}
		
		cDao.updateCustomerBySsnAndCcn(cName, newVal, ssn, ccn);
		System.out.println("Updated customer: ");
		System.out.printf(Formats.customerLayout, 
				"First Name", "Middle Name","Last Name","SSN","Credit Card No.", 
				"Apt No", "Street", "City","State","Country","Zip","Phone","Email");
		for(Customer e: cDao.getCustomerBySsn(ssn)) {
			System.out.println(e);
		}
		//think im looping here
//		System.out.println("probably loop");
		return;
//		ChooseRunner.select(scanner);
	}
	
	public static void generateBillByMonthYearForCcn(Scanner scanner) {
		CustomerDAO cDao = new CustomerDAO();
		// @int month, @int year, @string ccn
		int m = Prompter.staging("month").outputInt;
		int y = Prompter.staging("year").outputInt;
		String ccn = Prompter.staging("ccn").outputString;
		System.out.printf(Formats.monthBillLayoutHeader, "Balance Due($)","First Name","Last Name","SSN");
		System.out.println(
				cDao.getBillByMonthAndYearForCcn(m, y, ccn)
				);
	}
	
//	4) To display the transactions made by a customer between two dates. 
	//Order by year, month, and day in descending order
	// note: this may not account for the fact that a single customer could have more than 
	// one cc since the customer table has a compound primary key of ssn and ccn, unless we're
	// specifically looking for all transactions rather than transactions on a given card
	public static void custTransBetweenTwoDates(Scanner scanner) {
		CustomerDAO cDao = new CustomerDAO();
		//@int ssn, @String/date dateOne, @String/date dateTwo
		System.out.println("year is crapping out here when i'm trying to exit from chooserunner()?");
		int ssn = Prompter.staging("ssn").outputInt;
		int y = Prompter.staging("year").outputInt;
		//dateOne prompt
		System.out.println("First Date");
		
		String[] dateSplit = Prompter.staging("dateMonth").outputDateSplit;	//using var for readability
		//dateSplit[0] is day, dateSplit[1] is month
		
		String dateOne = y+"-"+dateSplit[1]+"-"+dateSplit[0];
		
		//dateTwo prompt
		System.out.println("Second Date");
		dateSplit = Prompter.staging("dateMonth").outputDateSplit;
		String dateTwo = y+"-"+dateSplit[1]+"-"+dateSplit[0];
		//11 categories
		System.out.printf(Formats.custTransBetweenDatesLayoutHeader,"First Name","Middle Name","Last Name","Transaction ID","Day","Month","Year","Credit Card No.","Branch Code","Type","Transaction Value");
		System.out.println();
		for(CustTransBetweenDates e : 
			cDao.getCustTransBetweenDatesBySsn(ssn, dateOne, dateTwo)) {
//					System.out.println(e);
					System.out.print(e);
		}
		
	}
}
