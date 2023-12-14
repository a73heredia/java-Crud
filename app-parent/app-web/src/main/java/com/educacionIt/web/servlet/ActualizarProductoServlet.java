package com.educacionIt.web.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.educacionIt.domain.Producto;
import com.educacionIt.web.enums.ViewEnums;
import com.educacionIt.web.enums.ViewKeyEnums;

/**
 * Servlet implementation class ActualizarProductoServlet
 */
public class ActualizarProductoServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Capturar los datos de la jsp
		
		String id = request.getParameter("id");
		String codigo = request.getParameter("codigo");
		String titulo = request.getParameter("titulo");
		String precio = request.getParameter("precio");
		String tipoProducto = request.getParameter("tipoProducto");
		
		ViewEnums target = ViewEnums.LISTADO_GENERAL;
		
		Producto nuevoProducto = null;
		
		try {
			
			Long idLong = Long.parseLong(id);
			Float precioF = Float.parseFloat(precio);
			Long tipoProductoL = Long.parseLong(tipoProducto);
			
			nuevoProducto = new Producto(idLong, titulo, precioF, codigo, tipoProductoL);
			super.ps.actualizarProducto(nuevoProducto);
			
			request.setAttribute(ViewKeyEnums.EXITO.name(), "Actualizacion Correcta");
			
			//recargar la lista
			Collection<Producto> productos = super.ps.findAll();
			
			request.setAttribute(ViewKeyEnums.LISTADO.name(), productos);
			
			
		} catch (Exception e) {
			request.setAttribute(ViewKeyEnums.ERROR_GENERAL.name(), e.getMessage());
			target = ViewEnums.EDITAR_PRODUCTO;
			
			//recargo el producto
			addAttribute(request, ViewKeyEnums.PRODUCTO_EDITAR, nuevoProducto);
		}
		
		//redireccion
		getServletContext().getRequestDispatcher(target.getView()).forward(request, response);
	}

}
