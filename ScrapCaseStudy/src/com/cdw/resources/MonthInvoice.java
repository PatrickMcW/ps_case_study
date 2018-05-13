package com.cdw.resources;

public class MonthInvoice {
	private double balance;
	private String fName;
	private String lName;
	private int id;
	public MonthInvoice(double balance, String fName, String lName, int id) {
		super();
		this.balance = balance;
		this.fName = fName;
		this.lName = lName;
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "MonthInvoice [balance=" + balance + ", fName=" + fName + ", lName=" + lName + ", id=" + id + "]";
	}
	
	
}
