package com.cdw.runner;

import java.util.Arrays;
import java.util.Scanner;

import com.cdw.dao.CustomerDAO;
import com.cdw.model.Customer;
import com.cdw.resources.CustTransBetweenDates;
import com.cdw.resources.Formats;
import com.cdw.resources.MonthInvoice;
import com.cdw.resources.Output;
import com.cdw.resources.Prompter;
import com.cdw.resources.WriteToFile;

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
					updateCustomerInfoBySsnAndCcn(scanner);
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
		boolean write = WriteToFile.writeFileQuestion(scanner);
		
		CustomerDAO cDao = new CustomerDAO();
		Output output = new Output();
		//1) To check the existing account details of a customer.
		//@int ssn
//		int ssn = Prompter.staging("ssn").getOutputInt();
		int ssn;
		Prompter.prompting("ssn", output);
		ssn = Integer.parseInt(output.getOutputString());
		//13 columns
		System.out.printf(Formats.customerLayout, 
				"First Name", "Middle Name","Last Name","SSN","Credit Card No.", 
				"Apt No", "Street", "City","State","Country","Zip","Phone","Email");
		System.out.println();
		for(Customer e: cDao.getCustomerBySsn(ssn)) {
			System.out.println(e);
			if(write) {
				WriteToFile.writeToLoc("customerBySsn", e.toFile() );
			}
		}
		
	}
	public static void updateCustomerInfoBySsnAndCcn(Scanner scanner) {
		boolean write = WriteToFile.writeFileQuestion(scanner);
		CustomerDAO cDao = new CustomerDAO();
		Output output = new Output();
		Output outputSsn = new Output();
		Output outputCcn = new Output();
		Output outputColName = new Output();
		Output newVal;
		//2) To modify the existing account details of a customer 
		
		//get unique customer+ccn record
//		int ssn = Prompter.staging("ssn").getOutputInt();
		int ssn;
		Prompter.prompting("ssn", outputSsn);
		ssn = Integer.parseInt(outputSsn.getOutputString());
		
		String ccn;
		Prompter.prompting("ccn", outputCcn);
		ccn = outputCcn.getOutputString();
		
		//display record info,
		;
		System.out.printf(Formats.customerLayout, 
				"First Name", "Middle Name","Last Name","SSN","Credit Card No.", 
				"Apt No", "Street", "City","State","Country","Zip","Phone","Email");
		System.out.println(cDao.getCustomerBySsnAndCcn(ssn, ccn));
	
		//ask use what the user wants to change
		//  @string column_name, @string/@int (depending) new_value, @int ssn, @String ccn
//		Output test = Prompter.staging("column");
//		System.out.println(test);
//		String cName = Prompter.staging("column").getOutputString(); 
//		String cName = test.getOutputString();
		String cName;
		Prompter.prompting("column", outputColName);
		cName = outputColName.getOutputString();
		output = new Output();
				
		//can check here for col dtype to newval dtype.
//		String[] useStrings = new String[] {"FIRST_NAME", "MIDDLE_NAME", "LAST_NAME", 
//				 "CREDIT_CARD_NO", "APT_NO", "STREET_NAME", "CUST_CITY",
//				"CUST_STATE", "CUST_COUNTRY", "CUST_ZIP", "CUST_EMAIL"}; 
		//leaving this here in case we need to check for string columns after any DB changes
		String[] useInts = new String[] {"SSN", "CUST_PHONE"};
		
		if(Arrays.asList(useInts).contains(cName)) {
//			newVal = new Output(Prompter.staging("newIntVal").getOutputInt());
			Prompter.prompting("newIntVal", output);
			newVal = output;
			output =  new Output();
			
		} else {
//			newVal = new Output(Prompter.staging("newStringVal").getOutputString());
			Prompter.prompting("newStringVal", output);
			newVal = output;
			output =  new Output();
		}
		
		//actually update the record info
		cDao.updateCustomerBySsnAndCcn(cName, newVal, ssn, ccn);
		
		//show newly updated record
		System.out.println("Updated customer: ");
		System.out.printf(Formats.customerLayout, 
				"First Name", "Middle Name","Last Name","SSN","Credit Card No.", 
				"Apt No", "Street", "City","State","Country","Zip","Phone","Email");	
		Customer cust = cDao.getCustomerBySsnAndCcn(ssn, ccn);
		System.out.println(cust);
		if(write) {
			WriteToFile.writeToLoc("updatedCustomer", cust.toFile());
		}
		return;
	}
	
	public static void generateBillByMonthYearForCcn(Scanner scanner) {
		boolean write = WriteToFile.writeFileQuestion(scanner);
		CustomerDAO cDao = new CustomerDAO();
		Output output = new Output();
		// @int month, @int year, @string ccn
//		int m = Prompter.staging("month").getOutputInt();
//		int y = Prompter.staging("year").getOutputInt();
//		String ccn = Prompter.staging("ccn").getOutputString();
//		MonthInvoice bill = cDao.getBillByMonthAndYearForCcn(m, y, ccn);
		int m,y;
		String ccn;
		MonthInvoice bill;
		
		Prompter.prompting("month", output);
		m=output.getOutputInt();
		output=new Output();
		
		Prompter.prompting("year", output);
		y=output.getOutputInt();
		output=new Output();
		
		Prompter.prompting("ccn", output);
		ccn = output.getOutputString();
		output=new Output();
		
		bill = cDao.getBillByMonthAndYearForCcn(m, y, ccn);
		
		System.out.printf(Formats.monthBillLayoutHeader, "Balance Due($)","First Name","Last Name","SSN");
		System.out.println(bill);
		if(write) {
			WriteToFile.writeToLoc("monthInvoice", bill.toFile());
		}	
	}
	
//	4) To display the transactions made by a customer between two dates. 
	//Order by year, month, and day in descending order
	// note: this may not account for the fact that a single customer could have more than 
	// one cc since the customer table has a compound primary key of ssn and ccn, unless we're
	// specifically looking for all transactions rather than transactions on a given card
	public static void custTransBetweenTwoDates(Scanner scanner) {
		boolean write = WriteToFile.writeFileQuestion(scanner);
		CustomerDAO cDao = new CustomerDAO();
		Output output = new Output();
		//@int ssn, @String/date dateOne, @String/date dateTwo
//		int ssn = Prompter.staging("ssn").getOutputInt();
//		int y = Prompter.staging("year").getOutputInt();
		
		int ssn, y;
		String[] dateSplit;
		//dateOne prompt
		System.out.println("First Date");	
//		String[] dateSplit = Prompter.staging("dateMonth").getOutputDateSplit();	//using var for readability
		//dateSplit[0] is day, dateSplit[1] is month	
		Prompter.prompting("ssn", output);
		ssn = Integer.parseInt(output.getOutputString());
		output= new Output();
		
		Prompter.prompting("year", output);
		y = output.getOutputInt();
		output=new Output();
		
		Prompter.prompting("dateMonth", output);
		dateSplit = output.getOutputDateSplit();
		output = new Output();
		
		String dateOne = y+"-"+dateSplit[1]+"-"+dateSplit[0];		
		//dateTwo prompt
		System.out.println("Second Date");
		Prompter.prompting("dateMonth", output);
		dateSplit = output.getOutputDateSplit();
		output = new Output();
		
		String dateTwo = y+"-"+dateSplit[1]+"-"+dateSplit[0];
		//11 categories
		System.out.printf(Formats.custTransBetweenDatesLayoutHeader,"First Name","Middle Name","Last Name","Transaction ID","Day","Month","Year","Credit Card No.","Branch Code","Type","Transaction Value");
		System.out.println();
		for(CustTransBetweenDates e : 
			cDao.getCustTransBetweenDatesBySsn(ssn, dateOne, dateTwo)) {
					System.out.println(e);
					if(write) {
						WriteToFile.writeToLoc("custTransBetweenDates", e.toFile());
					}
		}		
	}
}
