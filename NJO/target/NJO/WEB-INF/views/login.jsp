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
	        	<li id="idid"><form action="profile"  id="formid"><button ng-click="profileButton('Profile Clicked')" id="buttons">Profile</button></form></li>
	  
	        </ul>
        </div>
    </head>
    <body id="pagebody">
        <h1>Hello World from Login!!</h1>
        <p>This is the Login!</p>
    
    
    
    
    </body>
    
    
    
</html>
