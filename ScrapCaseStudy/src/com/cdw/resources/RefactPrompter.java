package com.cdw.resources;

import java.util.Scanner;

import com.cdw.runner.ChooseRunner;

public class RefactPrompter {

	private static final Scanner scanner = new Scanner (System.in); // this got rid of the yellow underline for similar declaration in staging(), but you would think the scanner should still be closed
	public static void outputter() {
		
	}
//	public static Output staging(String type/*, Scanner scanner*/) {
//	public static boolean staging(String type/*, Scanner scanner*/, Output value) {
	public static boolean staging(String type/*, Scanner scanner*/) {
//		public static void staging(String type/*, Scanner scanner*/, Output value) {
//			Scanner scanner = new Scanner (System.in); //if i can open/close scanner without issue here, do that,
			//otherwise, open in calling main and close there, and pass as arg
			String stringIn;
			int intIn;
//			Output value = new Output() {};
//			Output value;
//			Output value= new Output();
			String prompt=null,test=null, invalid=null, back=null ;
			
			//check input here, then 
			//while false, reprompt
			
			//when true, set values, then return
			switch(type) {
				case "zip":{
					// set string values
					prompt = Prompts.openPrompt + Prompts.zipPrompt +": ";
					test = Prompts.zipTestEntry;
					invalid = Prompts.invalidOpen + Prompts.zipPrompt + Prompts.invalidClose;
					back = Prompts.stringExit;
					//show prompt
					showPrompt(prompt, test, type, back);
					
					//get and validate entry
					stringIn = scanner.next();
					//check for exit command
					if(stringIn.equals("EXIT")) {
						ChooseRunner.select(scanner);
						return false;
//						break;
					}
					
					while(!Validator.zipValidCheck(stringIn, invalid) ) {
						staging(type);
//						staging(type,value);
						return false;
//						break;
					}
//					value=new Output(Integer.parseInt(stringIn)) {};
//					int gb = ;
//					value.reset();
					if(Validator.zipValidCheck(stringIn, invalid)) {
						
//						value.setOutputInt(Integer.parseInt(stringIn));;
//						System.out.println(value);
//						System.out.println("value in zip after set");
						System.out.println("doublecheck that input was valid");
						return true;
					}
					System.out.println("should only print when valid input is confirmed");
					return true;
				}
				case "month": {
					// set string values
					prompt = Prompts.openPrompt + Prompts.monthPrompt +": ";
					test = Prompts.monthTestEntry;
					invalid = Prompts.invalidOpen + Prompts.monthPrompt + Prompts.invalidClose;
					back = Prompts.intExit;
					//show prompt
					showPrompt(prompt, test, type, back);

					//get and validate entry
					intIn = scanner.nextInt(); //if the user is a dick, they can put a really long string here to break things
					if(intIn==0) {
						ChooseRunner.select(scanner);
						return false;
					} 
//					System.out.println(value);
//					System.out.println("value before while");
					while( !Validator.monthValidCheck(intIn, invalid)) {
//						value = new Output();
//						System.out.println(value);
//						System.out.println("value in while, before staging");
						//TODO: put the invalid before staging, take it out of validator. for all?
						staging(type);
//						staging(type,value);
//						System.out.println(value);
//						System.out.println("value in while, after staging");
						return false;
					}
					
//					if(Validator.monthValidCheck(intIn, invalid)) {
//						
////						value.reset();
////						value.setOutputInt(intIn);
////						System.out.println(value);
//						System.out.println("value after while and set");
//					}
					return true;
				}
				case "year": {
					// set string values
					prompt = Prompts.openPrompt + Prompts.yearPrompt +": ";
					test = Prompts.yearTestEntry;
					invalid = Prompts.invalidOpen + Prompts.yearPrompt + Prompts.invalidClose;
					back = Prompts.intExit;
					//show prompt
					showPrompt(prompt, test, type,back);

					//get and validate entry
					intIn = scanner.nextInt();
					if(intIn==0) {
						ChooseRunner.select(scanner);
						return false;
					} 
					while ( !Validator.yearValidCheck(intIn, invalid)) {
						staging(type);
//						staging(type,value);
						return false;
					}
//					value = new Output(intIn); 
//					value.reset();
//					value.setOutputInt(intIn);
					
					return true;
				}
				case "state": {
					// set string values
					prompt = Prompts.openPrompt + Prompts.statePrompt +": ";
					test = Prompts.stateTestEntry;
					invalid = Prompts.invalidOpen + Prompts.statePrompt + Prompts.invalidClose;
					back = Prompts.stringExit;
					//show prompt
					showPrompt(prompt, test, type, back);
					
					//get and validate entry
					stringIn = scanner.next();
					if(stringIn.equals("EXIT")) {
						ChooseRunner.select(scanner);
						return false;
					} 
					while ( !Validator.stateValidCheck(stringIn, invalid)) {
						staging(type);
//						staging(type,value);
						return false;
					}
//					value = new Output(stringIn); 
//					value.reset();
//					value.setOutputString(stringIn);
					return true;
				}
				case "type": {
					//set string values
					prompt = Prompts.openPrompt + Prompts.typePrompt +": ";
					test = Prompts.typeTestEntry;
					invalid = Prompts.invalidOpen + Prompts.typePrompt + Prompts.invalidClose;
					back = Prompts.stringExit;
					//show prompt
					showPrompt(prompt, test, type, back);
					
					//get and validate entry
					stringIn = scanner.next();
					if(stringIn.equals("EXIT")) {
						ChooseRunner.select(scanner);
						return false;
					}
					while ( !Validator.typeValidCheck(stringIn, invalid)) {
						staging(type);
//						staging(type,value);
						return false;
					}
//					value = new Output(stringIn); 
//					value.reset();
//					value.setOutputString(stringIn);
					return true;
				}
				case "ssn": {
					//set string values
					prompt = Prompts.openPrompt + Prompts.ssnPrompt +": ";
					test = Prompts.ssnTestEntry;
					invalid = Prompts.invalidOpen + Prompts.ssnPrompt + Prompts.invalidClose;
					back = Prompts.stringExit;;
					//show prompt
					showPrompt(prompt, test, type, back);
					
					//get and validate entry
					stringIn = scanner.next();
					if(stringIn.equals("EXIT")) {
						ChooseRunner.select(scanner);
						return false;
					} 
					while ( !Validator.custSsnValidCheck(stringIn, invalid) ) {
						staging(type);
//						staging(type,value);
						return false;
					}
					
//					value = new Output(Integer.parseInt(stringIn), stringIn);
//					value.reset();
//					value.setOutputInt(Integer.parseInt(stringIn));
					return true;
				}
				case "ccn": {
					//set string values
					prompt = Prompts.openPrompt + Prompts.getCcnPrompt +": ";
					test = Prompts.getCcnTestEntry;
					invalid = Prompts.invalidOpen + Prompts.getCcnPrompt + Prompts.invalidClose;
					back = Prompts.stringExit;
					//show prompt
					showPrompt(prompt, test, type, back);
					
					//get and validate entry
					stringIn = scanner.next();
					if(stringIn.equals("EXIT")) {
						ChooseRunner.select(scanner);
						return false;
					}

					while ( !Validator.ccnValidCheck(stringIn, invalid) ) {
						staging(type);
//						staging(type,value);
						return false;
					}
//					value = new Output(stringIn);
//					value.reset();
//					value.setOutputString(stringIn);
					return true;
				}
				case "dateMonth":{		 //this validator was returning t/f and not re-prompting, why was this working?	
					// set string values
					prompt = Prompts.openPrompt + Prompts.dateMonthPrompt +": ";
					test = Prompts.dateMonthTestEntry;
					invalid = Prompts.invalidOpen + Prompts.dateMonthPrompt + Prompts.invalidClose;
					back = Prompts.stringExit;
					//show prompt
					showPrompt(prompt, test, type,back);
					
					//get and validate entry
					stringIn = scanner.next();
					String[] splitIn = stringIn.split("/");
					
					if(stringIn.equals("EXIT")) {
						ChooseRunner.select(scanner);
						return false;
					}
					while ( !Validator.dateMonthValidCheck(splitIn, invalid) ) {
						// TODO: review this logic as far as when the validator returns
						// what here
						staging(type);
//						staging(type,value);
						return false;
					}
//					value = new Output(splitIn); 
//					value.reset();
//					value.setOutputDateSplit(splitIn);
					return true;
				}
				case "column": {
//					System.out.println("column case in prompter");
					// set string values
					prompt = Prompts.openPrompt + Prompts.columnPrompt +": ";
					test = Prompts.columnTestEntry;
					invalid = Prompts.invalidOpen + Prompts.columnPrompt + Prompts.invalidClose;
					back = Prompts.stringExit;
					//show prompt
					showPrompt(prompt, test, type, back);
					
					//get and validate entry
					stringIn = scanner.next();
					
					if(stringIn.equals("EXIT")) {
						ChooseRunner.select(scanner);
						return false;
					} 
					
					while( !Validator.columnValidCheck(stringIn, invalid) ) {
//						System.out.println(value);
//						System.out.println(value.toString());
//						System.out.println(value.getOutputString());
//						value;
						staging(type);
//						staging(type,value);
						return false;
					}
//					value = new Output(stringIn); 
//					value.reset();
//					value.setOutputString(stringIn);
					return true;
				}
				case "newStringVal": {
//					System.out.println("newStringVal case in prompter");
					// set string values
					prompt = Prompts.openPrompt + Prompts.newStringValPrompt +": ";
					test = Prompts.newStringValTestEntry;
					invalid = Prompts.invalidOpen + Prompts.newStringValPrompt + Prompts.invalidClose;
					back = Prompts.stringExit;
					//show prompt
					showPrompt(prompt, test, type, back);

					//get and validate entry
					stringIn = scanner.next();
					
					if(stringIn.equals("EXIT")) {
						ChooseRunner.select(scanner);
						return false;
					} 
					while ( !Validator.newStringValValidCheck(stringIn, invalid) ) {
						staging(type);
//						staging(type,value);
						return false;
					}
//					value = new Output(stringIn); 
//					value.reset();
//					value.setOutputString(stringIn);
					
	  				return true;
				}
				case "newIntVal": {
					System.out.println("newIntVal case in prompter");
					// set string values
					prompt = Prompts.openPrompt + Prompts.newIntValPrompt +": ";
					test = Prompts.newIntValTestEntry;
					invalid = Prompts.invalidOpen + Prompts.newIntValPrompt + Prompts.invalidClose;
					back = Prompts.intExit;
					//show prompt
					showPrompt(prompt, test, type, back);
					
					//get and validate entry
					intIn = scanner.nextInt();
					
					if(intIn==0) {
						ChooseRunner.select(scanner);
						return false;
//						return
					} 
					while ( !Validator.newIntValValidCheck(intIn, invalid) ) {
						staging(type);
//						staging(type,value);
						return false;
					}
//					value = new Output(intIn); 
//					value.reset();
//					value.setOutputInt(intIn);
					//while(checkIsFalse){ re-enter} value
					return true;
//					break;
				}			
				
				default: {
					System.out.println("Somehow reached default case in staging switch");
//					value = new Output();
					return false;
				}

			}
			
//			System.out.println("how here");
			//i need to only return an value when one of the cases have been met
//			value;
//			return value;
		}
	
	public static Output setOut(String type) {
//		Output value=null;
		String p=null, t=null, b=null, invalid=null;
		switch(type) {
		case "zip":{
	
			break;
		}
		case "month":{
			
			break;
		}
		case "year":{
			
			break;
		}
		case "state":{
			
			break;
		}
		case "type":{
			
			break;
		}
		case "ssn":{
			
			break;
		}
		case "ccn":{
			
			break;
		}
		case "dateMonth":{
			
			break;
		}
		case "column":{
			
			break;
		}
		case "newStringVal":{
			
			break;
		}
		case "newIntVal":{
			
			break;
		}
//		case "":{}
		default: {
			System.out.println("default in setOut in Prompter");
			break;
		}
		}
		return new Output();
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
