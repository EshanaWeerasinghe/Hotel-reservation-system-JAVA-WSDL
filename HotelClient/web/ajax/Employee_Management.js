var xmlHttp;
function createXMLHttpRequest() {
    if (window.ActiveXObject) {
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    } else if (window.XMLHttpRequest) {
        xmlHttp = new XMLHttpRequest();
    }
}

function loadTable() {
    try {
        var action = "List";
        createXMLHttpRequest();
        xmlHttp.onreadystatechange = setTable;
        xmlHttp.open("POST", "Employee_Management", true);
        xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xmlHttp.send("action=" + action);
    } catch (e) {
        alert("Alert in loadTable " + e);
    }
}

function setTable() {
    if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
        try {
            var jsonText = xmlHttp.responseText;
            //alert("jsontext = "+jsonText);
            var myArr = JSON.parse(jsonText);
            setToTable(myArr);
        } catch (e) {
            alert("Error in setTable " + e);
        }
    }
}

function setToTable(arr) {
    try {
        var arrList;
        var dataSet = new Array();
        for (var i = 0; i < arr.length; i++) {
            arrList = new Array();
            arrList.push(arr[i].id);
            arrList.push(arr[i].name);
            arrList.push(arr[i].emp_category);
            arrList.push(arr[i].hotel);
            arrList.push(arr[i].mobile);
            dataSet.push(arrList);
        }
        document.getElementById("divTable").innerHTML = '<table id="DataTable"></table>';
        $('#DataTable').DataTable({
            data: dataSet,
            columns: [
                {title: "id"},
                {title: "Name"},
                {title: "Emp Category"},
                {title: "Hotel"},
                {title: "Mobile"}
            ]
        });
    } catch (e) {
        alert("Error in setToTable " + e);
    }
}

function AddEmployee() {
    try {
        var action = "save";
        var fname = document.getElementById("fname").value;
        var lname = document.getElementById("lname").value;
        var addressl1 = document.getElementById("addressl1").value;
        var addressl2 = document.getElementById("addressl2").value;
        var addresscity = document.getElementById("addresscity").value;
        var addresspc = document.getElementById("addresspc").value;
        var mobile = document.getElementById("mobile").value;
        var nic = document.getElementById("nic").value;
        var emp_category_id = document.getElementById("empCategory").value;
        var hotel_id = document.getElementById("hotel").value;
        var username = document.getElementById("userName").value;
        var password = document.getElementById("passWord").value;
        createXMLHttpRequest();
        xmlHttp.onreadystatechange = confirmSave;
        xmlHttp.open("POST", "Employee_Management", true);
        xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xmlHttp.send("action=" + action + "&fname=" + fname + "&lname=" + lname + "&addressl1=" + addressl1 + "&addressl2=" + addressl2 + "&addresscity=" + addresscity + "&addresspc=" + addresspc + "&mobile=" + mobile + "&nic=" + nic + "&emp_category_id=" + emp_category_id + "&hotel_id=" + hotel_id + "&username=" + username + "&password=" + password);
        $("#AddEmployee").slideUp('slow');
    } catch (e) {
        alert("Error in AddEmployee " + e);
    }
}

function confirmSave(){
    if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
        try {
            var result = xmlHttp.responseXML.getElementsByTagName("result")[0].firstChild.data;
            //alert(result);
            if(result == '1'){
                $("#successAlert").slideDown('slow').delay(2500).slideUp('slow');
                $("#form1")[0].reset();
                loadTable();
            }
        }
        catch (e){
            alert("Error in confirmSave "+e);
        }
    }
}