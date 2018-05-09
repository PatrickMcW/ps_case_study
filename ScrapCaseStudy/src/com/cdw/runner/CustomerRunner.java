package com.cdw.runner;

import java.util.Scanner;

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
				
			}
			break;
			case 2: {
				
			}
			break;
			case 3: {
				
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
}
