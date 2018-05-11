package com.cdw.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cdw.model.Customer;
import com.cdw.resources.CustTransBetweenDates;
import com.cdw.resources.MonthInvoice;
import com.cdw.resources.Queries;

public class CustomerDAO extends AbstractDAO {
	
	public List<Customer> getAllCustomers() {
		List<Customer> list = null;
		
		
		
		return list;
	}
	
	public Customer formCustFromResults(ResultSet rs) {
		Customer cust = null;
		
		try {
			String fName		= rs.getString(1);
			String mName		= rs.getString(2);
			String lName		= rs.getString(3);
			int ssn				= rs.getInt(4);
			String ccn			= rs.getString(5);
			String aptN			= rs.getString(6);
			String streetN		= rs.getString(7);
			String custCity		= rs.getString(8);
			String custState	= rs.getString(9);
			String custCountry	= rs.getString(10);
			String custZip		= rs.getString(11);
			int custPhone		= rs.getInt(12);
			String custEmail	= rs.getString(13);
			
			cust = new Customer(fName, mName, lName, ssn, ccn, aptN, streetN, custCity, custState, custCountry, custZip, custPhone, custEmail);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return cust;
	}
	
	// get a customer by some identified (to be determined later)
	public Customer getCustomerBySsn(int ssn) /*throws Exception*/{
		Customer cust = null;
		String sql = Queries.GET_CUST_BY_SSN; //not obvious what you need here without looking at the Queries class
		establishConnection();
		
		//		PreparedStatement 
		try {
//			System.out.println(sql); //returns query string from Queries
//			conn.getWarnings();
			stmt=conn.prepareStatement(sql);
//			System.out.println(stmt);
			stmt.setInt(1, ssn);
			rs = stmt.executeQuery();
//			System.out.println(rs);
			if( rs.next() ) {

				
				cust = formCustFromResults(rs);
//				cust.toString(); //print to console
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cust;
	}
	
	public MonthInvoice getBillByMonthAndYearForCcn(int m, int y, String ccn) {
		// @int month, @int year, @string ccn
		MonthInvoice bill = null;
		String sql = Queries.MONTH_YEAR_BALANCE_DUE_BY_CCN;
		establishConnection();
		
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, m);
			stmt.setInt(2, y);
			stmt.setString(3, ccn);
			rs=stmt.executeQuery();
			
			while(rs.next()) {
				//balance, fName
				double balance 	= rs.getDouble(1);
				String fName 	= rs.getString(2);
				String lName 	= rs.getString(3);
				int id 			= rs.getInt(4);
				bill = new MonthInvoice(balance, fName, lName, id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bill;
	}
	
	public List<CustTransBetweenDates> getCustTransBetweenDatesBySsn(int ssn, String dateOne, String dateTwo) {
		//the date strings could probably be Date objs, but im lazy
		List<CustTransBetweenDates> list = new ArrayList<CustTransBetweenDates>();
		String sql = Queries.GET_TRANS_BY_CUST_BETWEEN_TWO_DATES;
		establishConnection();
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, ssn);
			stmt.setString(2, dateOne);
			stmt.setString(3, dateTwo);
			rs=stmt.executeQuery();
			
			while( rs.next() ) {
				String fName 			= rs.getString(1);
				String mName 			= rs.getString(2);
				int d 					= rs.getInt(3);
				int m 					= rs.getInt(4);
				int y 					= rs.getInt(5);
				String ccn 				= rs.getString(6);
				int branch 				= rs.getInt(7);
				String transaction_type  = rs.getString(8);
				double transaction_value = rs.getDouble(9);
				CustTransBetweenDates info = new CustTransBetweenDates(fName, mName, d, m, y, ccn, branch, transaction_type, transaction_value);
				
				list.add(info);
				System.out.println(info);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
