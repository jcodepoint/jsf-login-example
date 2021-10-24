function managePasswordVisibility(b) {
	if (b){
		showPassword();
	} else {
		hidePassword();
	}
}

function changeCursor(obj, cursorStyle) {
	obj.style.cursor = cursorStyle;
}

function passwordValueChanged(obj) {
	if (obj.value == '') {
		hidePassword();
	}
}	

function showPassword() {
	document.getElementById('loginForm:contrasena').type = 'text';
	document.getElementById('loginForm:show').style.display = 'none';
	document.getElementById('loginForm:hide').style.display = 'inline';
}	

function hidePassword() {
	document.getElementById('loginForm:contrasena').type = 'password';
	document.getElementById('loginForm:show').style.display = 'inline';
	document.getElementById('loginForm:hide').style.display = 'none';
}	
