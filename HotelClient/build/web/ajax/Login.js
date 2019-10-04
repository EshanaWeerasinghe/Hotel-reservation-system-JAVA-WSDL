var xmlHttp;
function createXMLHttpRequest() {
    if (window.ActiveXObject) {
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    } else if (window.XMLHttpRequest) {
        xmlHttp = new XMLHttpRequest();
    }
}

function getLogin() {
    try {
        var userName = document.getElementById("uemail").value;
        var password = document.getElementById("upw").value;
        createXMLHttpRequest();
        xmlHttp.onreadystatechange = setLogin;
        xmlHttp.open("POST", "Login", true);
        xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        alert("userName=" + userName + "&password=" + password);
        xmlHttp.send("userName=" + userName + "&password=" + password);
    } catch (e) {
        alert("Error in getAccounts " + e);
    }
}

function setLogin() {
    if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
        try {
            var result = xmlHttp.responseXML.getElementsByTagName("login")[0].firstChild.data;
            alert(result);
            if(result == '0'){
                
            }
        } catch (e) {
            alert("Error in setLogin " + e);
        }
    }
}