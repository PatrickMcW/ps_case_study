package com.cdw.resources;

public class StateTranCountVal {
	private String state;
	private int count;
	private double val;
	public StateTranCountVal(String state, int count, double val) {
		super();
		this.state = state;
		this.count = count;
		this.val = val;
	}
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
	@Override
	public String toString() {
		return "StateTranCountVal [state=" + state + ", count=" + count + ", val=" + val + "]";
	}
	
	

}
