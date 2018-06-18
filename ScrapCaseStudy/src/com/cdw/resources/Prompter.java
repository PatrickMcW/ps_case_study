package com.cdw.resources;

import java.util.Arrays;
import java.util.Scanner;

import com.cdw.runner.ChooseRunner;

public class Prompter {
	private static final Scanner scanner = new Scanner (System.in);
	
	public static void prompting(String type, Output output) {
		String str = null;
		int n = -1;
		String[] split = null;
		prompt(type, output);
		switch(checkOutputType(type)) {
			case "arr":{
				getSplitInput(type, split, output);
				
				break;
			}
			case "ints":{
				getIntInput(type, n, output);
				break;
			}
			case "strings": {
				getStringInput(type, str, output); //string input should be changed if invalid, otherwise, continue
				break;
			}
			default:{
				System.out.println("Somehow reached default case of prompting() of Promter.java");
			}
		}
	}

	public static void prompt(String type, Output output) {
		String p=null, test=null, b = Prompts.stringExit;
		switch(type) {
		case "zip":{
			p = Prompts.openPrompt + Prompts.zipPrompt +": ";
			//test = Prompts.zipTestEntry;
			break;
		}
		case "month":{
			p = Prompts.openPrompt + Prompts.monthPrompt +": ";
			//test = Prompts.monthTestEntry;
			b = Prompts.intExit;
			break;
		}
		case "year":{
			p = Prompts.openPrompt + Prompts.yearPrompt +": ";
			//test = Prompts.yearTestEntry;
			b = Prompts.intExit;
			break;
		}
		case "state":{
			p = Prompts.openPrompt + Prompts.statePrompt +": ";
			//test = Prompts.stateTestEntry;
			break;
		}
		case "type":{
			p = Prompts.openPrompt + Prompts.typePrompt +": ";
			//test = Prompts.typeTestEntry;
			break;
		}
		case "ssn":{
			p = Prompts.openPrompt + Prompts.ssnPrompt +": ";
			//test = Prompts.ssnTestEntry;
			break;
		}
		case "ccn":{
			p = Prompts.openPrompt + Prompts.getCcnPrompt +": ";
			//test = Prompts.getCcnTestEntry;
			break;
		}
		case "dateMonth":{
			p = Prompts.openPrompt + Prompts.dateMonthPrompt +": ";
			//test = Prompts.dateMonthTestEntry;
			break;
		}
		case "column":{
			p = Prompts.openPrompt + Prompts.columnPrompt +": ";
			//test = Prompts.columnTestEntry;
			break;
		}
		case "newStringVal":{
			p = Prompts.openPrompt + Prompts.newStringValPrompt +": ";
			//test = Prompts.newStringValTestEntry;
			break;
		}
		case "newIntVal":{
			p = Prompts.openPrompt + Prompts.newIntValPrompt +": ";
			//test = Prompts.newIntValTestEntry;
			b = Prompts.intExit;
			break;
		}
		default: {
			p = "default case";
			//test = "default case";
			b= "default case"; 
			
		}
	}
	Prompts.showPrompt(p, test, type, b);
	}

	public static String checkOutputType(String type) {
		String[] outInts = {"month","year","newIntVal"};
		String[] outStrings = {"ccn","zip","type","state","column","newStringVal","newIntVal","ssn",};
		String[] outArr = {"dateMonth"};
		if(Arrays.asList(outArr).contains(type)) {
			return "arr";
		} else if(Arrays.asList(outInts).contains(type)) {
			return "ints";
		} else if(Arrays.asList(outStrings).contains(type)) {
			return "strings";
		} else {
			System.out.println("Somehow reached default case of checkOutputType() of Promter.java");
			return "undefined";
		}
	}
	
	public static void getStringInput(String type, String input, Output output) {
		input = scanner.nextLine();
		String invalid = "";
		if(input.equals("EXIT")) {
			ChooseRunner.select(scanner);
		} 
		switch(type) {
			case "zip":{
				invalid = Prompts.invalidOpen + Prompts.zipPrompt + Prompts.invalidClose;
				if(!Validator.zipValidCheck(input, invalid)) {
					getStringInput(type, input, output);
				} 
				else {
					output.setOutputString(input);
				}
				break;
			}
			case "state": {
				invalid = Prompts.invalidOpen + Prompts.statePrompt + Prompts.invalidClose;
				if(!Validator.stateValidCheck(input, invalid)) {
					getStringInput(type, input, output);
				} else {
					output.setOutputString(input);
				}
				break;
			}
			case "type": {
				invalid = Prompts.invalidOpen + Prompts.typePrompt + Prompts.invalidClose;
				if(!Validator.typeValidCheck(input, invalid)) {
					getStringInput(type, input, output);
				} else {
					output.setOutputString(input);
				}
				break;
			}
			case "ssn": {
				invalid = Prompts.invalidOpen + Prompts.ssnPrompt + Prompts.invalidClose;
				if(!Validator.custSsnValidCheck(input, invalid)) {
					getStringInput(type, input, output);
				} else {
					output.setOutputString(input); 
				}
				break;
			}
			case "ccn": {
				invalid = Prompts.invalidOpen + Prompts.getCcnPrompt + Prompts.invalidClose;
				if(!Validator.ccnValidCheck(input, invalid)) {
					getStringInput(type, input, output);
				} else {
					output.setOutputString(input);
				}
				break;
			}
			case "column": {
				invalid = Prompts.invalidOpen + Prompts.columnPrompt + Prompts.invalidClose;
				input = input.toUpperCase();
				input = input.replace(' ', '_');
				if(!Validator.columnValidCheck(input, invalid)) {
					getStringInput(type, input, output);
				} else {
					output.setOutputString(input);
				}
				break;
			}
			case "newStringVal": {
				invalid = Prompts.invalidOpen + Prompts.newStringValPrompt + Prompts.invalidClose;
				if(!Validator.newStringValValidCheck(input, invalid)) {
					getStringInput(type, input, output);
				} else {
					output.setOutputString(input);
				}
				break;
			}
	//		case "": {
	//			invalid = 
	//			if() {
	//				getStringInput(type, input, output);
	//			} else {
	//				output.setOutputString(input);
	//			}
	//		} //skeletal structure for new options
			
			default: {
				getStringInput(type, input, output);
			}
		}
	}
	public static void getSplitInput(String type, String[] input, Output output) {
		input = scanner.next().split("/");
		String invalid = "";
		if(input[0].equals("EXIT")) {
			ChooseRunner.select(scanner);
		} 
		switch(type) {
		case "dateMonth":{
			invalid = Prompts.invalidOpen + Prompts.dateMonthPrompt + Prompts.invalidClose;
			if(!Validator.dateMonthValidCheck(input, invalid)) {
				getSplitInput(type, input, output);
			} else {
				output.setOutputDateSplit(input);
			}
			break;
		}
		default: {
			getSplitInput(type, input, output);
		}
		}
	}
	public static void getIntInput(String type, int input, Output output) {
		double buffer = scanner.nextDouble();
		if(buffer>Integer.MAX_VALUE) {
			System.out.println("Number too large, please enter something less than " + Integer.MAX_VALUE);
			getIntInput(type, input, output);
		}
		input = (int)buffer;
		String invalid = "";
		if(input==0) {
			ChooseRunner.select(scanner);
		}
		switch(type) {
		case "month": {
			invalid = Prompts.invalidOpen + Prompts.monthPrompt + Prompts.invalidClose;
			if(!Validator.monthValidCheck(input, invalid)) {
				getIntInput(type, input, output);
			} else {
				output.setOutputInt(input);
			}
			break;
		}
		case "year": {
			invalid = Prompts.invalidOpen + Prompts.yearPrompt + Prompts.invalidClose;
			if(!Validator.yearValidCheck(input, invalid)) {
				getIntInput(type, input, output);
			} else {
				output.setOutputInt(input);
			}
			break;
		}
		case "newIntVal": {
			invalid = Prompts.invalidOpen + Prompts.newIntValPrompt + Prompts.invalidClose;
			if(!Validator.newIntValValidCheck(input, invalid)) {
				getIntInput(type, input, output);
			} else {
				output.setOutputInt(input);
			}
			break;
		}
//		case "": {
//		invalid = 
//		if(!) {
//			getIntInput(type, input, output);
//		} else {
//			output.setOutputInt(input);
//		}
//	}	//skeletal structure for new options
		default: {
			getIntInput(type, input, output);
			}
		}
	}

}
