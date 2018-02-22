app.controller('jobCtrl', function($scope,$http) {
	
	$scope.Job={};

    $scope.BASEURL="http://localhost:9090/project2_middleware/job/";
	 $scope.saveJob= function() {
	     
	       
	       
	    	   $http.post( $scope.BASEURL+"addJob",$scope.Job)
	       	.then(function(response)
	       			{
	       		      alert($scope.Job.jobPrfl+"job added Successfully");
	       			},
	       			function(error)
	       			{
	       			 alert($scope.Job.jobPrfl+"job added unSuccessfully");
	       			}
	       			)
 
	       
 
	    };
	    
	    $scope.deleteJob= function() {
		      
		       
		       $scope.deletejob = function(jobid)
		       {
		    	   $http.post( $scope.BASEURL+"deleteJob/"+jobid)
		       	.then(function(response)
		       			{
		       		      alert($scope.Job.jobPrfl+"job deleted Successfully");
		       			},
		       			function(error)
		       			{
		       			 alert($scope.Job.jobPrfl+"job deleted unSuccessfully");
		       			}
		       			)
	 
		       }
	 
		    };
		    
		    $scope.updateJob= function() {
			      
			       
			       $scope.updateJob = function(jobid)
			       {
			    	   $http.post( $scope.BASEURL+"updateJob/"+jobid)
			       	.then(function(response)
			       			{
			       		      alert($scope.Job.jobPrfl+"job updated Successfully");
			       			},
			       			function(error)
			       			{
			       			 alert($scope.Job.jobPrfl+"job updated unSuccessfully");
			       			}
			       			)
		 
			       }
		 
			    };
			    
			    $scope.getAllJobs = function() {
			    	
			 	   console.log("getAllJobs Executed");
			     	$http.get( $scope.BASEURL+"getAllJobs")
			     	.then(function(response)
			     			{
			     		$scope.Jobs=response.data;
			     		console.log($scope.Jobs)
			 		    
			 			},
			 			function(error)
			 			{
			 			 alert("error");
			 			}
			 			)
			 	
			 };

			 $scope.getAllJobs(); 
});