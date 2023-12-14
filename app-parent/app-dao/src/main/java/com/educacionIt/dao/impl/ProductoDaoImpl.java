package com.educacionIt.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Collection;

import com.educacionIt.dao.ProductoDao;
import com.educacionIt.dao.exeptions.DuplicatedException;
import com.educacionIt.dao.exeptions.GenericException;
import com.educacionIt.dao.jdbc.AdministradorDeConexiones;
import com.educacionIt.domain.Producto;

public class ProductoDaoImpl implements ProductoDao {

	@Override
	public Producto create(Producto producto) throws GenericException, DuplicatedException {
	
		Connection connection = AdministradorDeConexiones.obtenerConexion();
		
		/* String sql = "INSERT INTO productos (titulo, precio, codigo, tipo_producto) "
				+ "VALUES ('"+producto.getTitulo()+"', '"+producto.getPrecio()+"',"
						+ "'"+producto.getCodigo()+"', '"+producto.getTipoProducto()+"')"; */
		
		String sql = "INSERT INTO productos (titulo, precio, codigo, tipo_producto) "
				+ "VALUES (?,?,?,?)";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setString(1, producto.getTitulo());
			statement.setFloat(2, producto.getPrecio());
			statement.setString(3, producto.getCodigo());
			statement.setLong(4, producto.getTipoProducto());
			
			statement.execute();
			
			ResultSet resultSet = statement.getGeneratedKeys();
			
			if(resultSet.next()) {
				Long pk = resultSet.getLong(1);
				producto.setId(pk);
			} else {
				throw new GenericException("No se pudo obtener la PK", null);
			}
			
			statement.close();
			
			return producto;
			
		} catch (SQLException e) {
			if( e instanceof SQLIntegrityConstraintViolationException ) {
				throw new DuplicatedException("Clave duplicada, no se ha registrado el producto", e);
			}
			throw new GenericException("No se ha podido crear el producto", e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e1) {
				throw new GenericException("Problema al cerrar la conexión, verifique la DB", e1);
			}
		}
	
	}


	@Override
	public Collection<Producto> findAll() throws GenericException {
		Collection<Producto> productos = new ArrayList<Producto>();
		
		Connection connection = AdministradorDeConexiones.obtenerConexion();
		
		String sqlSelect = "SELECT * FROM productos";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sqlSelect);
			
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				Producto producto = productoFromResultSet(resultSet);
				
				productos.add(producto);
			}
			
			statement.close();
			
			return productos;
			
		} catch (SQLException e) {
			throw new GenericException("No se ha podido listar el producto", e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e1) {
				throw new GenericException("Problema ala cerrar la conexion", e1);
			}
		}
		
		

	}

	@Override
	public Producto getById(Long id) throws GenericException {
		
		Connection connection = AdministradorDeConexiones.obtenerConexion();
		
		String sqlSelect = "SELECT * FROM productos WHERE id = '"+ id+"'";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sqlSelect);
			
			ResultSet resultSet = statement.executeQuery();
			
			Producto producto = null;
			
			if(resultSet.next()) {
				producto = productoFromResultSet(resultSet);
			}
			
			statement.close();
			
			return producto;
		} catch (SQLException e) {
			throw new GenericException("No se ha podido obtener el producto", e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e1) {
				throw new GenericException("Problema al cerrar la conexion", e1);
			}
		}
		
	}
	
	

	@Override
	public Producto getByCodigo(String codigo) throws GenericException {
		
		Connection connection = AdministradorDeConexiones.obtenerConexion();
		
		String sqlSelect = "SELECT * FROM productos WHERE codigo = '"+ codigo+"'";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sqlSelect);
			
			ResultSet resultSet = statement.executeQuery();
			
			Producto producto = null;
			
			if(resultSet.next()) {
				producto = productoFromResultSet(resultSet);
			}
			
			statement.close();
			
			return producto;
		} catch (SQLException e) {
			throw new GenericException("No se ha podido obtener el producto", e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e1) {
				throw new GenericException("Problema al cerrar la conexion", e1);
			}
		}
		
		
		
		
	}

	@Override
	public Producto update(Producto producto) throws GenericException {
				
		Producto productoBuscador = this.getById(producto.getId());
		
		Connection connection = AdministradorDeConexiones.obtenerConexion();
		
		if(productoBuscador == null) {
			throw new GenericException("No existe el producto id: " + producto.getId(), null);
		}
		
		String sqlUpdate = "UPDATE productos " 
				+ "SET titulo = ?, precio = ?, tipo_producto = ? WHERE id = ?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sqlUpdate);
			
			statement.setString(1, producto.getTitulo());
			statement.setFloat(2, producto.getPrecio());
			statement.setLong(3, producto.getTipoProducto());
			statement.setLong(4, producto.getId());
			
			
			int updated = statement.executeUpdate();
			if(updated != 1) {
				throw new Exception("No se pudieron modificar los datos del producto con ID " + producto.getId());
			}
			
			producto = this.getById(producto.getId());
			
			return producto;
		} catch (Exception e) {
			throw new GenericException("No se ha podido actualizar el producto", e);
		} finally {
			try {
				connection.close();
			} catch(SQLException e1) {
				throw new GenericException("Problema al cerrar la conexión", e1);
			}
		}
	}

	@Override
	public Producto deleteById(Long id) throws GenericException {
Producto producto = this.getById(id);
		
		Connection connection = AdministradorDeConexiones.obtenerConexion();

		if(producto == null) {
			throw new GenericException("No existe producto id:" + id, null);
		}
		
		String sql = "DELETE FROM productos WHERE ID = ?";
		
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setLong(1, id);
			
			int deleted = statement.executeUpdate();
			
			statement.close();
			
			if(deleted != 1) {
				throw new Exception("No se ha podido eliminar el producto id:" + id);
			}
			
		} catch (Exception e) {
			throw new GenericException("No se ha podido eliminar el producto", e);
		} finally {
			try {
				connection.close();
			} catch(SQLException e1) {
				throw new GenericException("Problema al cerrar la conexión", e1);
			}
		}
		
		return producto;
	}

	@Override
	public Producto deleteByCodigo(String codigo) throws GenericException {
		
		Producto producto = this.getByCodigo(codigo);
		
		Connection connection = AdministradorDeConexiones.obtenerConexion();

		if(producto == null) {
			throw new GenericException("No existe producto codigo:" + codigo, null);
		}
		
		String sql = "DELETE FROM productos WHERE codigo = ?";
		
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, codigo);
			
			int deleted = statement.executeUpdate();
			
			statement.close();
			
			if(deleted != 1) {
				throw new Exception("No se ha podido eliminar el producto codigo:" + codigo);
			}
			
		} catch (Exception e) {
			throw new GenericException("No se ha podido eliminar el producto", e);
		} finally {
			try {
				connection.close();
			} catch(SQLException e1) {
				throw new GenericException("Problema al cerrar la conexión", e1);
			}
		}
		
		return producto;
	}

	@Override
	public Collection<Producto> findAllByTitulo(String titulo) throws GenericException {

		Collection <Producto> productos = new ArrayList<Producto>();
		
		Connection connection = AdministradorDeConexiones.obtenerConexion();
		
		String sqlSelect = "SELECT * FROM productos WHERE upper(titulo) like '%"+titulo+"%'";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sqlSelect);
			
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				Producto producto = productoFromResultSet(resultSet);
				
				productos.add(producto);
			}
			
			statement.close();
			
			return productos;
			
			
		} catch (SQLException e) {
			throw new GenericException("No se ha podido obtener ningún registro con el título", e);
		} finally {
			try {
				connection.close();
			} catch(SQLException e1) {
				throw new GenericException("Problema al cerrar la conexión", e1);
			}
		}
		
		
	}
	
	private Producto productoFromResultSet(ResultSet resultSet) throws SQLException {
		Producto producto;
		Long id = resultSet.getLong(1);
		String titulo = resultSet.getString(2);
		Float precio = resultSet.getFloat(3);
		String codigo = resultSet.getString(4);
		Long tipoProducto = resultSet.getLong(5);
		
		producto = new Producto(id, titulo, precio, codigo, tipoProducto);
		
		return producto;
	}

}
