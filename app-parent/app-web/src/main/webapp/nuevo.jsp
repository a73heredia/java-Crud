<html>
	<head>
		<title>Educacion IT - Nuevo</title>
		<jsp:include page="styles.jsp"></jsp:include>
	</head>
	
	<body>
		<jsp:include page="navbar.jsp"></jsp:include>
		
		<div class="container">
			<h1>Nuevo Productos</h1>
			
			<div class="row">
				<div class="col">
					
					<form action="/app-web/NewProductoServlet" method="POST" class="border border-primary p-5 mt-3 w-50 m-auto">
						
						<div class="mb-3">
			  				<label for="lbl-id" class="form-label">ID:</label>
				  			<input type="text" class="form-control" id="lbl-id" name="id" placeholder="Ingrese el id">
						</div>
						
						<div class="mb-3">
			  				<label for="lbl-codigo" class="form-label">Codigo:</label>
				  			<input type="text" class="form-control" id="lbl-codigo" name="codigo" placeholder="Ingrese el codigo">
						</div>
						
						<div class="mb-3">
			  				<label for="lbl-titulo" class="form-label">Titulo:</label>
				  			<input type="text" class="form-control" id="lbl-titulo" name="titulo" placeholder="Ingrese el titulo">
						</div>
						
						<div class="mb-3">
			  				<label for="lbl-precio" class="form-label">Precio:</label>
				  			<input type="text" class="form-control" id="lbl-precio" name="precio" placeholder="Ingrese el precio">
						</div>
						
						<div class="mb-3">
			  				<label for="lbl-precio" class="form-label">Tipo Producto:</label>
				  			<select name="tipoProducto" class="form-control">
				  				<option value="1">Herramientas</option>
				  				<option value="2">Electrodomesticos</option>
				  				<option value="3">Celulares</option>
				  			</select>	
						</div>
						
						<button type="submit" class="btn btn-primary">Enviar</button>

					</form>
				
				
				</div>
			</div>
		</div>
	
	
		<jsp:include page="scripts.jsp"></jsp:include>
	</body>

</html>