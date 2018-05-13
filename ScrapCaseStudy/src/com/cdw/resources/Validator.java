package com.cdw.resources;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


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
			Prompter.staging("ssn");
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
	public static boolean dateMonthValidCheck(String[] split, String invalid) {
		//split[0] is the day, split[1] is the month
		int[] dayMonthAsInts = new int[] {Integer.parseInt(split[0]), Integer.parseInt(split[1])};
		Map<Integer, Integer[]> maxDays = new HashMap<Integer,Integer[]>();
		maxDays.put(29 , new Integer[] {2}); //we're not checking for leap years,but do allow for their entry TODO: incorporate leap year check as needed
		maxDays.put(30 , new Integer[] {4,6,9,11});
		maxDays.put(31 , new Integer[] {1,3,5,7,8,10,12});
		if(dayMonthAsInts[1]>=29) {
			for(Map.Entry<Integer, Integer[]> e : maxDays.entrySet() ) {
//				if(e.getKey()<=dayMonthAsInts[0]) {
				if(e.getKey()==dayMonthAsInts[0]) {
//					for(int i : e.getValue()) {
//						//i is the individual months in this value-set from maxDays???
//						
//					}
					System.out.println("inside if(e.getKey()==dayMonthAsInts[0])");
					Arrays.asList(e.getValue()).contains(dayMonthAsInts[1]);
					return true;
				} //else return false might end this before we have a chance to check other keys where the value may be OK
				System.out.println("inside for(Map.Entry<Integer, Integer[]> e : maxDays.entrySet() )");
			}
			System.out.println("inside if(dayMonthAsInts[1]>=29)");
		} else {
			return true; //valid date if day is 28 or less as all months have that
		}
		
		System.out.println("end of dateMonthValidCheck(String dm, String invalid)");
		//a check for day+month validity is needed i.e. no 30th of feb allowed
		return false;
	}
	
	public static boolean columnValidCheck(String col_name, String invalid) {
		String[] valids = new String[] {"FIRST_NAME", "MIDDLE_NAME", "LAST_NAME", 
				"SSN", "CREDIT_CARD_NO", "APT_NO", "STREET_NAME", "CUST_CITY",
				"CUST_STATE", "CUST_COUNTRY", "CUST_ZIP", "CUST_PHONE", "CUST_EMAIL"};
		
		if(!Arrays.asList(valids).contains(col_name)) {
			//if the transaction_type is not a valid type, reject it.
			System.out.println(invalid);
			System.out.println("Valid column names are: ");
//			for(String v:valids) {
//				System.out.print(v+", ");
//				
//			}
			for(int i=0; i<valids.length;i++) {
				if(i==valids.length-1) {
					System.out.print(valids[i]+".");
				} else if(i%4==0) {
					System.out.println(valids[i]+",");
				} else {
					System.out.print(valids[i]+", ");
				}
			}
			System.out.println();
			Prompter.staging("column");
		}
		
		return true;
	}
	
	//weak checks
	public static boolean newStringValValidCheck(String stringIn, String invalid) {
		//how the hell do I determine if the input is valid for the column 
		//when this has no idea what the column is? make the input a class that has both???
		if(stringIn.length()>40) {
			Prompter.staging("newStringVal");
		}
		return true;
	}
	public static boolean newIntValValidCheck(int intIn, String invalid) {
		//how the hell do I determine if the input is valid for the column 
		//when this has no idea what the column is? make the input a class that has both???
		if( Integer.toString(intIn).length()>10) {
			Prompter.staging("newIntVal");
		}
		return true;
	}
}
