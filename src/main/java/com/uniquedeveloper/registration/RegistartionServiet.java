package com.uniquedeveloper.registration;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class ReservationServlet
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
		RequestDispatcher dispatcher = null;
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/udesh_assignment?useSSL=false","root","");
			PreparedStatement pst = con.prepareStatement("insert into vehicle_service(username,date,time,location,vehicle_no,mileage,message) values(?,?,?,?,?,?,?)");
			
			pst.setString(1, username);
			pst.setString(2, date);
			pst.setString(3, time);
			pst.setString(4, location);
			pst.setString(5, vehicle_no);
			pst.setString(6, mileage);
			pst.setString(7, message);
			
			
			int rowCount = pst.executeUpdate();
			dispatcher = request.getRequestDispatcher("reservation.jsp");
			if(rowCount> 0) {
				request.setAttribute("status", "Registration was successful!");
				
				
			}else {
				request.setAttribute("status", "Registration failed. Please try again.");
			}
			dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}














