package com.cdw.resources;

import java.util.Arrays;
import java.util.Scanner;

public class RoundThree {
	private static final Scanner scanner = new Scanner (System.in);
	
	public static void wholeShabang(String type, Output output) {
		String str = null;
		int n = -1;
		String[] split = null;
		prompt(type, output);
		switch(checkOutputType(type)) {
		case "arr":{
//			split = getSplitInput(type, split, output);
//			output.setOutputDateSplit(split);
//			break;
			System.out.println("arr case");
			System.out.println(output + " was output");
			getSplitInput(type, split, output);
			
			break;
		}
		case "ints":{
//			n = getIntInput(type, n);
//			output.setOutputInt(n);
//			break;
			System.out.println("ints case");
			System.out.println(output + " was output");
			getIntInput(type, n, output);
			break;
		}
		case "strings": {
			System.out.println("strings case");
			System.out.println(output + " was output");
//			str = getStringInput(type, str);
			getStringInput(type, str, output); //string input should be changed if invalid, otherwise, continue
			if(type=="zip") {
				System.out.println("zip in case strings");
				System.out.println(str + " was str");
				System.out.println(output + " was output");
//				System.out.println(" -----");
//				output.setOutputInt(Integer.parseInt(str));
//				System.out.println("was output after set");
			} 
//			else {	
//				System.out.println("else in case strings");
//				output.setOutputString(str);
//			}
			break;
		}
		default:{
			System.out.println("you done f@#$ed up");
		}
		}
		
		System.out.println("end of whole shabang");
	}
		//prompt
		//get input
		//check input , then 
	
	//i think the problem is here, because if i call the input again, the first return still happens?
		//while false/invalid, reprompt
		//while true/valid, return
		
		//when true, set values, then return
	public static void prompt(String type, Output output) {
		String p=null, test=null, b = Prompts.stringExit;
		switch(type) {
		case "zip":{
			p = Prompts.openPrompt + Prompts.zipPrompt +": ";
			test = Prompts.zipTestEntry;
			break;
		}
		case "month":{
			p = Prompts.openPrompt + Prompts.monthPrompt +": ";
			test = Prompts.monthTestEntry;
//			invalid = Prompts.invalidOpen + Prompts.monthPrompt + Prompts.invalidClose;
			b = Prompts.intExit;
			break;
		}
		case "year":{
			p = Prompts.openPrompt + Prompts.yearPrompt +": ";
			test = Prompts.yearTestEntry;
//			invalid = Prompts.invalidOpen + Prompts.yearPrompt + Prompts.invalidClose;
			b = Prompts.intExit;
			break;
		}
		case "state":{
			p = Prompts.openPrompt + Prompts.statePrompt +": ";
			test = Prompts.stateTestEntry;
//			invalid = Prompts.invalidOpen + Prompts.statePrompt + Prompts.invalidClose;
			break;
		}
		case "type":{
			p = Prompts.openPrompt + Prompts.typePrompt +": ";
			test = Prompts.typeTestEntry;
//			invalid = Prompts.invalidOpen + Prompts.typePrompt + Prompts.invalidClose;
			break;
		}
		case "ssn":{
			p = Prompts.openPrompt + Prompts.ssnPrompt +": ";
			test = Prompts.ssnTestEntry;
//			invalid = Prompts.invalidOpen + Prompts.ssnPrompt + Prompts.invalidClose;
			break;
		}
		case "ccn":{
			p = Prompts.openPrompt + Prompts.getCcnPrompt +": ";
			test = Prompts.getCcnTestEntry;
//			invalid = Prompts.invalidOpen + Prompts.getCcnPrompt + Prompts.invalidClose;
			break;
		}
		case "dateMonth":{
			p = Prompts.openPrompt + Prompts.dateMonthPrompt +": ";
			test = Prompts.dateMonthTestEntry;
//			invalid = Prompts.invalidOpen + Prompts.dateMonthPrompt + Prompts.invalidClose;
			break;
		}
		case "column":{
			p = Prompts.openPrompt + Prompts.columnPrompt +": ";
			test = Prompts.columnTestEntry;
//			invalid = Prompts.invalidOpen + Prompts.columnPrompt + Prompts.invalidClose;
			break;
		}
		case "newStringVal":{
			p = Prompts.openPrompt + Prompts.newStringValPrompt +": ";
			test = Prompts.newStringValTestEntry;
//			invalid = Prompts.invalidOpen + Prompts.newStringValPrompt + Prompts.invalidClose;
			break;
		}
		case "newIntVal":{
			p = Prompts.openPrompt + Prompts.newIntValPrompt +": ";
			test = Prompts.newIntValTestEntry;
//			invalid = Prompts.invalidOpen + Prompts.newIntValPrompt + Prompts.invalidClose;
			b = Prompts.intExit;
			break;
		}
		default: {
			p = "default case";
			test = "default case";
//			invalid = "default case";
			b= "default case"; 
			
		}
	}
	Prompts.showPrompt(p, test, type, b);
	}

	public static String checkOutputType(String type) {
		String[] outInts = {"month","year","ssn","newIntVal"};
		String[] outStrings = {"ccn","zip","type","state","column","newStringVal","newIntVal"};
		String[] outArr = {"dateMonth"};
//		String[] outStrings = {"ccn","zip","type","state","column","newStringVal","newIntVal","dateMonth"};
		if(Arrays.asList(outArr).contains(type)) {
			return "arr";
		} else if(Arrays.asList(outInts).contains(type)) {
			return "ints";
		} else if(Arrays.asList(outStrings).contains(type)) {
			return "strings";
		} else {
			return "undefined";
		}
	}
	
//	public static String getStringInput(String type, String input) {
	public static void getStringInput(String type, String input, Output output) {
		input = scanner.next();
		String invalid = "";
		switch(type) {
		case "zip":{
			invalid = Prompts.invalidOpen + Prompts.zipPrompt + Prompts.invalidClose;
//			if(Validator.zipValidCheck(input, invalid)) {
//				return input;
//			} else {
//				getStringInput(type, input);
//			}
			if(!Validator.zipValidCheck(input, invalid)) {
				getStringInput(type, input, output);
			} 
			else {
				//input is valid, do nothing
				output.setOutputString(input);
			}
			break;
		}
		case "state": {
			invalid = Prompts.invalidOpen + Prompts.statePrompt + Prompts.invalidClose;
			if(!Validator.stateValidCheck(output.getOutputString(), invalid)) {
				getStringInput(type, input, output);
			} else {
				output.setOutputString(input);
			}
			break;
		}
		case "type": {
			invalid = Prompts.invalidOpen + Prompts.typePrompt + Prompts.invalidClose;
			if(!Validator.typeValidCheck(output.getOutputString(), invalid)) {
				getStringInput(type, input, output);
			} else {
				output.setOutputString(input);
			}
			break;
		}
		case "ssn": {
			invalid = Prompts.invalidOpen + Prompts.ssnPrompt + Prompts.invalidClose;
			if(!Validator.custSsnValidCheck(output.getOutputString(), invalid)) {
				getStringInput(type, input, output);
			} else {
				output.setOutputString(input); 
			}
			break;
		}
		case "ccn": {
			invalid = Prompts.invalidOpen + Prompts.getCcnPrompt + Prompts.invalidClose;
			if(!Validator.ccnValidCheck(output.getOutputString(), invalid)) {
				getStringInput(type, input, output);
			} else {
				output.setOutputString(input);
			}
			break;
		}
		case "column": {
			invalid = Prompts.invalidOpen + Prompts.columnPrompt + Prompts.invalidClose;
			if(!Validator.columnValidCheck(output.getOutputString(), invalid)) {
				getStringInput(type, input, output);
			} else {
				output.setOutputString(input);
			}
			break;
		}
		case "newStringVal": {
			invalid = Prompts.invalidOpen + Prompts.newStringValPrompt + Prompts.invalidClose;
			if(!Validator.newStringValValidCheck(output.getOutputString(), invalid)) {
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
//		}
		
		default: {
			getStringInput(type, input, output);
		}
		}
	}
	public static void getSplitInput(String type, String[] input, Output output) {
		input = scanner.next().split("/");
		String invalid = "";
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
		input = scanner.nextInt();
		String invalid = "";
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
				System.out.println(input + "  input in if(!Validator.yearValidCheck(output.getOutputInt(), invalid))");
				getIntInput(type, input, output);
			} else {
				System.out.println(input + " was input in else of if(!Validator.yearValidCheck(output.getOutputInt(), invalid)");
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
//	}
		default: {
			getIntInput(type, input, output);
			}
		}
	}

}