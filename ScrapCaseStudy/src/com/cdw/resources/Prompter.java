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
	private static final String monthTestEntry = "2";
	
	private static final String yearPrompt = "year criteria";
	private static final String yearTestEntry = "2018"; //only year in records
	
	private static final String statePrompt = "state criteria";
	private static final String stateTestEntry = "CT"; //not case sensitive in mysqlworkbench

	private static final String typePrompt = "type criteria";
	private static final String typeTestEntry = "Bills"; //case insensitive

	
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
				if ( zipValidCheck(stringIn, invalid) ) {
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
				if( monthValidCheck(intIn, invalid)) {
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
				if( yearValidCheck(intIn, invalid)) {
					output = new Output(intIn, null);
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
				if( stateValidCheck(stringIn, invalid)) {
					output = new Output(-1, stringIn); //-1 placeholder value
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
				if( typeValidCheck(stringIn, invalid)) {
					output = new Output(-1, stringIn); //-1 placeholder value
				}
				break;
			}
			default: {
				System.out.println("Somehow reached default case in staging switch");
			}

		}
		return output;
	}

	private static boolean zipValidCheck(String zIn, String invalid) {
		if(zIn.length()!=5) {
			System.out.println(invalid);
			staging("zip");
		}	
		return true; //should only be reached if the above if the zIn length is 5
	}
	private static boolean monthValidCheck(int mIn, String invalid) {
		if( mIn<1 || mIn>12 ) {
			System.out.println(invalid);
			staging("month");
		}
		return true; //reachable only if month valid??
	}
	private static boolean yearValidCheck(int yIn, String invalid) {
		if( yIn!=2018 ) {
			System.out.println(invalid);
			System.out.println("The only year in this dataset is 2018"); 
			//I could probably just not prompt for a year input but the reqs are the reqs
			staging("year");
		}
		return true; //reachable only if valid year entered
	}
	private static boolean typeValidCheck(String sIn, String invalid) {
		String[] valids = new String[]  { "Education","Entertainment","Grocery","Gas","Bills","Test","Healthcare" };
		
		if(!Arrays.asList(valids).contains(sIn)) {
			//if the transaction_type is not a valid type, reject it.
			System.out.println(invalid);
			System.out.println("Valid types are: ");
			for(String v:valids) {
				System.out.print(v+" ");
			}
			System.out.println();
			staging("type");
		} 
		return true; //reachable only if valid type entered
	}
	private static boolean stateValidCheck(String state_abbr, String invalid) {
		String[] valids = new String[] {"MN","IL","NY","FL","PA","NJ","CT","OH","MI","KY","MD","WA","CA","TX","NC","VA","GA","MT","AR","MS","WI","IN","SC","MA","IA","AL"};
//		"MN","IL","NY","FL","PA","NJ","CT","OH","MI","KY","MD","WA","CA","TX","NC","VA","GA","MT","AR","MS","WI","IN","SC","MA","IA","AL"

		if(!Arrays.asList(valids).contains(state_abbr)) {
			//if the transaction_type is not a valid type, reject it.
			System.out.println(invalid);
			System.out.println("Valid states are: ");
			for(String v:valids) {
				System.out.print(v+" ");
			}
			System.out.println();
			staging("state");
		} 
		
		return true;
	}
}
