package com.cdw.runner;

import java.util.Scanner;

import com.cdw.dao.TransactionDAO;
import com.cdw.model.Transaction;
import com.cdw.resources.Formats;
import com.cdw.resources.Prompter;

public class TransactionRunner {
	public static void Run(Scanner scanner) {
		System.out.println("Which transaction report would you like to run?");
		System.out.println("1. Transactions for a given zip code, month and year.");
		System.out.println("2. Transaction number and value for a given type.");
		System.out.println("3. Transaction number and value for a given state.");
		System.out.println("0 to exit Transaction category");
		select(scanner);
//		return;
	}
	
	public static void select(Scanner scanner) {
		int input = scanner.nextInt();
		while(input!=0) {
			switch (input) {
				case 1: {					
					transactionsForZipByMonthAndYear();
					return;
				}
				case 2: {					
					transactionNumberAndValueByType();
					return;
				}
				case 3: {					
					transactionNumberAndValueByState();
					return;
				}
				default: {					
					System.out.println("Somehow reached default case in transaction runner switch");
					input = 0;
				}
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("You have exited the Transaction category");
		ChooseRunner.select(scanner);
	}
	
//	1) To display the transactions made by customers living in a given zip code for a given month and year. Order by day in descending order. 
	public static void transactionsForZipByMonthAndYear() {
		TransactionDAO tDao = new TransactionDAO();
		int z = Prompter.staging("zip").outputInt;
		int m = Prompter.staging("month").outputInt;
		int y = Prompter.staging("year").outputInt;
		System.out.printf(Formats.transactionLayoutHeader+Formats.ssn+" %n", "Transaction ID","Day","Month","Year","Credit Card No.", /*"Customer ID",*/ "Branch Code","Type","Value($)", "Customer ID");
		System.out.println();
		for(Transaction t: tDao.getTransByZipMonthYear(z, m, y)) {
			System.out.print(t);
		}
	}
////	2) To display the number and total values of transactions for a given type. 
	public static void transactionNumberAndValueByType() {
		TransactionDAO tDao = new TransactionDAO();
		String transaction_type = Prompter.staging("type").outputString;
		
		System.out.printf(Formats.typeOrState+Formats.valueAndCountHeader, "Type","Value($)","# of Transactions");
		System.out.println();
		System.out.println(
				tDao.getTransactionTotalValForType(transaction_type)
				);
		
	}
////	3) To display the number and total values of transactions for branches in a given state 
	public static void transactionNumberAndValueByState() {
		TransactionDAO tDao = new TransactionDAO();
		String state_abbr = Prompter.staging("state").outputString;
		
		System.out.printf(Formats.typeOrState+Formats.valueAndCountHeader, "State","Value($)","# of Transactions");
		System.out.println();
		System.out.println(
				tDao.getStateTransactionCountAndVal(state_abbr)
				);
		
	}
}
