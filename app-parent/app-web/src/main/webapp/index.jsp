<!DOCTYPE html>
<html lang="es">
	<head>
		<meta charset="utf-8">
		<title>Titulo de la primer aplicacion jsp</title>
		
		<jsp:include page="styles.jsp"></jsp:include>
	</head>
	
	<body>
		<jsp:include page="navbar.jsp"></jsp:include>
		<div class="container">
		<h1>Clase 01 - Primer aplicacion servida con tomcat</h1>
		<h2>Ale!!!!!</h2>
		<a href="<%= request.getContextPath()%>/login.jsp">Login</a>
			
		</div>
		
		<jsp:include page="scripts.jsp"></jsp:include>
	</body>
	
</html>