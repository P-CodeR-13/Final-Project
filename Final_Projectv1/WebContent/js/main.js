//USER REGISTRATION
var addObj = {};

function register(){
	
	if($("#txtUsername").val() == '' || $("#txtPassword").val() == '' || $("#txtEmail").val() == '' 
		|| $("#txtFirst_name").val() == '' || $("#txtLast_name").val() == '' || $("#txtAddress").val() == '' || $("#txtContact").val() == '' )
		alert("Fields cannot be null");
	else {
	addObj.username = 	$("#txtUsername").val();
	addObj.password = 	$("#txtPassword").val();
	addObj.firstName = 	$("#txtFirst_name").val();
	addObj.lastName = 	$("#txtLast_name").val();
	addObj.email = 		$("#txtEmail").val();
	addObj.address = 	$("#txtAddress").val();
	addObj.contactNumber = $("#txtContact").val();	
	//alert(addObj.username+' '+addObj.password+' '+addObj.firstName+' '+addObj.lastName+' ');
	saveRegister();
	}
}

function saveRegister(){
	
	$.ajax({
		url: contextPath  + "/loginUser",
		method: "POST",
		data: {
				action: "insertRecord",
				username: addObj.username,
				password: addObj.password,
				firstName: addObj.firstName,
				lastName: addObj.lastName,
				email: addObj.email,
				address: addObj.address,
				contactNumber: addObj.contactNumber
		},
		success: function(response){
			alert("Registration Successful!");
			window.location.assign(contextPath);
		}
	});
}
//USER LOGIN
function login(){
	
	$.ajax({
		url: contextPath + "/loginUser",
		method: "POST",
		data: {
			action: "login",
			username: $("#username").val(),
			password:  $("#password").val()
		},
		success: function(response) {	
			$('#mainDiv').html(response);
		}
	});
	
}

//ADMIN PAGE FOR PRODUCT MANAGEMENT
/*function loadProductsAdmin() {
	
	$.ajax({
		url: contextPath + "/insertProduct",
		method: "GET",
		data : {
			action: "loadProductsAdmin"
		},
		success: function(result) {
			alert('welcome admin');
		}
	});
	
}*/
//////////ADD
function addRecord() {
	if($("#txtProductName").val() == null || $("#txtProductName").val() == ""){
			$("#txtProductName").val('');
			alert("Product Name is required");
	}
	else if($("#txtPrice").val() == null || $("#txtPrice").val() == ""){
		$("#txtPrice").val('');
		alert("Price is required");
	}
	else if($("#txtStocks").val() == null || $("#txtStocks").val() == ""){
		$("#txtStocks").val('');
		alert("Stocks is required");
	}
	else if($("#txtImage").val() == null || $("#txtImage").val() == ""){
		$("#txtImage").val('');
		alert("Image is required");
	}
	else if(isNaN($("#txtStocks").val()) || isNaN($("#txtPrice").val())){
		$("#txtStocks").val('');
		$("#txtPrice").val('');
		alert("Price or Stocks should be a valid number");
	}
	else{
	$.ajax({
		url: contextPath + "/insertProduct",
		method: "POST",
		data : {
			action: "insertProduct",
			productName:  $("#txtProductName").val(),
			price:  $("#txtPrice").val(),
			stocks:  $("#txtStocks").val(),
			image:  $("#txtImage").val()
		},
		success: function(result) {
			alert("Record Added!");
			window.location.reload();
		}
	});
	}
}

//////////// DELETE
function deleteRecord(){
	var notExists = true;
	
	if($("#deleteProductId").val() == null || $("#deleteProductId").val() == ""){
		$("#deleteProductId").val('');
		alert("Product ID is required");
	} else if (isNaN($("#deleteProductId").val())){
		$("#deleteProductId").val('');
		alert("Invalid Product ID");
	}

	$('.tableRow td').each(function() {
		if($(this).html() == $("#deleteProductId").val()){
			notExists = false;
		}
	});
	
	if(notExists){
		$("#deleteProductId").val('');
		alert("The record you are trying to delete does not exist on the table!");
	}else{
		$.ajax({
			url: contextPath + "/deleteProduct",
			method: "POST",
			data : {
				action: "deleteProduct",
				prodNo:  $("#deleteProductId").val()
			},
			success: function(result) {
				alert("Product unstocked");
				$("#deleteProductId").val('');
				window.location.reload();
			}
		});
	}
}

/////// UPDATE
$("#updateProductId").each(function(e){
	$(e).bind("change", function(){
		validateUpdateRec();
	})
});

function validateUpdateRec(){
	if(isNaN($("#updateProductId"))){
		$("#updateProductId").val('');
		alert("Invalid Employee Number");
	}
}

function updateUser(){
	
	$.ajax({
		url: contextPath + "/updateUser",
		method: "POST",
		data : {
		action: "updateUser",
		userId: $("#userId").val(),
		username: $("#username").val(),
		password: $("#password").val(),
		firstname: $("#firstname").val(),
		lastname: $("#lastname").val(),
		email: $("#email").val(),
		contactNum: $("#contactNum").val(),
		address: $("#address").val()
		},
		success: function(result) {
			alert("Profile Updated!");
			window.location.reload();
			$("#username").val('');
			$("#password").val('');
			$("#firstname").val('');
			$("#lastname").val('test');
			$("#email").val('');
			$("#contactNum").val('');
			$("#address").val('');
			
		}
	});
}

function updateRecord(){
	var notExists = true;
	if($("#updateProductId") == null || $("#updateProductId") == ""){
		$("#updateProductId").val('');
		alert("Employee number is required");
	}	
	
	$('.tableRow td').each(function() {
		if($(this).html() == $("#updateProductId").val()){
			notExists = false;
		}
	});
	
	if(notExists){
		alert("The record you are trying to update is not existing on the table!");
		$("#updateProductId").val('');
	} else {	
		$.ajax({
			url: contextPath + "/updateProduct",
			method: "POST",
			data : {
				action: "updateProduct",
				productId: $("#updateProductId").val(),
				productName: $("#updateProductName").val(),
				price: $("#updatePrice").val(),
				stocks: $("#updateStocks").val(),
				image: $("#updateImage").val()
			},
			success: function(result) {
				$("#updateProductId").val('');
				$("#updateProductName").val('');
				$("#updatePrice").val('');
				$("#updateStocks").val('');
				$("#updateImage").val('');
				alert("Record Updated!");
				window.location.reload();
			}
		});
	}
}
