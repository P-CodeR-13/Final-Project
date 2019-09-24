<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="js/prototype.js"></script>
<script>
	var contextPath = "${pageContext.request.contextPath}"
</script>
<title>LOGIN</title>
</head>
<body>
<div id="mainLog">
	<table>
		<tr>
			<td>USERNAME:</td>
			<td><input type="text" id="username"/></td>
		</tr>
		
		<tr>
			<td>PASSWORD:</td>
			<td><input type="password" id="password"/></td>
		</tr>
		
		<tr>
			<td><input type="button" id="login_btn" value="LOGIN"/></td>
		</tr>
	</table>
</div>
</body>
		<script>
			$("login_btn").observe("click", function(){
				login();
			});
			function login(){
				new Ajax.Request(contextPath +"/loginUser", {
					method: "POST",
					parameters: {
							action: "login",
							username: $F("username"),
							password:  $F("password")
					},
					onComplete: function(response){
						 $('mainLog').update(response.responseText)
					}
				});
			}
	</script>
</html>
