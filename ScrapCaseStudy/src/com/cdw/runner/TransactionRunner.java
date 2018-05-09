package com.cdw.runner;

import java.util.Scanner;

import com.cdw.dao.TransactionDAO;
import com.cdw.model.Transaction;
import com.cdw.resources.Prompter;

public class TransactionRunner {
	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		System.out.println("Which transaction query would you like to run?");
		System.out.println("1. Transactions by customer, for a given zip code, month and year");
		System.out.println("2. Transaction number and value for a given type");
		System.out.println("3. Trasaction number and value for a given state");
		int input = scanner.nextInt();
		switch (input) {
			case 1:
				transactionsForZipByMonthAndYear(scanner);
				break;
			case 2: 
				
				break;
			case 3:
				
				break;
		}

		
		scanner.close();
	}

	//below are prompt functions that allow for re-do with bad data. there's a lot of duplicate code shared between them, 
	//so i may want to consider a generalized function that handles all
//	public static Output zipPrompt(Scanner scanner) {
////		String zIn = null;
////		System.out.println("Please provide the zip code criteria: ");
////		System.out.println("Test entry 06109");
////		zIn = scanner.next();
////		if(zIn.length()!=5) {
////			System.out.println("An invalid zip was entered, please try again");
////			zipPrompt(scanner);
////		}
////		
////		return Integer.parseInt(zIn);
//		Output output = null;
//		
//		
//	}
//	public static int monthPrompt(Scanner scanner) {
//		int m = 0;
//		System.out.println("Please provide the month (integer) criteria: ");
//		System.out.println("Test entry 2");
//		m = scanner.nextInt();
//		if( m<1 || m>12 ) {
//			System.out.println("An invalid month was entered, please try again");
//			monthPrompt(scanner);
//		}
//		return m;
//		
//	}
//	public static int yearPrompt(Scanner scanner) {
//		int y = 0;
//		System.out.println("Please provide the year (integer) criteria: ");
//		System.out.println("Test Entry 2018");
//		y = scanner.nextInt();
//		if( y!=2018 ) {
//			System.out.println("An invalid year was entered, please try again");
//			System.out.println("The only year in this dataset is 2018"); //I could probably just not prompt for a year input
//			//but the reqs are the reqs
//			monthPrompt(scanner);
//		}
//		return y;
//		
//	}
	
//	1) To display the transactions made by customers living in a given zip code for a given month and year. Order by day in descending order. 
	public static void transactionsForZipByMonthAndYear(Scanner scanner) {
		TransactionDAO tDao = new TransactionDAO();
//		int z = zipPrompt(scanner);
//		System.out.println(Prompter.staging("zip")); //seems to be return null?
		int z = Prompter.staging("zip").outputInt;
//		int m = monthPrompt(scanner);
		int m = Prompter.staging("month").outputInt;
//		int y = yearPrompt(scanner);
		int y = Prompter.staging("year").outputInt;
		
		
		System.out.println(
				tDao.getTransByZipMonthYear(z, m, y)
				);
		
		
		
	}
////	2) To display the number and total values of transactions for a given type. 
//	public static void transactionNumberAndValueByType(Scanner scanner) {
//		TransactionDAO tDao = new TransactionDAO();
//		String transaction_type = typePrompt(scanner);
//		System.out.println(tDao.getTransactionTotalValForType(transaction_type));
//		
//	}
////	3) To display the number and total values of transactions for branches in a given state 
//	public static void transactionNumberAndValueByState(Scanner scanner) {
//		TransactionDAO tDao = new TransactionDAO();
//		String state_abbr = statePrompt(scanner);
//		System.out.println(tDao.getStateTransactionCountAndVal(state_abbr));
//		
//	}
}
