package com.educacionIt.services.impl;


import java.util.Collection;

import com.educacionIt.domain.Producto;
import com.educacionIt.exeptions.ServiceException;

public class TestProductoServiceImpl {

	public static void main(String[] args) {
		ProductoServiceImpl p = new ProductoServiceImpl();
		
		try {
			Collection<Producto> productos = p.findAll();
			
			for (Producto producto : productos) {
				System.out.println(producto);
			}
			
		} catch (ServiceException e) {
			
			e.printStackTrace();
		}

	}

}
