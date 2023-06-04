<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">


<title>Fisheries</title>

<!-- Home CSS -->

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js" integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD" crossorigin="anonymous"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>



<link rel="stylesheet" href="homeFisheries.css">



<!-- Home JS -->
<script src="/js/homeFisheries.js"></script>
</head>
<body>


	<div class="modal-content">
		<div id="signInLabel" class="heading mt-2 p-2">
			<h4>Fisheries</h4>
		</div>
		<div class="modal-body">
			<form id="signInForm" method="post">

				<div class="container">

					<label>
						<b>Date</b>
					</label>
					<br>
					<input id="date" class="form-control" type="date" name="date" required>
					<br>

					<div class="btndiv">
						<label>
							<b>Society</b>
						</label>
						<br>
						<input list="category" placeholder="Select Category" class="dropdown">

						<datalist id="category" name="category" class="selectpicker" data-live-search="true">
							<c:forEach var="list" items="${societylist}">
								<option id="${list.societyId}" value="${list.societyName}">${list.societyName}</option>
							</c:forEach>
						</datalist>
						
						<button type="button" class="btn btn-outline-success  btn-block" onClick="getNameList(category)">Save</button>
					</div>

					<br>

					<label>
						<b>Name</b>
					</label>
					<input list="nameList" class="form-control" placeholder="Enter First Name" class="dropdown" required>
						<datalist id="nameList" name="category" class="selectpicker" data-live-search="true">
							<c:forEach var="list" items="${fisherManNamelist}">
								<option id="${list.fisherManId}" value="${list.fisherManName}">${list.fisherManName}</option>
							</c:forEach>
						</datalist>
					<br>

					<label>
						<b>Katla</b>
					</label>
					<input id="katla" class="form-control" type="number" placeholder="Enter Katla No." name="katla">
					<br>

					<label>
						<b>Rohu</b>
					</label>
					<input id="rohu" class="form-control" type="number" placeholder="Enter Rohu No." name="rohu">
					<br>

					<label>
						<b>Mrigal</b>
					</label>
					<input id="mrigal" class="form-control" type="number" placeholder="Enter Mrigal No." name="mrigal">
					<br>

					<div class="btndiv">
						<button type="button" class="btn btn-outline-danger btn-block" >Reset</button>
						<button type="button" class="btn btn-outline-success  btn-block">Submit</button>
					</div>

				</div>


			</form>
		</div>

	</div>

</body>
</html>
</body>
</html>