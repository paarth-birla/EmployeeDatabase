package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.LoginDAO;


@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Signup() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		LoginDAO loginDAO = new LoginDAO();
		int empid = Integer.parseInt(request.getParameter("employee_id"));
		String password = request.getParameter("password");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String dob = request.getParameter("dob");
		String job = request.getParameter("job");
		int contact = Integer.parseInt(request.getParameter("contact"));
		float salary = Float.parseFloat(request.getParameter("salary"));
		float yearbonus = Float.parseFloat(request.getParameter("yearbonus"));
		
		if(loginDAO.insertEmployeeDetails(empid, fname, lname, dob, contact, job, salary, yearbonus, password))
		{
			String name = loginDAO.checkCredential(empid, password);
			HttpSession session = request.getSession();
			session.setAttribute("name", name);
			response.sendRedirect("report.jsp");
		}
		else {
			response.sendRedirect("login.jsp");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
