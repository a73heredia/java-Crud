package com.educacionIt.services.impl;

import com.educacionIt.domain.Usuario;
import com.educacionIt.exeptions.ServiceException;

public class TestLoginServiceImpl {

	public static void main(String[] args) {
		
		LoginServiceImpl ls = new LoginServiceImpl();
		
		try {
			Usuario u1 = ls.getUserByUserName("Alejandro");
			System.out.println(u1);
			
			Usuario u2 = ls.getUserByUserName("pepe");
			System.out.println(u2);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
