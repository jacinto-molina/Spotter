angular.module('App',['AppHttp']).controller('CreateUserController',CreateUserController);

CreateUserController.$inject = ['HttpAPICall']
function CreateUserController(HttpAPICall){
	
	/* jshint validthis: true */ 
	let vm = this;
	vm.CAOnClick = CAOnClick;
	
	function CAOnClick(){
		//alert("VM: "+JSON.stringify(vm))
		postUserData(HttpAPICall,JSON.stringify(vm),'/saveUser')
		.then(function(status){
			//alert("status code: " + status)
		})
	}
}

function postUserData(HttpAPICall,data,url){
	 return HttpAPICall.post(data,url).then(function(status){
		return status;
	})
}




