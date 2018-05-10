package com.cdw.resources;

public class Queries {
	private Queries() {}; //since this is private, a constructor can never be invoked

	
	//Customer has a compound key, may need to adjust the above string and it's using method to account for that
	//@int input
	public final static String GET_TRANSACTION_BY_T_ID = "SELECT * FROM CDW_SAPP_CREDITCARD WHERE transaction_id = ?";
	
//	1) To display the transactions made by customers living in a given zipcode for a given month and year. 
	//Order by day in descending order.
	//@four int inputs
	public final static String GET_TRANSACTION_LIST_BY_ZIP_MONTH_YEAR = "SELECT * FROM " + 
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
	public final static String GET_CUST_BY_SSN = "SELECT * FROM CDW_SAPP_CUSTOMER WHERE ssn = ?";

	//2) To modify the existing account details of a customer 
	// @string table_name, @string column_name, @string/@int (depending) new_value, @int ssn
	public final static String UPDATE_CUST_BY_SSN = "UPDATE ? SET ? = ? WHERE ssn = ?";
	
	//3) To generate monthly bill for a credit card number for a given month and year. 
	// @int month, @int year, @string ccn
	public final static String MONTH_YEAR_BALANCE_DUE_BY_CCN = "SELECT SUM(cc.TRANSACTION_VALUE) 'Balance Due', c.FIRST_NAME 'First Name', c.LAST_NAME 'Last Name', c.SSN 'Identifier' " + 
			"	From cdw_sapp_creditcard cc " + 
			"		INNER JOIN cdw_sapp_customer c on cc.CREDIT_CARD_NO=c.CREDIT_CARD_NO " + 
			"    WHERE cc.month = ? " + 
			"		AND cc.year = ? " + 
			"        AND cc.CREDIT_CARD_NO = ?";
	
	//4) To display the transactions made by a customer between two dates. Order by year, month, and day in descending order

}

 

