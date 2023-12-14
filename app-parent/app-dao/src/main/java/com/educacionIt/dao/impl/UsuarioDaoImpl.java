package com.educacionIt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.educacionIt.dao.UsuarioDao;
import com.educacionIt.dao.exeptions.GenericException;
import com.educacionIt.dao.jdbc.AdministradorDeConexiones;
import com.educacionIt.domain.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {

	@Override
	public Usuario getUsuarioByName(String usuario) throws GenericException {
		
		Connection connection = AdministradorDeConexiones.obtenerConexion();
		
		String sqlSelect = "SELECT * FROM usuarios WHERE upper(usuario) = '" + usuario.toUpperCase()+"'";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sqlSelect);
			ResultSet resultSet = statement.executeQuery();
			
			Usuario usuarioResultado = null;
			
			if(resultSet.next()) {
				Long id = resultSet.getLong(1);
				String username = resultSet.getString(2);
				String password = resultSet.getString(3);
				
				usuarioResultado = new Usuario(id, username, password);
				
				
			}
			statement.close();
			return usuarioResultado;
		} catch (Exception e) {
				throw new GenericException("No se ha podido obtener el usuario", e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e1) {
				throw new GenericException("Problema cerrando la conexion", e1);
			}
		}
		
	
	}

}
