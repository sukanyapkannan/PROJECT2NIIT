app.controller('chatController', function($scope,$rootScope,ChatService)
{
	$scope.messages=[];
	$scope.message="";
	$scope.max=140;
	
	$scope.addMessage=function()
	{
		
		ChatService.send($rootScope.currentuser.username+":"+$scope.message);
		$scope.message="";
	};

	ChatService.receive().then(null,null,function(message)
	{
		$scope.messages.push(message);
	});	

});