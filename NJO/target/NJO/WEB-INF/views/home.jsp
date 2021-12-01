<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html ng-app="App"> 
   <head >
   		<script type="text/javascript" src="https://code.angularjs.org/1.8.2/angular.js"></script>
		<script type="text/javascript" src="resources/static/js/app.HomePage.js"></script>
        <script type="text/javascript" src="resources/static/js/app.MenuButtons.js"></script>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link href="../resources/style.css" rel="stylesheet" type="text/css">
        <div id="menu" ng-controller="MenuButton as vm">
	        <ul>
	        	<li id="idid"><form  action="about" id="formid"><button ng-click="vm.aboutButton('About Clicked')" id="buttons">About</button></form></li>
	        	<li id="idid"><form action="workouts"  id="formid"><button ng-click="vm.workoutsButton('Workout Clicked')" id="buttons">Workouts</button></form></li>
	        	<li id="idid"><form action="setting"  id="formid"><button ng-click="vm.settingButton('Setting Clicked')" id="buttons">Setting</button></form></li>
	        	<li id="idid"><form action="profile"  id="formid"><button ng-click="vm.profileButton('Profile Clicked')" id="buttons">Profile</button></form></li>
	        	<li id="idid"><form action="managerView"  id="formid"><button ng-click="vm.loginButton('Login Clicked')" id="buttons">Manager</button></form></li>
	        </ul>
        </div>
        <h1 style="text-align:center;color: #ffd700;font-family: "Garamond", Serif;">Welcome to Spotter</h1>
    </head>
    <body id="pagebody" ng-controller="HomePage as vm">
    	<div id="goldTextTitle">
    		{{ vm.title }}
    	</div>
    	<div   style="padding-top:100px"> 
       		<img  src="resources/img/GymBanner.jfif" width="350px" style="float:right" >
       		<p id="homeSignup">{{ vm.summary }}</p>
       		<form action="createAccount"><button style="margin-left: 120px;margin-top:20px;background-color:#ffd700;border:2px white;border-color:#ffd700">Create Account</button></form>
       		
      	</div> 
    </body>
</html>
