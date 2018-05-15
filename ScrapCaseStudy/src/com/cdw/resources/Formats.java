package com.cdw.resources;

public class Formats {
	private Formats() {};
	
	public final static String customerNameLayout = "%-40s | %-40s | %-40s |";
	public final static String customerLayout = customerNameLayout + " %-9s | %-16s | %-7s | %-30s | %-30s | %-30s | %-30s | %-7s | %-10s | %-40s | %n";
	public final static String ssn = " %-9s";
	public final static String monthBillLayout = "%,30.2f | %-40s | %-40s | %-9s | ";
	public final static String monthBillLayoutHeader = "%30s | %-40s | %-40s | %-9s | %n";
	public final static String transactionLayoutHeader = " %-14s | %-3s | %-5s | %-4s | %-16s | %-11s | %-30s | %30s | ";
	public final static String transactionLayout = " %-14s | %-3s | %-5s | %-4s | %-16s | %-11s | %-30s | %,30.2f | ";
//	public final static String custTransBetweenDatesLayout = customerNameLayout + transactionLayout;
	public final static String custTransBetweenDatesLayout = "%-40s | %-40s | %-40s |" + " %-14s | %-3s | %-5s | %-4s | %-16s | %-11s | %-30s | %,30.2f %n";
	public final static String custTransBetweenDatesLayoutHeader = customerNameLayout + transactionLayoutHeader;
	
	public final static String valueAndCountHeader = "%30s | %20s";
	public final static String valueAndCount = "%,30.2f | %20s";
	
	public final static String typeOrState = " %-30s |";
	
//	public final static String
}
