package com.cdw.resources;

import com.cdw.model.Transaction;

public class CustTransBetweenDates extends Transaction {
	//fields
	private String fName;
	private String mName;
	private String lName;
	
	//constructor
	public CustTransBetweenDates(String fName, String mName, String lName, int t_id, int d, int m, int y, String ccn, int branch,
			String transaction_type, double transaction_value) {
		super.setT_id(t_id);
		super.setM(m);
		super.setD(d);
		super.setY(y);
		super.setCcn(ccn);
		super.setBranch(branch);
		super.setTransaction_type(transaction_type);
		super.setTransaction_value(transaction_value);
		this.fName = fName;
		this.mName = mName;
		this.lName = lName;
	}
	
	//getters/setters
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}

	//prints
	@Override
	public String toString() {
		return String.format(Formats.custTransBetweenDatesLayout, fName, mName, lName, super.getT_id(), super.getD(), super.getM(), super.getY(), super.getCcn(), super.getBranch(), super.getTransaction_type(), super.getTransaction_value()  );
	}
	@Override //transaction's method
	public String toFile() {
		return fName + "," + mName + "," + lName + "," + super.getT_id() + "," + super.getD() + "," + super.getM() + "," + super.getY() + "," + super.getCcn() + "," + super.getBranch() + "," + super.getTransaction_type() + "," + super.getTransaction_value();
	}
}
