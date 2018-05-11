package com.cdw.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

import com.cdw.model.Transaction;
import com.cdw.resources.StateTranCountVal;
import com.cdw.resources.Queries;
import com.cdw.resources.TranTypeValCount;

public class TransactionDAO extends AbstractDAO{

	
	public static List<Transaction> getAllTransactions(){
		List<Transaction> list = null;
		
		
		
		return list;
	}
	public Transaction formTransFromResults(ResultSet rs) {
		//The ResultSet interface provides getter methods (getBoolean, getLong, and so on) 
		// for retrieving column values from the current row.
		Transaction trans = null;
//		System.out.println("formTransFromResults was called");
//		System.out.println(rs);
//		System.out.println(" was rs");
		
		 try { //this try is maybe not happening?
//			 System.out.println(rs.toString());
//			 System.out.println("was rs.toString()"); //nothing
//			 System.out.println(rs.getInt(1) + " was rs.getInt(1)");
			 int t_id 					= rs.getInt(1);
			 int d 						= rs.getInt(2);
			 int m 						= rs.getInt(3);
			 int y 						= rs.getInt(4);
			 String ccn					= rs.getString(5);
			 int c_ssn					= rs.getInt(6);
			 
			 int branch					= rs.getInt(7);
			 String transaction_type	= rs.getString(8);
			 double transaction_value	= rs.getDouble(9);
			 trans = new Transaction(t_id, d, m, y, ccn, c_ssn, branch, transaction_type, transaction_value);
//			 trans.toString();
//			 System.out.println(trans);
//			 if(trans == null) {
//				 System.out.println("trans is null");
//			 }
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(trans);
//		System.out.println("was trans print");
//		trans.toString();
//		System.out.println("was trans.toString()");
		return trans;
	}
	
	public Transaction getTransactionByTId(int id) {
		Transaction trans = null;
		String sql = Queries.GET_TRANSACTION_BY_T_ID; //not obvious what you need here without looking at the Queries class
		establishConnection();
		//		PreparedStatement
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if( rs.next() ) {
				trans = formTransFromResults(rs);			
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return trans;
	}
	
//	1) To display the transactions made by customers living in a given zipcode for a given month and year. 
	//Order by day in descending order. 
	public List<Transaction> getTransByZipMonthYear(int z, int m, int y){
		List<Transaction> list = new ArrayList<Transaction>();
		String sql = Queries.GET_TRANSACTION_LIST_BY_ZIP_MONTH_YEAR;
//		System.out.println("before connection in getTransByZipMonthYear");
		establishConnection();
		
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, z);
			stmt.setInt(2, m);
			stmt.setInt(3, y);
//			System.out.println(z+ " "+m + " " +y+ " was zmy");
			rs = stmt.executeQuery();
//			System.out.println(rs.getMetaData());
			while( rs.next() ) {
				Transaction trans = formTransFromResults(rs);
//				System.out.println("Transaction trans = formTransFromResults(rs);");
//				trans.toString();
//				System.out.println("was trans in getTransByZipMonthYear before adding to list");
				list.add(trans); 
//				System.out.println(list.toArray().length);
				;
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
//		list.toString();
//		System.out.println(list.toArray().length);
//		for(Transaction t:list) {
//			System.out.println(t);
//			System.out.println("was t");
//		}
		return list;
	}
//	2) To display the number and total values of transactions for a given type. 
//	public enum T_Type{
//		Education,
//		Entertainment,
//		Grocery,
//		Gas,
//		Bills,
//		Test,
//		Healthcare
//	} //java does not have square bracket var notation, so this won't work.
	public TranTypeValCount getTransactionTotalValForType(String transaction_type){
		TranTypeValCount result = null;
//		System.out.println("getTransactionTotalValForType called");
		//acceptable inputs
//		String[] valids = new String[]  { "Education","Entertainment","Grocery","Gas","Bills","Test","Healthcare" };
		
//		if(!Arrays.asList(valids).contains(transaction_type)) {
//			//if the transaction_type is not a valid type, reject it.
//			//TODO: this will probably be validated in the runner and not needed here
//		} else {
			
			String sql = Queries.GET_TRANSACTION_TOTAL_VALUE_BY_TYPE;
			
			//connect to db
			establishConnection();
			
			
			try {
				stmt=conn.prepareStatement(sql);
				stmt.setString(1, transaction_type);
				rs = stmt.executeQuery();
				
				while( rs.next() ) {
					//full transaction lines are not the result here. 
					// Type, Count, Total Value are column names/order
					String type = rs.getString(1);
					int count 	= rs.getInt(2);
					double val 	= rs.getDouble(3);
					result = new TranTypeValCount(type, count, val);					
				}		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//		}
		
		
		
		return result;
	}
//	3) To display the number and total values of transactions for branches in a given state 
	public StateTranCountVal getStateTransactionCountAndVal(String state_abbr) {
		StateTranCountVal result = null;
//		List<StateTranCountVal> state = null;
		String sql = Queries.GET_STATE_TRANSACTION_COUNT_VAL_BY_STATE;
		establishConnection();
		
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, state_abbr);
			rs = stmt.executeQuery();
			
			while( rs.next() ) {
				
				String state = rs.getString(1);
				int count 	= rs.getInt(2);
				double val 	= rs.getDouble(3);
				result = new StateTranCountVal(state, count, val);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
}
