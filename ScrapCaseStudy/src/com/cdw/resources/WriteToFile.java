package com.cdw.resources;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class WriteToFile {
	private WriteToFile() {};
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
			writer.println(printable);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//indicate to user where file is?
		//it is in default (src) directory
		System.out.println("Files are saved in same directory as /src folder");
	}
	public static void overWrite(String loc) {
		try {
			FileWriter writer = new FileWriter(loc+".csv");
			writer.write("");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
