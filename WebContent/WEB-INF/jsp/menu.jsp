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
		
		
		<style>
			body{
				font-family: 'Nunito', sans-serif;
			}
			
			#navigationbar{
				margin-top : 40px;
				margin-bottom : 40px;
			}
			
			
			#content{
			
				margin-top : 70px;
				margin-bottom : 70px;	
			}
			
			.footer {
				position: fixed;
				left: 0;
				bottom: 0;
				width: 100%;
				background-color: black;
				color: white;
  				text-align: center;
  				height : 120px;
			}
			
			#footer-data{
				margin-top : 30px;
			}
			
			#cart_logo,#cart_value{
				padding-right : 5px;
			}
			
			nav{
				margin-top : 20px;
				margin-bottom : 20px;
			}
			
			.navbar-brand{
				color : #039BE5;
			}
			
		</style>
</head>
<body>
		
		<div class="container-fluid">
			<div class="container-fluid" id="navigationbar">
				<div class="card">
					<nav class="navbar navbar-expand-sm">
						  <a class="navbar-brand" href="">
						  	<h3><b>${hotel}</b></h3>
						  </a>
						  <ul class="navbar-nav ml-auto">
							<li class="nav-item">
							  <a class="nav-link text-danger" href="./login">Login</a>
							</li>
							<li class="nav-item">
							  <a class="nav-link text-danger" href="./register">Register</a>
							</li>
							<li class="nav-item" id="cart_logo">
								<a href="" id="cart"><img alt="cart" src="https://i.ibb.co/wQdbbhw/cart.png"></a>		
							</li>
							<li class="nav-item" id="cart_value">
								<h6></h6>							
							</li>
						  </ul>
					</nav>
				</div>
			</div>
			<div class="container-fluid" id="content">
				<div class="row">
				
					<c:forEach  var="food" items="${menulist}">
						<div class="col">
							<div class="card menu" style="width:200px">
								<img class="card-img-top" src="${food.image}" alt="Menu" style="width:100%; height:150px;">
									<div class="card-body">
										<center>
											<h5 class="card-title">${food.name}</h5>
											<p class="card-text">Rs. ${food.price}</p>
										<center>
										<button class="btn btn-block btn-primary add" id="${food.id}">Add</button>
									</div>
							</div>
						</div>
					</c:forEach>
					
					
				</div>
			</div>
			
			<div class="container-fluid footer">
				<div class="container-fluid" id="footer-data">
					<h5>Powered By @Uber Technologies</h5>
				</div>
			</div>
			
		</div>

		<script>
			
			var menuID=new Array();
			
			$(".add").click(function(){
				
				var cart_val = $("#cart_value").text().trim();
				console.log("ID : "+this.id);
				menuID.push(this.id);
				
				if(cart_val.length === 0){
					console.log("1st Flow");
					cart_val = 1;
				}else{
					console.log("2nd Flow");
					cart_val = parseInt(cart_val) + 1;
				}
				console.log("New Value "+cart_val);
				$("#cart_value").text(cart_val);
				
			});
			
			
			$("#cart").click(function(){
				
				var cartHref="./cart?";
				console.log("clicked cart");
				for(i = 0 ; i < menuID.length ; i++){
					cartHref += "menuID="+menuID[i]+"&";
				}
				cartHref = cartHref.slice(0,-1);
				$("#cart").attr("href",cartHref);
				
			});
				
		</script>
	

</body>
</html>