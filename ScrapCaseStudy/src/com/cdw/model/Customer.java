package com.cdw.model;

public class Customer {

	private String first_name;
	private String middle_name;
	private String last_name;
	private int ssn;
	private String credit_card_no;
	

	private String apt_num;
	private String street_name;
	private String cust_city;
	private String cust_state;
	private String cust_country;
	private String cust_zip;
	private int cust_phone;
	private String cust_email;

	public Customer() {};

	public String getFirst_name() {return first_name;}

	public void setFirst_name(String first_name) {this.first_name = first_name;}

	public String getMiddle_name() {return middle_name;}

	public void setMiddle_name(String middle_name) {this.middle_name = middle_name;}

	public String getLast_name() {return last_name;}

	public void setLast_name(String last_name) {this.last_name = last_name;}

	public int getSsn() {return ssn;}

	public void setSsn(int ssn) {this.ssn = ssn;}

	public String getCredit_card_no() {return credit_card_no;}

	public void setCredit_card_no(String credit_card_no) {this.credit_card_no = credit_card_no;}
	
	public String getApt_num() {return apt_num;}

	public void setApt_num(String apt_num) {this.apt_num = apt_num;}

	public String getStreet_name() {return street_name;}

	public void setStreet_name(String street_name) {this.street_name = street_name;}

	public String getCust_city() {return cust_city;}

	public void setCust_city(String cust_city) {this.cust_city = cust_city;}

	public String getCust_state() {return cust_state;}

	public void setCust_state(String cust_state) {this.cust_state = cust_state;}

	public String getCust_country() {return cust_country;}

	public void setCust_country(String cust_country) {this.cust_country = cust_country;}

	public String getCust_zip() {return cust_zip;}

	public void setCust_zip(String cust_zip) {this.cust_zip = cust_zip;}

	public int getCust_phone() {return cust_phone;}

	public void setCust_phone(int cust_phone) {this.cust_phone = cust_phone;}

	public String getCust_email() {return cust_email;}

	public void setCust_email(String cust_email) {this.cust_email = cust_email;};

}
