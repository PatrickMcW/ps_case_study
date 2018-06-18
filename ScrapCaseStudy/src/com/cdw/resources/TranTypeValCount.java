package com.cdw.resources;

public class TranTypeValCount {
	//fields
	private String 	type;
	private double 	val;
	private int 	count;
	
	//constructor
	public TranTypeValCount(String type, int count, double val) {
		super();
		this.type = type;
		this.count = count;
		this.val = val;
	}
	
	//getters/setters
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
		return String.format(Formats.typeOrState+Formats.valueAndCount, type, val, count);
	}
	public String toFile() {
		return type + "," + val + "," + count;
	}
	
}
