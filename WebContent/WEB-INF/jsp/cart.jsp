<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
		<link href="https://fonts.googleapis.com/css?family=Nunito" rel="stylesheet">
		
</head>
<body>

		<c:if test="${isCartEmpty}">
			
			<center>
				<div class="container-fluid">
					
					<img src="https://i.ibb.co/tMzyM3v/empty-cart.png" style="width:40%;"/>
				</div>
			</center>
		
		</c:if>
		
		
		<c:if test="${not isCartEmpty}">
				
			<div class="container-fluid">
			
			<div class="jumbotron">
				<center><h1>CART</h1></center>
			</div>
			<table class="table table-bordered" style="text-align: center;">
			    <thead>
			      <tr>
			        <th>Item Name</th>
			        <th>Quantity</th>
			        <th>Price/Unit</th>
			        <th>Total Price</th>
			      </tr>
			    </thead>
			    <tbody>
			      <c:forEach var="item" items="${menuData}">
			      	<tr>
				        <td>${item.menu.name}</td>
				        <td>${item.quantity}</td>
				        <td>${item.menu.price}</td>
				        <td>Rs. ${item.menu.price * item.quantity}</td>
			      	</tr>
			      </c:forEach>
			      	<tr>
				        <td colspan="3">Total Payable Amount : </td>
				        <td>Rs. ${totalValue}</td>
			      	</tr>
			    </tbody>
			</table>
			<div class="container-fluid">
				<center><button id="checkout" style="width:50%" class="btn btn-block btn-danger">Proceed To Checkout</button></center>
			</div>
		</div>
		</c:if>

		
		
		
		<script>
		
			$("#checkout").click(
				function(){
					
					window.alert("Successfully Ordered");
					window.location ="./";
					
				}		
			);
		</script>

</body>
</html>