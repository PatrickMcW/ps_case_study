package com.cdw.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cdw.model.Transaction;
import com.cdw.resources.StateTranCountVal;
import com.cdw.resources.Queries;
import com.cdw.resources.TranTypeValCount;

public class TransactionDAO extends AbstractDAO{

	public Transaction formTransFromResults(ResultSet rs) {
		//The ResultSet interface provides getter methods (getBoolean, getLong, and so on) 
		// for retrieving column values from the current row.
		Transaction trans = null;	
		 try { 
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
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trans;
	}
	
	public Transaction getTransactionByTId(int id) {
		Transaction trans = null;
		String sql = Queries.GET_TRANSACTION_BY_T_ID;
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

		establishConnection();
		
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, z);
			stmt.setInt(2, m);
			stmt.setInt(3, y);

			rs = stmt.executeQuery();

			while( rs.next() ) {
				Transaction trans = formTransFromResults(rs);
				list.add(trans); 
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}

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
		String sql = Queries.GET_TRANSACTION_TOTAL_VALUE_BY_TYPE;
			
		//connect to db
		establishConnection();		
		
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, transaction_type);
			rs = stmt.executeQuery();
			
			while( rs.next() ) {
				String type = rs.getString(1);
				int count 	= rs.getInt(2);
				double val 	= rs.getDouble(3);
				result = new TranTypeValCount(type, count, val);					
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
//	3) To display the number and total values of transactions for branches in a given state 
	public StateTranCountVal getStateTransactionCountAndVal(String state_abbr) {
		StateTranCountVal result = null;
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
