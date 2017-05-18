var SBIApp = angular.module('SBIApp', ['ngSanitize']);
	
	
	SBIApp.controller('DemographicControl', ['$http', function($http) {
		
		var myvar = this;
		myvar.noError=true;
		
		 angular.element(document).ready(function(){	
			
			var url = '/demography';
			
			$http.get(url).then(function(res) {
				
				var errorExists = res.data.containsError;
				myvar.noError= !errorExists;
				
				if(errorExists){						
					myvar.errorMessage = res.data.message;
				}else{			
					myvar.demography = res.data.data;
				}

			},function errorCallback(response) {
				myvar.errorMessage = response.data.error;
			});
		});

	}]);
	
	
	SBIApp.controller('PeerDataControl', ['$http', function($http) {
		
		var myvar = this;
		myvar.noError=true;
		
		 angular.element(document).ready(function(){	
			
			var url = '/peerdata';
			
			$http.get(url).then(function(res) {
				
				var errorExists = res.data.containsError;
				myvar.noError= !errorExists;
				
				if(errorExists){						
					myvar.errorMessage = res.data.message;
				}else{			
					myvar.peerdata = res.data.data;
				}

			},function errorCallback(response) {
				myvar.errorMessage = response.data.error;
			});
		});

	}]);
	
	SBIApp.controller('GoalControl', ['$http', function($http) {
		
		var myvar = this;
		myvar.noError=true;
		
		 angular.element(document).ready(function(){	
			
			var url = '/goals';
			
			$http.get(url).then(function(res) {
				
				var errorExists = res.data.containsError;
				myvar.noError= !errorExists;
				
				if(errorExists){						
					myvar.errorMessage = res.data.message;
				}else{			
					myvar.goals = res.data.data;
				}

			},function errorCallback(response) {
				myvar.errorMessage = response.data.error;
			});
		});

	}]);
	
	SBIApp.controller('InvestmentControl', ['$http', function($http) {
		
		var myvar = this;
		myvar.noError=true;
		
		 angular.element(document).ready(function(){	
			
			var url = '/investments';
			
			$http.get(url).then(function(res) {
				
				var errorExists = res.data.containsError;
				myvar.noError= !errorExists;
				
				if(errorExists){						
					myvar.errorMessage = res.data.message;
				}else{			
					myvar.investments = res.data.data;
				}

			},function errorCallback(response) {
				myvar.errorMessage = response.data.error;
			});
		});

	}]);