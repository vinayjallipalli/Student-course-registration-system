<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Welcome to SCR!</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
   body {
    
    background-image: url("bg2crs.jpg");
    background-repeat: no-repeat;        
    background-attachment: fixed;
    background-size: 100% 100%;
}
h1 {
	font-family: Convergence;
	font-size: 30px;
	font-style: normal;
	font-variant: normal;
	font-weight: 500;
	line-height: 26.4px;
}
label{
    text-align: center;
    text-transform: uppercase;
    color: #2c3e50;
    	font-family: Convergence;
	font-size: 16px;
	font-style: normal;
	font-variant: normal;
	font-weight: 500;
	line-height: 26.4px;
}
.button {
 
  padding: 5px 8px;
  font-family: Convergence;
  font-size: 17px;
  text-align: center;
  cursor: pointer;
  outline: none;
  color: #fff;
  background-color: #4CAF50;
  border: none;
  width: 90px;
  border-radius: 15px;
  box-shadow: 0 5px #999;
}

.button:hover {background-color: #3e8e41}

.button:active {
  background-color: #3e8e41;
  box-shadow: 0 5px #666;
  transform: translateY(4px);
}


input[type=text] {
 padding: 2px;
  border: solid 1px #dcdcdc;
  transition: box-shadow 0.3s, border 0.3s;
}
input[type=text]:focus,
input[type=text].focus {
    border: solid 1px #707070;
  box-shadow: 0 0 5px 1px #969696;
}

input[type=password] {
  padding: 2px;
  border: solid 1px #dcdcdc;
  transition: box-shadow 0.3s, border 0.3s;
}
input[type=password]:focus,
input[type=password].focus {
  border: solid 1px #707070;
  box-shadow: 0 0 5px 1px #969696;
}

</style>

</head>
<body>
    <h1 align="center">Student Course Registration</h1><br>
<form action="ShowMenuServlet" method="post">
    <p align="center"><label>Username<br><input type="text" name="username"></label></p>
    <p align="center"><label>Password<br> <input type="password" name="password"></label></p>
    <p align="center"><input class="button" type="submit" value="Login"></p>
</form>
    
    <br><br><br><br>
 <form action="RegisterServlet" method="post">
     <p align="center"><label>New user? Click to register!<br><br><input class="button" type="submit" value="Register"></label></p>
</form>
    
    
</body>
</html>