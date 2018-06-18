package com.cdw.model;

import com.cdw.resources.Formats;

public class Transaction {
	//fields
	private int t_id;
	private int d;
	private int m;
	private int y;
	private String ccn;
	private int c_ssn;
	private int branch;
	private String transaction_type;
	private double transaction_value;
	
	//constructors
	public Transaction(int t_id, int d, int m, int y, String ccn, int c_ssn, int branch, String transaction_type,
			double transaction_value) {
		super();
		this.t_id = t_id;
		this.d = d;
		this.m = m;
		this.y = y;
		this.ccn = ccn;
		this.c_ssn = c_ssn;
		this.branch = branch;
		this.transaction_type = transaction_type;
		this.transaction_value = transaction_value;
	}

	public Transaction() {}
	
	//getters/setters
	public int getT_id() {return t_id;}

	public void setT_id(int t_id) {this.t_id = t_id;}

	public int getD() {return d;}

	public void setD(int d) {this.d = d;}

	public int getM() {return m;}

	public void setM(int m) {this.m = m;}

	public int getY() {return y;}

	public void setY(int y) {this.y = y;}

	public String getCcn() {return ccn;}

	public void setCcn(String ccn) {this.ccn = ccn;}

	public int getC_ssn() {return c_ssn;}

	public void setC_ssn(int c_ssn) {this.c_ssn = c_ssn;}

	public int getBranch() {return branch;}

	public void setBranch(int branch) {this.branch = branch;}

	public String getTransaction_type() {return transaction_type;}

	public void setTransaction_type(String transaction_type) {this.transaction_type = transaction_type;}

	public double getTransaction_value() {return transaction_value;}

	public void setTransaction_value(double transaction_value) {this.transaction_value = transaction_value;}

	//prints
	@Override
	public String toString() {
		return String.format(Formats.transactionLayout + Formats.ssn +" %n", t_id, d,m,y, ccn, branch, transaction_type, transaction_value,c_ssn);
	}
	public String toFile() {
		return t_id + "," + d + "," + m + "," + y + "," + ccn + "," + c_ssn + "," + branch + "," + transaction_type + "," + transaction_value ;
	}
}
