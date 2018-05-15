package com.cdw.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cdw.model.Customer;
import com.cdw.resources.CustTransBetweenDates;
import com.cdw.resources.MonthInvoice;
import com.cdw.resources.Output;
import com.cdw.resources.Queries;

public class CustomerDAO extends AbstractDAO {
		
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
	
	// get a customer by ssn
	public List<Customer> getCustomerBySsn(int ssn) /*throws Exception*/{
		List<Customer> list = new ArrayList<Customer>();;
		String sql = Queries.GET_CUST_BY_SSN;
		establishConnection();
		
		//		PreparedStatement 
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, ssn);
			rs = stmt.executeQuery();
			while( rs.next() ) {
				Customer cust = formCustFromResults(rs);
//				System.out.println(cust);
				list.add(cust);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
//		System.out.println(list);
		return list;
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
				String lName			= rs.getString(3);
				int t_id				= rs.getInt(4);
				String date				= rs.getString(5);
				String[] decompDate		= date.split("-"); //0 year, 1 month, 2 day
				int d 					= Integer.parseInt(decompDate[2]);
				int m 					= Integer.parseInt(decompDate[1]);
				int y 					= Integer.parseInt(decompDate[0]);
				String ccn 				= rs.getString(6);
				int branch 				= rs.getInt(7);
				String transaction_type  = rs.getString(8);
				double transaction_value = rs.getDouble(9);
				
				CustTransBetweenDates info = new CustTransBetweenDates(fName, mName, lName, t_id, d, m, y, ccn, branch, transaction_type, transaction_value);
				list.add(info);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public void updateCustomerBySsnAndCcn(String cName, Output newVal, int ssn, String ccn) {

		String sqlStart = Queries.UPDATE_START;
		String sqlEnd = Queries.UPDATE_END;
		String sql = sqlStart+cName+sqlEnd;
		System.out.println(sql + " was sql");
		establishConnection();
		
		try {
			stmt=conn.prepareStatement(sql);
		//  @string column_name, @string/@int (depending) new_value, @int ssn, @String ccn
			
			//newVal can be 2 types, this if-else sets appropriately
			if(newVal.getOutputString() instanceof String) {
				System.out.println("was inside if newVal.getOutputString() instanceof String");
				System.out.println("string of: "+ newVal.getOutputString());
				stmt.setString(1, newVal.getOutputString());
			} else {
				System.out.println("was inside else of if");
				System.out.println("int of: "+ newVal.getOutputInt());
				stmt.setInt(1, newVal.getOutputInt()); //even though less int cases, can't instanceof int easily
			}
			
			stmt.setInt(2, ssn);
			stmt.setString(3, ccn);
			int res = stmt.executeUpdate();
			if(res==1) {
				System.out.println("Update occurred.");
			} else if (res==0) {
				System.out.println("Update failed.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
