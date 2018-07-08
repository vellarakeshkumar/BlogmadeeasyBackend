app.controller('LoginController',function($scope,$rootScope,$location,LoginService,$cookieStore){
	
		$scope.login=function(user)
		{
		console.log('LoginController -> login')
		console.log(user)
		LoginService.loginUser($scope.user).
		
		then(function(response){
			$rootScope.loggedInUser=response.data
			$cookieStore.put('currentuser',response.data)/* key value pair*/
			$location.path('/home')
		},function(response){
			console.log('error')
			$scope.error=response.data
			$location.path('/login')
		}
		)
	}
	
/*				$scope.updateUser=function(user) {
					UserService.updateUser(user).then(function(response){
						alert('updated user profile successfully')
						$rootScope.loggedInUser=response.data
						$cookieStore.put('loggedInUser',response.data)
						$location.path('/home')
				},function(response) {
					if(response.status==401)
						$location.path('/login')
						else
							$scope.error=response.data
				})
				}
				
				$rootScope.searchUser=function(user) {
					UserService.searchUser(user).then(function(response) {
						$scope.users=response.data
					},function(response) {
						$scope.error=response.data
					$location.path('/login')			})
				}*/
				})