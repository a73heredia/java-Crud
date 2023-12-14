package com.educacionIt.dao;

import com.educacionIt.dao.exeptions.GenericException;
import com.educacionIt.domain.Usuario;

public interface UsuarioDao {
	public Usuario getUsuarioByName(String usuario) throws GenericException;
	
}
