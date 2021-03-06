package com;
import model.payment;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/paymentAPI")
public class paymentAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 payment paymentObj = new payment(); 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String output = paymentObj.insertPayment(request.getParameter("customerName"), 
				 request.getParameter("email"), 
				request.getParameter("contactNo"), 
				request.getParameter("amount"),
		        request.getParameter("paymentDate")); 
				response.getWriter().write(output); 
	}

	// Convert request parameters to a Map
	private static Map<String, String> getParasMap(HttpServletRequest request) 
	{ 
	 Map<String, String> map = new HashMap<String, String>(); 
	try
	 { 
	 Scanner scanner = new Scanner(request.getInputStream(), "UTF-8"); 
	 String queryString = scanner.hasNext() ? 
	 scanner.useDelimiter("\\A").next() : ""; 
	 scanner.close(); 
	 String[] params = queryString.split("&"); 
	 for (String param : params) 
	 { 

	 String[] p = param.split("="); 
	 map.put(p[0], p[1]); 
	 } 
	 } 
	catch (Exception e) 
	 { 
	 } 
	return map; 
	}
	
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map paras = getParasMap(request); 
		 String output = paymentObj.updatePayment(paras.get("hidItemIDSave").toString(), 
		 paras.get("customerName").toString(), 
		paras.get("email").toString(), 
		paras.get("contactNo").toString(), 
		paras.get("amount").toString(),
		paras.get("paymentDate").toString()); 
		response.getWriter().write(output); 
	}


	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<?, ?> paras = getParasMap(request); 
		 String output = paymentObj.deletePayment(paras.get("paymentID").toString()); 
		response.getWriter().write(output); 
	}

}
