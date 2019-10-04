var xmlHttp;
function createXMLHttpRequest() {
    if (window.ActiveXObject) {
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    } else if (window.XMLHttpRequest) {
        xmlHttp = new XMLHttpRequest();
    }
}

function getDetails() {
    try {
        var fname = document.getElementById("fname").value;
        var lname = document.getElementById("lname").value;
        var mobile = document.getElementById("mobile").value;
        var email = document.getElementById("email").value;
        var uname = document.getElementById("uname").value;
        var pwd = document.getElementById("pwd").value;
        createXMLHttpRequest();
        xmlHttp.onreadystatechange = confirmSave;
        xmlHttp.open("POST", "CustomerRegistration", true);
        xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xmlHttp.send("fname=" + fname + "&lname=" + lname + "&mobile=" + mobile + "&email=" + email + "&uname=" + uname + "&pwd=" + pwd);
    } catch (e) {
        alert("Error in getDetails " + e);
    }
}

function confirmSave() {
    if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
        try {
            var result = xmlHttp.responseXML.getElementsByTagName("result")[0].firstChild.data;
            if(result == '1'){
                $("#successAlert").slideDown('slow');
            }
            else{
                
            }
        } catch (e) {
            alert("Error in confirmSave " + e);
        }
    }
}