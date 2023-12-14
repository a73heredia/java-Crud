package com.educacionIt.dao;

import java.util.Collection;

import com.educacionIt.dao.exeptions.DuplicatedException;
import com.educacionIt.dao.exeptions.GenericException;
import com.educacionIt.domain.Producto;

public interface ProductoDao {

	public Producto create(Producto producto) throws GenericException, DuplicatedException;
	public Collection<Producto> findAll() throws GenericException, DuplicatedException;
	public Producto getById(Long id) throws GenericException, DuplicatedException;
	public Producto getByCodigo(String codigo) throws GenericException, DuplicatedException;
	public Producto update(Producto producto) throws GenericException, DuplicatedException;
	public Producto deleteById(Long id) throws GenericException, DuplicatedException;
	public Producto deleteByCodigo(String codigo) throws GenericException, DuplicatedException;
	public Collection<Producto> findAllByTitulo(String titulo) throws GenericException, DuplicatedException;
}
