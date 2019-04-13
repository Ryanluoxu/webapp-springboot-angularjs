/**
 *
 */

app.controller('userController', function($scope, $http, $location, $rootScope) {

	$scope.showCustomerInfo = function() {
		$location.url("/customerInfo")
	}
	$scope.showOrderInfo = function() {
		$location.url("/orderInfo")
	}
	$scope.showCompanyInfo = function() {
		$location.url("/companyInfo")
	}
	$scope.showProductInfo = function() {
		$location.url("/productInfo")
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