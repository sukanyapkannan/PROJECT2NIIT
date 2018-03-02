app.controller('jobCtrl', function($scope,$http,$rootScope) {
	
	$scope.Job={};

    $scope.BASEURL="http://localhost:9090/project2_middleware/job/";
	 $scope.saveJob= function() {
	     
	         console.log($scope.Job)
	       
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
	    
	  
		       
		       $scope.deletejob = function(jobId)
		       {
		    	   console.log("jobid :"+jobId)
		    	   $http.post( $scope.BASEURL+"deleteJob/"+jobId)
		       	.then(function(response)
		       			{
		       		      alert($scope.Job.jobPrfl+"job deleted Successfully");
		       			},
		       			function(error)
		       			{
		       			 alert($scope.Job.jobPrfl+"job deleted unSuccessfully");
		       			}
		       			)
	 
		       
	 
		    };
		    
		  $scope.fetchjobforedit=function(jobId)
		  {
			  $http.get($scope.BASEURL+"getJob/"+jobId).then(function(response)
			  {
				  $rootScope.ejob=response.data;
			  });
			  $location.path('/jobupdate')
		  }
		 
		  
		  
		  
		  
			       
			       $scope.updateJob = function(jobId)
			       {
			    	   
			    	   
			    	   console.log("jobid :"+jobId)
			    	   
			    	   
	    if($scope.Job.jobPrfl==null)
		{
		
		$scope.Job.jobPrfl=$rootScope.ejob.jobPrfl;
			}
		
		if($scope.Job.jobDescp==null)
		{
		
		$scope.Job.jobPrfl=$rootScope.ejob.jobDescp;
			}
		
		
		if($scope.Job.qualification==null)
		{
		
		$scope.Job.jobPrfl=$rootScope.ejob.qualification;
			}
		
		
		if($scope.Job.salary==null)
		{
		
		$scope.Job.jobPrfl=$rootScope.ejob.salary;
			}
		
		
		if($scope.Job.company==null)
		{
		
		$scope.Job.jobPrfl=$rootScope.ejob.company;
			}
		
		if($scope.Job.companyDesc==null)
		{
		
		$scope.Job.jobPrfl=$rootScope.ejob.companyDesc;
			}
			    	   
			    	   $http.post( $scope.BASEURL+"updateJob/"+jobId)
			       	.then(function(response)
			       			{
			       		      alert($scope.Job.jobPrfl+"update job form");
			       			},
			       			function(error)
			       			{
			       			 alert($scope.Job.jobPrfl+"error");
			       			}
			       			)
		 
			       $location.path("/job")
		 
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