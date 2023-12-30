<!DOCTYPE html>
<!-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> -->
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Fisheries</title>

<link rel="icon" type="image/x-icon" href="/images/favicon.ico">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js" integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD" crossorigin="anonymous"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>

<script src='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/js/all.min.js'></script>

<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />

<!-- Home JS -->
<script type="text/javascript" src="js/homeFisheries.js"></script>
<!-- Home CSS -->
<link rel="stylesheet" href="homeFisheries.css">
</head>

<body>
	<div class="container-fluid mt-4 mb-4">
		<header class="sticky-top">
			<div id="head-title">
				<p class="mb-0">Fisheries</p>
				<span id="main-icon" class="material-symbols-outlined"> sailing </span>
			</div>
			<nav>
				<a onClick="openAddNewFisherMan()">Add New Fisher Men</a>
				<a onClick="openDownloadSheet()">Download Excel Sheet</a>
			</nav>
		</header>
		<form action="#" id="signInForm" method="post" class="p-4">
			<div class="mb-3">
				<label for="dateOfWork" class="form-label">Date</label>
				<input id="dateOfWork" type="date" class="form-control" aria-describedby="dateOfWorkHelp" required>
				<div id="dateOfWorkHelp" class="form-text">Please enter your date of work here</div>
			</div>
			<div class="mb-3">
				<label for="societyInput" class="form-label">Society</label>
				<input id="societyInput" list="categoryList" class="form-control" name="societyId" placeholder="Select Society Name" class="dropdown">

				<datalist id="categoryList" class="selectpicker" data-live-search="true">
					<c:forEach var="list" items="${societylist}">
						<option id="${list.societyId}" value="${list.societyName}">${list.societyName}</option>
					</c:forEach>
				</datalist>
			</div>
			<div class="mb-3">
				<label for="nameInput" class="form-label">Name</label>
				<input id="nameInput" list="nameList" class="form-control" name="fisherManId" placeholder="Select Fisherman Name" class="dropdown" required>
				<datalist id="nameList" class="selectpicker" data-live-search="true">
					<c:forEach var="list" items="${fisherManNamelist}">
						<option id="${list.fisherManId}" value="${list.fisherManName}">${list.fisherManName}</option>
					</c:forEach>
				</datalist>
			</div>
			<hr />
			<h3 class="mb-3 text-center">Major Corp</h3>
			<div class="mb-3">
				<label for="katla" class="form-label">Katla</label>
				<div class="row">
					<div class="col">
						<input id="katla" class="form-control" type="number" placeholder="Enter Number of Katla" name="katla" onchange="handleKRM_NumChange()">
					</div>
					<div class="col">
						<input id="katlaWt" class="form-control" type="number" step="0.10" placeholder="Enter Weight of Katla" name="katlaWt" onchange="handleKRM_WtChange()">
					</div>
				</div>
			</div>
			<div class="mb-3">
				<label for="rohu" class="form-label">Rohu</label>
				<div class="row">
					<div class="col">
						<input id="rohu" class="form-control" type="number" placeholder="Enter Number of Rohu" name="rohu" onchange="handleKRM_NumChange()">
					</div>
					<div class="col">
						<input id="rohuWt" class="form-control" type="number" step="0.10" placeholder="Enter Weight of Rohu" name="rohuWt" onchange="handleKRM_WtChange()">
					</div>
				</div>
			</div>
			<div class="mb-3">
				<label for="mrigal" class="form-label">Mrigal</label>
				<div class="row">
					<div class="col">
						<input id="mrigal" class="form-control" type="number" placeholder="Enter Number of Mrigal" name="mrigal" onchange="handleKRM_NumChange()">
					</div>
					<div class="col">
						<input id="mrigalWt" class="form-control" type="number" step="0.10" placeholder="Enter Weight of Mrigal" name="mrigalWt" onchange="handleKRM_WtChange()">
					</div>
				</div>
			</div>
			<div class="mb-3">
				<label for="otherMjrCorp" class="form-label">Other Major Corp</label>
				<div class="row">
					<div class="col">
						<input id="otherMjrCorp" class="form-control" type="number" placeholder="Enter Number of Other Major Corp" name="otherMjrCorp" onchange="handleKRM_NumChange()">
					</div>
					<div class="col">
						<input id="otherMjrCorpWt" class="form-control" type="number" step="0.10" placeholder="Enter Weight of Other Major Corp" name="otherMjrCorpWt" onchange="handleKRM_WtChange()">
					</div>
				</div>
			</div>
			<div class="mb-3">
				<label for="totalKRM" class="form-label fs-5 fw-bold">Total</label>
				<div class="row">
					<div class="col">
						<input id="totalKRM" class="form-control" type="number" placeholder="Total Number" name="totalKRM" disabled>
					</div>
					<div class="col">
						<input id="totalKRMWt" class="form-control" type="number" step="0.10" placeholder="Total Wt" name="totalKRMWt" disabled>
					</div>
				</div>
			</div>
			<hr>
			<h3 class="mb-3 text-center">Local Major Corp</h3>
			<div class="mb-3">
				<label for="singhad" class="form-label">Singhad</label>
				<div class="row">
					<div class="col">
						<input id="singhad" class="form-control" type="number" placeholder="Enter Number of Singhad" name="singhad" onchange="handleLocalMajor_NumChange()">
					</div>
					<div class="col">
						<input id="singhadWt" class="form-control" type="number" step="0.10" placeholder="Enter Weight of Singhad" name="singhadWt" onchange="handleLocalMajor_WtChange()">
					</div>
				</div>
			</div>
			<div class="mb-3">
				<label for="pabCheetSambKal" class="form-label">Pabda/Cheetal/Sambal</label>
				<div class="row">
					<div class="col">
						<input id="pabCheetSambKal" class="form-control" type="number" placeholder="Enter Number of Pabda/Cheetal/Sambal/Kalvasu" name="pabCheetSambKal" onchange="handleLocalMajor_NumChange()">
					</div>
					<div class="col">
						<input id="pabCheetSambKalWt" class="form-control" type="number" step="0.10" placeholder="Enter Weight of Pabda/Cheetal/Sambal/Kalvasu" name="pabCheetSambKalWt" onchange="handleLocalMajor_WtChange()">
					</div>
				</div>
			</div>

			<div class="mb-3">
				<label for="pabCheetSambKal" class="form-label">Kalvasu</label>
				<div class="row">
					<div class="col">
						<input id="kalvasu" class="form-control" type="number" placeholder="Enter Number of Kalvasu" name="kalvasu" onchange="handleLocalMajor_NumChange()">
					</div>
					<div class="col">
						<input id="kalvasuWt" class="form-control" type="number" step="0.10" placeholder="Enter Weight of Kalvasu" name="kalvasuWt" onchange="handleLocalMajor_WtChange()">
					</div>
				</div>
			</div>
			
			<div class="mb-3">
				<label for="totalLocalMaj" class="form-label fs-5 fw-bold">Total Local Major</label>
				<div class="row">
					<div class="col">
						<input id="totalLocalMaj" class="form-control" type="number" placeholder="Total Number of Local Major" name="totalLocalMaj" disabled>
					</div>
					<div class="col">
						<input id="totalLocalMajWt" class="form-control" type="number" step="0.10" placeholder="Total Weight of Local Major" name="totalLocalMajWt" disabled>
					</div>
				</div>
			</div>
			<hr>
			<h3 class="mb-3 text-center">Minor</h3>
			<div class="mb-3">
				<label for="bigMinor" class="form-label">Big Minor</label>
				<div class="row">
					<div class="col">
						<input id="bigMinor" class="form-control" type="number" placeholder="Enter Number of Big Minor" name="bigMinor" onchange="handleMinor_NumChange()">
					</div>
					<div class="col">
						<input id="bigMinorWt" class="form-control" type="number" step="0.10" placeholder="Enter Weight of Big Minor" name="bigMinorWt" onchange="handleMinor_WtChange()">
					</div>
				</div>
			</div>
			<div class="mb-3">
				<label for="minorWt" class="form-label">Minor</label>
				<input id="minorWt" class="form-control" type="number" step="0.10" placeholder="Enter Weight of Minor" name="minorWt" onchange="handleMinor_WtChange()">
			</div>
			<div class="mb-3">
				<label for="totalMinor" class="form-label fs-5 fw-bold">Minor Total</label>
				<div class="row">
					<div class="col">
						<input id="totalMinor" class="form-control" type="number" placeholder="Total Number of Minor" name="totalMinor" disabled>
					</div>
					<div class="col">
						<input id="totalMinorWt" class="form-control" type="number" step="0.10" placeholder="Total Weight of Minor" name="totalMinorWt" disabled>
					</div>
				</div>
			</div>
			<hr>
			<div class="mb-3">
				<label for="grandTotal" class="form-label fs-5 fw-bold">Grand Total</label>
				<div class="row">
					<div class="col">
						<input id="grandTotal" class="form-control" type="number" placeholder="Grand Total" name="grandTotal" disabled>
					</div>
					<div class="col">
						<input id="grandTotalWt" class="form-control" type="number" step="0.10" placeholder="Grand Total" name="grandTotalWt" disabled>
					</div>
				</div>
			</div>
		</form>
		<!-- Container Footer Starts -->
		<div class="container-footer sticky-bottom">
			<div id="form-buttons" class="btndiv">
				<button type="button" class="btn btn-danger btn-block" onClick="resetData()">Reset</button>
				<button type="Submit" class="btn btn-success  btn-block" onClick="submitData()">Submit</button>
				<span class="successfully-saved">
					<i class="fa fa-thumbs-up"></i> Saved!
				</span>
			</div>
			<!-- <div class="btndiv">
                <button id="btnAddNewFisherMan" type="button" class="btn btn-outline-info  btn-block"
                    onClick="openAddNewFisherMan()">Add new Fisher Man</button>
            </div>
            <div class="btndiv">
                <button id="btnDwnldXlSheet" type="button" class="btn btn-outline-primary  btn-block"
                    onClick="openDownloadSheet()">Download Excel sheet</button>
            </div> -->
		</div>
	</div>

	<!-- Model for adding new Fisherman -->
	<div class="modal fade" id="addNewFishManModal" tabindex="-1">
		<jsp:include page="addNewFishMan.jsp">
			<jsp:param value="${signIn}" name="addNewFishMan" />
		</jsp:include>
	</div>

	<!-- Model for downloading sheet -->
	<div class="modal fade" id="downloadSheetModal" tabindex="-1">
		<jsp:include page="downloadSheet.jsp">
			<jsp:param value="${signIn}" name="downloadSheet" />
		</jsp:include>
	</div>
</body>

</html>