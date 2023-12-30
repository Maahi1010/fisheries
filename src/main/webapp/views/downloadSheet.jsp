<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="dwnldSheetLabel">Download Sheet</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<form id="dwnldSheetForm">
				
					<div>
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
						`
					</div>
					
					<div class="mb-3">
						<label>
						<b>Date</b>
						</label> 
					<input id="dateOfWorkDlwnd" class="form-control" type="date" name="dateOfWork" required>
					</div>
					
					<div align="center">
						<button type="button" class="btn btn-dark" data-bs-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-warning" onclick="downloadSheet(event)">Download</button>
					</div>

				</form>
			</div>
		</div>
	</div>

</body>
</html>