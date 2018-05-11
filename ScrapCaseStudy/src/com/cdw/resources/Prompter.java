package com.cdw.resources;

import java.util.Arrays;
import java.util.Scanner;

public final class Prompter {
	private static final String openPrompt = "Please provide the ";
	private static final String invalidOpen = "An invalid ";
	private static final String invalidClose = " was entered, please try again.";
	
	private static final String zipPrompt = "zip criteria";
	private static final String zipTestEntry = "06109";
	
	private static final String monthPrompt = "month (as integer) criteria ";
	private static final String monthTestEntry = "2 or 11";
	
	private static final String yearPrompt = "year criteria";
	private static final String yearTestEntry = "2018"; //only year in records
	
	private static final String statePrompt = "state criteria";
	private static final String stateTestEntry = "CT"; //not case sensitive in mysqlworkbench

	private static final String typePrompt = "type criteria";
	private static final String typeTestEntry = "Bills"; //case insensitive
	
	private static final String ssnPrompt = "customer ssn";
	private static final String  ssnTestEntry = "123456100"; 
	
	private static final String getCcnPrompt = "credit card number";
	private static final String  getCcnTestEntry = "4210653349028689"; 
	
	private static final String dayPrompt = "date (of month) criteria";
	private static final String  dayTestEntry = "1 or 23 or 24"; 

	
	public static Output staging(String type/*, Scanner scanner*/) {
		Scanner scanner = new Scanner (System.in); //if i can open/close scanner without issue here, do that,
		//otherwise, open in calling main and close there, and pass as arg
		String stringIn;
		int intIn;
		Output output = null;
		String prompt=null,test=null, invalid=null ;
		switch(type) {
			case "zip": {
				// set string values
				prompt = openPrompt + zipPrompt +": ";
				test = zipTestEntry;
				invalid = invalidOpen + zipPrompt + invalidClose;
				
				//show prompt
				System.out.println(prompt);
				//show test entry that will return results
				System.out.println(test);
				
				//get and validate entry
				stringIn = scanner.next();
				if ( Validator.zipValidCheck(stringIn, invalid) ) {
					output = new Output(Integer.parseInt(stringIn),null);
				}
				break;
			}
			case "month": {
				// set string values
				prompt = openPrompt + monthPrompt +": ";
				test = monthTestEntry;
				invalid = invalidOpen + monthPrompt + invalidClose;
				//show prompt
				System.out.println(prompt);
				System.out.println(test);
				//get and validate entry
				intIn = scanner.nextInt();
				if( Validator.monthValidCheck(intIn, invalid)) {
					output = new Output(intIn, null);
				}
				break;
			}
			case "year": {
				// set string values
				prompt = openPrompt + yearPrompt +": ";
				test = yearTestEntry;
				invalid = invalidOpen + yearPrompt + invalidClose;
				//show prompt
				System.out.println(prompt);
				System.out.println(test);
				//get and validate entry
				intIn = scanner.nextInt();
				if( Validator.yearValidCheck(intIn, invalid)) {
					output = new Output(intIn, null); //outputs int intIn, null string
				}
				
				break;
			}
			case "state": {
				// set string values
				prompt = openPrompt + statePrompt +": ";
				test = stateTestEntry;
				invalid = invalidOpen + statePrompt + invalidClose;
				
				//show prompt
				System.out.println(prompt);
				System.out.println(test);
				
				//get and validate entry
				stringIn = scanner.next();
				if( Validator.stateValidCheck(stringIn, invalid)) {
					output = new Output(-1, stringIn); //-1 placeholder value for int, stringIn for string
				}
				break;
			}
			case "type": {
				//set string values
				prompt = openPrompt + typePrompt +": ";
				test = typeTestEntry;
				invalid = invalidOpen + typePrompt + invalidClose;
				
				//show prompt
				System.out.println(prompt);
				System.out.println(test);
				
				//get and validate entry
				stringIn = scanner.next();
				if( Validator.typeValidCheck(stringIn, invalid)) {
					output = new Output(-1, stringIn); //-1 placeholder value for int, stringIn for string
				}
				break;
			}
			case "ssn": {
				//set string values
				prompt = openPrompt + ssnPrompt +": ";
				test = ssnTestEntry;
				invalid = invalidOpen + ssnPrompt + invalidClose;
				
				//show prompt
				System.out.println(prompt);
				System.out.println(test);
				
				//get and validate entry
				stringIn = scanner.next();
				if( Validator.custSsnValidCheck(stringIn, invalid) ) {
					output = new Output(Integer.parseInt(stringIn), stringIn); //outputs int version of stringIn, stringIn string(but probably dont need to)
				}
				
				break;
			}
			case "ccn": {
				//set string values
				prompt = openPrompt + getCcnPrompt +": ";
				test = getCcnTestEntry;
				invalid = invalidOpen + getCcnPrompt + invalidClose;
				
				//show prompt
				System.out.println(prompt);
				System.out.println(test);
				
				//get and validate entry
				stringIn = scanner.next();
				if( Validator.ccnValidCheck(stringIn, invalid) ) {
					output = new Output(-1, stringIn);//-1 placeholder value for int, stringIn for string
				}
				
				break;
			}
			case "date": {
				// set string values
				prompt = openPrompt + dayPrompt +": ";
				test = dayTestEntry;
				invalid = invalidOpen + dayPrompt + invalidClose;
				//show prompt
				System.out.println(prompt);
				System.out.println(test);
				//get and validate entry
				intIn = scanner.nextInt();
				if( Validator.dateValidCheck(intIn, invalid)) {
					output = new Output(intIn, null); //outputs int intIn, null string
				}
				
				break;
			}
			
			default: {
				System.out.println("Somehow reached default case in staging switch");
			}

		}
		return output;
	}
	
	
}
