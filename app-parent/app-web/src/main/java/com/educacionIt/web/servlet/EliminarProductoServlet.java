package com.educacionIt.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.educacionIt.domain.Producto;
import com.educacionIt.exeptions.ServiceException;
import com.educacionIt.web.enums.ViewEnums;
import com.educacionIt.web.enums.ViewKeyEnums;

/**
 * Servlet implementation class EliminarProductoServlet
 */
public class EliminarProductoServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter(ViewKeyEnums.ID_PRODUCTO.getViewKey());
		
		ViewEnums target = ViewEnums.LISTADO_GENERAL;
		
		try {
			Long idLong = Long.parseLong(id);
			super.ps.eliminarProducto(idLong);
			super.addAttribute(request, ViewKeyEnums.EXITO, "Se ha eliminado el producto");
		} catch (Exception e) {
			super.addAttribute(request, ViewKeyEnums.ERROR_GENERAL, e.getMessage());
		} finally {
			Collection<Producto> productos;
			try {
				productos = super.ps.findAll();
			} catch (ServiceException e2) {
				productos = new ArrayList<Producto>();
			}
			
			addAttribute(request, ViewKeyEnums.LISTADO, productos);
		}
		
		//redireccion
		getServletContext().getRequestDispatcher(target.getView()).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
