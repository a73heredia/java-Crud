<%@page import="com.educacionIt.domain.Producto"%>
<%@page import="com.educacionIt.web.enums.ViewKeyEnums"%>
<%
	// asumo que el servlet ya cargo el objeto producto
	System.out.println(ViewKeyEnums.PRODUCTO_EDITAR.name());
	Producto aux = (Producto)request.getAttribute(ViewKeyEnums.PRODUCTO_EDITAR.name());
%>
<html>
	<head>
		<title>Educacion IT - Editar</title>
		<jsp:include page="styles.jsp"></jsp:include>
	</head>
	<body>
		<jsp:include page="navbar.jsp"></jsp:include>
		
		<div class="container">
			<h1>Editando el Producto Id: <%= aux.getId() %></h1>
			
			<div class="row">
				<div class="col">
					
					<form action="<%= request.getContextPath() %>/ActualizarProductoServlet" method="POST" class="border border-primary p-5 mt-3 w-50 m-auto">
					
						<input type="hidden" value="<%= aux.getId() %>" name="id">
						
						<div class="mb-3">
			  				<label for="lbl-codigo" class="form-label">Codigo:</label>
				  			<input type="text" value="<%= aux.getCodigo() %>" class="form-control" id="lbl-codigo" name="codigo" placeholder="Ingrese el codigo">
						</div>
						
						<div class="mb-3">
			  				<label for="lbl-titulo" class="form-label">Titulo:</label>
				  			<input type="text" value="<%= aux.getTitulo() %>" class="form-control" id="lbl-titulo" name="titulo" placeholder="Ingrese el titulo">
						</div>
						
						<div class="mb-3">
			  				<label for="lbl-precio" class="form-label">Precio:</label>
				  			<input type="text" class="form-control" value="<%= aux.getPrecio() %>" id="lbl-precio" name="precio" placeholder="Ingrese el precio">
						</div>
						
						<div class="mb-3">
			  				<label for="lbl-precio" class="form-label">Tipo Producto:</label>
				  			<select name="tipoProducto" class="form-control">
				  				<option value="1">Herramientas</option>
				  				<option value="2">Electrodomesticos</option>
				  				<option value="3">Celulares</option>
				  			</select>	
						</div>
						
						<button type="submit" class="btn btn-primary">Actualizar</button>

					</form>
				
				
				</div>
			</div>
		</div>
	
	
		<jsp:include page="scripts.jsp"></jsp:include>
	</body>

</html>