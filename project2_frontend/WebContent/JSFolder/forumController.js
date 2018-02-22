app.controller('forumCtrl', function($scope) {
	
	$scope.Forum={};
	 $scope.saveForum= function() {
	       alert($scope.Forum.forumName+"forum uploaded Successfully");
	    };
});