package com.educacionIt.services;

import com.educacionIt.domain.Usuario;
import com.educacionIt.exeptions.ServiceException;

public interface LoginService {
	Usuario getUserByUserName(String usuario) throws ServiceException;
}
