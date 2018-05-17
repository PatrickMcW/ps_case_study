package com.cdw.resources;

import java.util.Scanner;

import com.cdw.runner.ChooseRunner;

public final class Prompter {
	private static final String openPrompt = "Please provide the ";
	private static final String invalidOpen = "An invalid ";
	private static final String invalidClose = " was entered, please try again.";
	private static final String intExit = "Enter 0 to re-select category";
	private static final String stringExit = "Enter EXIT to re-select category";
	
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
	private static final String ssnTestEntry = "123456100"; 
	
	private static final String getCcnPrompt = "credit card number";
	private static final String getCcnTestEntry = "4210653310061055 or 4210653349028689"; 

	private static final String dateMonthPrompt = "date criteria (format: dd/mm)";
	private static final String dateMonthTestEntry = "01/11 or 30/11"; 
	
	
	private static final String columnPrompt = "column criteria";
	private static final String columnTestEntry = "first_name"; 
	
	private static final String newStringValPrompt = "new string for field";
	private static final String newStringValTestEntry = "";
	
	private static final String newIntValPrompt = "new int for field";
	private static final String newIntValTestEntry = "";

	private static final Scanner scanner = new Scanner (System.in); // this got rid of the yellow underline for similar declaration in staging(), but you would think the scanner should still be closed
	
	public static Output staging(String type/*, Scanner scanner*/) {
//		Scanner scanner = new Scanner (System.in); //if i can open/close scanner without issue here, do that,
		//otherwise, open in calling main and close there, and pass as arg
		String stringIn;
		int intIn;
		Output output = null;
		String prompt=null,test=null, invalid=null, back=null ;
		switch(type) {
			case "zip": {
				// set string values
				prompt = openPrompt + zipPrompt +": ";
				test = zipTestEntry;
				invalid = invalidOpen + zipPrompt + invalidClose;
				back = stringExit;
				//show prompt
				showPrompt(prompt, test, type, back);
				
				//get and validate entry
				stringIn = scanner.next();
				if(stringIn.equals("EXIT")) {
					ChooseRunner.select(scanner);
				} else if ( Validator.zipValidCheck(stringIn, invalid) ) {
					output = new Output(Integer.parseInt(stringIn));
				}
				break;
			}
			case "month": {
				// set string values
				prompt = openPrompt + monthPrompt +": ";
				test = monthTestEntry;
				invalid = invalidOpen + monthPrompt + invalidClose;
				back = intExit;
				//show prompt
				showPrompt(prompt, test, type, back);

				//get and validate entry
				intIn = scanner.nextInt();
				if(intIn==0) {
					ChooseRunner.select(scanner);
				} else if( Validator.monthValidCheck(intIn, invalid)) {
					output = new Output(intIn);
				}
				break;
			}
			case "year": {
				// set string values
				prompt = openPrompt + yearPrompt +": ";
				test = yearTestEntry;
				invalid = invalidOpen + yearPrompt + invalidClose;
				back = intExit;
				//show prompt
				showPrompt(prompt, test, type,back);

				//get and validate entry
				intIn = scanner.nextInt();
				if(intIn==0) {
					ChooseRunner.select(scanner);
				} else if( Validator.yearValidCheck(intIn, invalid)) {
					output = new Output(intIn); 
				}
				
				break;
			}
			case "state": {
				// set string values
				prompt = openPrompt + statePrompt +": ";
				test = stateTestEntry;
				invalid = invalidOpen + statePrompt + invalidClose;
				back = stringExit;
				//show prompt
				showPrompt(prompt, test, type, back);
				
				//get and validate entry
				stringIn = scanner.next();
				if(stringIn.equals("EXIT")) {
					ChooseRunner.select(scanner);
				} else if( Validator.stateValidCheck(stringIn, invalid)) {
					output = new Output(stringIn); 
				}
				break;
			}
			case "type": {
				//set string values
				prompt = openPrompt + typePrompt +": ";
				test = typeTestEntry;
				invalid = invalidOpen + typePrompt + invalidClose;
				back = stringExit;
				//show prompt
				showPrompt(prompt, test, type, back);
				
				//get and validate entry
				stringIn = scanner.next();
				if(stringIn.equals("EXIT")) {
					ChooseRunner.select(scanner);
				} else if( Validator.typeValidCheck(stringIn, invalid)) {
					output = new Output(stringIn); 
				}
				break;
			}
			case "ssn": {
				//set string values
				prompt = openPrompt + ssnPrompt +": ";
				test = ssnTestEntry;
				invalid = invalidOpen + ssnPrompt + invalidClose;
				back = stringExit;
				//show prompt
				showPrompt(prompt, test, type, back);
				
				//get and validate entry
				stringIn = scanner.next();
				if(stringIn.equals("EXIT")) {
					ChooseRunner.select(scanner);
				} else if( Validator.custSsnValidCheck(stringIn, invalid) ) {
					output = new Output(Integer.parseInt(stringIn), stringIn);
				}
				
				break;
			}
			case "ccn": {
				//set string values
				prompt = openPrompt + getCcnPrompt +": ";
				test = getCcnTestEntry;
				invalid = invalidOpen + getCcnPrompt + invalidClose;
				back = stringExit;
				//show prompt
				showPrompt(prompt, test, type, back);
				
				//get and validate entry
				stringIn = scanner.next();
				if(stringIn.equals("EXIT")) {
					ChooseRunner.select(scanner);
				} else if( Validator.ccnValidCheck(stringIn, invalid) ) {
					output = new Output(stringIn);
				}
				
				break;
			}
			case "dateMonth":{			
				// set string values
				prompt = openPrompt + dateMonthPrompt +": ";
				test = dateMonthTestEntry;
				invalid = invalidOpen + dateMonthPrompt + invalidClose;
				back = stringExit;
				//show prompt
				showPrompt(prompt, test, type,back);
				
				//get and validate entry
				stringIn = scanner.next();
				String[] splitIn = stringIn.split("/");
				
				if(stringIn.equals("EXIT")) {
					ChooseRunner.select(scanner);
				} else if( Validator.dateMonthValidCheck(splitIn, invalid) ) {
					output = new Output(splitIn); 
				}
				break;
			}
			case "column": {
//				System.out.println("column case in prompter");
				// set string values
				prompt = openPrompt + columnPrompt +": ";
				test = columnTestEntry;
				invalid = invalidOpen + columnPrompt + invalidClose;
				back = stringExit;
				//show prompt
				showPrompt(prompt, test, type, back);
				
				//get and validate entry
				stringIn = scanner.next();
				
				if(stringIn.equals("EXIT")) {
					ChooseRunner.select(scanner);
				} else if( Validator.columnValidCheck(stringIn, invalid) ) {
					output = new Output(stringIn); 
				}
				break;
			}
			case "newStringVal": {
				System.out.println("newStringVal case in prompter");
				// set string values
				prompt = openPrompt + newStringValPrompt +": ";
				test = newStringValTestEntry;
				invalid = invalidOpen + newStringValPrompt + invalidClose;
				back = stringExit;
				//show prompt
				showPrompt(prompt, test, type, back);

				//get and validate entry
				stringIn = scanner.next();
				
				if(stringIn.equals("EXIT")) {
					ChooseRunner.select(scanner);
				} else if( Validator.newStringValValidCheck(stringIn, invalid) ) {
					output = new Output(stringIn); 
				}
				
				break;
			}
			case "newIntVal": {
				System.out.println("newIntVal case in prompter");
				// set string values
				prompt = openPrompt + newIntValPrompt +": ";
				test = newIntValTestEntry;
				invalid = invalidOpen + newIntValPrompt + invalidClose;
				back = intExit;
				//show prompt
				showPrompt(prompt, test, type, back);
				
				//get and validate entry
				intIn = scanner.nextInt();
				
				if(intIn==0) {
					ChooseRunner.select(scanner);
				} else if( Validator.newIntValValidCheck(intIn, invalid) ) {
					output = new Output(intIn); 
				}
				
				break;
			}			
			
			default: {
				System.out.println("Somehow reached default case in staging switch");
			}

		}
		return output;
	}
	
	public static void showPrompt(String p, String t, String c, String b) {
		System.out.println(p);
		//special cases: column
		if(c.equals("column")) {
			System.out.println("(use underscores for spaces, and all caps)");
		}
		
		//test values to get results. can be removed for "live" use
		System.out.println(t);	
		
		System.out.println(b);
	}
}
