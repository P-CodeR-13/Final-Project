<!DOCTYPE html>
<html lang="en">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title  -->
    <title>Amado - Furniture Ecommerce Template | Sign-up</title>

    <!-- Favicon  -->
    <link rel="icon" href="${pageContext.request.contextPath}/img/core-img/favicon.ico">

    <!-- Core Style CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/core-style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
	
	<script>
		var contextPath = "${pageContext.request.contextPath}"
	</script>

</head>

<body>
	<table id="tableDiv" style="width:600px; margin:2px 0px 0px 2px; border: 1px solid gray">
		<tr name="columnNames" class="tableRow">
			<th>Product Id</th>
			<th>Product Name</th>
			<th>Price</th>
			<th>Stocks</th>
			<th>Image</th>
		</tr>
		<c:forEach var="prod" items="${prodList}">
			<tr name="rowname" class="tableRow" id="rowid${prod.productId}">
				<td><c:out value="${prod.productId}"></c:out></td>
				<td><c:out value="${prod.productName}"></c:out></td>
				<td><c:out value="${prod.price}"></c:out></td>
				<td><c:out value="${prod.stocks}"></c:out></td>
				<td><img src="images/${prod.image}" width="50px" height="50px"></td>
			</tr>
		</c:forEach>
	</table>	
	<br>
	
    <!-- ##### Main Content Wrapper Start ##### -->
    <div class="main-content-wrapper d-flex clearfix">
	
        <!-- Mobile Nav (max width 767px)-->
        <div class="mobile-nav">
            <!-- Navbar Brand -->
            <div class="amado-navbar-brand">
                <a href="javascript:window.location.href=window.location.href"><img src="${pageContext.request.contextPath}/img/core-img/logo.png" alt=""></a>
            </div>
            <!-- Navbar Toggler -->
            <div class="amado-navbar-toggler">
                <span></span><span></span><span></span>
            </div>
        </div>

        <!-- Header Area Start -->
        <header class="header-area clearfix">
            <!-- Close Icon -->
            <div class="nav-close">
                <i class="fa fa-close" aria-hidden="true"></i>
            </div>
            <!-- Logo -->
            <div class="logo">
                <a href="javascript:window.location.href=window.location.href"><img src="${pageContext.request.contextPath}/img/core-img/logo.png" alt=""></a>
            </div>
            <div class="amado-btn-group mt-30 mb-100">
                <a href="${pageContext.request.contextPath}/pages/index.jsp" class="btn amado-btn active">Logout</a>
            </div>
            <!-- Amado Nav -->
   
            <!-- Button Group -->
           <!--  <div class="amado-btn-group mt-30 mb-100">
                <a href="#" class="btn amado-btn mb-15">%Discount%</a>
                <a href="#" class="btn amado-btn active">New this week</a>
            </div> -->
 
        </header>
        <!-- Header Area End -->
		<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
		<div id="productTable"></div>
        <div class="cart-table-area section-padding-95">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-12 col-lg-8">
                        <div class="checkout_details_area mt-50 clearfix">

                            <div class="cart-title">
                                <h2>Add Product</h2>
                            </div>

                            <form action="#" method="post">
                                <div class="row">
                                   
                                    <div class="col-md-12 mb-3">
                                        <input type="text" class="form-control" id="txtProductName"  placeholder="Product Name" required>
                                    </div>
                                    <div class="col-12 mb-3">
                                        <input type="text" class="form-control" id="txtPrice" placeholder="Price" required>
                                    </div>
                                    <div class="col-12 mb-3">
                                        <input type="text" class="form-control" id="txtStocks" placeholder="Stock" required>
                                    </div>
                                    <div class="col-12 mb-3">
                                        <input type="text" class="form-control" id="txtImage" placeholder="Image" required>
                                    </div>
                                    <div class="col-md-5 mb-3">
                                    </div>
                                    <div class="col-md-3 mb-3">
                                 		<!-- <a href="#" class="btn amado-btn mb-15" style="height: 48px;">Save</a> -->
                                 	</div>
                                 	&nbsp;<div class="col-md-3 mb-3">
                                 		<a href="#" class="btn amado-btn active" id="btnAdd"  style="height: 48px;">Add</a>
                                 	</div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-12 col-lg-8">
                        <div class="checkout_details_area mt-50 clearfix">

                            <div class="cart-title">
                                <h2>Update Product</h2>
                            </div>

                            <form action="#" method="post">
                                <div class="row">
                                    <div class="col-md-12 mb-3">
                                        <input type="text" class="form-control" id="updateProductId" placeholder="Product No." required>
                                    </div>
                                    <div class="col-md-12 mb-3">
                                        <input type="password" class="form-control" id="updateProductName" placeholder="Product Name" required>
                                    </div>
                                    <div class="col-12 mb-3">
                                        <input type="text" class="form-control" id="updatePrice" placeholder="Price" required>
                                    </div>
                                    <div class="col-12 mb-3">
                                        <input type="text" class="form-control" id="updateStocks" placeholder="Stock" required>
                                    </div>
                                    <div class="col-12 mb-3">
                                        <input type="text" class="form-control" id="updateImage" placeholder="Image" required>
                                    </div>
                                    <div class="col-md-5 mb-3">
                                    </div>
                                    <div class="col-md-3 mb-3">
                                    	<!-- <a href="#" class="btn amado-btn mb-15" style="height: 48px;">Save</a> -->	
                                 	</div>
                                 	&nbsp;<div class="col-md-3 mb-3">
                                 		<a href="#" class="btn amado-btn active" id="btnUpdate" style="height: 48px;">Update</a>
                                 	</div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-12 col-lg-8">
                        <div class="checkout_details_area mt-50 clearfix">

                            <div class="cart-title">
                                <h2>Delete Product</h2>
                            </div>

                            <form action="#" method="post">
                                <div class="row">
                                    <div class="col-md-12 mb-3">
                                        <input type="text" class="form-control" id="deleteProductId" placeholder="Product No." required>
                                    </div>
                                    <div class="col-md-5 mb-3">
                                    </div>
                                    <div class="col-md-3 mb-3">
                                   		 <!-- <a href="#" class="btn amado-btn mb-15" style="height: 48px;">Save</a> -->
                                 	</div>
                                 	&nbsp;<div class="col-md-3 mb-3">
                                 		<a href="#" class="btn amado-btn active" id ="btnDelete" style="height: 48px;">Delete</a>
                                 	</div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- ##### Main Content Wrapper End ##### -->

    <!-- ##### jQuery (Necessary for All JavaScript Plugins) ##### -->
    <script src="${pageContext.request.contextPath}/js/jquery/jquery-2.2.4.min.js"></script>
    <!-- Popper js -->
    <script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
    <!-- Bootstrap js -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <!-- Plugins js -->
    <script src="${pageContext.request.contextPath}/js/plugins.js"></script>
    <!-- Active js -->
    <script src="${pageContext.request.contextPath}/js/active.js"></script>
    
    <script src="${pageContext.request.contextPath}/js/active.js"></script>

</body>
	<script>
$(document).ready(function(){
	$("#btnAdd").bind("click", function(){
		addRecord();
	});
	$("#btnDelete").bind("click", function(){
		deleteRecord();
	});
	$("#btnUpdate").bind("click", function(){
		updateRecord();
	});
	
});
</script>
</html>