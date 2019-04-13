/**
 *
 */

app.controller('mainController', function($rootScope, $scope, $http, $location, $rootScope) {

	$scope.goHome = function() {
		$location.url("/")
	}
	$scope.login = function() {
		$location.url("/login")
	}
	$scope.showUserPage = function() {
		$location.url("/user")
	}
	$scope.showAdminPage = function() {
		$location.url("/admin")
	}
	
	var getCredential = function(){
		$http.get("/getCredential").success(function(data, status, headers, config) {
			$rootScope.loginUser = data.data;
		}).error(function(data, status, headers, config) {
			$scope.message = status;
		})
	}

	getCredential();

});