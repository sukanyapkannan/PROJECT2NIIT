/*app.controller("notificationcontroller", function ($scope,$http,$location,$rootScope) {
	
	$scope.Notifications={Notif:'',username:''};
	function fetchAllNotifications()
	{
	$http.get("http://localhost:9090/project2_middleware/notifications/")
		.then(function(response)
		{
			
			$rootScope.notific=response.data;
		
		
						
		},function(error)
		{
			console.log("Error on retrieving notis")
		});
	};
	fetchAllNotifications();	
	

	 $scope.deletenoti=function(id)
	 {
		console.log("in delete notig method")
		 $http.get("http://localhost:9090/project2_middleware/notifications/deleteNoti/"+id).then(fetchAllNotifications(),function(response){
			 console.log("notification deleted successfully")
								
			},function(error){
				console.error("Error while delete notificatiosn")
			});
		$location.path('/noti')
		 
	 }

	
	
});*/