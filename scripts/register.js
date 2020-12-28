function validate1()
{
	var name = document.getElementById("name").value;
	var email = document.getElementById("email").value;
	var num = document.getElementById("numb").value;
	var password = document.getElementById("password").value;
	var password1 = document.getElementById("password1").value;
	var reg = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	var reg1 = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,15}$/;
	var phnum = /^\d{10}$/;

	if (name == "") 
	{
		alert("Name must be filled out!");
		return false;
	}

	if (email == "") 
	{
		alert("E-mail must be filled out!");
		return false;
	}
	if (email.match(reg))
	{	
	}
	else
	{
		alert("You have entered an invalid email ID!");
		return false;
	}
		
	if (num == "" )
	{
		alert("Contact number must be filled out!");
		return false;
	}

	if (num.match(phnum))
	{
	}
	else
	{
		alert("invalid number!");
		return false;
	}
	if (password == "") 
	{
		alert("Password must be filled out!");
		return false;
	}
	
	if (password.match(reg1))
	{
	}
	else
	{
		alert("Password should contain at least one lowercase letter, one uppercase letter, one numeric digit, and one special character!\nPassword length should be more than 7 characters!");
		return false;
	}
	
	if (password1 == "") 
	{
		alert("Please confirm your password!");
		return false;
	}
	if (password1 === password)
	{
	}
	else
	{
		alert("Password not matching!");
		return false;
	}
}