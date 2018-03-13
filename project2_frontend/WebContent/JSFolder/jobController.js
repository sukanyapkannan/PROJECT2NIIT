app.controller('jobCtrl', function($scope,$http,$rootScope,$location,$cookieStore) {
	
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
		$scope.Job.jobDescp=$rootScope.ejob.jobDescp;
			}
		if($scope.Job.qualification==null)
		{	
		$scope.Job.qualification=$rootScope.ejob.qualification;
			}		
		if($scope.Job.salary==null)
		{
		$scope.Job.salary=$rootScope.ejob.salary;
			}
		if($scope.Job.company==null)
		{
		$scope.Job.company=$rootScope.ejob.company;
			}	
		if($scope.Job.companyDesc==null)
		{
		$scope.Job.companyDesc=$rootScope.ejob.companyDesc;
			}
		$scope.Job.jobId=$rootScope.ejob.jobId;
		
		console.log($scope.Job)
			    	   $http.post( $scope.BASEURL+"updateJob",$scope.Job)
			       	.then(function(response)
			       			{
			       		      alert("Job Udated Successfully");
			       			},
			       			function(error)
			       			{
			       				
			       			 alert("Job Udated Successfully");
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


$scope.applyJob = function(jobId)
{
	console.log('apply job'+jobId);
	$http.get( $scope.BASEURL+"applyJob/"+jobId+"/"+$rootScope.currentuser.userId)
	.then(getAllJobs(), function(response) 
	{
		console.log("successful jobs applied");
		$location.path("/blog")
	});
}
});