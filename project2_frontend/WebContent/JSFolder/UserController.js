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
    	
    	console.log($scope.User);
 	$http.post( $scope.BASEURL+"login",$scope.User)
 	.then(function(response)
 			{
 		 $rootScope.tempuser=response.data;
 		 console.log("user"+ $rootScope.tempuser);
 		 	if($rootScope.tempuser.errormessage!="login success")
 		 		{
 		 			alert($rootScope.tempuser.errormessage)
 		 		}
 		 	else
 		 		{
 		 		  if($rootScope.tempuser.status=='A')
 		 			  {
 		 			$rootScope.currentuser=$rootScope.tempuser;
 		 			$cookieStore.put('user', $rootScope.currentuser);
 		 			console.log("ROLE"+$rootScope.currentuser.role)
 		 			$location.path("/blog");
 		 			  
 		 			  }
 		 		  else if($rootScope.tempuser.status=='P')
 		 			  {
 		 			    alert("You are not yet approved by admin")
 		 			    $location.path("/login")
 		 			  }
 		 		  else
 		 			  {
 		 			 alert("You Rejected by admin")
 		 			 $location.path("/login")
 		 			  }
 		 		
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
			);
}
$scope.getAllUser();


		 $scope.logout=function()
		 {
		 
			 console.log( $rootScope.currentuser.email)
				$http.get($scope.BASEURL+"logout/"+$rootScope.currentuser.email)
					.then(function(response)
					{
						 $rootScope.currentuser={};
						 $cookieStore.remove('user');
					
						 $location.path("/login")
						
					},function(error)
					{
						
					});
		 }
	});