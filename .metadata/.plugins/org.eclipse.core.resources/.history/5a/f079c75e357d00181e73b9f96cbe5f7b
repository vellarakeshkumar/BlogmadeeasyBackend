 var app=angular.module('myApp', ['ngRoute','ngCookies'])

 app.config(['$routeProvider', function($routeProvider) {
	    $routeProvider.

	      when('/home', {
			templateUrl: 'home/home.html',
			controller: 'HomeController'
	      }).
	      
	      
	      when('/contact', {
				templateUrl: 'contact/contact.html',
				controller: 'ContactController'
				
			}).
			when('/about', {
				templateUrl: 'about/about.html',
				controller: 'AboutController'
				
			}).
			when('/register', {
				templateUrl: 'view/register.html',
				controller: 'RegisterController'
				
			}).
			when('/login', {
				templateUrl: 'view/login.html',
				controller: 'LoginController'
				
			}).
			when('/addblog', {
				templateUrl: 'view/blogRegisterForm.html',
				controller: 'BlogController'
				
			}).
			
	      otherwise({
			redirectTo: '/'
	      });
	}]);

 
 
 
 app.run(function($rootScope,$location,LoginService,$cookieStore){
		if($rootScope.loggedInUser==undefined)
			$rootScope.loggedInUser=$cookieStore.get('currentuser')
			
			$rootScope.logout=function()
			{
			LoginService.logout().then(function(response)
					{
					delete $rootScope.loggedInUser;
					$cookieStore.remove('currentuser')
					$rootScope.message="Loggedout Successfully..."
					$location.path('/login');
					},function(response)
					{
						$rootScope.error=response.data
						if(response.status==401)
						$location.path('/login')
					})
		}
	})