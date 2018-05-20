package com.cdw.resources;

import java.util.Arrays;

public class Output {
	private int outputInt;
	private String outputString;
	private String[] outputDateSplit; //[0] should be day, [1] should be month
	
	//constructors
	public Output() {};
	
	public Output(int intIn, String stringIn, String[] arrIn) {
		super();
		this.outputInt = intIn;
		this.outputString = stringIn;
		this.outputDateSplit = arrIn;
	}
	public Output(int outputInt, String outputString) {
		super();
		this.outputInt = outputInt;
		this.outputString = outputString;
	}
	public Output(String stringIn) {
		this.outputString = stringIn;
		if(stringIn!=null) {
			if(stringIn.length()==5) {
				String[] arr = outputString.split("/");
				if(arr.length==2) {
					setOutputDateSplit(arr);
				}
			}
		}
		
	}
	public Output(int intIn) {
		this.outputInt = intIn;
	}
	public Output(String[] splitIn) {
		this.outputDateSplit = splitIn;
	}
	
	//getters
	public int getOutputInt() {
		return outputInt;
	}
	public String getOutputString() {
		return outputString;
	}
	public String[] getOutputDateSplit() {
		return outputDateSplit;
	}
	
	//setters
	public void setOutputInt(int outputInt) {
		this.outputInt = outputInt;
	}
	public void setOutputString(String outputString) {
		this.outputString = outputString;
	}
	public void setOutputDateSplit(String[] outputDateSplit) {
		this.outputDateSplit = outputDateSplit;
	}
	
	public void reset() {
		this.outputDateSplit=null;
		this.outputInt=-1;
		this.outputString=null;
	}
	
	//toString
	@Override
	public String toString() {
		return "Output [outputInt=" + outputInt + ", outputString=" + outputString + ", outputDateSplit="
				+ Arrays.toString(outputDateSplit) + "]";
	}
	
	
}
