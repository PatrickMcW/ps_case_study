package com.cdw.runner;

import java.util.Scanner;

import com.cdw.resources.WriteToFile;

public class ChooseRunner {
	public static void main(String[] args) {
		//delete files here to clean up last run
		String[] fileNames = {
				"transByZipMonthYear", "transCountAndValByType", "transCountAndValByState",
				"customerBySsn", "updatedCustomer", "monthInvoice","custTransBetweenDates"
				};
		String[] columnNames = {
				"t_id,d,m,y,ccn,branch,transaction_type,transaction_value,c_ssn",
				"type, val, count",
				"state, val, count",
				"fName, mName,lName,ssn,ccn,aptN,streetN,custCity,custState,custCountry,custZip,custPhone,custEmail",
				"fName, mName,lName,ssn,ccn,aptN,streetN,custCity,custState,custCountry,custZip,custPhone,custEmail",
				"balance, fName, lName, id",
				"fName, mName, lName,t_id,d,m,y,ccn,branch,transaction_type,transaction_value"
				
		};
		for(int i = 0;i<fileNames.length;i++) {
			WriteToFile.overWrite(fileNames[i]);
			WriteToFile.writeToLoc(fileNames[i], columnNames[i]);
		}
		//might be easier to just non-append-write the files here to blank them out
			//narrator: it was.	
		Scanner scanner = new Scanner (System.in);
		select(scanner);
		scanner.close();
		return;	
	}
	public static void select(Scanner scanner) {
		System.out.println("Available report query types:"); 
		System.out.println("1. Transaction category");
		System.out.println("2. Customer category ");
		System.out.println("0 to exit program");
		System.out.println("Choose: ");
		int input = scanner.nextInt();
		
		while(input!=0) {
			switch (input) {
				case 1:{
					TransactionRunner.Run(scanner);
				}
				break;
				case 2:{
					CustomerRunner.Run(scanner);
				}
				break;			
				default: {
					System.out.println("You hit default, run again");
					select(scanner);
				}
				break;		
			}
			System.out.println();
		}
		if(input==0) {
			System.out.println("You have exited the program. Have a great day!");
			System.exit(0);
		}
	}
}
