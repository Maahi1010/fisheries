<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- downloadSheet JS -->
<script type="text/javascript" src="js/downloadSheet.js"></script>
</head>
<body>
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="dwnldSheetLabel">Download Sheet</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<form id="dwnldSheetForm">
					<div class="row">
						<h5>Daily Report Format</h5>
						<div class="col-3">
							<label>
								<b>Society</b>
							</label>
							<br>
							<input id="societyInputDwnlModal" list="categoryList" class="form-control" name="societyId" placeholder="Select Category" class="dropdown">

							<datalist id="categoryList" class="selectpicker" data-live-search="true">
								<c:forEach var="list" items="${societylist}">
									<option id="${list.societyId}" value="${list.societyName}">${list.societyName}</option>
								</c:forEach>
							</datalist>

						</div>
						<div class="col-3">
							<label>
								<b>Date</b>
							</label>
							<input id="dateOfWorkDlwnd" class="form-control" type="date" name="dateOfWork" required>
						</div>
						<div class="col-2 single-button">
							<button type="submit" class="btn btn-warning" onclick="downloadSheet(event)">Download</button>
						</div>
					</div>
					<br>
					<hr>
					<div class="row">
						<h5>Weekly Report Format</h5>

						<div class="col-3">
							<label>
								<b>From Date</b>
							</label>
							<br>
							<input id="fromDateWeek" class="form-control" type="date" name="fromDate" required>
						</div>
						<div class="col-3">
							<label>
								<b>To Date</b>
							</label>
							<input id="toDateWeek" class="form-control" type="date" name="toDate" required>
						</div>

						<div class="col-2 single-button">
							<button type="submit" class="btn btn-warning" onclick="downloadWeeklySheetCustom(event)">Download</button>
						</div>
						<div class="col-1 vertical-separator"></div>


						<div class="col-2 single-button">
							<button type="submit" class="btn btn-warning" onclick="downloadWeeklySheet(event)">Last 7 days data</button>
						</div>

					</div>

					<br>
					<hr>

					<div class="row">
						<h5>Monthly Report Format</h5>
						<div class="col-3">
							<label>
								<b>From Date</b>
							</label>
							<br>
							<input id="fromDateMonth" class="form-control" type="date" name="fromDate" required>



						</div>
						<div class="col-3">
							<label>
								<b>To Date</b>
							</label>
							<input id="toDateMonth" class="form-control" type="date" name="toDate" required>
						</div>
						<div class="col-2 single-button">
							<button type="submit" class="btn btn-warning" onclick="downloadMonthlySheetCustom(event)">Download</button>
						</div>
						<br>
						<div class="col-1 vertical-separator"></div>


						<div class="col-2 single-button">
							<button type="submit" class="btn btn-warning" onclick="downloadMonthlySheet(event)">Monthly Report</button>
						</div>
					</div>
					<br>
				</form>
			</div>
		</div>
	</div>

</body>
</html>