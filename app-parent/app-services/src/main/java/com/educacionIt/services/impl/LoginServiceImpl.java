 package com.educacionIt.services.impl;

import com.educacionIt.dao.UsuarioDao;
import com.educacionIt.dao.exeptions.GenericException;
import com.educacionIt.dao.impl.UsuarioDaoImpl;
import com.educacionIt.domain.Usuario;
import com.educacionIt.exeptions.ServiceException;
import com.educacionIt.services.LoginService;

public class LoginServiceImpl implements LoginService {
	
	private UsuarioDao usuarioDao;
	
	
	public LoginServiceImpl() {
		this.usuarioDao = new UsuarioDaoImpl();
	}
	
	@Override
	public Usuario getUserByUserName(String usuario) throws ServiceException {
		try {
			return this.usuarioDao.getUsuarioByName(usuario);
		} catch (GenericException e) {
			 throw new ServiceException(e.getMessage(), e);
		}
		
	}

}
