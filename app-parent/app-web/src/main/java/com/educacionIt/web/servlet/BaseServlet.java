package com.educacionIt.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.educacionIt.services.ProductoServices;
import com.educacionIt.services.impl.ProductoServiceImpl;
import com.educacionIt.web.enums.ViewEnums;
import com.educacionIt.web.enums.ViewKeyEnums;

/**
 * Servlet implementation class BaseServlet
 */
public class BaseServlet extends HttpServlet {
	
	protected ProductoServices ps = new ProductoServiceImpl();
	
	//metodos
	public static void addAttribute(HttpServletRequest request, ViewKeyEnums key, Object value) {
		request.setAttribute(key.name(), value);
	}
	
	public static void addAttribute(HttpServletRequest request, ViewEnums key, Object value) {
		request.setAttribute(key.name(), value);
	}
	
	public void redirect(ViewEnums target, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher(target.getView()).forward(request, response);
	}

}
