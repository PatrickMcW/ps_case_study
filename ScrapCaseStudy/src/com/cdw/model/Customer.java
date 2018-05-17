package com.cdw.model;

import com.cdw.resources.Formats;

public class Customer {
	//fields
	private String fName;
	private String mName;
	private String lName;
	private int ssn;
	private String ccn;
	private String aptN;
	private String streetN;
	private String custCity;
	private String custState;
	private String custCountry;
	private String custZip;
	private int custPhone;
	private String custEmail;

	
	//construct
	public Customer() {};

	public Customer(String fName, String mName, String lName, int ssn, String ccn, String aptN, String streetN,
			String custCity, String custState, String custCountry, String custZip, int custPhone, String custEmail) {
		super();
		this.fName = fName;
		this.mName = mName;
		this.lName = lName;
		this.ssn = ssn;
		this.ccn = ccn;
		this.aptN = aptN;
		this.streetN = streetN;
		this.custCity = custCity;
		this.custState = custState;
		this.custCountry = custCountry;
		this.custZip = custZip;
		this.custPhone = custPhone;
		this.custEmail = custEmail;
	}


	//get/set
	public String getfName() {return fName;}

	public void setfName(String fName) {this.fName = fName;}

	public String getmName() {return mName;}

	public void setmName(String mName) {this.mName = mName;}

	public String getlName() {return lName;}

	public void setlName(String lName) {this.lName = lName;}

	public int getSsn() {return ssn;}

	public void setSsn(int ssn) {this.ssn = ssn;}

	public String getccn() {return ccn;}

	public void setccn(String ccn) {this.ccn = ccn;}
	
	public String getaptN() {return aptN;}

	public void setaptN(String aptN) {this.aptN = aptN;}

	public String getstreetN() {return streetN;}

	public void setstreetN(String streetN) {this.streetN = streetN;}

	public String getCustCity() {return custCity;}

	public void setCustCity(String custCity) {this.custCity = custCity;}

	public String getCustState() {return custState;}

	public void setCustState(String custState) {this.custState = custState;}

	public String getCustCountry() {return custCountry;}

	public void setCustCountry(String custCountry) {this.custCountry = custCountry;}

	public String getCustZip() {return custZip;}

	public void setCustZip(String custZip) {this.custZip = custZip;}

	public String getCustEmail() {return custEmail;}

	public void setCustEmail(String custEmail) {this.custEmail = custEmail;};
	
	@Override
	public String toString() {	
		return String.format(Formats.customerLayout, 
				fName, mName,lName,ssn,ccn,aptN,streetN,custCity,custState,custCountry,custZip,custPhone,custEmail);

	}
	
	public String toFile() {
		return fName + "," + mName + "," + lName + "," + ssn + "," + ccn + "," + aptN + "," + streetN + "," + custCity + "," + custState + "," + custCountry + "," + custZip + "," + custPhone + "," + custEmail;
	}

}
