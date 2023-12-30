/*function getNameList() {
	var idElement = document.getElementById("category");
	var selectedValue = idElement.id;
	var conceptName = $('#category').find(":selected").val();

	/*var selectedValue = idElement.options[idElement.selectedIndex].value;
	window.location.href = "home/nameByCategory";
}

function submitData() {
	var societyId = document.getElementById("categoryList").value;
	var fisherManId = document.getElementById("fisherNameList").value;

	var element = {}, cart = [];
	element.societyId = societyId;
	element.fisherManId = fisherManId;
	cart.push(element);
}
*/

document.addEventListener("DOMContentLoaded", function() {
	const societyInput = document.getElementById("societyInput");
	const categoryList = document.getElementById("categoryList");


	societyInput.addEventListener("change", function() {
		const selectedValue = societyInput.value;

		if (selectedValue != null) {
			let selectedId = document.querySelector(`#categoryList option[value="${selectedValue}"]`).id;

			// Call your function here to handle the change
			handleSocietyChange(selectedId);
		}


	});

	function handleSocietyChange(value) {
		fetch("/home/postman?Id=" + value)  // 
			.then(response => response.json())
			.then(data => {
				// Process the retrieved data
				console.log("Society details:", data);

				let nameList = document.querySelector("#nameList");
				nameList.replaceChildren();

				let nameInput = document.querySelector("#nameInput");
				nameInput.value = "";

				for (let i = 0; i < data.length; i++) {
					let option = document.createElement("option");
					var fatherName = 'NA';
					if(data[i].fisherManFatherName!=null){
					fatherName	=data[i].fisherManFatherName;
					}
					option.value = data[i].fisherManName+" ("+fatherName+")";
					option.id = data[i].fisherManId;
					nameList.appendChild(option);
				}
			})
			.catch(error => {
				console.error("Error fetching society details:", error);
			});


	}



});

function submitData() {
	const selectedSocietyId = document.getElementById("societyInput").value;
	let societyId = document.querySelector(`#categoryList option[value="${selectedSocietyId}"]`).id;
	console.log(`societyId: ${societyId}`);

	const selectednameId = document.getElementById("nameInput").value;
	let fisherManId = document.querySelector(`#nameList option[value="${selectednameId}"]`).id;
	console.log("fisherManId : " + fisherManId);
	
	

	const jsonData = {
		dateOfWork: document.getElementById("dateOfWork").value,
		fisherManId: fisherManId,
		societyId: societyId,
		societyName: selectedSocietyId,
		fisherManName: document.getElementById("nameInput").value,

		//Major
		katla: document.getElementById("katla").value,
		rohu: document.getElementById("rohu").value,
		mrigal: document.getElementById("mrigal").value,
		totalKRM: document.getElementById("totalKRM").value,
		katlaWt: document.getElementById("katlaWt").value,
		rohuWt: document.getElementById("rohuWt").value,
		mrigalWt: document.getElementById("mrigalWt").value,

		otherMjrCorp: document.getElementById("otherMjrCorp").value,

		otherMjrCorpWt: document.getElementById("otherMjrCorpWt").value,

		totalKRMWt: document.getElementById("totalKRMWt").value,

		//Local Major 
		singhad: document.getElementById("singhad").value,

		singhadWt: document.getElementById("singhadWt").value,

		pabCheetSambKal: document.getElementById("pabCheetSambKal").value,

		pabCheetSambKalWt: document.getElementById("pabCheetSambKalWt").value,

		kalvasu: document.getElementById("kalvasu").value,

		kalvasuWt: document.getElementById("kalvasuWt").value,

		totalLocalMaj: document.getElementById("totalLocalMaj").value,

		totalLocalMajWt: document.getElementById("totalLocalMajWt").value,


		//Minor

		bigMinor: document.getElementById("bigMinor").value,

		bigMinorWt: document.getElementById("bigMinorWt").value,

		minorWt: document.getElementById("minorWt").value,

		totalMinor: document.getElementById("totalMinor").value,

		totalMinorWt: document.getElementById("totalMinorWt").value,
		// Grand Total
		grandTotal: document.getElementById("grandTotal").value,

		grandTotalWt: document.getElementById("grandTotalWt").value,

	};

	//formData.append("dateOfWork", dateOfWork);

	console.log(jsonData);


	// Send a POST request to the JSP page
	fetch("/home/save", {
		method: "POST",
		headers: {
			"Content-Type": "application/json", // Set the content type to JSON
		},
		body: JSON.stringify(jsonData),
	})

		.then(response => response.json())
		.then(data => {

			// Process the retrieved data
			console.log("Details have been saved:", data);
			$(".successfully-saved").css("display", "block").delay(100000).fadeOut(400);
			resetData();
		})
		.catch(error => {
			console.error("Error while saving details:", error);
		});

}


function openDownloadSheet() {
	jQuery('#downloadSheetModal').modal('show');
}

function downloadSheet(e) {
	e.preventDefault();
	let downloadModal = document.getElementById("downloadSheetModal");
	const selectedSocietyName = document.getElementById("societyInputDwnlModal").value;
	//societyId = document.querySelector(`#categoryList option[value="${selectedSocietyName}"]`).id;

	//let sanitizedSocietyName = encodeURIComponent(selectedSocietyName);
	//let societyId = document.querySelector(`#categoryList option[value="${sanitizedSocietyName}"]`).id;
	let societyId = document.querySelector(`#categoryList option[value="${selectedSocietyName}"]`).id;

	console.log("selectedSocietyName:", selectedSocietyName);

	console.log("societyId : " + societyId);

	const jsonData = {
		dateOfWork: document.getElementById("dateOfWorkDlwnd").value,
		societyId: societyId,
		societyName: selectedSocietyName

	};

	// Send a GET request to the JSP page
	fetch("/home/download", {
		method: "POST",
		headers: {
			"Content-Type": "application/json",// Set the content type to JSON
			"Authorization": "Bearer 6Qerer"
		},
		body: JSON.stringify(jsonData),
	})

		.then(response => response.blob())
		.then(blob => {
			// Process the retrieved data
			console.log("Details have been downloaded:");

			downloadExcelFile(blob);

			//var file = window.URL.createObjectURL(blob);
			//window.location.assign(file);
			jQuery("#downloadSheetModal").modal("hide");
			//location.reload();
		})
		.catch(error => {
			console.error("Error while downloaded details:", error);
		});
}

function downloadExcelFile(blob) {
	let d = new Date();
	let fileName = document.getElementById("societyInputDwnlModal").value + "_" + d.getDate() + "-" + d.getMonth() + "-" + d.getFullYear() + ".xlsx";

	let a = document.createElement("a");
	a.href = window.URL.createObjectURL(blob);
	a.setAttribute("download", fileName);
	a.click()
}
function openAddNewFisherMan() {
	jQuery('#addNewFishManModal').modal('show');
}

function addNewFisherMan() {
	const selectedSocietyId = document.getElementById("societyInputModal").value;
	let societyId = document.querySelector(`#categoryList option[value="${selectedSocietyId}"]`).id;
	console.log("societyId : " + societyId);

	const jsonData = {
		societyId: societyId,
		fisherManName: document.getElementById("fisherManName").value,
		fisherManFatherName: document.getElementById("fisherManFatherName").value,

	};

	// Send a POST request to the JSP page
	fetch("/home/addNewFisherMan", {
		method: "POST",
		headers: {
			"Content-Type": "application/json", // Set the content type to JSON
		},
		body: JSON.stringify(jsonData),
	})

		.then(response => response.json())
		.then(data => {
			// Process the retrieved data
			console.log("Details have been saved:", data);
			location.reload();
		})
		.catch(error => {
			console.error("Error while saving details:", error);
		});

}

function handleKRM_NumChange() {
	var katlaValue = parseInt(document.getElementById("katla").value) || 0;
	var rohuValue = parseInt(document.getElementById("rohu").value) || 0;
	var mrigalValue = parseInt(document.getElementById("mrigal").value) || 0;
	var otherMjrCorpValue = parseInt(document.getElementById("otherMjrCorp").value) || 0;

	var totalKRMValue = katlaValue + rohuValue + mrigalValue + otherMjrCorpValue;
	console.log("katlaElement:", katlaValue);
	console.log("rohuElement:", rohuValue);
	console.log("mrigalElement:", mrigalValue);
	console.log("otherMjrCorpValue:", otherMjrCorpValue);

	console.log("totalKRMElement:", totalKRMValue);
	document.getElementById("totalKRM").value = totalKRMValue;

	changeTotalNum();

}

function handleKRM_WtChange() {
	var katlaValue = parseFloat(document.getElementById("katlaWt").value) || 0;
	var rohuValue = parseFloat(document.getElementById("rohuWt").value) || 0;
	var mrigalValue = parseFloat(document.getElementById("mrigalWt").value) || 0;
	var otherMjrCorpValue = parseFloat(document.getElementById("otherMjrCorpWt").value) || 0;

	var totalKRMValue = katlaValue + rohuValue + mrigalValue + otherMjrCorpValue;
	console.log("katlaElement:", katlaValue);
	console.log("rohuElement:", rohuValue);
	console.log("mrigalElement:", mrigalValue);
	console.log("totalKRMElement:", totalKRMValue);
	console.log("otherMjrCorpValue:", otherMjrCorpValue);
	document.getElementById("totalKRMWt").value = totalKRMValue;

	changeTotalWt();

}

function handleLocalMajor_NumChange() {
	var singhadValue = parseInt(document.getElementById("singhad").value) || 0;
	var pabCheetSambKalValue = parseInt(document.getElementById("pabCheetSambKal").value) || 0;
	var kalvasuValue = parseFloat(document.getElementById("kalvasu").value) || 0;

	var totalLocalMaj = singhadValue + pabCheetSambKalValue + kalvasuValue;
	console.log("singhadValue:", singhadValue);
	console.log("pabCheetSambKalValue:", pabCheetSambKalValue);
	console.log("kalvasuValue:", kalvasuValue);
	console.log("totalLocalMaj:", totalLocalMaj);

	document.getElementById("totalLocalMaj").value = totalLocalMaj;
	changeTotalNum();


}

function handleLocalMajor_WtChange() {
	var singhadValue = parseFloat(document.getElementById("singhadWt").value) || 0;
	var pabCheetSambKalValue = parseFloat(document.getElementById("pabCheetSambKalWt").value) || 0;
	var kalvasuValue = parseFloat(document.getElementById("kalvasuWt").value) || 0;

	var totalLocalMaj = singhadValue + pabCheetSambKalValue + kalvasuValue;
	console.log("singhadValue:", singhadValue);
	console.log("pabCheetSambKalValue:", pabCheetSambKalValue);
	console.log("kalvasuValue:", kalvasuValue);
	console.log("totalLocalMajorValue:", totalLocalMaj);

	document.getElementById("totalLocalMajWt").value = totalLocalMaj;
	changeTotalWt();
}

function handleMinor_NumChange() {

	var bigMinorValue = parseInt(document.getElementById("bigMinor").value) || 0;
	console.log("bigMinorValue:", bigMinorValue);

	document.getElementById("totalMinor").value = bigMinorValue;
	changeTotalNum();

}

function handleMinor_WtChange() {

	var bigMinorValue = parseFloat(document.getElementById("bigMinorWt").value) || 0;
	var minorWtValue = parseFloat(document.getElementById("minorWt").value) || 0;

	var totalMinor = bigMinorValue + minorWtValue;

	console.log("bigMinorValue:", bigMinorValue);
	console.log("minorWtValue:", minorWtValue);
	console.log("totalMinor:", totalMinor);

	document.getElementById("totalMinorWt").value = totalMinor;
	changeTotalWt();


}

function changeTotalNum() {
	var totalKRM = parseInt(document.getElementById("totalKRM").value) || 0;
	var totalMinor = parseInt(document.getElementById("totalMinor").value) || 0;
	var totalLocalMaj = parseInt(document.getElementById("totalLocalMaj").value) || 0;

	document.getElementById("grandTotal").value = totalMinor + totalKRM + totalLocalMaj;

}

function changeTotalWt() {
	var totalKRMWt = parseFloat(document.getElementById("totalKRMWt").value) || 0;
	var totalMinorWt = parseFloat(document.getElementById("totalMinorWt").value) || 0;
	var totalLocalMaj = parseFloat(document.getElementById("totalLocalMajWt").value) || 0;

	document.getElementById("grandTotalWt").value = totalMinorWt + totalKRMWt + totalLocalMaj;

}

function resetData() {
	// IDs of the fields to preserve
	const selectedSocietyId = document.getElementById("societyInput").value;
	/*let societyId = document.querySelector(`#categoryList option[value="${selectedSocietyId}"]`).id;
	*/

	var dateOfWork = document.getElementById("dateOfWork").value;
	console.log(`societyName: ${selectedSocietyId}`);
	console.log(`Date: ${dateOfWork}`);

	document.getElementById('signInForm').reset();


	document.getElementById("dateOfWork").value = dateOfWork;
	document.getElementById("societyInput").value = selectedSocietyId;
}




