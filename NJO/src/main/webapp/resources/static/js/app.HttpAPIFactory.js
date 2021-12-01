angular.module('AppHttp',[]).factory('HttpAPICall', HttpAPICall);
	
	
	function HttpAPICall($http,$q){
		return {
			get: getCall,
			post: postCall 
		}
		
		function postCall(bodyObject,url){ //Post Api Call 
			const header = {
				method:'POST',
				timeout: 15000
			}
			return $http.post(("http://127.0.0.1:8081"+url),bodyObject,header).then(function (response){
				return (response.status)
			})
			}
			
		function getCall(url){ //Get Api Call
			const headerTest = {
				method: 'GET',
				timeout: 15000,
			}
			return $http.get(("http://127.0.0.1:8081"+url),headerTest).then(function (response){
				return response.data;
			})
			}
	}
