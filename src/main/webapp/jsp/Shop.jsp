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
	<div class="wrapper">
		<!-- Navbar -->
		<div class="content">
			<div class="container-fluid">
				<div class="navbar-wrapper">
					<br>
					<p class="navbar-brand" href="#pablo">Hello from ${shop.name}</p>
				</div>
			</div>
		</div>
		<!-- End Navbar -->
		<div class="content">
			<div class="container-fluid">

				<div class="row">
					<div class="col-lg-8 col-md-8">
						<div class="card">
							<div class="card-header card-header-success">
								<h4 class="card-title">Shop trading list</h4>
								<p class="card-category"></p>
							</div>

							<div class="card-body table-responsive">

								<table class="table table-hover">
									<thead class="text-warning">
										<th>Name</th>
										<th>Available amount</th>
										<th>Price</th>
										<th>Info</th>
										<th>Amount</th>
										<th></th>
									</thead>
									<tbody>
										<c:forEach var="storageItem" items="${shopStorageList}">
											<c:if test="${storageItem.onTrading}">
												<tr>
													<td class="name">${storageItem.product.name}</td>
													<td class="amount">${storageItem.amount}</td>
													<td class="price">${storageItem.factPrice}</td>
													<td><a href="/product/${storageItem.product.id}" class="btn btn-success">Info</a></td>
													<td>
														<input type="number" class="selected-amount form-control" min="1" max="${storageItem.amount}" required>
													</td>
													<td>
														<input type="hidden" name="id" id="id" value="${id}">
														<input type="hidden" class="id" value="${storageItem.id}" name="storageItemId">
														<input class="btn btn-success addToCard" type="button" value="Add to card">
													</td>
												</tr>
											</c:if>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-4">
						<div class="card">
							<div class="card-header card-header-success">
								<h4 class="card-title">Shopping cart</h4>
								<p class="card-category"></p>
							</div>

							<div class="card-body table-responsive">

								<table class="table table-hover">
									<thead class="text-warning">
										<th>Name</th>
										<th>Amount</th>
										<th>Price</th>
										<th></th>
									</thead>
									<tbody class="tbody">
									</tbody>
								</table>
								<form action="makeOrder" method="post" name="orderForm" id="orderForm">
									<input type="hidden" name="id" id="id" value="${id}">
									<input type="submit" class="btn btn-success pull-right" value="Make order" form="orderForm">
								</form>

							</div>
						</div>
					</div>
				</div>
			</div>
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
		$(".addToCard").click(function () {
			var str = "<tr>";
			str += "<input type='hidden' name='ids' value='" + $(this).parent().parent().find(".id").val() + "' form='orderForm'>";
			str += "<td>" + $(this).parent().parent().find(".name").text() + "</td>";
			var amount = $(this).parent().parent().find(".selected-amount").val();
			if (!amount) {
				amount = 0;
			}
			str += "<input type='hidden' name='amounts' value='" + amount + "' form='orderForm'>";
			str += "<td>" + amount + "</td>";
			str += "<td>" + amount * Number($(this).parent().parent().find(".price").text()) + "</td>";
			str += "<td><input class='btn btn-danger removeFromCart' type='button' value='REMOVE'></td>";
			str += "</tr>";
			$(".tbody").append(str);
			$(".removeFromCart").unbind("click");
			$(".removeFromCart").click(function () {
				$(this).parent().parent().remove();
			});
		});
	</script>
</body>

</html>