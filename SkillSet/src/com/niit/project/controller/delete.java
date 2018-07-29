package com.niit.project.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.project.model.Employee;
import com.niit.project.model.EmployeeDao;

/**
 * Servlet implementation class delete
 */
@WebServlet("/delete")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    public void deleteemp (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    Employee emp = new Employee();
    emp.setEmployeeid(request.getParameter("empid"));
    EmployeeDao edao = new EmployeeDao();
    int i = edao.del_emp(emp);
    if (i>0)
    	{
    	PrintWriter out = response.getWriter();
    	out.print("Deleted!");
    	edao.get_all_employees();
    	}
    else
       {
    	PrintWriter out = response.getWriter();
    	out.print("Error!!");
    	}
    RequestDispatcher dispatcher = request.getRequestDispatcher("/HRcontroller");
	dispatcher.forward(request,response);
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		deleteemp(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
