package com.cdw.resources;

import java.util.Arrays;


public class Validator {
	
	//contains methods to validate input from user prompts
	public Validator() {};//prevent instantiation;
	
	public static boolean ccnValidCheck(String cIn, String invalid) {
		if(! ( cIn.length()==16 && cIn.matches("[0-9]+") ) ) {
			System.out.println(invalid);
			Prompter.staging("ccn");
		}
			
		
		return true;
	}
	
	public static boolean custSsnValidCheck(String sIn, String invalid) {
		if(!(sIn.length()==9 &&
				Integer.valueOf(sIn) instanceof Integer //this may allow too many kinds of entries, but good enough for now
			 )
			) {
			System.out.println(invalid);
			Prompter.staging("custSsn");
		}
			
		
		return true;
	}
	
	public static boolean zipValidCheck(String zIn, String invalid) {
		if(zIn.length()!=5) {
			System.out.println(invalid);
			Prompter.staging("zip");
		}	
		return true; //should only be reached if the above if the zIn length is 5
	}
	
	public static boolean monthValidCheck(int mIn, String invalid) {
		if( mIn<1 || mIn>12 ) {
			System.out.println(invalid);
			Prompter.staging("month");
		}
		return true; //reachable only if month valid??
	}
	
	public static boolean yearValidCheck(int yIn, String invalid) {
		if( yIn!=2018 ) {
			System.out.println(invalid);
			System.out.println("The only year in this dataset is 2018"); 
			//I could probably just not prompt for a year input but the reqs are the reqs
			Prompter.staging("year");
		}
		return true; //reachable only if valid year entered
	}
	
	public static boolean typeValidCheck(String sIn, String invalid) {
		String[] valids = new String[]  { "Education","Entertainment","Grocery","Gas","Bills","Test","Healthcare" };
		
		if(!Arrays.asList(valids).contains(sIn)) {
			//if the transaction_type is not a valid type, reject it.
			System.out.println(invalid);
			System.out.println("Valid types are: ");
			for(String v:valids) {
				System.out.print(v+" ");
			}
			System.out.println();
			Prompter.staging("type");
		} 
		return true; //reachable only if valid type entered
	}
	
	public static boolean stateValidCheck(String state_abbr, String invalid) {
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
			Prompter.staging("state");
		} 
		
		return true;
	}
}
