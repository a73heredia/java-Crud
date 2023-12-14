package com.educacionIt.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.educacionIt.domain.Producto;
import com.educacionIt.services.ProductoServices;
import com.educacionIt.services.impl.ProductoServiceImpl;
import com.educacionIt.web.enums.ViewEnums;

/**
 * Servlet implementation class NewProductoServlet
 */
public class NewProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// capturar los datos que envia la jsp
		
		String codigo = request.getParameter("codigo"); // name="codigo"
		String titulo = request.getParameter("titulo"); // name="titulo"
		String precio = request.getParameter("precio"); // name="precio"
		String tipoProducto = request.getParameter("tipoProducto"); // name="tipoProducto"
				
			
		Float precioF = Float.parseFloat(precio);
		Long tipoProductoL = Long.parseLong(tipoProducto);
		
		Producto nuevoProducto = new Producto(titulo, precioF, codigo, tipoProductoL);
		
		ProductoServices ps = new ProductoServiceImpl();
		
		ViewEnums target = ViewEnums.LISTADO_GENERAL; // Hacía donde va a terminar redirigiendo
		
		try {
			ps.nuevoProducto(nuevoProducto);
		} catch (Exception e) {
			target = ViewEnums.NUEVO_PRODUCTO;
		}
		
		// Redirección
		getServletContext().getRequestDispatcher(target.getView()).forward(request, response);		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}