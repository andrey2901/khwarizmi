function userNameRequired() {
	if (document.getElementsByName('j_username')[0].value == "") {
		document.getElementById('userNameError').innerHTML = "User is empty.";
	}
	else
		document.getElementById('userNameError').innerHTML = "";
}

function passwordRequired() {
	if (document.getElementsByName('j_password')[0].value == "") {
		document.getElementById('passwordError').innerHTML = "Password is empty.";
	}
	else
		document.getElementById('passwordError').innerHTML = "";
}