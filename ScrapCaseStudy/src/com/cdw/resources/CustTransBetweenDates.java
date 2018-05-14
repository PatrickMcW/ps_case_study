package com.cdw.resources;

import com.cdw.model.Transaction;

public class CustTransBetweenDates extends Transaction {
	private String fName;
	private String mName;
	public CustTransBetweenDates(String fName, String mName,int d, int m, int y, String ccn, int branch,
			String transaction_type, double transaction_value) {
		super.setM(m);
		super.setD(d);
		super.setY(y);
		super.setCcn(ccn);
		super.setBranch(branch);
		super.setTransaction_type(transaction_type);
		super.setTransaction_value(transaction_value);
		this.fName = fName;
		this.mName = mName;
	}
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
	@Override
	public String toString() {
		return "CustTransBetweenDates [fName=" + fName + ", mName=" + mName + ", "  + super.subClassCTBDToString() + "]";
	} //this is kind of wonky //less wonky with new super toString
	
	
}
