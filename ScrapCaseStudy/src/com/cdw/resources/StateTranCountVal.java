package com.cdw.resources;

public class StateTranCountVal {
	//fields
	private String 	state;
	private int 	count;
	private double 	val;
	
	//constructor
	public StateTranCountVal(String state, int count, double val) {
		super();
		this.state = state;
		this.count = count;
		this.val = val;
	}
	
	//getters/setters
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getVal() {
		return val;
	}
	public void setVal(double val) {
		this.val = val;
	}

	//prints
	@Override
	public String toString() {
		return String.format(Formats.typeOrState+Formats.valueAndCount, state, val, count);

	}
	public String toFile() {
		return state + "," + val + "," + count;
	}

}
