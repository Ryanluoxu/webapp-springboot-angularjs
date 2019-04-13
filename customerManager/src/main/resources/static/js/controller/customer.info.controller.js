/**
 *
 */
app.controller('customerInfoController', function($scope, $http, $rootScope, $location) {
	$scope.findAllCustomerInfo = function() {
		$http.get("/rest/customerInfo/findAll").success(function(data, status, headers, config) {
			$scope.customerInfoVOs = data.data;
		}).error(function(data, status, headers, config) {
			$scope.message = status;
		})
	}
	$scope.preview = function(){
		$scope.isPreview = true;
	}
	$scope.addOrUpdateCustomerInfo = function(customerInfo) {
		var input = {
				"customerName":$scope.customerInfo.customerName,
				"function":$scope.customerInfo.function,
				"companyName":$scope.customerInfo.companyName,
				"country":$scope.customerInfo.country,
				"email":$scope.customerInfo.email,
				"contactMobile":$scope.customerInfo.contactMobile,
				"contactOffice":$scope.customerInfo.contactOffice,
				"contactFax":$scope.customerInfo.contactFax,
				"address":$scope.customerInfo.address
		}
		var postPath = '/rest/customerInfo/add';
		if ($rootScope.isEdit) {
			input.customerInfoId = customerInfo.customerInfoId;
			postPath = '/rest/customerInfo/update';
		}
		$http.post(postPath, input).success(function(data, status, headers, config) {
			if (data.status == 'success') {
				alert("success");
				$scope.customerInfo = null;
				$location.url("/customerInfo");
			} else if (data.status == 'fail') {
				alert(data.errorMsg);
				$scope.isPreview = false;
			}
		}).error(function(data, status, headers, config) {
			$scope.message = "fail";
		})
	}
	$scope.goToCustomerInfoAdd = function(){
		$rootScope.isEdit = false;
		$location.url("/customerInfo/addOrEdit");
	}
	$scope.editCustomerInfo = function(customerInfoVO) {
		$rootScope.customerInfo = customerInfoVO;
		$rootScope.isEdit = true;
		$location.url("/customerInfo/addOrEdit");
	}
	$scope.deleteCustomerInfo = function(customerInfoId) {
		var isConfirmed = confirm("Are you sure to delete this record ?");
		if (isConfirmed) {
			var input = {
					"customerInfoId":customerInfoId
			}
			$http.post('/rest/customerInfo/delete', input).success(function(data, status, headers, config) {
				if (data.status == 'success') {
					alert("success");
					$rootScope.customerInfo = null;
					$location.url("/customerInfo");
				} else if (data.status == 'fail') {
					alert(data.errorMsg);
				}
			}).error(function(data, status, headers, config) {
				$scope.message = "fail";
			})
		}
	}
	$scope.showOrderInfo = function(customerInfoVO){
		$rootScope.seletedCustomerInfo = customerInfoVO;
		$location.url("/orderInfo");
	}
	
	$scope.isPreview = false;
	$scope.findAllCustomerInfo();
});