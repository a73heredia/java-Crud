package com.educacionIt.services;

import java.util.Collection;

import com.educacionIt.domain.Producto;
import com.educacionIt.exeptions.ServiceException;

public interface ProductoServices {
	
	Collection<Producto> findAll() throws ServiceException;
	public Producto getById(Long id) throws ServiceException;
	public Producto nuevoProducto(Producto producto) throws ServiceException;
	public Collection<Producto> buscarProductos(String clave) throws ServiceException;
	public Producto eliminarProducto(Long id) throws ServiceException;
	public void actualizarProducto(Producto producto) throws ServiceException;
	public Producto obtenerPorCodigo(String codigo) throws ServiceException;
}
