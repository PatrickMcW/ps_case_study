package com.cdw.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.cdw.model.Customer;
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

}
