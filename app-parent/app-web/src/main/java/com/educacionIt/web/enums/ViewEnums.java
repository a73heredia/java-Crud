package com.educacionIt.web.enums;

public enum ViewEnums {
	LOGIN("/login.jsp"),
	LISTADO_GENERAL("/listadoGeneral.jsp"),
	NUEVO_PRODUCTO("/nuevo.jsp"),
	LOGIN_SUCCESS("/loginSuccess.jsp"), 
	EDITAR_PRODUCTO("/editar.jsp");
	
	private String view;
	
	// Ctrl + Space
	private ViewEnums(String view) {
		this.view = view;
	}
	
	public String getView() {
		return this.view;
	}
}
