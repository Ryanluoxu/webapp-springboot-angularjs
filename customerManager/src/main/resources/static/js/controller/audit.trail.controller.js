/**
 *
 */
app.controller('auditTrailController', function($scope, $http, $rootScope, $location) {
	
	$scope.findAllAuditTrail = function() {
		$http.get("/rest/auditTrail/findAll").success(function(data, status, headers, config) {
			if (data.status == 'success') {
				$scope.allAuditTrailVOs = data.data;
				$scope.filterData();
			} else if (data.status == 'fail') {
				alert(data.errorMsg);
			}
		}).error(function(data, status, headers, config) {
			$scope.message = status;
		});
	}
	
	$scope.filterData = function(){
		$scope.auditTrailVOs = [];
		angular.forEach($scope.allAuditTrailVOs, function(auditTrail, key) {
			if ($scope.filterByAdd && auditTrail.actionType == 'add') {
				$scope.auditTrailVOs.push(auditTrail);
			}
			if ($scope.filterByUpdate && auditTrail.actionType == 'update') {
				$scope.auditTrailVOs.push(auditTrail);
			}
			if ($scope.filterByDelete && auditTrail.actionType == 'delete') {
				$scope.auditTrailVOs.push(auditTrail);
			}
		});
	}
	
	
	/**
	 * ----- admin go to view page
	 * 1. initialize filters as all true
	 * 2. find all data
	 * 3. filter data, get auditTrailVOs
	 */	
	$scope.filterByAdd = true;
	$scope.filterByUpdate = true;
	$scope.filterByDelete = true;
	
	$scope.findAllAuditTrail();
	
	/**
	 * ----- admin click any filter
	 * 1. update filters automatically when click
	 * 2. filter data, get auditTrailVOs
	 */
	
	
});