package com.cdw.resources;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class WriteToFile {
	public static void main(String[] args) {
//		PrintWriter writer = null;
//		Scanner scanner = new Scanner (System.in);
//		System.out.println("Do you want to write these results to file?");
//		System.out.println("1 for yes, 2 for no: ");
//		int wantWrite = scanner.nextInt(); 
//		//file name only, not extension.
//		if(wantWrite==1) {
//			
//			System.out.println("Enter file name (no extension, will be .csv): ");
//			String loc = scanner.next(); //probably need a check here for legit file names
//			try {
//				writer = new PrintWriter(new BufferedWriter(new FileWriter(loc+".csv", true)));
//				//probably need a way to clean the file between test runs
//				writeToLoc(/*loc,*/ writer);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} //true param should allow appending, rather than overwriting.
//			finally {
//				writer.close();
//			}
//			
//			
//		}
//		
//		
//		
	}
	public static boolean writeFileQuestion(Scanner scanner) {
		System.out.println("Do you want to write the results to a file?");
		System.out.println("1 for yes, 2 for no: ");
		String input = scanner.next();
		if(input.equals("1")) {
			return true;
		} else {	
			return false;
		}
		
	}
	public static void writeToLoc(String loc, String printable/*, PrintWriter writer*/) {
		try {
			PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(loc+".csv", true)));
//			System.out.println(printable);
//			System.out.println("=================");
			writer.println(printable);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//indicate to user where file is?
	}
	public static void overWrite(String loc) {
		try {
			FileWriter writer = new FileWriter(loc+".csv");
			writer.write("");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
