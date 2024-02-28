<!DOCTYPE html>
<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 --%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image/x-icon" href="/images/favicon.ico">

<title>Login</title>


<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css" />
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />


<!-- login CSS -->
<link rel="stylesheet" href="login1.css" type="text/css" />


<base href="/">
</head>
<body>
	<div class="container">
		<h1>Login</h1>
		<form action="#" id="signInForm" method="post" class="p-4">
			<div class="mb-3">
				<label for="username" class="form-label">Username</label>
				<input id="username" type="text" class="form-control" required>
			</div>
			<div class="mb-3">
				<label for="password" class="form-label">Password</label>
				<input id="password" type="password" class="form-control" required>
			</div>
			<div id="form-buttons" class="btndiv">
				<button type="submit" class="btn btn-success btn-block" onclick="login()">Submit</button>
			</div>
		</form>
	</div>
</body>
</html>