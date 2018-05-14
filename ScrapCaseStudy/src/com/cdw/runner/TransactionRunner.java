package com.cdw.runner;

import java.util.Scanner;

import com.cdw.dao.TransactionDAO;
import com.cdw.model.Transaction;
import com.cdw.resources.Prompter;

public class TransactionRunner {
	public static void Run(Scanner scanner) {
		System.out.println("Which transaction report would you like to run?");
		System.out.println("1. Transactions by customer, for a given zip code, month and year.");
		System.out.println("2. Transaction number and value for a given type.");
		System.out.println("3. Transaction number and value for a given state.");
		int input = scanner.nextInt();
		switch (input) {
			case 1:
				transactionsForZipByMonthAndYear();
				break;
			case 2: 
				transactionNumberAndValueByType();
				break;
			case 3:
				transactionNumberAndValueByState();
				break;
			default:
				System.out.println("Somehow reached default case in transaction runner switch");
		}	
		scanner.close();
	}
	
//	1) To display the transactions made by customers living in a given zip code for a given month and year. Order by day in descending order. 
	public static void transactionsForZipByMonthAndYear() {
		TransactionDAO tDao = new TransactionDAO();
		int z = Prompter.staging("zip").outputInt;
		int m = Prompter.staging("month").outputInt;
		int y = Prompter.staging("year").outputInt;
			
		for(Transaction t: tDao.getTransByZipMonthYear(z, m, y)) {
			System.out.println(t);
			t.toString();
		}
	}
////	2) To display the number and total values of transactions for a given type. 
	public static void transactionNumberAndValueByType() {
		TransactionDAO tDao = new TransactionDAO();
		String transaction_type = Prompter.staging("type").outputString;
		
		System.out.println(
				tDao.getTransactionTotalValForType(transaction_type)
				);
		
	}
////	3) To display the number and total values of transactions for branches in a given state 
	public static void transactionNumberAndValueByState() {
		TransactionDAO tDao = new TransactionDAO();
		String state_abbr = Prompter.staging("state").outputString;
		
		System.out.println(
				tDao.getStateTransactionCountAndVal(state_abbr)
				);
		
	}
}
