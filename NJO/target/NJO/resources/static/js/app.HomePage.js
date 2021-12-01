angular.module('App',[]).controller('HomePage', HomePage);

function HomePage() {
	
		/* jshint validthis: true */ 
		let vm = this;
		
		vm.title = "Helper website to help you learn how to target your muscles";
		vm.summary = "Join us and take your life back! Get fit, stronger, and faster. If you have signed up already, please login. If you have not signed up you can create your account today!"
		vm.gymBanner = "resources/img/GymBanner.jfif"
	}
	
