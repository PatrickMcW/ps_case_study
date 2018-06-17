package com.cdw.resources;

public class Queries {
	private Queries() {}; //since this is private, a constructor can never be invoked

	
	//Customer has a compound key, may need to adjust the above string and it's using method to account for that
	//@int input
	public final static String GET_TRANSACTION_BY_T_ID = "SELECT transaction_id, day, month, year, credit_card_no, cust_ssn, branch_code, transaction_type, transaction_value FROM CDW_SAPP_CREDITCARD WHERE transaction_id = ?";
	
//	1) To display the transactions made by customers living in a given zipcode for a given month and year. 
	//Order by day in descending order.
	//@four int inputs
	public final static String GET_TRANSACTION_LIST_BY_ZIP_MONTH_YEAR = "SELECT "+
			" cc.TRANSACTION_ID, cc.DAY, cc.MONTH, cc.YEAR, cc.CREDIT_CARD_NO, cc.CUST_SSN, "+
			" cc.BRANCH_CODE, cc.TRANSACTION_TYPE, cc.TRANSACTION_VALUE, c.FIRST_NAME, "+
			" c.MIDDLE_NAME, c.LAST_NAME, c.SSN, c.CREDIT_CARD_NO, c.APT_NO, c.STREET_NAME, "+
			" c.CUST_CITY, c.CUST_STATE, c.CUST_COUNTRY, c.CUST_ZIP, c.CUST_PHONE, c.CUST_EMAIL FROM " + 
			"	cdw_sapp_creditcard cc INNER JOIN cdw_sapp_customer c ON cc.CREDIT_CARD_NO=c.CREDIT_CARD_NO" + 
			"    WHERE c.CUST_ZIP = ?" + 
			"		AND cc.MONTH = ?" + 
			"        AND cc.YEAR = ?" + 
			"   ORDER BY cc.DAY DESC";
	
//	2) To display the number and total values of transactions for a given type.
	//GET_TRANSACTION_TOTAL_VALUE_BY_TYPE
	//https://stackoverflow.com/a/12789493
	//@string input, of select type. see transaction dao for details
	public final static String GET_TRANSACTION_TOTAL_VALUE_BY_TYPE = "SELECT t.TRANSACTION_TYPE Type, count(t.TRANSACTION_ID) Count, sum(t.TRANSACTION_VALUE) 'Total Value' " + 
			"	FROM cdw_sapp_creditcard t" + 
			"    WHERE t.TRANSACTION_TYPE =  ?" + 
			"    group by 1";
	
	
//	3) To display the number and total values of transactions for branches in a given state 
	public final static String GET_STATE_TRANSACTION_COUNT_VAL_BY_STATE = "SELECT DISTINCT b.BRANCH_STATE 'State', count(t.TRANSACTION_ID) '# Transactions', sum(t.TRANSACTION_VALUE) 'Total Value' " + 
			"	FROM cdw_sapp_branch b " + 
			"		INNER JOIN cdw_sapp_creditcard t ON b.BRANCH_CODE=t.BRANCH_CODE" + 
			"	WHERE b.BRANCH_STATE = ?" + 
			"	GROUP BY 1";
	
	//1) To check the existing account details of a customer.
	//@int ssn
	public final static String GET_CUST_BY_SSN = "SELECT FIRST_NAME, MIDDLE_NAME, LAST_NAME, SSN, CREDIT_CARD_NO, APT_NO,\r\n" + 
			" STREET_NAME, CUST_CITY, CUST_STATE, CUST_COUNTRY, CUST_ZIP, CUST_PHONE, \r\n" + 
			" CUST_EMAIL FROM CDW_SAPP_CUSTOMER WHERE ssn = ?";
	
	//get cust by ssn and ccn
	//@int ssn @string ccn
	public final static String GET_CUST_BY_SSN_AND_CCN = "SELECT FIRST_NAME, MIDDLE_NAME, LAST_NAME, SSN, CREDIT_CARD_NO, APT_NO,\r\n" + 
			" STREET_NAME, CUST_CITY, CUST_STATE, CUST_COUNTRY, CUST_ZIP, CUST_PHONE, \r\n" + 
			" CUST_EMAIL FROM CDW_SAPP_CUSTOMER WHERE ssn = ? AND credit_card_no = ?";

	//2) To modify the existing account details of a customer 
	//  @string column_name, @string/@int (depending) new_value, @int ssn, @String ccn
//	public final static String UPDATE_CUST_BY_SSN = "UPDATE cdw_sapp_customer SET ? = ? WHERE ssn = ? AND CREDIT_CARD_NO = ?";
	public final static String UPDATE_START = "UPDATE cdw_sapp_customer SET ";
	public final static String UPDATE_END = " = ? WHERE ssn = ? AND CREDIT_CARD_NO = ?";
	
	//3) To generate monthly bill for a credit card number for a given month and year. 
	// @int month, @int year, @string ccn
	public final static String MONTH_YEAR_BALANCE_DUE_BY_CCN = "SELECT SUM(cc.TRANSACTION_VALUE) 'Balance Due', c.FIRST_NAME 'First Name', c.LAST_NAME 'Last Name', c.SSN 'Identifier' " + 
			"	From cdw_sapp_creditcard cc " + 
			"		INNER JOIN cdw_sapp_customer c on cc.CREDIT_CARD_NO=c.CREDIT_CARD_NO " + 
			"    WHERE cc.month = ? " + 
			"		AND cc.year = ? " + 
			"        AND cc.CREDIT_CARD_NO = ?";
	//3b list of transactions for that month
	public final static String GET_TRANSACTION_LIST_BY_M_Y_CCN = "SELECT cc.transaction_id, cc.day, cc.month, cc.year, cc.credit_card_no, cc.cust_ssn, cc.branch_code, cc.transaction_type, cc.transaction_value " +
			"	From cdw_sapp_creditcard cc " + 
			"		INNER JOIN cdw_sapp_customer c on cc.CREDIT_CARD_NO=c.CREDIT_CARD_NO " + //i don't think this line is necessary, but leaving it for now
			"    WHERE cc.month = ? " + 
			"		AND cc.year = ? " + 
			"        AND cc.CREDIT_CARD_NO = ?";
	
	//4) To display the transactions made by a customer between two dates. Order by year, month, and day in descending order
	//@int ssn, @String dateOne, @String dateTwo
	public final static String GET_TRANS_BY_CUST_BETWEEN_TWO_DATES = "SELECT c.FIRST_NAME 'First Name', c.MIDDLE_NAME 'Middle Name', c.LAST_NAME 'Last Name', " + "cc.TRANSACTION_ID, " +
			"	STR_TO_DATE(CONCAT(cc.YEAR,',',cc.MONTH,',',cc.DAY),'%Y,%m,%d') 'Date', " + 
			"	cc.CREDIT_CARD_NO 'CCN', cc.BRANCH_CODE 'Branch', cc.TRANSACTION_TYPE 'Type', cc.TRANSACTION_VALUE 'Value' " + 
			"	FROM cdw_sapp_customer c " + 
			"		INNER JOIN cdw_sapp_creditcard cc ON c.CREDIT_CARD_NO=cc.CREDIT_CARD_NO" + 
			" 		WHERE c.SSN = ? " + 
			" 			AND STR_TO_DATE(CONCAT(cc.YEAR,',',cc.MONTH,',',cc.DAY),'%Y,%m,%d') " + 
			"				BETWEEN ? AND ? " + 
			"        ORDER BY cc.YEAR desc, cc.MONTH desc, cc.DAY desc";
}

 

