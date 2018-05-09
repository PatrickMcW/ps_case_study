package com.cdw.resources;

public class Output {
	public int outputInt = -1;
	
	public String outputString = null;
	public Output(int outputInt, String outputString) {
		super();
		this.outputInt = outputInt;
		this.outputString = outputString;
	}
	public int getOutputInt() {
		return outputInt;
	}
	public String getOutputString() {
		return outputString;
	}
	
	
	@Override
	public String toString() {
		return "Output [outputInt=" + outputInt + ", outputString=" + outputString + "]";
	}
	
}
