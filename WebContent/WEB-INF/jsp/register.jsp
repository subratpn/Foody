<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <title>Register</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script></head>
<body>
<div class="container-fluid">
	<form action="./register" method="post">
		<div class="row">
			<div class="col">
				Enter Your Name
			</div>
			<div class="col">
				<input type="text" name="name">
			</div>
		</div>
		<div class="row">
			<div class="col">
				Enter Your Email
			</div>
			<div class="col">
				<input type="email" name="email">
			</div>
		</div>
		<div class="row">
			<div class="col">
				Enter Your Password
			</div>
			<div class="col">
				<input type="password" name="password">
			</div>
		</div>
		<div class="row">
			<div class="col">
				Confirm Your Password
			</div>
			<div class="col">
				<input type="password" name="conf_password">
			</div>
		</div>
		
		<input type="submit" class="btn btn-primary" value="Register" style="margin-top : 50px;,margin-left : 500px;"/>
	</form>
</div>

</body>
</html>