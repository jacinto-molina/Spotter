angular
	.module('App')
	.controller('MenuButton', MenuButton);
	
function MenuButton(){
	var vm = this;
			
	vm.homeButton = homeButton;	
	vm.aboutButton = aboutButton;
	vm.workoutsButton = workoutsButton;
	vm.settingButton = settingButton; 
	vm.profileButton = profileButton; 
	vm.loginButton = loginButton; 
	
	function homeButton(msg){
		alert(msg)
	}
	
	function aboutButton (msg){
	
		alert(msg)
	}
	
	function workoutsButton(msg){
		alert(msg)
	}
	
	function settingButton(msg){
		alert(msg)
	}
	
	function profileButton(msg){
		alert(msg)
	}
	
	function loginButton(msg){
		//alert(msg)
	}
}