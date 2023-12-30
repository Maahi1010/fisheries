<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">


<title>Fisheries</title>

<!-- Home CSS -->
<link rel="icon" type="image/x-icon" href="/images/favicon.ico">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js" integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<!-- <script src='https://kit.fontawesome.com/a076d05399.js'></script>-->
<script src='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/js/all.min.js'></script>
<script type="text/javascript" src="js/homeFisheries.js"></script>
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
				<!-- action="./home/save" -->

				<div class="container">

					<label>
						<b>Date</b>
					</label>
					<br>
					<input id="dateOfWork" class="form-control" type="date" name="dateOfWork" required>
					<br>

					<div class="btndiv">
						<label>
							<b>Society</b>
						</label>
						<br>
						<input id="societyInput" list="categoryList" class="form-control" name="societyId" placeholder="Select Category" class="dropdown">

						<datalist id="categoryList" class="selectpicker" data-live-search="true">
							<c:forEach var="list" items="${societylist}">
								<option id="${list.societyId}" value="${list.societyName}">${list.societyName}</option>
							</c:forEach>
						</datalist>
						`
					</div>

					<label>
						<b>Name</b>
					</label>
					<input id="nameInput" list="nameList" class="form-control" name="fisherManId" placeholder="Enter First Name" class="dropdown" required>
					<datalist id="nameList" class="selectpicker" data-live-search="true">
						<c:forEach var="list" items="${fisherManNamelist}">
							<option id="${list.fisherManId}" value="${list.fisherManName}">${list.fisherManName}</option>
						</c:forEach>
					</datalist>
					<br>

					<label>
						<b>Katla</b>
					</label>

					<input id="katla" class="form-control" type="number" width="50%" placeholder="Enter Katla No." name="katla" onchange="handleKRM_NumChange()">

					<input id="katlaWt" class="form-control" type="number" step="0.01" width="50%" placeholder="Enter Katla Wt." name="katlaWt" onchange="handleKRM_WtChange()">



					<br>

					<label>
						<b>Rohu</b>
					</label>
					<input id="rohu" class="form-control" type="number" placeholder="Enter Rohu No." name="rohu" onchange="handleKRM_NumChange()">
					<input id="rohuWt" class="form-control" type="number" step="0.01" placeholder="Enter Rohu Wt" name="rohuWt" onchange="handleKRM_WtChange()">
					
					<br>

					<label>
						<b>Mrigal</b>
					</label>
					<input id="mrigal" class="form-control" type="number" placeholder="Enter Mrigal No." name="mrigal" onchange="handleKRM_NumChange()">
					<input id="mrigalWt" class="form-control" type="number" step="0.01" placeholder="Enter Mrigal Wt" name="mrigalWt" onchange="handleKRM_WtChange()">

					<br>
					
					<label>
						<b>Other Major Corp</b>
					</label>
					<input id="otherMjrCorp" class="form-control" type="number" placeholder="Enter Other Major Corp No." name="otherMjrCorp" onchange="handleKRM_NumChange()">
					<input id="otherMjrCorpWt" class="form-control" type="number" step="0.01" placeholder="Enter Other Major Corp Wt" name="otherMjrCorpWt" onchange="handleKRM_WtChange()">

					<br>

					<label>
						<b>Total</b>
					</label>
					<input id="totalKRM" class="form-control" type="number" placeholder="Total No." name="totalKRM" disabled>
					<input id="totalKRMWt" class="form-control" type="number" step="0.01" placeholder="Total Wt" name="totalKRMWt" disabled>

					<br>
					
					<label>
						<b>Low Major Corp</b>
					</label>
					<br>
					<label>
						<b>Singhad</b>
					</label>
					<input id="singhad" class="form-control" type="number" placeholder="Enter Singhad No." name="singhad"  onchange="handleMinor_NumChange()">
					<input id="singhadWt" class="form-control" type="number" step="0.01" placeholder="Enter Singhad Wt" name="singhadWt"  onchange="handleMinor_WtChange()">

					<br>
					
					<label>
						<b>Pabda/Cheetal/Sambal/Kalvasu</b>
					</label>
					<input id="pabCheetSambKal" class="form-control" type="number" placeholder="Enter Pabda/Cheetal/Sambal/Kalvasu No." name="pabCheetSambKal"  onchange="handleMinor_NumChange()">
					<input id="pabCheetSambKalWt" class="form-control" type="number" step="0.01" placeholder="Enter Pabda/Cheetal/Sambal/Kalvasu Wt" name="pabCheetSambKalWt" onchange="handleMinor_WtChange()">

					<br>
					
					<label>
						<b>Big Minor</b>
					</label>
					<input id="bigMinor" class="form-control" type="number" placeholder="Enter Big Minor No." name="bigMinor"  onchange="handleMinor_NumChange()">
					<input id="bigMinorWt" class="form-control" type="number" step="0.01" placeholder="Enter Big Minor Wt" name="bigMinorWt" onchange="handleMinor_WtChange()">

					<br>
					
					<label>
						<b>Minor</b>
					</label>
					<input id="minorWt" class="form-control" type="number" step="0.01" placeholder="Enter Minor Wt" name="minorWt" onchange="handleMinor_WtChange()">
					<br>
					
					<label>
						<b>Minor Total</b>
					</label>
					<input id="totalMinor" class="form-control" type="number" placeholder="Total Minor No." name="totalMinor" disabled>
					<input id="totalMinorWt" class="form-control" type="number" step="0.01" placeholder="Total Minor Wt" name="totalMinorWt" disabled>

					<br>
					
					<label>
						<b>Grand Total</b>
					</label>
					<input id="grandTotal" class="form-control" type="number" placeholder="Grand Total" name="grandTotal" disabled>
					<input id="grandTotalWt" class="form-control" type="number" step="0.01" placeholder="Grand Total" name="grandTotalWt" disabled>

					<br>
					
					<div class="btndiv">
						<button type="button" class="btn btn-outline-danger btn-block" onClick="resetData()">Reset</button>
						<button type="Submit" class="btn btn-outline-success  btn-block" onClick="submitData()">Submit</button>
						<span class="successfully-saved">
							<i class="fa fa-thumbs-up"></i> Saved!
						</span>
					</div>
					<br>
					<div class="btndiv">
						<button id="btnAddNewFisherMan" type="button" class="btn btn-outline-info  btn-block" onClick="openAddNewFisherMan()">Add new Fisher Man</button>
					</div>
					<br>
					<div class="btndiv">
						<button id="btnDwnldXlSheet" type="button" class="btn btn-outline-primary  btn-block" onClick="openDownloadSheet()">Download Excel sheet</button>
					</div>
				</div>


			</form>


		</div>

	</div>

	<!-- Model for adding new Fisherman -->
	<div class="modal fade" id="addNewFishManModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<jsp:include page="addNewFishMan.jsp">
			<jsp:param value="${signIn}" name="addNewFishMan" />
		</jsp:include>
	</div>

	<!-- Model for downloading sheet -->
	<div class="modal fade" id="downloadSheetModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<jsp:include page="downloadSheet.jsp">
			<jsp:param value="${signIn}" name="downloadSheet" />
		</jsp:include>
	</div>
</body>
</html>
</body>
</html>