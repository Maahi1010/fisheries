<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Fisherman</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="/js/homeFisheries.js"></script>

</head>
<body>

<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="addNewLabel">Add New Fisher Man</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<form id="addNewFishManForm">
				
					<div>
						<label>
							<b>Society</b>
						</label>
						<br>
						<input id="societyInputModal" list="categoryList" class="form-control" name="societyId" placeholder="Select Category" class="dropdown">

						<datalist id="categoryList" class="selectpicker" data-live-search="true">
							<c:forEach var="list" items="${societylist}">
								<option id="${list.societyId}" value="${list.societyName}">${list.societyName}</option>
							</c:forEach>
						</datalist>
						`
					</div>
					
					<div class="mb-3">
						<label>
						<b>Name</b>
						</label> 
						<input type="text" class="form-control" id="fisherManName" name="fisherManName" placeholder="Enter Name" >
					</div>
					
					<div class="mb-3">
						<label>
						<b>Name</b>
						</label> 
						<input type="text" class="form-control" id="fisherManFatherName" name="fisherManFatherName" placeholder="Enter Father's Name" >
					</div>
					
					<div align="center">
						<button type="button" class="btn btn-dark" data-bs-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-danger" onclick="addNewFisherMan()">Add</button>
					</div>

				</form>
			</div>
		</div>
	</div>
</body>
</html>