package com.educacionIt.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.educacionIt.domain.Usuario;
import com.educacionIt.services.LoginService;
import com.educacionIt.services.impl.LoginServiceImpl;
import com.educacionIt.web.enums.ViewEnums;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		LoginService ls = new LoginServiceImpl();
		
		ViewEnums target = ViewEnums.LOGIN_SUCCESS;
		
		try {
			Usuario usuario = ls.getUserByUserName(username);
			
			if(usuario != null && usuario.getPassword().equals(password)) {
				// Sesiones
			} else {
				target = ViewEnums.LOGIN;
			}
			
		} catch (Exception e) {
			target = ViewEnums.LOGIN; 
		}
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(target.getView());
		rd.forward(request, response);
	}

}
