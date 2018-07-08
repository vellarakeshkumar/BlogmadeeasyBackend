app.factory('LoginService',function($http)
{
    var userService={}
    
    userService.loginUser = loginUser;
    userService.logout=logout;
  
    
//RegisterService.registerUser{}
    function loginUser(user)
    {
         console.log("login start")
        return $http.post("http://localhost:8180/BackEndCollaboration/login",user)
        console.log(user);
        console.log("logged in")  
    }
    
    function logout()
    {
    
    	console.log("logout start")
    	return $http.put("http://localhost:8180/BackEndCollaboration/logout")
    	console.log("logout finished")
    }
 

    
return userService;
})