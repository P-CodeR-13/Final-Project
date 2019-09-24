<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="js/prototype.js"></script>
<script src="js/main.js"></script>
<script>
	var contextPath = "${pageContext.request.contextPath}"
</script>
<title>REGISTER</title>
</head>
<body>
<div id="mainAdd">
	<table>
		<tr>
			<td>Username:</td>
			<td><input type="text" id="txtUsername"/></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type="password" id="txtPassword"/></td>
		</tr>
		<tr>
			<td>First Name:</td>
			<td><input type="text" id="txtFirst_name"/></td>
		</tr>
		<tr>
			<td>Last Name:</td>
			<td><input type="text" id="txtLast_name"/></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><input type="text" id="txtEmail"/></td>
		</tr>
		<tr>
			<td>Address:</td>
			<td><input type="text" id="txtAddress"/></td>
		</tr>
		<tr>
			<td>Contact Number:</td>
			<td><input type="text" id="txtContact"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="button" id="register_btn" value="REGISTER"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="button" id="login_btn" value="Login"/></td>
		</tr>
	</table>
</div>
</body>
	<script>
	$("register_btn").observe("click", function(){
		register();
	});
	
	$("login_btn").observe("click", function(){

		new Ajax.Request(contextPath +"/registerNewUser", {
			method: "GET",
			parameters: {
					action: "goToLogin"
			},
			onComplete: function(response){
				 $('mainAdd').update(response.responseText)
			}
		});
		
	});
</script>
</html>
