<%@page import="com.educacionIt.domain.Usuario" %>
<%@page import="com.educacionIt.services.impl.LoginServiceImpl" %>
<%@page import="com.educacionIt.services.LoginService" %>

<html>
	<head>
		<jsp:include page="styles.jsp"></jsp:include>
	</head>
	
	<body>
	
		<jsp:include page="navbar.jsp"></jsp:include>
	
		<div class="container">
			
			<%
				//scriptet: código java
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				
				LoginService ls = new LoginServiceImpl();
				Usuario usuario = ls.getUserByUserName(username);
				
				if ( usuario !=null && usuario.getPassword().equals(password)) {
					
			%>
				<div class="alert alert-success" role="alert">
					Usuario: <%= username.toUpperCase() %>
				</div>
				
				<ul>
					<li>
						<a href="<%= request.getContextPath()%>/listadoGeneral.jsp">Listado General</a>
					</li>
				</ul>
				
			<% 
				} else {
			%>		
				<div class="alert alert-danger" role="alert">
					LOGIN INVALIDO
				</div>
							
			<% } %>
			<ul>
				<li>
					<a href="<%= request.getContextPath() %>">Volver al index</a>
				</li>
			</ul>
		</div>
	
		<jsp:include page="scripts.jsp"></jsp:include>
	</body>

</html>