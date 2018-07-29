package com.niit.project.model;

import java.io.PrintWriter;
import java.util.*;
import java.sql.*;

public class EmployeeDao {

	public int insert_record(Employee obj)
	{
		int status=0;
		
		try {
			Class.forName("org.h2.Driver");  
			Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");  
			PreparedStatement p = con.prepareStatement("insert into skillset values( ?,?,?,?,?,?,?);");
			p.setString(1,obj.getEmployeeid() );
			p.setString(2, obj.getEmpname());
			p.setString(3, obj.getEmailaddress());
			p.setString(4, obj.getPasswd());
			p.setString(5, obj.getPhonenum());
			p.setString(6, obj.getRole());
			p.setString(7, "false");

			status = p.executeUpdate();	
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return status;
	} //end of insert
	
	public int approve_employee(Employee obj)
	{
		int status =0;
		try
		{
			Class.forName("org.h2.Driver");  
			Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
			PreparedStatement pupdt = con.prepareStatement("update skillset set active=true where empid=?");
			pupdt.setString(1, obj.getEmployeeid());
			status = pupdt.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return status;
	}
	
		public int del_emp(Employee obj)
		{
				int status =0;
				try
				{
					Class.forName("org.h2.Driver");  
					Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
					PreparedStatement pupdt = con.prepareStatement("delete from skillset where empid=?");
					pupdt.setString(1, obj.getEmployeeid());
					status = pupdt.executeUpdate();
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
				return status;
			
		}
		
		public ArrayList<Employee> get_all_employees()
		{
			ArrayList<Employee> le = new ArrayList<Employee>();
			try {
				Class.forName("org.h2.Driver");  
				Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select * from skillset where active=true");
				
				while (rs.next())
				{
					Employee emp = new Employee();
					emp.setEmployeeid(rs.getString(1));
					emp.setEmpname(rs.getString(2));
					emp.setEmailaddress(rs.getString(3));
					emp.setPasswd(rs.getString(4));
					emp.setPhonenum(rs.getString(5));
					emp.setRole(rs.getString(6));
					emp.setActive(rs.getBoolean(7));
					le.add(emp);
				}
				
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			return le;
		} //end of get all employees
		
		public ArrayList<Employee> get_unapproved_emp()
		{
			ArrayList<Employee> le = new ArrayList<Employee>();
			try {
				Class.forName("org.h2.Driver");  
				Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select * from skillset where active=false");
				
				while (rs.next())
				{
					Employee emp = new Employee();
					emp.setEmployeeid(rs.getString(1));
					emp.setEmpname(rs.getString(2));
					emp.setEmailaddress(rs.getString(3));
					emp.setPasswd(rs.getString(4));
					emp.setPhonenum(rs.getString(5));
					emp.setRole(rs.getString(6));
					emp.setActive(rs.getBoolean(7));
					le.add(emp);
				}
				
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			return le;
		} //employees where active=false
		public Employee get_emp_byID(Employee obj)
		{
			Employee emp = new Employee();
			try
			{
				Class.forName("org.h2.Driver");  
				Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select * from skillset where empid="+obj.getEmployeeid());
				while (rs.next())
				{
					emp.setEmployeeid(rs.getString(1));
					emp.setEmpname(rs.getString(2));
					emp.setEmailaddress(rs.getString(3));
					emp.setPasswd(rs.getString(4));
					emp.setPhonenum(rs.getString(5));
					emp.setRole(rs.getString(6));
					emp.setActive(rs.getBoolean(7));
				}
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			return emp;
			
		}
		
		public Employee get_emp_byName(Employee obj)
		{
			Employee emp = new Employee();
			try
			{
				Class.forName("org.h2.Driver");  
				Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select * from skillset where empname like '"+obj.getEmpname()+"%'");
				while (rs.next())
				{
					emp.setEmployeeid(rs.getString(1));
					emp.setEmpname(rs.getString(2));
					emp.setEmailaddress(rs.getString(3));
					emp.setPasswd(rs.getString(4));
					emp.setPhonenum(rs.getString(5));
					emp.setRole(rs.getString(6));
					emp.setActive(rs.getBoolean(7));
				}
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			return emp;
		} // end of get employee by name
	}
	
