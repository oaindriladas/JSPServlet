package com.niit.project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.project.model.Employee;
import com.niit.project.model.EmployeeDao;

@WebServlet("/searchbyid")
public class searchbyid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchbyid() {
        super();
        // TODO Auto-generated constructor stub
    }
public void search_by_id(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("hello");	
	Employee emp = new Employee();
    emp.setEmployeeid(request.getParameter("empid"));
    System.out.println(request.getParameter("empid"));
    EmployeeDao edao = new EmployeeDao();
    request.setAttribute("emp", edao.get_emp_byID(emp));
    
    RequestDispatcher dispatcher = request.getRequestDispatcher("searchbyid.jsp");
	 dispatcher.forward(request,response);  
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		search_by_id(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
