	<!DOCTYPE html>
	<html lang="es">
		<head>
			<meta charset="utf-8">
			<jsp:include page="styles.jsp"></jsp:include>
			<title>Ingreso de usuario</title>
		</head>
		
		<body>
			<jsp:include page="navbar.jsp"></jsp:include>
			<div class="container">
			<h1 class="mb-3 mt-5 ">Login - Ingreso de usuario</h1>
			
			<hr>
			<form action="loginController.jsp" class="p-5 border border-success w-50 m-auto" method="GET">
				<div class="mb-3">
  					<label for="lbl-username" class="form-label">Usuario: </label>
  					<input type="text" class="form-control" id="lbl-username" name="username" placeholder="Ingrese su usuario">
				</div>
				
				<div class="mb-3">
  					<label for="lbl-password" class="form-label">Contraseña: </label>
  					<input type="text" class="form-control" id="lbl-password" name="password" placeholder="Ingrese su password">
				</div>
				
				<input type="submit" class="btn btn-success" value="Enviar">
				
			</form>
			</div>
			<jsp:include page="scripts.jsp"></jsp:include>
		</body>
		
	</html>