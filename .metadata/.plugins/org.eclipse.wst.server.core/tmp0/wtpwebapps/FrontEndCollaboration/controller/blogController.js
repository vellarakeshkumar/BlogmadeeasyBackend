app.controller('BlogController',function($scope,$location,$rootScope,BlogService,$routeParams) {
	var id=$routeParams.id
	$scope.addBlog=function() {
		BlogService.addBlog($scope.post).then(
				function(response) {
					alert('Blogpost is added successfully and it is waiting for approval');
					$location.path('/home')
				},
				function(response) {
					$rootScope.error=response.data
					if(response.status==401)
						$location.path('/login')
				})
	}
	
	
	if($rootScope.loggedInUser.role=='ROLE_ADMIN') {
		BlogService.getBlogsWaitingForApproval()
		.then(function(response) {
					$scope.blogsWaitingForApproval=response.data
				},function(response) {
					$rootScope.error=response.data
					if(response.status==401)
						$location.path('/login')
				})
	}		
	if($rootScope.loggedInUser.role=='ROLE_ADMIN') {	
	 BlogService.getBlogbyID(id)
	 .then(function(response) {
				 $scope.blog=response.data
				 $scope.content=$sce.trustAsHtml($scope.blog.blogContent)
			 },function(response) {
				 $rootScope.error=response.data
				 if(response.status==401)
					 $location.path('/login')
			 })
	}

});