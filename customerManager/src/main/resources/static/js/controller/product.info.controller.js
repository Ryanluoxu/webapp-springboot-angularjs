/**
 *
 */
app.controller('productInfoController', function($scope, $http, $rootScope, $location) {
	$scope.findAllProductInfo = function() {
		$http.get("/rest/productInfo/findAll").success(function(data, status, headers, config) {
			if (data.status == 'success') {
				$scope.productInfoVOs = data.data;
			} else if (data.status == 'fail') {
				alert(data.errorMsg);
			}
		}).error(function(data, status, headers, config) {
			$scope.message = status;
		})
	}
	$scope.findAllCompanyInfo = function() {
		$http.get("/rest/companyInfo/findAll").success(function(data, status, headers, config) {
			if (data.status == 'success') {
				$scope.companyInfoVOs = data.data;
			} else if (data.status == 'fail') {
				alert(data.errorMsg);
			}
		}).error(function(data, status, headers, config) {
			$scope.message = status;
		})
	}
	$scope.preview = function(){
		if ($scope.productInfo.companyInfo == null) {
			alert("please select company.");
			return;
		}
		$scope.isPreview = true;
	}
	$scope.addOrUpdateProductInfo = function(productInfo) {
		var input = {
				"productName":productInfo.productName,
				"companyInfoId":productInfo.companyInfo.companyInfoId,
				"minPrice":productInfo.minPrice,
				"maxPrice":productInfo.maxPrice
		}
		var postPath = '/rest/productInfo/add';
		if ($rootScope.isEdit) {
			input.productInfoId = productInfo.productInfoId;
			postPath = '/rest/productInfo/update';
		}
		$http.post(postPath, input).success(function(data, status, headers, config) {
			if (data.status == 'success') {
				alert("success");
				$scope.orderInfo = null;
				$location.url("/productInfo");
			} else if (data.status == 'fail') {
				alert(data.errorMsg);
				$scope.isPreview = false;
			}
		}).error(function(data, status, headers, config) {
			$scope.message = "fail";
		})
	}
	$scope.goToProductInfoAdd = function(){
		$rootScope.isEdit = false;
		$location.url("/productInfo/addOrEdit");
	}
	$scope.editProductInfo = function(productInfoVO) {
		$rootScope.productInfo = productInfoVO;
		$rootScope.isEdit = true;
		$location.url("/productInfo/addOrEdit");
	}
	$scope.deleteProductInfo = function(productInfoId) {
		var isConfirmed = confirm("Are you sure to delete this record ?");
		if (isConfirmed) {
			var input = {
					"productInfoId":productInfoId
			}
			$http.post('/rest/productInfo/delete', input).success(function(data, status, headers, config) {
				if (data.status == 'success') {
					alert("success");
					$rootScope.productInfo = null;
					$location.url("/productInfo");
				} else if (data.status == 'fail') {
					alert(data.errorMsg);
				}
			}).error(function(data, status, headers, config) {
				$scope.message = "fail";
			})
		}
	}

	$scope.isPreview = false;
	$scope.findAllProductInfo();
	$scope.findAllCompanyInfo();
});