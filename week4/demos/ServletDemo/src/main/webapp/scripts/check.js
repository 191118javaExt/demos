/**
 * 
 */

function sendAjaxGet(url, func) {
	var xhr = new XMLHttpRequest()
			|| new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			func(this);
		}
	};
	xhr.open("GET", url, true);
	xhr.send();
};

function populateUser(xhr) {
	if (xhr.responseText) {
		var res = JSON.parse(xhr.responseText);
		console.log(res);
		if (res.username) {
			document.getElementById("user").innerText = "you are logged in as "
					+ res.username;
		}
	} else {
		window.location = "http://localhost:8084/ServletDemo/login";
	}
};

window.onload = function() {
	sendAjaxGet("http://localhost:8084/ServletDemo/session", populateUser);
}
