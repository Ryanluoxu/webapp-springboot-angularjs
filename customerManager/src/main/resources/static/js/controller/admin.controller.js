/**
 *
 */

app.controller('adminController', function($scope, $http, $location, $rootScope) {

	$scope.showUserInfo = function() {
		$location.url("/userInfo")
	}
	$scope.showAuditTrail   = function(){
		$location.url("/auditTrail")
	}
	$scope.goHome = function() {
		$location.url("/")
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