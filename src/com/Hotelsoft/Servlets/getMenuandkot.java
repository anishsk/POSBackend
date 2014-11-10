package com.Hotelsoft.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Hotelsoft.JavaClasses.JsonAggregator;

/**
 * Servlet implementation class getMenuandkot
 */
@WebServlet("/getMenuandkot")
public class getMenuandkot extends HttpServlet {
	private JsonAggregator j = new JsonAggregator();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getMenuandkot() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
		
		JsonAggregator json = new JsonAggregator();
		response.getWriter().print(j.getAllJson());
	//	response.getWriter().print(j.getAllJson().toString());
		//System.out.println(j.getAllJson().toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
		response.getWriter().print(j.getAllJson());
	}

}
