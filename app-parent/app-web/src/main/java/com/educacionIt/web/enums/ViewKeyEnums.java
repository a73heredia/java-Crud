package com.educacionIt.web.enums;

public enum ViewKeyEnums {
	ID_PRODUCTO("id"),
	ERROR_GENERAL("error"),
	EXITO("exito"),
	LISTADO("listado"), 
	PRODUCTO_EDITAR("producto_editar"), 
	CLAVE_BUSQUEDA("claveBusqueda"), 
	TOTAL("total");
	
	private String viewKey;

	private ViewKeyEnums(String viewKey) {
		this.viewKey = viewKey;
	}
	
	public String getViewKey() {
		return viewKey;
	}
}
