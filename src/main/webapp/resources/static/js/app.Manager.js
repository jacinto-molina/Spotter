angular.module('App',['AppHttp']).controller('ManagerController',ManagerController)
	
	ManagerController.$inject = ['HttpAPICall']
	
	function ManagerController(HttpAPICall){
		let vm = this; 
		
		vm.val=[];
		vm.DeleteAccount = DeleteAccountMeth;
		vm.UpdateAccount = UpdateAccountMeth;
		
		function DeleteAccountMeth(acc){
			deleteUser(HttpAPICall,acc,"/deleteUser").then(function(data){
				window.location.reload();
			})
		}
		
		function UpdateAccountMeth(acc){
			updateUser(HttpAPICall,acc,"/updateUser").then(function(data){
				window.location.reload();
			})
		}
		
		getAllUserData(HttpAPICall,"/GetAllUsers").then(function(data){
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