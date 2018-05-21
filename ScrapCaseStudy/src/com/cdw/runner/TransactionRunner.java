package com.cdw.runner;

import java.util.Scanner;

import com.cdw.dao.TransactionDAO;
import com.cdw.model.Transaction;
import com.cdw.resources.Formats;
import com.cdw.resources.Output;
import com.cdw.resources.Prompter;
import com.cdw.resources.WriteToFile;

public class TransactionRunner {
	public static void Run(Scanner scanner) {
		System.out.println("Which transaction report would you like to run?");
		System.out.println("1. Transactions for a given zip code, month and year.");
		System.out.println("2. Transaction number and value for a given type.");
		System.out.println("3. Transaction number and value for a given state.");
		System.out.println("0 to exit Transaction category");
		select(scanner);
	}
	
	public static void select(Scanner scanner) {
		int input = scanner.nextInt();
		while(input!=0) {
			switch (input) {
				case 1: {					
					transactionsForZipByMonthAndYear(scanner);
					return;
				}
				case 2: {					
					transactionCountAndValueByType(scanner);
					return;
				}
				case 3: {					
					transactionNumberAndValueByState(scanner);
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
	public static void transactionsForZipByMonthAndYear(Scanner scanner) {
		boolean write = WriteToFile.writeFileQuestion(scanner);
		TransactionDAO tDao = new TransactionDAO();
		Output output=new Output();
		int z,m,y;
		
		Prompter.prompting("zip", output);
		z= Integer.parseInt(output.getOutputString() );

		System.out.println(z + " was z");
		output.reset();
		
		Prompter.prompting("month", output);
		m= output.getOutputInt();
		
		output=new Output();
		Prompter.prompting("year", output);
		y = output.getOutputInt();
		System.out.println(z + " was z");
		System.out.println(m + " was m");
		System.out.println(y + " was y");
		
		System.out.printf(Formats.transactionLayoutHeader+Formats.ssn+" %n", "Transaction ID","Day","Month","Year","Credit Card No.", /*"Customer ID",*/ "Branch Code","Type","Value($)", "Customer ID");
		System.out.println();
		//TODO: uncomment the below for block
		for(Transaction t: tDao.getTransByZipMonthYear(z, m, y)) {
			if(write) {
				WriteToFile.writeToLoc("transByZipMonthYear", t.toFile()); //no message indicating file location for user
			}
			
			System.out.print(t);
		}
	}
////	2) To display the number and total values of transactions for a given type. 
	public static void transactionCountAndValueByType(Scanner scanner) {
		boolean write = WriteToFile.writeFileQuestion(scanner);
		TransactionDAO tDao = new TransactionDAO();
		Output output=new Output();
//		Output output = null;
		
//		Prompter.staging("type",output);
//		String transaction_type = output.outputString;
//		String transaction_type = Prompter.staging("type").getOutputString();
		String transaction_type;
		Prompter.prompting("type", output);
		transaction_type = output.getOutputString();
		
		System.out.printf(Formats.typeOrState+Formats.valueAndCountHeader, "Type","Value($)","# of Transactions");
		System.out.println();
		System.out.println(
				tDao.getTransactionTotalValForType(transaction_type)
				);
		if(write) {
			WriteToFile.writeToLoc("transCountAndValByType", tDao.getTransactionTotalValForType(transaction_type).toFile());
		}
		
	}
////	3) To display the number and total values of transactions for branches in a given state 
	public static void transactionNumberAndValueByState(Scanner scanner) {
		boolean write = WriteToFile.writeFileQuestion(scanner);
		TransactionDAO tDao = new TransactionDAO();
		Output output = new Output();
//		Prompter.staging("state",output);
//		String state_abbr = Prompter.staging("state").getOutputString();
		String state_abbr;
		Prompter.prompting("state", output);
		state_abbr = output.getOutputString();
		
		System.out.printf(Formats.typeOrState+Formats.valueAndCountHeader, "State","Value($)","# of Transactions");
		System.out.println();
		System.out.println(
				tDao.getStateTransactionCountAndVal(state_abbr)
				);
		if(write) {
			WriteToFile.writeToLoc("transCountAndValByState", tDao.getStateTransactionCountAndVal(state_abbr).toFile());
		}
	}
}
