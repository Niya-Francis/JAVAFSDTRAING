package com.ust.exaample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveServlet
 */
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public SaveServlet() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		response.setContentType("text/html");  
		PrintWriter out=response.getWriter();  
		String name=request.getParameter("name");  
		String password=request.getParameter("password");  
		String email=request.getParameter("email");  
		String country=request.getParameter("country"); 
		
		Studentpro e=new Studentpro();  
		 e.setName(name);  
		 e.setPassword(password);  
		 e.setEmail(email);  
		 e.setCountry(country);  

		int status=StudentDAO.save(e);  
		if(status>0){  
			out.print("<p>Record saved successfully!</p>");  
			request.getRequestDispatcher("Index.html").include(request, response);  
		}else{  
			 out.println("Sorry! unable to save record");  
			 }  
		    
			 out.close();  
		}  

		

	
}
