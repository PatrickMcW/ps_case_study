package com.cdw.resources;

import java.util.Arrays;

public class Output {
	public int outputInt;
	public String outputString;
	public String[] outputDateSplit; //[0] should be day, [1] should be month
	
	//constructors
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
	
	
	
	//toString
	@Override
	public String toString() {
		return "Output [outputInt=" + outputInt + ", outputString=" + outputString + ", outputDateSplit="
				+ Arrays.toString(outputDateSplit) + "]";
	}
	
	
}
