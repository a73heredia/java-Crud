package com.educacionIt.services.impl;

import java.util.Collection;

import com.educacionIt.dao.ProductoDao;
import com.educacionIt.dao.exeptions.DuplicatedException;
import com.educacionIt.dao.exeptions.GenericException;
import com.educacionIt.dao.impl.ProductoDaoImpl;
import com.educacionIt.domain.Producto;
import com.educacionIt.exeptions.ServiceException;
import com.educacionIt.services.ProductoServices;

public class ProductoServiceImpl implements ProductoServices {
	
	private ProductoDao productoDao;
	
	public ProductoServiceImpl() {
		this.productoDao = new ProductoDaoImpl();
	}

	@Override
	public Collection<Producto> findAll() throws ServiceException {
		
		try {
			return this.productoDao.findAll();
		} catch (GenericException | DuplicatedException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		
	}

	@Override
	public Producto getById(Long id) throws ServiceException {
		try {
			return this.productoDao.getById(id);	
		} catch (GenericException | DuplicatedException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public Producto nuevoProducto(Producto producto) throws ServiceException {
		try {
			return this.productoDao.create(producto);
		} catch (DuplicatedException e) {
			throw new ServiceException("Producto duplicado:" + e.getMessage(), e);
		} catch (GenericException e) {
			throw new ServiceException("Error interno: " + e.getMessage(), e);
		}
	}

	@Override
	public Collection<Producto> buscarProductos(String clave) throws ServiceException {
		try {
			return this.productoDao.findAllByTitulo(clave);	
		} catch (GenericException | DuplicatedException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public Producto eliminarProducto(Long id) throws ServiceException {
		try {
			return this.productoDao.deleteById(id);	
		} catch (GenericException | DuplicatedException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public void actualizarProducto(Producto producto) throws ServiceException {
		try {
			 this.productoDao.update(producto);	
		} catch (GenericException | DuplicatedException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		
	}

	@Override
	public Producto obtenerPorCodigo(String codigo) throws ServiceException {
		try {
			return this.productoDao.getByCodigo(codigo);	
		} catch (GenericException | DuplicatedException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

}
