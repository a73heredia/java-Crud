<%@page import="com.educacionIt.web.enums.ViewKeyEnums"%>

<%
	if(request.getAttribute(ViewKeyEnums.EXITO.name()) != null) {
%>
		<div class="row">
			<div class="alert alert-success" role="alert">
		  		<%= request.getAttribute(ViewKeyEnums.EXITO.name()) %>
			</div>
		</div>
<%
	}
%>

<%
	if(request.getAttribute(ViewKeyEnums.ERROR_GENERAL.name()) != null) {
%>
		<div class="row">
			<div class="alert alert-danger" role="alert">
			  <%= request.getAttribute(ViewKeyEnums.ERROR_GENERAL.name()) %>
			</div>
		</div>
<%
	}
%>