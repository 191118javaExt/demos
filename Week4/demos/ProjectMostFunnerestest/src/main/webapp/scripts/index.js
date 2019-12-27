function sendLogin() {
	console.log("sendLogin started.");
	let loginForm = document.loginForm;
	let username = loginForm.username.value;
	let password = loginForm.password.value;

	let loginTemplate = {
			username: username,
			password: password,
	};

	let xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if(this.readyState === 4 && this.status === 200) {
			sessionStorage.setItem('currentUser', this.responseText);
			window.location = "http://localhost:8080/ProjectMostFunnerestest/user/home.html";
		}
		
		if(this.readyState === 4 && this.status === 204) {
			alert("Failed to login! Username or password is incorrect.");
		}
	};

	xhr.open("POST", "http://localhost:8080/ProjectMostFunnerestest/login");

	xhr.send(JSON.stringify(loginTemplate));
}
