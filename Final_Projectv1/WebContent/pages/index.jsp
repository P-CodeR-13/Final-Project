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
<title>Login</title>
</head>
<body>
<div id="mainAdd">

</div>
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
	</table>
</body>
</html>
<script>
var addObj = {};


$("register_btn").observe("click", function(){
	register();
});

function register(){
	
	var isNull=false;
	
	$w("txtPassword txtUsername txtEmail").each(function(c){
		if ($F(c) == null || $F(c) == ""){
			isNull = true;
		}
	})
	
	if(isNull){
		alert("Fields cannot be null");
		return false;
	}
	
	addObj.username = $F("txtUsername");
	addObj.password = $F("txtPassword");
	addObj.firstName = $F("txtFirst_name");
	addObj.lastName = $F("txtLast_name");
	addObj.email = $F('txtEmail');
	addObj.address = $F("txtAddress");
	addObj.contactNumber = $F("txtContact");
	
	saveRegister();
}

function saveRegister(){
	new Ajax.Request(contextPath +"/registerNewUser", {
		method: "POST",
		parameters: {
				action: "insertRecord",
				username: addObj.username,
				password: addObj.password,
				firstName: addObj.firstName,
				lastName: addObj.lastName,
				email: addObj.email,
				address: addObj.address,
				contactNumber: addObj.contactNumber
		},
		onComplete: function(response){
			 alert("Registered!!");
			 $('mainAdd').update(response.responseText)
		}
	});
}
</script>