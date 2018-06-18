package com.cdw.resources;



public class MonthInvoice {
	//fields
	private double balance;
	private String fName;
	private String lName;
	private int id;
	
	//constructor
	public MonthInvoice(double balance, String fName, String lName, int id/*, List<Transaction> lineItems*/) {
		super();
		this.balance = balance;
		this.fName = fName;
		this.lName = lName;
		this.id = id;
	}
	
	//getters/setters
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
	
	//prints
	@Override
	public String toString() {
		return String.format(Formats.monthBillLayout, balance, fName, lName, id);
	}
	public String toFile() { //this needs to be redone with the list. I proably want to decouple the list from the bill
		return balance + "," + fName + "," + lName + "," + id;
	}
	
}
