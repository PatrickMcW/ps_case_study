package com.cdw.runner;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import com.cdw.resources.WriteToFile;

public class ChooseRunner {
	public static void main(String[] args) {
		//delete files here to clean up last run
//		Path testPath = Paths.get("*.csv");// Exception in thread "main" java.nio.file.InvalidPathException: Illegal char <*> at index 0: *.csv
//		System.out.println(testPath);
//		System.out.println("csv path");
		String[] fileNames = {
				"transByZipMonthYear", "transCountAndValByType", "transCountAndValByState",
				"customerBySsn", "updatedCustomer", "monthInvoice","custTransBetweenDates"
				};
		for(String n: fileNames) {
			WriteToFile.overWrite(n);
		}
		//might be easier to just non-append-write the files here to blank them out
		
		Scanner scanner = new Scanner (System.in);
		select(scanner);
		//TODO: give exit option, then loop
		//TODO: make prints pretty, give them a 
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
//					return;
//					input = 0;
					select(scanner);
				}
				break;
			
			}
			System.out.println();
		}
		if(input==0) {
			System.out.println("You have exited the program. Have a great day!");
//			return;
			System.exit(0);
		}
		
//		scanner.close();
//		return;
	}
}
