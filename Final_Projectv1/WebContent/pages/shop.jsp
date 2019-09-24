<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title  -->
    <title>Amado - Furniture Ecommerce Template | Shop</title>

    <!-- Favicon  -->
    <link rel="icon" href="${pageContext.request.contextPath}/img/core-img/favicon.ico">

    <!-- Core Style CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/core-style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

</head>

<body>
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
            <!-- Amado Nav -->
            <nav class="amado-nav">
                <ul>
                    <li><a href="${pageContext.request.contextPath}/pages/home.jsp">Home</a></li>
                    <li><a href="${pageContext.request.contextPath}/pages/profile.jsp">Profile</a></li>
                    <li class="active"><a href="${pageContext.request.contextPath}/pages/shop.jsp">Shop</a></li>
                    <li> <div class="cart-fav-search mb-100">
                <a href="${pageContext.request.contextPath}/pages/cart.jsp" class="cart-nav"><img src="${pageContext.request.contextPath}/img/core-img/cart.png" alt=""> Cart <span>(0)</span></a>
            </div></li>
                </ul>
               
            </nav>
            <!-- Button Group -->
            <div class="amado-btn-group mt-30 mb-100">
                <a href="${pageContext.request.contextPath}/pages/index.jsp" class="btn amado-btn active">Logout</a>
            </div>
            <!-- Social Button -->
           <!--  <div class="social-info d-flex justify-content-between">
                <a href="#"><i class="fa fa-pinterest" aria-hidden="true"></i></a>
                <a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a>
                <a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a>
                <a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
            </div> -->
        </header>
        <!-- Header Area End -->
		<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
            <div class="amado_product_area section-padding-95">
            <div class="container-fluid">
				<div class="row">
                    <div class="col-12">
                        <div class="product-topbar d-xl-flex align-items-end justify-content-between">
                            <!-- Total Products -->
                           <!--  <div class="total-products">
                                <p>Showing 1-8 0f 25</p>
                            </div> -->
                        </div>
                    </div>
                </div>

                <div class="row">
                    <!-- Single Product Area -->
                    <div class="col-12 col-sm-6 col-md-12 col-xl-6">
                        <div class="single-product-wrapper">
                            <!-- Product Image -->
                            <div class="product-img">
                                <img src="${pageContext.request.contextPath}/img/product-img/product1.jpg" alt="">
                                <!-- Hover Thumb -->
                                <img class="hover-img" src="${pageContext.request.contextPath}/img/product-img/product2.jpg" alt="">
                            </div>

                            <!-- Product Description -->
                            <div class="product-description d-flex align-items-center justify-content-between">
                                <!-- Product Meta Data -->
                                <div class="product-meta-data">
                                    <div class="line"></div>
                                    <p class="product-price">$180</p>
                                    <a href="product-details.jsp">
                                        <h6>Modern Chair</h6>
                                    </a>
                                </div>
                                <!-- Ratings & Cart -->
                                <div class="cart text-right">
                                	<br/>
                                    <div class="cart">
                                        <a href="${pageContext.request.contextPath}/pages/cart.jsp" data-toggle="tooltip" data-placement="left" title="Add to Cart"><img src="${pageContext.request.contextPath}/img/core-img/cart.png" alt=""></a>
                                    </div>
                                </div>
                            </div>
                            <div class="short_overview my-5">
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquid quae eveniet culpa officia quidem mollitia impedit iste asperiores nisi reprehenderit consequatur, autem, nostrum pariatur enim?</p>
                            </div>
                        </div>
                    </div>
                    <!-- Single Product Area -->
                    <div class="col-12 col-sm-6 col-md-12 col-xl-6" style="width:110%">
                        <div class="single-product-wrapper">
                            <!-- Product Image -->
                            <div class="product-img">
                                <img src="${pageContext.request.contextPath}/img/product-img/product2.jpg" alt="">
                                <!-- Hover Thumb -->
                                <img class="hover-img" src="${pageContext.request.contextPath}/img/product-img/product3.jpg" alt="">
                            </div>

                            <!-- Product Description -->
                            <div class="product-description d-flex align-items-center justify-content-between">
                                <!-- Product Meta Data -->
                                <div class="product-meta-data">
                                    <div class="line"></div>
                                    <p class="product-price">$180</p>
                                    <a href="${pageContext.request.contextPath}/pages/product-details.jsp">
                                        <h6>Modern Chair</h6>
                                    </a>
                                </div>
                                <!-- Ratings & Cart -->
                                <div class="cart text-right">
                                	<br/>
                                    <div class="cart">
                                        <a href="${pageContext.request.contextPath}/pages/cart.jsp" data-toggle="tooltip" data-placement="left" title="Add to Cart"><img src="${pageContext.request.contextPath}/img/core-img/cart.png" alt=""></a>
                                    </div>
                                </div>
                            </div>
                            <div class="short_overview my-5">
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquid quae eveniet culpa officia quidem mollitia impedit iste asperiores nisi reprehenderit consequatur, autem, nostrum pariatur enim?</p>
                            </div>
                        </div>
                    </div>

                    <!-- Single Product Area -->
                    <div class="col-12 col-sm-6 col-md-12 col-xl-6">
                        <div class="single-product-wrapper">
                            <!-- Product Image -->
                            <div class="product-img">
                                <img src="${pageContext.request.contextPath}/img/product-img/product3.jpg" alt="">
                                <!-- Hover Thumb -->
                                <img class="hover-img" src="${pageContext.request.contextPath}/img/product-img/product4.jpg" alt="">
                            </div>

                            <!-- Product Description -->
                            <div class="product-description d-flex align-items-center justify-content-between">
                                <!-- Product Meta Data -->
                                <div class="product-meta-data">
                                    <div class="line"></div>
                                    <p class="product-price">$180</p>
                                    <a href="${pageContext.request.contextPath}/pages/product-details.jsp">
                                        <h6>Modern Chair</h6>
                                    </a>
                                </div>
                                <!-- Ratings & Cart -->
                                <div class="cart text-right">
                                	<br/>
                                     <div class="cart">
                                        <a href="${pageContext.request.contextPath}/pages/cart.jsp" data-toggle="tooltip" data-placement="left" title="Add to Cart"><img src="${pageContext.request.contextPath}/img/core-img/cart.png" alt=""></a>
                                    </div>
                                </div>
                            </div>
                            <div class="short_overview my-5">
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquid quae eveniet culpa officia quidem mollitia impedit iste asperiores nisi reprehenderit consequatur, autem, nostrum pariatur enim?</p>
                            </div>
                        </div>
                    </div>

                    <!-- Single Product Area -->
                    <div class="col-12 col-sm-6 col-md-12 col-xl-6">
                        <div class="single-product-wrapper">
                            <!-- Product Image -->
                            <div class="product-img">
                                <img src="${pageContext.request.contextPath}/img/product-img/product4.jpg" alt="">
                                <!-- Hover Thumb -->
                                <img class="hover-img" src="${pageContext.request.contextPath}/img/product-img/product5.jpg" alt="">
                            </div>

                            <!-- Product Description -->
                            <div class="product-description d-flex align-items-center justify-content-between">
                                <!-- Product Meta Data -->
                                <div class="product-meta-data">
                                    <div class="line"></div>
                                    <p class="product-price">$180</p>
                                    <a href="${pageContext.request.contextPath}/pages/product-details.jsp">
                                        <h6>Modern Chair</h6>
                                    </a>
                                </div>
                                <!-- Ratings & Cart -->
                                <div class="cart text-right">
                                	<br/>
                                    <div class="cart">
                                        <a href="${pageContext.request.contextPath}/pages/cart.jsp" data-toggle="tooltip" data-placement="left" title="Add to Cart"><img src="${pageContext.request.contextPath}/img/core-img/cart.png" alt=""></a>
                                    </div>
                                </div>
                            </div>
                            <div class="short_overview my-5">
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquid quae eveniet culpa officia quidem mollitia impedit iste asperiores nisi reprehenderit consequatur, autem, nostrum pariatur enim?</p>
                            </div>
                        </div>
                    </div>

                    <!-- Single Product Area -->
                    <div class="col-12 col-sm-6 col-md-12 col-xl-6">
                        <div class="single-product-wrapper">
                            <!-- Product Image -->
                            <div class="product-img">
                                <img src="${pageContext.request.contextPath}/img/product-img/product5.jpg" alt="">
                                <!-- Hover Thumb -->
                                <img class="hover-img" src="${pageContext.request.contextPath}/img/product-img/product6.jpg" alt="">
                            </div>

                            <!-- Product Description -->
                            <div class="product-description d-flex align-items-center justify-content-between">
                                <!-- Product Meta Data -->
                                <div class="product-meta-data">
                                    <div class="line"></div>
                                    <p class="product-price">$180</p>
                                    <a href="${pageContext.request.contextPath}/pages/product-details.jsp">
                                        <h6>Modern Chair</h6>
                                    </a>
                                </div>
                                <!-- Ratings & Cart -->
                                <div class="cart text-right">
                                	<br/>
                                    <div class="cart">
                                        <a href="${pageContext.request.contextPath}/pages/cart.jsp" data-toggle="tooltip" data-placement="left" title="Add to Cart"><img src="${pageContext.request.contextPath}/img/core-img/cart.png" alt=""></a>
                                    </div>
                                </div>
                            </div>
                            <div class="short_overview my-5">
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquid quae eveniet culpa officia quidem mollitia impedit iste asperiores nisi reprehenderit consequatur, autem, nostrum pariatur enim?</p>
                            </div>
                        </div>
                    </div>

                    <!-- Single Product Area -->
                    <div class="col-12 col-sm-6 col-md-12 col-xl-6">
                        <div class="single-product-wrapper">
                            <!-- Product Image -->
                            <div class="product-img">
                                <img src="${pageContext.request.contextPath}/img/product-img/product6.jpg" alt="">
                                <!-- Hover Thumb -->
                                <img class="hover-img" src="${pageContext.request.contextPath}/img/product-img/product1.jpg" alt="">
                            </div>

                            <!-- Product Description -->
                            <div class="product-description d-flex align-items-center justify-content-between">
                                <!-- Product Meta Data -->
                                <div class="product-meta-data">
                                    <div class="line"></div>
                                    <p class="product-price">$180</p>
                                    <a href="${pageContext.request.contextPath}/pages/product-details.jsp">
                                        <h6>Modern Chair</h6>
                                    </a>
                                </div>
                                <!-- Ratings & Cart -->
                                <div class="cart text-right">
                                	<br/>
                                    <div class="cart">
                                        <a href="${pageContext.request.contextPath}/pages/cart.jsp" data-toggle="tooltip" data-placement="left" title="Add to Cart"><img src="${pageContext.request.contextPath}/img/core-img/cart.png" alt=""></a>
                                    </div>
                                </div>
                            </div>
                            <div class="short_overview my-5">
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquid quae eveniet culpa officia quidem mollitia impedit iste asperiores nisi reprehenderit consequatur, autem, nostrum pariatur enim?</p>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-12">
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- ##### Main Content Wrapper End ##### -->
    <!-- ##### Footer Area Start ##### -->
    <footer class="footer_area clearfix">
        <div class="container">
            <div class="row align-items-center">
                <!-- Single Widget Area -->
                <div class="col-12 col-lg-4">
                    <div class="single_widget_area">
                        <!-- Logo -->
                        <div class="footer-logo mr-50">
                            <a href="${pageContext.request.contextPath}/pages/index.jsp"><img src="${pageContext.request.contextPath}/img/core-img/logo2.png" alt=""></a>
                        </div>
                    </div>
                </div>
                <!-- Single Widget Area -->
                <div class="col-12 col-lg-8">
                    <div class="single_widget_area">
                        <!-- Footer Menu -->
                        <div class="footer_menu">
                            <nav class="navbar navbar-expand-lg justify-content-end">
                                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#footerNavContent" aria-controls="footerNavContent" aria-expanded="false" aria-label="Toggle navigation"><i class="fa fa-bars"></i></button>
                                <div class="collapse navbar-collapse" id="footerNavContent">
                                    <ul class="navbar-nav ml-auto">
                                         <li class="nav-item active">
                                            <a class="nav-link" href="${pageContext.request.contextPath}/pages/home.jsp">Home</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="${pageContext.request.contextPath}/pages/profile.jsp">Profile</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="${pageContext.request.contextPath}/pages/shop.jsp">Shop</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="${pageContext.request.contextPath}/pages/cart.jsp">Cart</a>
                                        </li>
                                    </ul>
                                </div>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- ##### Footer Area End ##### -->

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

</body>

</html>