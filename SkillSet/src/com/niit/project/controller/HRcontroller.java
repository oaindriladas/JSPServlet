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
 * Servlet implementation class HRcontroller
 */
@WebServlet("/HRcontroller")

public class HRcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HRcontroller() {
        super();  
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDao edao = new EmployeeDao();
        ArrayList<Employee> em=edao.get_unapproved_emp();
        request.setAttribute("lemp", em);
        
        ArrayList<Employee> uem= edao.get_all_employees(); 
        request.setAttribute("uemp", uem);
		
        RequestDispatcher dispatcher = request.getRequestDispatcher("HR.jsp");
		dispatcher.forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
