var xmlHttp;
function createXMLHttpRequest() {
    if (window.ActiveXObject) {
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    } else if (window.XMLHttpRequest) {
        xmlHttp = new XMLHttpRequest();
    }
}

function whenBodyOnLoad() {
    var date = new Date();
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    if (month < 10) {
        month = '0' + month;
    }
    var day = date.getDate();
    if (day < 10) {
        day = '0' + day;
    }
    var today = year + '-' + month + '-' + day;
    //alert(today);
    document.getElementById("fdate").min = today;
}

function setDate() {
    var fdate = document.getElementById("fdate").value;
    if (fdate == "" || fdate == null) {

    } else {
        document.getElementById("tdate").min = fdate;
    }
}

function getAvailableRooms() {
    try {
        var action = "getAvailable";
        var hotel_id = document.getElementById("hotel_id").value;
        var room_type_id = document.getElementById("roomsCategory").value;
        if (room_type_id == "") {

        } else {
            createXMLHttpRequest();
            xmlHttp.onreadystatechange = setAvailableRooms;
            xmlHttp.open("POST", "BookRooms", true);
            xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xmlHttp.send("action=" + action + "&hotel_id=" + hotel_id + "&room_type_id=" + room_type_id);
        }
    } catch (e) {
        alert("Error in getAvailableRooms " + e);
    }
}

function setAvailableRooms() {
    if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
        try {
            var result = xmlHttp.responseXML.getElementsByTagName("result")[0].firstChild.data;
            var t = parseInt(result);
            var slt = document.getElementById("NoRooms");
            slt.innerHTML = null;
            for (var i = 0; i < t; i++) {
                var text = document.createTextNode(i + 1);
                var opt = document.createElement("option");
                opt.setAttribute('value', i + 1);
                opt.appendChild(text);
                slt.appendChild(opt);
            }
        } catch (e) {
            alert("Error in setAvailableRooms " + e);
        }
    }
}

function getDate() {
    try {
        var action = "save";
        var hotel_id = document.getElementById("hotel_id").value;
        var customer_id = document.getElementById("customer_id").value;
        var room_category_id = document.getElementById("roomsCategory").value;
        var no_of_rooms = document.getElementById("NoRooms").value;
        var from_date = document.getElementById("fdate").value;
        var to_date = document.getElementById("tdate").value;
        createXMLHttpRequest();
        xmlHttp.onreadystatechange = confirmSave;
        xmlHttp.open("POST", "BookRooms", true);
        xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xmlHttp.send("action=" + action + "&hotel_id=" + hotel_id + "&customer_id=" + customer_id + "&room_category_id=" + room_category_id + "&no_of_rooms=" + no_of_rooms + "&from_date=" + from_date + "&to_date=" + to_date);
    } catch (e) {
        alert("Error in getDate " + e);
    }
}

function confirmSave(){
    if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
        try {
            var result = xmlHttp.responseXML.getElementsByTagName("result")[0].firstChild.data;
            if(result == '1'){
                $("#successAlert").slideDown('slow').delay(2500).slideUp('slow')
                $("#form1")[0].reset();
            }
            else{
                alert("Error in Save");
            }
        }
        catch (e){
            alert("Error in confirmSave "+e);
        }
    }
}