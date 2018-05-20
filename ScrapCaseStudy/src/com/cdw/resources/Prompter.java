package com.cdw.resources;

import java.util.Scanner;

import com.cdw.runner.ChooseRunner;

public final class Prompter {
	
	private static final Scanner scanner = new Scanner (System.in); // this got rid of the yellow underline for similar declaration in staging(), but you would think the scanner should still be closed
	
	public static Output staging(String type/*, Scanner scanner*/) {
//	public static void staging(String type/*, Scanner scanner*/, Output output) {
//		Scanner scanner = new Scanner (System.in); //if i can open/close scanner without issue here, do that,
		//otherwise, open in calling main and close there, and pass as arg
		String stringIn;
		int intIn;
//		Output output = new Output() {};
//		Output output;
		Output output= new Output();
		String prompt=null,test=null, invalid=null, back=null ;
		
		//prompt
		//get input
		//check input , then 
		//while false/invalid, reprompt
		//while true/valid, return
		
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
					break;
				}
				
				while(!Validator.zipValidCheck(stringIn, invalid) ) {
					staging(type);
					break;
				}
//				output=new Output(Integer.parseInt(stringIn)) {};
//				int gb = ;
				output.reset();
				if(Validator.zipValidCheck(stringIn, invalid)) {
					
					output.setOutputInt(Integer.parseInt(stringIn));;
					System.out.println(output);
					System.out.println("output in zip after set");
				}
				break;
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
					break;
				} 
				System.out.println(output);
				System.out.println("output before while");
				while( !Validator.monthValidCheck(intIn, invalid)) {
//					output = new Output();
					System.out.println(output);
					System.out.println("output in while, before staging");
					//TODO: put the invalid before staging, take it out of validator. for all?
					staging(type);
					System.out.println("output in while, after staging");
					break;
				}
				
				if(Validator.monthValidCheck(intIn, invalid)) {
					
					output.reset();
					output.setOutputInt(intIn);
					System.out.println(output);
					System.out.println("output after while and set");
				}
				break;
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
					break;
				} 
				while ( !Validator.yearValidCheck(intIn, invalid)) {
					staging(type);
					break;
				}
//				output = new Output(intIn); 
				output.reset();
				output.setOutputInt(intIn);
				
  				break;
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
					break;
				} 
				while ( !Validator.stateValidCheck(stringIn, invalid)) {
					staging(type);
					break;
				}
//				output = new Output(stringIn); 
				output.reset();
				output.setOutputString(stringIn);
  				break;
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
					break;
				}
				while ( !Validator.typeValidCheck(stringIn, invalid)) {
					staging(type);
					break;
				}
//				output = new Output(stringIn); 
				output.reset();
				output.setOutputString(stringIn);
  				break;
			}
			case "ssn": {
				//set string values
				prompt = Prompts.openPrompt + Prompts.ssnPrompt +": ";
				test = Prompts.ssnTestEntry;
				invalid = Prompts.invalidOpen + Prompts.ssnPrompt + Prompts.invalidClose;
				back = Prompts.stringExit;
				//show prompt
				showPrompt(prompt, test, type, back);
				
				//get and validate entry
				stringIn = scanner.next();
				if(stringIn.equals("EXIT")) {
					ChooseRunner.select(scanner);
					break;
				} 
				while ( !Validator.custSsnValidCheck(stringIn, invalid) ) {
					staging(type);
					break;
				}
				
//				output = new Output(Integer.parseInt(stringIn), stringIn);
				output.reset();
				output.setOutputInt(Integer.parseInt(stringIn));
  				break;
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
					break;
				}

				while ( !Validator.ccnValidCheck(stringIn, invalid) ) {
					staging(type);
					break;
				}
//				output = new Output(stringIn);
				output.reset();
				output.setOutputString(stringIn);
  				break;
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
					break;
				}
				while ( !Validator.dateMonthValidCheck(splitIn, invalid) ) {
					// TODO: review this logic as far as when the validator returns
					// what here
					staging(type);
					break;
				}
//				output = new Output(splitIn); 
				output.reset();
				output.setOutputDateSplit(splitIn);
  				break;
			}
			case "column": {
//				System.out.println("column case in prompter");
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
					break;
				} 
				
				while( !Validator.columnValidCheck(stringIn, invalid) ) {
//					System.out.println(output);
//					System.out.println(output.toString());
//					System.out.println(output.getOutputString());
//					output;
					staging(type);
					break;
				}
//				output = new Output(stringIn); 
				output.reset();
				output.setOutputString(stringIn);
				break;
			}
			case "newStringVal": {
//				System.out.println("newStringVal case in prompter");
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
					break;
				} 
				while ( !Validator.newStringValValidCheck(stringIn, invalid) ) {
					staging(type);
					break;
				}
//				output = new Output(stringIn); 
				output.reset();
				output.setOutputString(stringIn);
				
  				break;
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
					break;
//					return
				} 
				while ( !Validator.newIntValValidCheck(intIn, invalid) ) {
					staging(type);
					break;
				}
//				output = new Output(intIn); 
				output.reset();
				output.setOutputInt(intIn);
				//while(checkIsFalse){ re-enter} output
				
				break;
			}			
			
			default: {
				System.out.println("Somehow reached default case in staging switch");
				output = new Output();
			}

		}
//		System.out.println("how here");
		//i need to only return an output when one of the cases have been met
//		output;
		return output;
	}
	
//	public static Output caseTest(String type, boolean check, String input) {
//		
//	}
//	public static Output caseTest(String type, boolean check, int input) {
//		
//	}
//	
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
