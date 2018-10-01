<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% request.setCharacterEncoding("ISO-8859-2"); %>
<% response.setCharacterEncoding("ISO-8859-2"); %>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8" />
	<link rel="apple-touch-icon" sizes="76x76" href="/assets/img/apple-icon.png">
	<link rel="icon" type="image/png" href="/assets/img/favicon.png">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<title>Material Dashboard by Creative Tim</title>
	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
	<!--     Fonts and icons     -->
	<link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
	<!-- CSS Files -->
	<link href="/assets/css/material-dashboard.css?v=2.1.0" rel="stylesheet" />
	<!-- CSS Just for demo purpose, don't include it in your project -->
	<link href="/assets/demo/demo.css" rel="stylesheet" />
</head>

<body class="">
	<div class="wrapper ">
		<div class="sidebar" data-color="purple" data-background-color="white" data-image="/assets/img/sidebar-1.jpg">
			<!--
        Tip 1: You can change the color of the sidebar using: data-color="purple | azure | green | orange | danger"

        Tip 2: you can also add an image using data-image tag
    -->
			<div class="logo">
				<a href="http://www.creative-tim.com" class="simple-text logo-normal"> Creative Tim </a>
			</div>
			<div class="sidebar-wrapper">
				<ul class="nav">
					<c:forEach var="shop" items="${shopList}" varStatus="loop">
						<li class="nav-item "><a class="nav-link" href="/manager/dashboard/${shop.id}"> <i class="material-icons">dashboard</i>
								<p>${shop.name}</p>
							</a></li>
					</c:forEach>


					<!-- <li class="nav-item active-pro ">
                <a class="nav-link" href="./upgrade.html">
                    <i class="material-icons">unarchive</i>
                    <p>Upgrade to PRO</p>
                </a>
            </li> -->
				</ul>
			</div>
		</div>
		<div class="main-panel">
			<!-- Navbar -->
			<nav class="navbar navbar-expand-lg navbar-transparent navbar-absolute fixed-top ">
				<div class="container-fluid">
					<div class="navbar-wrapper">
						<a class="navbar-brand" href="#pablo">Dashboard</a>
					</div>
					<button class="navbar-toggler" type="button" data-toggle="collapse" aria-controls="navigation-index" aria-expanded="false"
					 aria-label="Toggle navigation">
						<span class="sr-only">Toggle navigation</span> <span class="navbar-toggler-icon icon-bar"></span> <span class="navbar-toggler-icon icon-bar"></span>
						<span class="navbar-toggler-icon icon-bar"></span>
					</button>
					<div class="collapse navbar-collapse justify-content-end">
						<form class="navbar-form">
							<div class="input-group no-border">
								<input type="text" value="" class="form-control" placeholder="Search...">
								<button type="submit" class="btn btn-white btn-round btn-just-icon">
									<i class="material-icons">search</i>
									<div class="ripple-container"></div>
								</button>
							</div>
						</form>
						<ul class="navbar-nav">
							<li class="nav-item"><a class="nav-link" href="#pablo">
									<i class="material-icons">dashboard</i>
									<p class="d-lg-none d-md-block">Stats</p>
								</a></li>
							<li class="nav-item dropdown"><a class="nav-link" href="http://example.com" id="navbarDropdownMenuLink"
								 data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="material-icons">notifications</i>
									<span class="notification">5</span>
									<p class="d-lg-none d-md-block">Some Actions</p>
								</a>
								<div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
									<a class="dropdown-item" href="#">Mike John responded to
										your email</a> <a class="dropdown-item" href="#">You have 5
										new tasks</a> <a class="dropdown-item" href="#">You're now
										friend with Andrew</a> <a class="dropdown-item" href="#">Another
										Notification</a> <a class="dropdown-item" href="#">Another One</a>
								</div>
							</li>
							<li class="nav-item"><a class="nav-link" href="#pablo">
									<i class="material-icons">person</i>
									<p class="d-lg-none d-md-block">Account</p>
								</a></li>
						</ul>
					</div>
				</div>
			</nav>
			<!-- End Navbar -->
			<div class="content">
				<div class="container-fluid">

					<div class="row">
						<div class="col-lg-12 col-md-12">
							<div class="card">
								<div class="card-header card-header-info">
									<h4 class="card-title">Trading archive</h4>
									<p class="card-category"></p>
								</div>

								<div class="card-body table-responsive">
									<form action="/manager/dashboard/${id}" name="dashboardForm" id="dashboardForm"></form>
									<table class="table table-hover">
										<thead class="text-info">
											<th>Search from</th>
											<th>Search to</th>
											<th>Search by product name</th>
											<th>Search</th>
											<th>Show all</th>
										</thead>
										<tbody>
											<tr>
												<td>
													<input type="text" class="form-control model" name="searchFrom" id="searchFrom" placeholder="YYYY-MM-DD"
													 form="dashboardForm">
												</td>
												<td>
													<input type="text" class="form-control model" name="searchTo" id="searchTo" placeholder="YYYY-MM-DD" form="dashboardForm">
												</td>
												<td>
													<select class="form-control" name="productName" form="dashboardForm">
														<option disabled selected>Select product name</option>
														<c:forEach var="product" items="${productList}">
															<option value="${product.name}">${product.name}</option>
														</c:forEach>
													</select>
												
													<!-- <input type="text" class="form-control model" name="productName" id="productName" placeholder="Product name"
													 form="dashboardForm"> -->
												</td>
												<td>
													<input class="btn btn-success" type="submit" value="Search" form="dashboardForm">
												</td>
												<td>
													<a class="btn btn-success" href="/manager/dashboard/${id}">Show all</a>
												</td>
											</tr>
										</tbody>
									</table>
									<table class="table table-hover">
										<thead class="text-info">
											<th>Datetime</th>
											<th>Name</th>
											<th>Amount</th>
											<th>Price</th>
										</thead>
										<tbody>
											<c:forEach var="sHistoryItem" items="${sHistoryList}">
												<tr>
													<td>${sHistoryItem.datetimeOfSelling}</td>
													<td>${sHistoryItem.product.name}</td>
													<td>${sHistoryItem.amount}</td>
													<td>${sHistoryItem.factPrice}</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-lg-6 col-md-6">
							<div class="card">
								<div class="card-header card-header-warning">
									<h4 class="card-title">Shop storage list</h4>
									<p class="card-category"></p>
								</div>
								<div class="card-body table-responsive">

									<table class="table table-hover">
										<thead class="text-warning">
											<th>Name</th>
											<th>Amount</th>
											<th>Average price</th>
											<th>Fact price</th>
											<th></th>
										</thead>
										<tbody>
											<c:forEach var="storageItem" items="${shopStorageList}" varStatus="loop">
												<tr>
													<td>${storageItem.product.name}</td>
													<td>${storageItem.amount}</td>
													<td>${storageItem.avgPrice}</td>
													<c:if test="${not storageItem.onTrading}">
														<form method="POST" action="/manager/putToTrading" id="onTrading${loop.index}" name="onTrading${loop.index}"></form>
														<td>
															<input type="number" step=".01" class="form-control model" name="factPrice" placeholder="Fact price"
															 form="onTrading${loop.index}" required></td>
														<td>
															<input type="hidden" name="id" id="id" value="${id}" form="onTrading${loop.index}">
															<input type="hidden" value="${storageItem.id}" name="storageItemId" form="onTrading${loop.index}">
															<input class="btn btn-success" type="submit" value="To trading" form="onTrading${loop.index}">
														</td>
													</c:if>
													<c:if test="${storageItem.onTrading}">
														<td>${storageItem.factPrice}</td>
														<td></td>
													</c:if>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
						<div class="col-lg-6 col-md-6">
							<div class="card">
								<div class="card-header card-header-warning">
									<h4 class="card-title">Shop trading list</h4>
									<p class="card-category"></p>
								</div>
								<div class="card-body table-responsive">
									<table class="table table-hover">
										<thead class="text-warning">
											<th>Name</th>
											<th>Amount</th>
											<th>Fact price</th>
											<th></th>
										</thead>
										<tbody>
											<c:forEach var="storageItem" items="${shopStorageList}">
												<c:if test="${storageItem.onTrading}">
													<tr>
														<td>${storageItem.product.name}</td>
														<td>${storageItem.amount}</td>
														<td>${storageItem.factPrice}</td>
														<td>
															<form method="POST" action="/manager/putFromTrading">
																<input type="hidden" name="id" id="id" value="${id}">
																<input type="hidden" value="${storageItem.id}" name="storageItemId">
																<input class="btn btn-danger" type="submit" value="From trading">
															</form>
														</td>
													</tr>
												</c:if>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="card">
								<div class="card-header card-header-primary">
									<h4 class="card-title">Product adding form</h4>
								</div>
								<div class="card-body">
									<form method="POST" action="/manager/processProductForm">
										<input type="hidden" name="id" id="id" value="${id}">
										<div class="row">
											<div class="col-md-6">
												<div class="form-group bmd-form-group">
													<label class="bmd-label-static">Product</label>
													<select class="form-control" name="productId" required>
														<c:forEach var="product" items="${productList}">
															<option value="${product.id}">${product.name}</option>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group bmd-form-group">
													<label class="bmd-label-floating">Amount</label>
													<input type="text" class="form-control model" name="amount" id="amount" required>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-6">
												<div class="form-group bmd-form-group">
													<label class="bmd-label-floating">Price</label>
													<input type="number" step=".01" class="form-control color" name="price" id="price" required>
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group bmd-form-group">
													<label class="bmd-label-static">Shops</label>
													<select class="form-control" name="shopId" required>
														<c:forEach var="shop" items="${shopList}">
															<option value="${shop.id}">${shop.name}</option>
														</c:forEach>
													</select>
												</div>
											</div>
										</div>
										<input type="submit" class="btn btn-primary pull-right" value="Add product">
										<div class="clearfix"></div>
									</form>
								</div>
							</div>
						</div>

						<div class="col-md-6">
							<div class="card">
								<div class="card-header card-header-primary">
									<h4 class="card-title">Add product</h4>
								</div>
								<div class="card-body">
									<form action="/manager/addProduct" method="POST">
										<input type="hidden" name="id" id="id" value="${id}">
										<div class="row">
											<div class="col-md-6">
												<div class="form-group bmd-form-group">
													<label class="bmd-label-floating">Product name</label>
													<input type="text" class="form-control brand" name="name" id="name" required>
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group bmd-form-group">
													<label class="bmd-label-floating">Info</label>
													<input type="text" class="form-control model" name="info" id="info" required>
												</div>
											</div>
										</div>
										<input type="submit" class="btn btn-primary pull-right" value="Add product">
										<div class="clearfix"></div>
									</form>
								</div>
							</div>
						</div>


					</div>
				</div>
			</div>
			<footer class="footer">
				<div class="container-fluid">
					<nav class="float-left">
						<ul>
							<li><a href="https://www.creative-tim.com"> Creative Tim
								</a></li>
							<li><a href="https://creative-tim.com/presentation">
									About Us </a></li>
							<li><a href="http://blog.creative-tim.com"> Blog </a></li>
							<li><a href="https://www.creative-tim.com/license">
									Licenses </a></li>
						</ul>
					</nav>
					<div class="copyright float-right">
						&copy;
						<script>
							document.write(new Date().getFullYear())
						</script>
						, made with <i class="material-icons">favorite</i> by <a href="https://www.creative-tim.com" target="_blank">Creative
							Tim</a> for a better web.
					</div>
				</div>
			</footer>
		</div>
	</div>
	<!--   Core JS Files   -->
	<script src="/assets/js/core/jquery.min.js" type="text/javascript"></script>
	<script src="/assets/js/core/popper.min.js" type="text/javascript"></script>
	<script src="/assets/js/core/bootstrap-material-design.min.js" type="text/javascript"></script>
	<script src="/assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
	<!--  Google Maps Plugin    -->
	<script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
	<!-- Chartist JS -->
	<script src="/assets/js/plugins/chartist.min.js"></script>
	<!--  Notifications Plugin    -->
	<script src="/assets/js/plugins/bootstrap-notify.js"></script>
	<!-- Control Center for Material Dashboard: parallax effects, scripts for the example pages etc -->
	<script src="/assets/js/material-dashboard.min.js?v=2.1.0" type="text/javascript"></script>
	<!-- Material Dashboard DEMO methods, don't include it in your project! -->
	<script src="/assets/demo/demo.js"></script>
	<script>
		$(document).ready(function () {
			// Javascript method's body can be found in assets/js/demos.js
			md.initDashboardPageCharts();

		});
	</script>
</body>

</html>