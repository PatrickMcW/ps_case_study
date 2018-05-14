package com.cdw.runner;

import java.util.Scanner;

public class ChooseRunner {
	public static void main(String[] args) {
		System.out.println("Available report query types:"); 
		System.out.println("1. Transaction category");
		System.out.println("2. Customer category ");
		System.out.println("Choose: ");
		Scanner scanner = new Scanner (System.in);
		int input = scanner.nextInt();
		switch (input) {
			case 1:{
				TransactionRunner.Run(scanner);
			}
			break;
			case 2:{
				CustomerRunner.Run(scanner);
			}
			break;
			
		}
	}
}
