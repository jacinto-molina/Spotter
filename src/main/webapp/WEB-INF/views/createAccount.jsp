<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html ng-app="AppTest"> 
    <head>
    	<script type="text/javascript" src="https://code.angularjs.org/1.8.2/angular.js"></script>
		<script type="text/javascript" src="resources/static/js/route.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link href="../resources/style.css" rel="stylesheet" type="text/css">
        <div id="menu" ng-controller="MenuButton">
	        <ul>
	        	<li id="idid"><form action="/"  id="formid"><button ng-click="homeButton('Home Clicked')" id="buttons">Home</button></form></li>
	       	 	<li id="idid"><form  action="about" id="formid"><button ng-click="aboutButton('About Clicked')" id="buttons">About</button></form></li>
	        	<li id="idid"><form action="workouts"  id="formid"><button ng-click="workoutsButton('Workout Clicked')" id="buttons">Workouts</button></form></li>
	        	<li id="idid"><form action="setting"  id="formid"><button ng-click="settingButton('Setting Clicked')" id="buttons">Setting</button></form></li>
	        	<li id="idid"><form action="login"  id="formid"><button ng-click="loginButton('Login Clicked')" id="buttons">Login</button></form></li>
	  
	        </ul>
        </div>
    </head>
    <body id="createbody">
    	<div style="background-color: black;width:2000px;height:10px;margin-top:5px;margin-left:-20px;"></div>
        <h1 id="goldTextTitle" style="border:5px solid black;">Create your Account</h1>
        <form id="createAcc" action="/" method="post">
        	<div id="createDiv" style="width:800px" >
        		<div style="width:300px;height:300px;background-color: black;" ng-controller="InputVariable">
        		<ul>
        			<li id="createF"><label for="fname">First Name:</label>
			        	<input type="text" id="fname" name="fname" ng-model="firstName" value="" required><br></li>
		        	<li id="createF"><label for="lname">Last Name:</label>
		        		<input type="text" id="lname" name="lname" ng-model="lastName" value="" required><br></li>
	        		<li id="createF"><label for="ename" style="padding-left:32px">Email:</label>
		        		<input type="text" id="ename" name="ename" ng-model="email" value="" required><br></li>
	        		<li id="createF"><label for="password" style="padding-left:8px">Password:</label>
		        		<input type="password" id="password" name="password" ng-model="password" value="" required><br></li>
	        	
	        		<li id="createF" style="padding-left:30px"><label for="height">Height</label>
	        			<select id="selectFeet" ng-model="selectFeet" name="selectFeet">
	        				<option>4</option>
	        				<option>5</option>
	        				<option>6</option>
	        				<option>7</option>
	        			</select>
	        			<select id="selectInch" ng-model="selectInch" name="selectInch">
	        				<option>0</option>
	        				<option>1</option>
	        				<option>2</option>
	        				<option>3</option>
	        				<option>4</option>
	        				<option>5</option>
	        				<option>6</option>
	        				<option>7</option>
	        				<option>8</option>
	        				<option>9</option>
	        			</select>
	        		</li>
	        		<li id="createF"><label for="weight" style="padding-left:22px">Weight:</label>
		        		<input type="number" id="weight" ng-model='weight' name="weight" value=0 ><br></li>
	        	</ul>
	        	<form><button ng-click="CAOnClick()" style="margin-left:117px;width: 40%;">Create Account</button> </form>
        		</div>
        	</div>
        </form>
        <div style="background-color: black;width:2000px;height:10px;margin-top:5px;margin-left:-20px;"></div>
        
    </body>
</html>
e