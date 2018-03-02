app.controller('UserCtrl', function($scope,$http,$cookieStore,$rootScope,$location) {
	
	$scope.User={username:"","email":"","address":"","phone":"","password":"","status":"P","role":"ROLE_USER"};
    $scope.firstName = "John";
    $scope.lastName = "Doe";
    $scope.UserById={};
    
    $scope.BASEURL="http://localhost:9090/project2_middleware/user/";
    $scope.register = function() {
    	
    	   console.log($scope.User);
    	$http.post( $scope.BASEURL+"register",$scope.User)
    	.then(function(response)
    			{
    		      alert($scope.User.email+"Registered Successfully");
    			},
    			function(error)
    			{
    			 alert($scope.User.email+"Registered unSuccessfully");
    			}
    			)
    	
    };
  
    $scope.login = function() {
    	
 	   $scope.User['status']='A';
 	$http.post( $scope.BASEURL+"login",$scope.User)
 	.then(function(response)
 			{
 		 $rootScope.currentuser=response.data;
 		 	if($rootScope.currentuser.errormessage!="login success")
 		 		{
 		 			alert($rootScope.currentuser.errormessage)
 		 		}
 		 	if($rootScope.currentuser.errormessage=="You are not yet approved by admin" || $rootScope.currentuser.errormessage=="You rejected please contact admin" || $rootScope.currentuser.errormessage=="You are not registered yet" || $rootScope.currentuser.errormessage=="email id or password incorrect")
 		 		{
 		 			$location.path("/login")
 		 		} 
 		 	else
 		 		{
 		 			$cookieStore.put('user', $rootScope.currentuser);
 		 			console.log("ROLE"+$rootScope.currentuser.role)
 		 			$location.path("/blog")
 		 		}
 			},
 			function(error)
 				{
 					alert($scope.User.email+"login unSuccessfully");
 				}
 			)
 	
 };

 $scope.approveUser = function(id) {
	 
	 $http.get( $scope.BASEURL+"getUserById/"+id)
		.then(function(response)
		{
			console.log(response.data)
			$scope.UserById=response.data;				
					})
					
					
		console.log($scope.UserById)
    	
	    $scope.UserById.status='A';
    	$http.post( $scope.BASEURL+"update",$scope.UserById)
    	.then(function(response)
    			{
    		      alert($scope.UserById.email+"approved Successfully");
    			},
    			function(error)
    			{
    			 alert($scope.UserById.email+"error");
    			}
    			)
    	
    };
 $scope.rejectUser = function(id) {
	 $http.get( $scope.BASEURL+"getUserById/"+id)
		.then(function(response)
		{
			console.log(response.data)
			$scope.UserById=response.data;				
					})
					
					
		console.log($scope.UserById)
    	
	    $scope.UserById.status='R';
    	$http.post( $scope.BASEURL+"update",$scope.UserById)
    	.then(function(response)
    			{
    		      alert($scope.UserById.email+"sorry, access is rejected by the admin");
    			},
    			function(error)
    			{
    			 alert($scope.UserById.email+"error");
    			}
    			)
    	
    };
 $scope.updateUser = function() {
    	
	    $scope.User['status']='A';
    	$http.get( $scope.BASEURL+"update",$scope.User)
    	.then(function(response)
    			{
    		      alert($scope.User.email+"updated Successfully");
    			},
    			function(error)
    			{
    			 alert($scope.User.email+"error");
    			}
    			)
    	
    };
    
$scope.getAllUser = function() {
    	
	   console.log("getAllUser Executed");
    	$http.get( $scope.BASEURL+"getAllUser")
    	.then(function(response)
    			{
    		$scope.users=response.data;
    		console.log($scope.users)
		    
			},
			function(error)
			{
			 alert("error");
			}
			)
	
};

$scope.getAllUser();

});