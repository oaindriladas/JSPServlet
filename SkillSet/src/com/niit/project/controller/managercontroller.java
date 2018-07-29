package com.niit.project.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.project.model.Employee;
import com.niit.project.model.EmployeeDao;

/**
 * Servlet implementation class managercontroller
 */
@WebServlet("/managercontroller")
public class managercontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public managercontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String empid = request.getParameter("empid");
		//Employee emp = new Employee();
		//emp.setEmployeeid(empid);
		EmployeeDao edao = new EmployeeDao();
		ArrayList<Employee> em= edao.get_all_employees();
        request.setAttribute("lemp", em);
		//Employee res= edao.get_emp_byID(emp);
		//request.setAttribute("manager", res);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("manager.jsp");
		  dispatcher.forward(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
