/**
 *
 */
app.controller('companyInfoController', function($scope, $http, $rootScope, $location) {
	$scope.findAllCompanyInfo = function() {
		$http.get("/rest/companyInfo/findAll").success(function(data, status, headers, config) {
			if (data.status == 'success') {
				$scope.companyInfoVOs = data.data;
			} else if (data.status == 'fail') {
				alert(data.errorMsg);
			}
		}).error(function(data, status, headers, config) {
			$scope.message = status;
			alert(data.errorMsg);
		})
	}
	$scope.preview = function(){
		$scope.isPreview = true;
	}
	$scope.addOrUpdateCompanyInfo = function(companyInfo) {
		var input = {
				"companyName":$scope.companyInfo.companyName,
				"country":$scope.companyInfo.country
		}
		var postPath = '/rest/companyInfo/add';
		if ($rootScope.isEdit) {
			input.companyInfoId = companyInfo.companyInfoId;
			postPath = '/rest/companyInfo/update';
		}
		$http.post(postPath, input).success(function(data, status, headers, config) {
			if (data.status == 'success') {
				alert("success");
				$scope.companyInfo = null;
				$location.url("/companyInfo");
			} else if (data.status == 'fail') {
				alert(data.errorMsg);
				$scope.isPreview = false;
			}
		}).error(function(data, status, headers, config) {
			$scope.message = "fail";
		})
	}
	$scope.goToCompanyInfoAdd = function(){
		$rootScope.isEdit = false;
		$location.url("/companyInfo/addOrEdit");
	}
	$scope.editCompanyInfo = function(companyInfoVO) {
		$rootScope.companyInfo = companyInfoVO;
		$rootScope.isEdit = true;
		$location.url("/companyInfo/addOrEdit");
	}
	$scope.deleteCompanyInfo = function(companyInfoId) {
		var isConfirmed = confirm("Are you sure to delete this record ?");
		if (isConfirmed) {
			var input = {
					"companyInfoId":companyInfoId
			}
			$http.post('/rest/companyInfo/delete', input).success(function(data, status, headers, config) {
				if (data.status == 'success') {
					alert("success");
					$rootScope.companyInfo = null;
					$location.url("/companyInfo");
				} else if (data.status == 'fail') {
					alert(data.errorMsg);
				}
			}).error(function(data, status, headers, config) {
				$scope.message = "fail";
			})
		}
	}

	$scope.isPreview = false;
	$scope.findAllCompanyInfo();
});