<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html ng-app="App"> 
    <head>
    	<script type="text/javascript" src="https://code.angularjs.org/1.8.2/angular.js"></script>
		<script type="text/javascript" src="resources/static/js/app.HttpAPIFactory.js"></script>
		
		<script type="text/javascript" src="resources/static/js/app.Manager.js"></script>
        <script type="text/javascript" src="resources/static/js/app.MenuButtons.js"></script>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     
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
    <body id="DatabaseBodyView">
    	<div>
    		<h1>Current Users in Database</h1>
    	</div>
    	<table style="border: 2px solid white ;border-color: #000000;border-collapse: collapse;" ng-controller="ManagerController as vm">
    		<tr style="background: #000000;top-padding: 5px;" >
    			<th style="color: #ffd700;">Firstname</th>
    			<th style="color: #ffd700;">Lastname</th>
    			<th style="color: #ffd700;">Weight</th>
    			<th style="color: #ffd700;">Feet</th>
    			<th style="color: #ffd700;">Inches</th>
    			<th style="color: #ffd700;">Email</th>
    		 </tr>
    		<tr ng-repeat="acc in vm.AccountList" style="border: 2px solid black ;top-padding: 5px;" >
    			<td><input id="InputBack" type="text" ng-model="acc.firstname" value="acc.firstname"></td>
    			<td><input id="InputBack" type="text" ng-model="acc.lastname" value="acc.lastname"></td>
    			<td><input id="InputBack" type="number" min="1" ng-model="acc.weight" value="acc.weight"></td>
    			<td><input id="InputBack" type="number" min="4" max="8" ng-model="acc.selectFeet" value="acc.selectFeet"></td>
    			<td><input id="InputBack" type="number" min="0" max="9" ng-model="acc.selectInch" value="acc.selectInch"></td>
    			<td><input id="InputBack" type="text" ng-model="acc.email" value="acc.email"></td>
    			<td><form><button ng-click="vm.UpdateAccount(acc)"> Update</button> <button ng-click="vm.DeleteAccount(acc)">Delete</button></form></td>
    			<td></td>
    		</tr>
    	</table>
    </body>
    
    
</html>