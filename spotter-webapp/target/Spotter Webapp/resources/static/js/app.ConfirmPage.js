angular.module('App',['AppHttp']).controller('ConfirmPage',ConfirmPage)
	
	ConfirmPage.$inject = ['HttpAPICall']
	
	function ConfirmPage(HttpAPICall){
		let vm = this;
		//alert(vm.emailGrab);
		getUserData(HttpAPICall).then(function(data){
		
			//alert(JSON.stringify(data))
			vm.FName = data.Firstname;
			vm.LName = data.Lastname;
			vm.Email = data.Email;
			vm.SelectFeet = parseInt(data.SelectFeet);
			vm.SelectInch = parseInt(data.SelectInch);
			vm.Weight = parseInt(data.Weight);
		});
	} 
	
	function getUserData(HttpAPICall){
		return HttpAPICall.post("/getUser").then(function(data){
			return data;
		})
	}