<%-- 
    Document   : testjsp
    Created on : Oct 28, 2016, 11:51:54 PM
    Author     : Vansh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to SCR!</title>
        <style>
            h2{
        font-family: Convergence;
	font-size: 40px;
	font-style: normal;
	font-variant: normal;
	font-weight: 500;
	line-height: 26.4px; 
        
            }
            
                    MARQUEE{
        font-family: Convergence;
	font-size: 22px;
        color: red; 
	font-style: normal;
	font-variant: normal;
	font-weight: 500;
	line-height: 26.4px; 
        
            }
            
               h3{
        font-family: Convergence;
	font-size: 20px;
	font-style: normal;
	font-variant: normal;
	font-weight: 500;
	line-height: 26.4px; 
        
            }
            
            
 body {
    
    background-image: url("bg2crs.jpg");
    background-repeat: no-repeat;        
    background-attachment: fixed;
    background-size: 100% 100%;
}
.button {
 
  padding: 15px 25px;
  font-family: Convergence;
  font-size: 17px;
  text-align: center;
  cursor: pointer;
  outline: none;
  color: #fff;
  background-color: #34495E;
  border: none;
  width: 250px;
  border-radius: 15px;
  box-shadow: 0 5px #999;
}

.button:hover {background-color: #3e8e41}

.button:active {
  background-color: #3e8e41;
  box-shadow: 0 5px #666;
  transform: translateY(4px);
}
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    width: 25%;
    background-color: transparent;
    position: fixed;
    height: 100%;
    overflow: auto;
}

li a {
    text-align:center;
    display: block;
    color: #000;
    padding: 8px 16px;
    text-decoration: none;
}

li a.active {
    background-color: #4CAF50;
    color: white;
}

li a:hover:not(.active) {
    background-color: #555;
    color: white;
}

ol { display:table; margin:0 auto;}
</style>
    </head>
    <body>
        <ul>
            <li>
                <form method="post" action="RegistercourseServlet">   
                <br><br><p align="center"><input class="button" type="submit" name="b1" value="Register Course"></input></p>
                </form>
            </li>
               
            <li>
                    <form method="post" action="DeregisterCourseServlet">   
                    <p align="center"><input class="button" type="submit" name="b2" value="De-register Courses"></input></p>
                    </form>
            </li>
                    
            <li>
                    <form method="post" action="UpdateDetailsServlet">   
                    <p align="center"> <input class="button" type="submit" name="b3" value="Update Personal Information"> </input></p>
                    </form>
            </li>
        </ul> 
        
        <div style="margin-left:25%;padding:1px 7px;height:100px;">
                <h2 align="center">News Updates:</h2>
                
                <MARQUEE scrolldelay="100" id="n1"></MARQUEE>
                <ol >        
                    <li > <h3 id="n2"></h3> </li>
                    <li> <h3 id="n3"></h3> </li> 
                    <li> <h3 id="n4"></h3> </li> 
                    <li> <h3 id="n5"></h3> </li> 
                </ol>
        </div>
        <script>
        
            var x = document.cookie;
            var d=x.split(".");
            document.getElementById("n1").innerHTML=d[1];
            document.getElementById("n2").innerHTML=d[2];
            document.getElementById("n3").innerHTML=d[3];
            document.getElementById("n4").innerHTML=d[4];
            document.getElementById("n5").innerHTML=d[5];
            </script>
        
        
        
    </body>
</html>
