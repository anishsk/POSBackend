package com.Hotelsoft.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Hotelsoft.JavaClasses.ValidateUserLogin;

/**
 * Servlet implementation class getLoginCreden
 */
@WebServlet("/getLoginCreden")
public class getLoginCreden extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getLoginCreden() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String uname,upass;
		uname=request.getParameter("user");
		upass=request.getParameter("pwd");
		ValidateUserLogin v = new ValidateUserLogin(uname,upass);
		final String validStatus = new Integer(v.checkIfValiduser()).toString();
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.write(validStatus);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname,upass;
		uname=request.getParameter("user");
		upass=request.getParameter("pwd");
		ValidateUserLogin v = new ValidateUserLogin(uname,upass);
		final String validStatus = new Integer(v.checkIfValiduser()).toString();
//		response.setContentLength(validStatus.length());
//		response.getOutputStream().write(validStatus.getBytes());
//		response.getOutputStream().flush();
//		response.getOutputStream().close();
		
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.write(validStatus);
		
	}
}
