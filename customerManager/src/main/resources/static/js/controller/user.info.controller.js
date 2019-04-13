/**
 *
 */
app.controller('userInfoController', function($scope, $http, $rootScope, $location) {
	$scope.findAllUserInfo = function() {
		$http.get("/rest/userInfo/findAll").success(function(data, status, headers, config) {
			$scope.userInfoVOs = data.data;
		}).error(function(data, status, headers, config) {
			$scope.message = status;
		})
	}
	$scope.preview = function(userInfo){
		if (userInfo.password == userInfo.passwordToConfirm) {
			$scope.isPreview = true;			
		} else {
			alert("Password Different.");
			userInfo = null;
		}
	}
	$scope.addOrUpdateUserInfo = function(userInfo) {
		var input = {
				"userName":userInfo.userName,
				"password":userInfo.password
		}
		var postPath = '/rest/userInfo/add';
		if ($rootScope.isEdit) {
			input.userInfoId = userInfo.userInfoId
			postPath = '/rest/userInfo/update';
		}
		$http.post(postPath, input).success(function(data, status, headers, config) {
			if (data.status == 'success') {
				alert("success");
				$scope.userInfo = null;
				$location.url("/userInfo");				
			} else if (data.status == 'fail') {
				alert(data.errorMsg);
				$scope.isPreview = false;	
			}
		}).error(function(data, status, headers, config) {
			$scope.message = "fail";
		})
	}   
	$scope.goToUserInfoAdd = function(){
		$rootScope.isEdit = false;
		$location.url("/userInfo/addOrEdit");
	}
	$scope.editUserInfo = function(userInfoVO) {
		$rootScope.userInfo = userInfoVO;
		$rootScope.isEdit = true;
		$location.url("/userInfo/addOrEdit");			
	}
	$scope.deleteUserInfo = function(userInfoId) {
		var isConfirmed = confirm("Are you sure to delete this record ?");
		if (isConfirmed) {
			var input = {
					"userInfoId":userInfoId
			}
			$http.post('/rest/userInfo/delete', input).success(function(data, status, headers, config) {
				if (data.status == 'success') {
					alert("success");
					$rootScope.userInfo = null;
					$location.url("/userInfo");				
				} else if (data.status == 'fail') {
					alert(data.errorMsg);
				}
			}).error(function(data, status, headers, config) {
				$scope.message = "fail";
			})			
		}
	}
 
	$scope.isPreview = false;
	$scope.findAllUserInfo();
});