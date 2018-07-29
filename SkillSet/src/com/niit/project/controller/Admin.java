package com.niit.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//this is the login page for all users
/**
 * Servlet implementation class Admin
 */
@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("emailaddress");
		String pwd = request.getParameter("passwd");
		
		
		try(PrintWriter out=response.getWriter()) {
			Class.forName("org.h2.Driver");  
			Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from skillset where email_id='"+username+"' and password='"+pwd+"'");
			//out.println(username);
			//out.println(pwd);
	     if(rs.next())
	    {    
		 if(request.getParameter("role").equals("admin"))
		 {    RequestDispatcher dispatcher = request.getRequestDispatcher("/HRcontroller");
			  dispatcher.forward(request,response);	
		 } //if for HR
		 else 
			 if(request.getParameter("role").equals("manager"))
		 {
			if(rs.getNString("ACTIVE").equals("TRUE"))
			{
			 RequestDispatcher dispatcher = request.getRequestDispatcher("/managercontroller");
			  dispatcher.forward(request,response);
			}
			else
			{
				out.println("Your application has not been approved by the HR. You cannot login!");
			}
		 } //if for manager
		 else
		 {   
			 if(rs.getNString("ACTIVE").equals("TRUE"))
			 {
			 RequestDispatcher dispatcher = request.getRequestDispatcher("/employee.jsp");
			  dispatcher.forward(request,response);
			 }
			 else
			 {
				 out.println("Cannot login!!");
			 }
		 } //for employee
		}   //end of rs.next
		else
		{
			System.out.println("Failed!");
		}
//		con.close();
		}
		catch(Exception e)
		{
			
			System.out.println(e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
