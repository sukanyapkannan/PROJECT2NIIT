app.controller("friendrequestcontroller", function ($scope,$http,$location,$rootScope) {

	function fetchAllfriendreq()
	{
	
	 $http.get("http://localhost:9090/project2_middleware/friend/getAllMyFriendRequests/"+$rootScope.currentuser.userId)
	    .then(function(response)
	    		{
	    	
	    
		 $scope.myfriendreqs=response.data;
	
		console.log("all my friend request fetched")
							
		},function(error){
			console.log("Error on retrieving friends")
		});
	}
	fetchAllfriendreq();
	
	$scope.acceptfriend = function(friendid)
	{
	console.log("in unfriend method")
		$http.get('http://localhost:9090/project2_middleware/friend/acceptfriend/'+$rootScope.currentuser.userId+'/'+friendid)
		.then(fetchAllfriendreq(), function(response) {
			console.log("successful friend add ");
			$location.path("/usersearch")
		});
	}
	
	$scope.rejectfriend = function(friendid)
	{
	console.log("in unfriend method")
		$http.get('http://localhost:9090/project2_middleware/friend/rejectfriend/'+$rootScope.currentuser.userId+'/'+friendid)
		.then(fetchAllfriendreq(), function(response) {
			console.log("successful friend rejected ");
			$location.path("/usersearch")
		});
	}

});




app.controller("friendcontroller", function ($scope,$http,$location,$rootScope) {
	
	
	
	function fetchAlluser()
	{
	
	 $http.get("http://localhost:9090/project2_middleware/user/getAllUser/"+ $rootScope.currentuser.userId)
	    .then(function(response)
	    		{
	    	
	    
		 $scope.users=response.data;
				
		},function(error){
			console.error("Error while fetching user");
		});
	}
	
	
	fetchAlluser();
	
	function fetchAllUsers()
	{
		
		
		$http.get("http://localhost:9090/project2_middleware/friend/getMyFriends/"+ $rootScope.currentuser.userId)

		.then(function(response) {
			$scope.myfriends = response.data;
			console.log("all my friends fetched")
		},function(error)
		{
			console.log("Error on retrieving friends")
		});
		
		
		$http.get("http://localhost:9090/project2_middleware/friend/getAllOtherUsers/"+ $rootScope.currentuser.userId)

		.then(function(response) {
			$scope.otherusers = response.data;
			console.log("all other users fetched")
		},function(error)
		{
			console.log("Error on retrieving friends")
		});
		

		$http.get("http://localhost:9090/project2_middleware/friend/getOnlineFriends/"+ $rootScope.currentuser.userId)

		.then(function(response) {
			$scope.onlineusers = response.data;
			console.log("all online users fetched")
		},function(error)
		{
			console.log("Error on retrieving friends")
		});
		
		
		$http.get("http://localhost:9090/project2_middleware/friend/getAllMyFriendRequests/"+ $rootScope.currentuser.userId)

		.then(function(response) {
			$scope.myfriendreqs = response.data;
			console.log("all my friendsreqs  fetched")
		},function(error)
		{
			console.log("Error on retrieving friends")
		});
		
		
		
		
	}
	;
	fetchAllUsers();
	
	
	
	$scope.insertFriend = function(friendid)
	{
		
		console.log('entered add friend method'+friendid);
		$http.get('http://localhost:9090/project2_middleware/friend/addFriend/'+$rootScope.currentuser.userId+'/'+friendid)
		.then(fetchAllUsers(), function(response) {
			console.log("successful friend add ");
			$location.path("/usersearch")
		});
	}
	
	
	

	$scope.unfriend = function(friendid)
	{
	console.log("in unfriend method")
		$http.get('http://localhost:9090/project2_middleware/friend/unfriend/'+$rootScope.currentuser.userId+'/'+friendid)
		.then(fetchAllUsers(), function(response) {
			console.log("successful friend add ");
			$location.path("/usersearch")
		});
	}
	
	
	
	$rootScope.friendpreview=function(friendid)
	{
		if(friendid==$rootScope.currentuser.userId)
			{
			$location.path("/usersearch")
			}
		else
			{
		$http.get("http://localhost:9090/project2_middleware/user/getUserById/"+friendid)

		.then(function(response) {
			$rootScope.friendpreviewdata = response.data;
			$scope.fr=response.data;
			console.log($rootScope.friendpreviewdata.email);
			console.log($rootScope.friendpreviewdata.user_id);
			console.log($rootScope.currentuser.userId);
		},function(error)
		{
			console.log("Error on retrieving friends")
		});

	$http.get("http://localhost:9090/project2_middleware/user/ismyfriend/"+$rootScope.friendpreviewdata.user_id+"/"+$rootScope.currentuser.user_id)

		.then(function(response) {
			$rootScope.ismyfriend = response.data;
		
		},function(error)
		{
			
		});
		
		
		$http.get("http://localhost:9090/project2_middleware/user/friendsfriends/"+$rootScope.friendpreviewdata.user_id+"/"+$rootScope.currentuser.userId)

		.then(function(response) {
			$rootScope.friendsfriends = response.data;
		
		},function(error)
		{
			
		});
		
		
		
		
		$http.get("http://localhost:9090/project2_middleware/blog/getAllMyBlogs/"+$rootScope.friendpreviewdata.user_id)
		.then(function(response)
		{
			
			$rootScope.friendblogs=response.data;
			
						
		},function(error)
		{
			console.log("Error on retrieving blogs")
		});	
		
		
		$location.path("/usersearch")
		
	}
	}
	
	
});

