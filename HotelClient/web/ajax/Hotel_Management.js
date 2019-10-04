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
        xmlHttp.open("POST", "Hotel_Management", true);
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
            //alert(jsonText);
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
            arrList.push(arr[i].location);
            arrList.push(arr[i].no_of_single_rooms);
            arrList.push(arr[i].no_of_double_rooms);
            arrList.push(arr[i].no_of_family_rooms);
            dataSet.push(arrList);
        }
        document.getElementById("divTable").innerHTML = '<table id="DataTable"></table>';
        $('#DataTable').DataTable({
            data: dataSet,
            columns: [
                {title: "id"},
                {title: "Name"},
                {title: "Location"},
                {title: "Single Rooms"},
                {title: "Double Rooms"},
                {title: "family Rooms"}
            ]
        });
    } catch (e) {
        alert("Error in setToTable " + e);
    }
}

function SaveHotel() {
    try {
        var action = "save";
        var name = document.getElementById("hotelName").value;
        var location = document.getElementById("hotelLocation").value;
        var srooms = document.getElementById("SRooms").value;
        var drooms = document.getElementById("DRooms").value;
        var frooms = document.getElementById("FRooms").value;
        createXMLHttpRequest();
        xmlHttp.onreadystatechange = confirmSave;
        xmlHttp.open("POST", "Hotel_Management", true);
        xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xmlHttp.send("action=" + action + "&name=" + name + "&location=" + location + "&srooms=" + srooms + "&drooms=" + drooms + "&frooms=" + frooms);
        $("#AddHotel").slideUp('slow');
    } catch (e) {
        alert("Error in SaveHotel " + e);
    }
}

function confirmSave() {
    if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
        try {
            var result = xmlHttp.responseXML.getElementsByTagName("result")[0].firstChild.data;
            //alert(result);
            if(result == '1'){
                $("#form1")[0].reset();
                $("#successAlert").slideDown('slow').delay(2500).slideUp('slow');
                loadTable();
            }
            else{
                alert("Error in Save Hotel");
            }
        }
        catch (e){
            alert("Error in confirmSave "+e);
        }
    }
}