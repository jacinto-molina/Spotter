angular.module('App',['AppHttp']).controller('ManagerController',ManagerController)
	
	ManagerController.$inject = ['HttpAPICall']
	
	function ManagerController(HttpAPICall){
		let vm = this; 
		
		vm.val=[];
		vm.DeleteAccount = DeleteAccountMeth;
		vm.UpdateAccount = UpdateAccountMeth;
		
		function DeleteAccountMeth(acc){
			deleteUser(HttpAPICall,JSON.stringify(acc),"/deleteUser")
		}
		
		function UpdateAccountMeth(acc){
			//alert(JSON.stringify(acc))
			updateUser(HttpAPICall,JSON.stringify(acc),"/updateUser")
		}
		
		getAllUserData(HttpAPICall,"/GetAllUsers").then(function(data){
			//alert(data + " | " + JSON.stringify(data));
			vm.AccountList = data;
		})
		
	}
	
	function deleteUser(HttpAPICall, acc, url){
		return HttpAPICall.post(acc,url)
	}
	
	function updateUser(HttpAPICall, acc,url){
		return HttpAPICall.post(acc, url)
	}
	
	function getAllUserData(HttpAPICall, url){
		return HttpAPICall.get(url).then(function(data){
			return data;
		})
	}