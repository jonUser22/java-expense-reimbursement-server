


//modal
document.getElementById("login-nav-opt").addEventListener("click", openModal);
document.getElementById("close-btn").addEventListener("click", closeModal);
document.getElementById("submit-btn").addEventListener("click", attemptLogin);



//function performAjaxGetRequest(url, callback){
  function openModal(){
    $('#loginModal').modal('show');
}

function closeModal(){
    $('#loginModal').modal('hide');
}


/*
window.onload = function(){

    // if this token is null, redirect (on the frontend, change the browsers location 
    - perhaps to some web page that allows us to login)
    // send an ajax request validating the token
    // if token valid? stay on page
    // if token is invalid, redirect (on the frontend, change the browsers location)
}

*/




function attemptLogin(){
  let username = document.getElementById("username-input").value;
  let password = document.getElementById("password-input").value;
  let credentials = {username, password};
  
  const loginUrl =  baseUrl + "/login";
  performAjaxPostRequest(loginUrl, JSON.stringify(credentials), handleSuccessfulLogin, handleUnsuccessfulLogin);
}

function handleSuccessfulLogin(responseText){
  console.log("Success! You're logged in");
  document.getElementById("error-msg").hidden = true;
  closeModal();
  let token = responseText;

  sessionStorage.setItem("token", token);
  toggleLoginToLogout();
  displayLogInUser();
  changingHtmlPage();

}


function handleUnsuccessfulLogin(){
  console.log("Login unsuccessful");
  document.getElementById("error-msg").hidden = false;
}

function toggleLoginToLogout(){
  let loginBtn = document.getElementById("login-nav-opt");
  loginBtn.innerText = "Log out";
  loginBtn.removeEventListener("click", openModal);
  loginBtn.addEventListener("click", logout);
}

function logout(){
  sessionStorage.removeItem("token");
  toggleLogoutToLogin();
  removeDisplLogInUserGreeting();
}

function toggleLogoutToLogin(){
  let loginBtn = document.getElementById("login-nav-opt");
  loginBtn.innerText = "Log in";
  loginBtn.addEventListener("click", openModal);
  loginBtn.removeEventListener("click", logout);
}


function displayLogInUser(){
const token = sessionStorage.getItem("token")
const parsedToken = token.split(":");
const logInId = parsedToken[0];

getUserById(logInId, function(usersJSON){

 const user = JSON.parse(usersJSON);
 document.getElementById("greeting-header").innerText 
 = "Welcome, " + user.firstName +" "+ user.lastName;

});}

function removeDisplLogInUserGreeting(){
  document.getElementById("greeting-header").innerText = " Welcome ";
}

//Opens the employee & manager webpage
function changingHtmlPage(){

  let token = sessionStorage.getItem("token");
  if (token != null){

    const parsedToken = token.split(":");
    const jobTitle = parsedToken[1];

    if (jobTitle === "MANAGER"){
        
        Window = window.open("C:/Users/pjbak/Project_1/manager.html"); 
        logout();

    } else if (jobTitle === "ASSOCIATE"){

        Window = window.open("C:/Users/pjbak/Project_1/employee.html");
        logout();
    }

  }

}



