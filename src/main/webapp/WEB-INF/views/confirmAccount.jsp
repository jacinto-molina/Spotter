<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html ng-app="App"> 
    <head>
    	<script type="text/javascript" src="https://code.angularjs.org/1.8.2/angular.js"></script>
		<script type="text/javascript" src="resources/static/js/app.HttpAPIFactory.js"></script>
		
		<script type="text/javascript" src="resources/static/js/app.ConfirmPage.js"></script>
        <script type="text/javascript" src="resources/static/js/app.MenuButtons.js"></script>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Home</title>
        <link href="../resources/style.css" rel="stylesheet" type="text/css">
        <div id="menu" ng-controller="MenuButton as vm">
	        <ul>
	       		<li id="idid"><form action="/"  id="formid"><button ng-click="vm.homeButton('Home Clicked')" id="buttons">Home</button></form></li>
	       	 	<li id="idid"><form  action="about" id="formid"><button ng-click="vm.aboutButton('About Clicked')" id="buttons">About</button></form></li>
	        	<li id="idid"><form action="workouts"  id="formid"><button ng-click="vm.workoutsButton('Workout Clicked')" id="buttons">Workouts</button></form></li>
	        	<li id="idid"><form action="setting"  id="formid"><button ng-click="vm.settingButton('Setting Clicked')" id="buttons">Setting</button></form></li>
	        	<li id="idid"><form action="login"  id="formid"><button ng-click="vm.loginButton('Login Clicked')" id="buttons">Login</button></form></li>
	  
	        </ul>
        </div>
    </head>
    <body id="confirmPagebody">
    	<div style="background-color: #ffd700;width:2000px;height:10px;margin-top:5px;margin-left:-20px;"></div>
       
        <h1 id="confirmText">Hello World from ConfirmPage!!</h1>
        <div ng-controller="ConfirmPage as vm">
        	<input type="hidden" ng-model="vm.emailGrab" value="${acc}"></p>
        	<h1 id="confirmText" style="text-align:center">Your information being saved, Continue to Homepage</h1><br>
        	<p id="confirmText" style="font-size: 50px">FullName: {{vm.FName}} {{vm.LName}}</p><br>
       		<label id="confirmText" style="font-size: 50px">Email: {{vm.Email}}</label><br>
       		<label id="confirmText" style="font-size: 50px">Height: {{vm.SelectFeet}} {{vm.SelectInch}}   Weight: {{vm.Weight}} </label><br>
       		<form action="/"><button>Home</button></form>
        	<div style="background-color: #fdd700;width:2000px;height:10px;margin-top:5px;margin-left:-20px;"></div>
        </div>
        
    </body>
</html>
