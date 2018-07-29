package com.niit.project.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.niit.project.model.Employee;
import com.niit.project.model.EmployeeDao;;
/**
 * Servlet implementation class NewUser
 */
@WebServlet("/NewUser")
public class NewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewUser() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee emp = new Employee();
		emp.setEmployeeid(request.getParameter("empid")); 
		emp.setEmpname(request.getParameter("name"));
		emp.setEmailaddress(request.getParameter("emailaddress"));
		emp.setPasswd(request.getParameter("passwd"));
		emp.setPhonenum(request.getParameter("phone"));
		
		if (request.getParameter("role").equals("manager"))
		    emp.setRole("manager"); //add a condition for employee and manager
		else
			emp.setRole("employee");
		
		EmployeeDao ed = new EmployeeDao();
		int i = ed.insert_record(emp);
		
		if (i>0)
		{
			PrintWriter out=response.getWriter();
			out.println("Registered!<br> Waiting for HR to approve!");
		}
		else
		{
			PrintWriter out=response.getWriter();
			out.println("Failed to register!");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
