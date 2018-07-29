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

@WebServlet("/Searchbyname")
public class Searchbyname extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Searchbyname() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void search_by_name(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Employee emp = new Employee();
	    emp.setEmpname(request.getParameter("empname"));
	    
	    EmployeeDao edao = new EmployeeDao();
	    request.setAttribute("emp", edao.get_emp_byName(emp));
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher("Searchbyname.jsp");
		 dispatcher.forward(request,response); 
		
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		search_by_name(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
