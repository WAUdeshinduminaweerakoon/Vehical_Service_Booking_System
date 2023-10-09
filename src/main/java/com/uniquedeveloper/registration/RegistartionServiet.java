package com.uniquedeveloper.registration;
import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistartionServiet
 */
@WebServlet("/Registartion")
public class RegistartionServiet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("uname");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String location = request.getParameter("location");
		String vehicle_no = request.getParameter("reg_number");
		String mileage = request.getParameter("mileage");
		String message = request.getParameter("message");
		
		
		
		PrintWriter out = response.getWriter();
		out.print(username);
	    out.print(date);
		out.print(time);
		out.print(location);
		out.print(vehicle_no);
		out.print(mileage);
		out.print(message);
		

    }
}