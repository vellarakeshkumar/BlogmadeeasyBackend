app.factory('RegisterService',function($http)
{
    var userService={}
    
    userService.registerUser = registerUser;
  
    
//RegisterService.registerUser{}
    function registerUser(user)
    {
     console.log("registration start")
        return $http.post("http://localhost:8180/BackEndCollaboration/registration",user)
        console.log(user);
        console.log("Registration done")  
    }
    
 

    
return userService;
})