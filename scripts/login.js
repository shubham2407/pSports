

// Below function Executes on click of login button.
function validate()
{
	var username = document.getElementById("email").value;
	var password = document.getElementById("password").value;

  if (username == "") 
  {
    alert("username must be filled out!");
    return false;
  }
  if (password == "") 
  {
    alert("password must be filled out!");
    return false;
  }
  if (password.length < 8) 
  {
    alert("Password must contain atleast Eight characters!");
    return false;
  }
}
