var app = angular.module('AppTest',[]);

app.controller('ServerTest',function($scope, httpAPICall){
	$scope.ServerClick =  function(){
		httpAPICall.get("/serverTest").then((data)=>{
			alert(JSON.stringify(data))
		}).catch(function(response){
			console.log(response.status)
		})
	}

})
