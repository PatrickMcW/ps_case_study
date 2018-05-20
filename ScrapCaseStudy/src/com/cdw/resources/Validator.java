package com.cdw.resources;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Validator {
	//contains methods to validate input from user prompts
	
	private Validator() {};//prevent instantiation;
	
	public static boolean ccnValidCheck(String cIn, String invalid) {
		if(! ( cIn.length()==16 && cIn.matches("[0-9]+") ) ) {
			System.out.println(invalid);
			return false;
//			Prompter.staging("ccn");
		}
		return true;
	}
	
	public static boolean custSsnValidCheck(String sIn, String invalid) {
		if(!(sIn.length()==9 &&
				Integer.valueOf(sIn) instanceof Integer //this may allow too many kinds of entries, but good enough for now
			 )
			) {
			System.out.println(invalid);
			return false;
//			Prompter.staging("ssn");
		}		
		return true;
	}
	
	public static boolean zipValidCheck(String zIn, String invalid) {
		if(zIn.length()!=5) {
			System.out.println(zIn.length());
			System.out.println(invalid);
			System.out.println(zIn);
			return false;
//			Prompter.staging("zip");
		}	
		System.out.println(zIn.length());
		System.out.println("valid");
		return true; //should only be reached if the above if the zIn length is 5
	}
	
	public static boolean monthValidCheck(int mIn, String invalid) {
//		if( mIn<1 || mIn>12 ) {
//			System.out.println(invalid);
//			return false;
////			Prompter.staging("month");
//		}
//		return true; //reachable only if month valid??
		if( mIn>=1 && mIn<=12 ) {
			System.out.println("valid month");
			return true;
//			Prompter.staging("month");
		}
		System.out.println(invalid);
		return false; //reachable only if month valid??
	}
	
	public static boolean yearValidCheck(int yIn, String invalid) {
		System.out.println(yIn + " was yin in yearValidCheck");
		if( yIn!=2018 ) {
			System.out.println(yIn);
			System.out.println(invalid);
			System.out.println("The only year in this dataset is 2018"); 
			//I could probably just not prompt for a year input but the reqs are the reqs
			return false;
//			Prompter.staging("year");
		}
		System.out.println(yIn);
//		System.out.println(invalid);
		return true; //reachable only if valid year entered
	}
	
	public static boolean typeValidCheck(String sIn, String invalid) {
		String[] valids = new String[]  { "Education","Entertainment","Grocery","Gas",
				"Bills","Test","Healthcare" };
		
		if(!Arrays.asList(valids).contains(sIn)) {
			//if the transaction_type is not a valid type, reject it.
			System.out.println(invalid);
			System.out.println("Valid types are: ");
			for(String v:valids) {
				System.out.print(v+" ");
			}
			System.out.println();
			return false;
//			Prompter.staging("type");
		} 
		return true; //reachable only if valid type entered
	}
	
	public static boolean stateValidCheck(String state_abbr, String invalid) {
		String[] valids = new String[] {"MN","IL","NY","FL","PA","NJ","CT","OH","MI","KY",
				"MD","WA","CA","TX","NC","VA","GA","MT","AR","MS","WI","IN","SC","MA","IA","AL"};

		if(!Arrays.asList(valids).contains(state_abbr)) {
			//if the transaction_type is not a valid type, reject it.
			System.out.println(invalid);
			System.out.println("Valid states are: ");
			for(String v:valids) {
				System.out.print(v+" ");
			}
			System.out.println();
			return false;
//			Prompter.staging("state");
		} 
		
		return true;
	}
	public static boolean dateMonthValidCheck(String[] split, String invalid) {
		//split[0] is the day, split[1] is the month
		int[] dayMonthAsInts = new int[] {Integer.parseInt(split[0]), Integer.parseInt(split[1])};
		Map<Integer, Integer[]> maxDays = new HashMap<Integer,Integer[]>();
		maxDays.put(28 , new Integer[] {2}); //we're not checking for leap years TODO: incorporate leap year check as needed
		maxDays.put(30 , new Integer[] {4,6,9,11});
		maxDays.put(31 , new Integer[] {1,3,5,7,8,10,12});
		if(dayMonthAsInts[1]>=29) {
			for(Map.Entry<Integer, Integer[]> e : maxDays.entrySet() ) {
				if(e.getKey()==dayMonthAsInts[0]) {
					Arrays.asList(e.getValue()).contains(dayMonthAsInts[1]);
					return true;
				} //else return false might end this before we have a chance to check other keys where the value may be OK
			}
		} else {
			return true; //valid date if day is 28 or less as all months have that
		}
		
		System.out.println("end of dateMonthValidCheck(String dm, String invalid)");
		return false;
	}
	
	public static boolean columnValidCheck(String col_name, String invalid) {
		String[] valids = new String[] {"FIRST_NAME", "MIDDLE_NAME", "LAST_NAME", 
				"SSN", "CREDIT_CARD_NO", "APT_NO", "STREET_NAME", "CUST_CITY",
				"CUST_STATE", "CUST_COUNTRY", "CUST_ZIP", "CUST_PHONE", "CUST_EMAIL"};
		
//		if(!Arrays.asList(valids).contains(col_name)) {
//			//if the transaction_type is not a valid type, reject it.
//			System.out.println(invalid);
//			System.out.println("Valid column names are: ");
//			for(int i=0; i<valids.length;i++) {
//				if(i==valids.length-1) {
//					System.out.print(valids[i]+".");
//				} else if(i%4==0) {
//					System.out.println(valids[i]+",");
//				} else {
//					System.out.print(valids[i]+", ");
//				}
//			}
//			System.out.println();
//			System.out.println("columnValidCheck reject");
////			return false;
//			Prompter.staging("column");
//			return false;
//		} else {
//			System.out.println("columnValidCheck pass");
//			return true; //this may be redundant, but we'll see if ELEPHANTS breaks this again
//		}
//		System.out.println("why is this printing");
//		return false;
		if(Arrays.asList(valids).contains(col_name)) {
			System.out.println("columnValidCheck pass");
			return true; //this may be redundant, but we'll see if ELEPHANTS breaks this again

		} else {
			//if the transaction_type is not a valid type, reject it.
			System.out.println(invalid);
			System.out.println("Valid column names are: ");
			for(int i=0; i<valids.length;i++) {
				if(i==0) {
					System.out.print(valids[i]+",");
				} else if(i==valids.length-1) {
					System.out.print(valids[i]+".");
				} else if(i%4==0) {
					System.out.println(valids[i]+",");
				} else {
					System.out.print(valids[i]+", ");
				}
			}
			System.out.println();
			System.out.println("columnValidCheck reject");
//			return false;
			return false;
//			Prompter.staging("column");
		}
	}
	
	//weak checks
	public static boolean newStringValValidCheck(String stringIn, String invalid) {
		if(stringIn.length()>40) { //this is a shitty metric, but here we are
			return false;
//			Prompter.staging("newStringVal");
		}
		return true;
	}
	public static boolean newIntValValidCheck(int intIn, String invalid) {
		if( Integer.toString(intIn).length()>10) {
			return false;
//			Prompter.staging("newIntVal");
		}
		return true;
	}
}
