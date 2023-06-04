function getNameList() {
var idElement = document.getElementById("category");
var selectedValue=idElement.id;
var conceptName = $('#category').find(":selected").val();

/*
var selectedValue = idElement.options[idElement.selectedIndex].value;*/
 window.location.href = "home/nameByCategory";
};
