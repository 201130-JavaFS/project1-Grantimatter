console.log("Login loaded");
let loginForm = document.getElementById("login_form");
loginForm.onsubmit = onLoginSubmit;

let employeePassword = document.getElementById("employeePassword");

function onLoginSubmit(){
    //console.log("Email submitted: ");
    window.open(employeePassword.value, "_blank");
}