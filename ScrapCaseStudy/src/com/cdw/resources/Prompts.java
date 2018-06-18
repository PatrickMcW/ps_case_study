package com.cdw.resources;

public class Prompts {
	private Prompts() {};
	
	public static final String openPrompt = "Please provide the ";
	public static final String invalidOpen = "An invalid ";
	public static final String invalidClose = " was entered, please try again.";
	public static final String intExit = "Enter 0 to re-select category";
	public static final String stringExit = "Enter EXIT to re-select category";
	
	public static final String zipPrompt = "zip criteria";
//	public static final String zipTestEntry = "06109";
	
	public static final String monthPrompt = "month (as integer) criteria ";
//	public static final String monthTestEntry = "2 or 11";
	
	public static final String yearPrompt = "year criteria";
//	public static final String yearTestEntry = "2018"; //only year in records
	
	public static final String statePrompt = "state criteria";
//	public static final String stateTestEntry = "CT"; //not case sensitive in mysqlworkbench

	public static final String typePrompt = "type criteria";
//	public static final String typeTestEntry = "Bills"; //case insensitive
	
	public static final String ssnPrompt = "customer ssn";
//	public static final String ssnTestEntry = "123456100"; 
	
	public static final String getCcnPrompt = "credit card number";
//	public static final String getCcnTestEntry = "4210653310061055 or 4210653349028689"; 

	public static final String dateMonthPrompt = "date criteria (format: dd/mm)";
//	public static final String dateMonthTestEntry = "01/11 or 30/11"; 
	
	
	public static final String columnPrompt = "column criteria";
//	public static final String columnTestEntry = "first_name"; 
	
	public static final String newStringValPrompt = "new string for field";
//	public static final String newStringValTestEntry = "";
	
	public static final String newIntValPrompt = "new int for field";
//	public static final String newIntValTestEntry = "";

	
//	public static final String
	public static void showPrompt(String p, String test, String type, String b) {
		System.out.println(p);
		//special cases: column
//		if(type.equals("column")) {
//			System.out.println("(use underscores for spaces, and all caps)");
//		} //added input modification to column case in Prompter.java so this warning should be moot
		
		//test values to get results. can be removed for "live" use
//		System.out.println(test);	
		
		System.out.println(b);
	}
	
}
