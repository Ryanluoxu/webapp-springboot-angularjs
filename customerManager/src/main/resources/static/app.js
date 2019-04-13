/**
 *
 */

var app = angular.module('app', [ 'ngRoute' ]);

// configure our routes
app.config(function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : 'pages/home.html',
		controller : 'mainController'
	})

	.when('/admin', {
		templateUrl : 'pages/admin/admin.html',
		controller : 'adminController'
	})
	.when('/user', {
		templateUrl : 'pages/user/user.html',
		controller : 'userController'
	})
	
	.when('/auditTrail', {
		templateUrl : 'pages/admin/auditTrail/view.html',
		controller : 'auditTrailController'
	})
	
	.when('/userInfo', {
		templateUrl : 'pages/admin/userInfo/view.html',
		controller : 'userInfoController'
	}).when('/userInfo/addOrEdit', {
		templateUrl : 'pages/admin/userInfo/addOrEdit.html',
		controller : 'userInfoController'
	})
	
	.when('/customerInfo', {
		templateUrl : 'pages/user/customerInfo/view.html',
		controller : 'customerInfoController'
	}).when('/customerInfo/addOrEdit', {
		templateUrl : 'pages/user/customerInfo/addOrEdit.html',
		controller : 'customerInfoController'
	})
	
	.when('/orderInfo', {
		templateUrl : 'pages/user/orderInfo/view.html',
		controller : 'orderInfoController'
	}).when('/orderInfo/addOrEdit', {
		templateUrl : 'pages/user/orderInfo/addOrEdit.html',
		controller : 'orderInfoController'
	})
	
	.when('/companyInfo', {
		templateUrl : 'pages/user/companyInfo/view.html',
		controller : 'companyInfoController'
	}).when('/companyInfo/addOrEdit', {
		templateUrl : 'pages/user/companyInfo/addOrEdit.html',
		controller : 'companyInfoController'
	})
	
	.when('/productInfo', {
		templateUrl : 'pages/user/productInfo/view.html',
		controller : 'productInfoController'
	}).when('/productInfo/addOrEdit', {
		templateUrl : 'pages/user/productInfo/addOrEdit.html',
		controller : 'productInfoController'
	})
	
	.otherwise({
		redirectTo : '/'
	});

});

