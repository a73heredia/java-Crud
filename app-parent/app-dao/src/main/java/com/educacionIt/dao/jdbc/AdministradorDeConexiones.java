package com.educacionIt.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.educacionIt.dao.exeptions.GenericException;

public class AdministradorDeConexiones {
	
	
	public static Connection obtenerConexion() throws GenericException{
		
		String url = "jdbc:mysql://localhost:3306/java";	
		
		String user = "root";
		String password = "";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, user, password);
			
			return connection;
		} catch (ClassNotFoundException | SQLException e) {
			
			throw new GenericException("No se ha podido obtener una conexion", e);
		}
		
		
	}
}
