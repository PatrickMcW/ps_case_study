package com.cdw.resources;

import java.util.Scanner;

public final class Prompter {
//	private String type;
//	private Scanner scanner;
	private static final String openPrompt = "Please provide the ";
	private static final String invalidOpen = "An invalid ";
	private static final String invalidClose = "was entered, please try again.";
	
	private static final String zipPrompt = "zip criteria";
	private static final String zipTestEntry = "06109";
//	private static final String zipInvalidEntry = "An invalid zip was entered, please try again";
	
	private static final String monthPrompt = "month (as integer) criteria: ";
	private static final String monthTestEntry = "2";
//	private static final String monthInvalidEntry = "An invalid month was entered, please try again";
	
	private static final String yearPrompt = "year criteria: ";
	private static final String yearTestEntry = "2018"; //only year in records
//	private static final String yearInvalidEntry = "An invalid year was entered, please use 2018";
	
	private static final String statePrompt = "state criteria: ";
	private static final String stateTestEntry = "CT"; //not case sensitive in mysqlworkbench
//	private static final String stateInvalidEntry = "An invalid state was entered, please try again";
	

	
	public static Output staging(String type/*, Scanner scanner*/) {
		Scanner scanner = new Scanner (System.in); //if i can open/close scanner without issue here, do that,
		//otherwise, open in calling main and close there, and pass as arg
		String stringIn;
		int intIn;
		Output output = null;
		String prompt=null,test=null, invalid=null ;
		switch(type) {
			case "zip": {
//					Prompter.zipPrompt;
				prompt = openPrompt + zipPrompt +": ";
				test = zipTestEntry;
				invalid = invalidOpen + zipPrompt + invalidClose;
				
//				prompt(prompt, test, invalid);
				System.out.println(prompt);
				System.out.println(test);
				stringIn = scanner.next();
				if ( zipValidCheck(stringIn, invalid) ) {
//					System.out.println(stringIn + " was stringIn");
					output = new Output(Integer.parseInt(stringIn),null);
//					output.toString();
				}
				break;
			}
			case "month": {
				prompt = openPrompt + monthPrompt +": ";
				test = monthTestEntry;
				invalid = invalidOpen + monthPrompt + invalidClose;
				
//				prompt(prompt, test, invalid);
				System.out.println(prompt);
				System.out.println(test);
				intIn = scanner.nextInt();
				if( monthValidCheck(intIn, invalid)) {
					output = new Output(intIn, null);
				}
				break;
			}
			case "year": {
				prompt = openPrompt + yearPrompt +": ";
				test = yearTestEntry;
				invalid = invalidOpen + yearPrompt + invalidClose;
				System.out.println(prompt);
				System.out.println(test);
				intIn = scanner.nextInt();
				if( yearValidCheck(intIn, invalid)) {
					output = new Output(intIn, null);
				}
				
				break;
			}
			case "state": {
				
				break;
			}
			default: {
				System.out.println("Somehow reached default case in staging switch");
			}

		}
		
		//user is prompted for specific data

		
		//
//		if(type.equals("zip") && inType.equals("string")) {
//		if(type.equals("zip")) {
//			
//		}

		return output;
	}
//	public static void prompt(String prompt, String test, String invalid) {
////		Output output = null;
//		System.out.println(prompt);
//		System.out.println(test);
////		stringIn = scanner.next();
////		zipValidCheck(stringIn);
//		
////		return output;
//	}
	private static boolean zipValidCheck(String zIn, String invalid) {
//		boolean valid = false;
//		System.out.println(zIn + " was zIn in zipValidCheck");
		if(zIn.length()!=5) {
			System.out.println(invalid);
//			prompt(scanner);
			staging("zip");
		}	
//		return valid;
		return true; //should only be reached if the above if the zIn length is 5
	}
	private static boolean monthValidCheck(int mIn, String invalid) {
		if( mIn<1 || mIn>12 ) {
			System.out.println(invalid);
//			monthPrompt(scanner);
			staging("month");
		}
		return true; //reachable only if month valid??
	}
	private static boolean yearValidCheck(int yIn, String invalid) {
		if( yIn!=2018 ) {
			System.out.println(invalid);
			System.out.println("The only year in this dataset is 2018"); 
			//I could probably just not prompt for a year input but the reqs are the reqs
//			monthPrompt(scanner);
			staging("year");
		}
		return true; //reachable only if valid year(s)
	}
}
