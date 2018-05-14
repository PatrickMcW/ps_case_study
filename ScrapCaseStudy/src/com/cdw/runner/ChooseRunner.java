package com.cdw.runner;

import java.util.Scanner;

public class ChooseRunner {
	public static void main(String[] args) {
		
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
