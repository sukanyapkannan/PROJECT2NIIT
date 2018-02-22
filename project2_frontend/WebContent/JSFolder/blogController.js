app.controller('blogCtrl', function($scope,$http) {
	
	$scope.Blog={};
	$scope.BlogById={}
	
	    
	    $scope.BASEURL="http://localhost:9090/project2_middleware/blog/";
		 $scope.addBlog= function() {
			  console.log("In Add Blog",$scope.Blog)
		       
		    	   $http.post( $scope.BASEURL+"addBlog",$scope.Blog)
		       	.then(function(response)
		       			{
		       		      alert($scope.Blog.blogName+"blog added Successfully");
		       			},
		       			function(error)
		       			{
		       			 alert($scope.Blog.blogName+"blog added unSuccessfully");
		       			}
		       			)
	 
		       }
	 
		  
		    $scope.deleteBlog= function() {
			      
			       
			       $scope.deleteBlog = function(blogId)
			       {
			    	   $http.post( $scope.BASEURL+"deleteBlog/"+blogId)
			       	.then(function(response)
			       			{
			       		      alert($scope.Blog.blogName+"blog deleted Successfully");
			       			},
			       			function(error)
			       			{
			       			 alert($scope.Blog.blogName+" delete unSuccessful");
			       			}
			       			)
		 
			       }
		 
			    };
			    
	
				       
				       $scope.updateBlog = function(blogId)
				       {
				    	   $http.post( $scope.BASEURL+"updateBlog/"+blogId)
				       	.then(function(response)
				       			{
				       		      alert($scope.Blog.blogName+"blog updated Successfully");
				       			},
				       			function(error)
				       			{
				       			 alert($scope.Blog.blogName+"blog updated unSuccessfully");
				       			}
				       			)
			 
				       };
			 
				   
				    
				    $scope.approveBlog = function(bid) {
				    	
				    	$http.get( $scope.BASEURL+"getBlogById/"+bid)
						.then(function(response)
						{
							console.log(response.data)
							$scope.BlogById=response.data;				
									})
									
									
						console.log($scope.BlogById)
				    	
					    $scope.BlogById.status='A';
				    	$http.post( $scope.BASEURL+"updateBlog",$scope.BlogById)
				    	.then(function(response)
				    			{
				    		      alert($scope.BlogById.blogName+"approved Successfully");
				    			},
				    			function(error)
				    			{
				    			 alert($scope.BlogById.blogName+"error");
				    			}
				    			)
				    	
				    };
				    
				    $scope.rejectBlog = function(bid) {
				    	
				    	$http.get( $scope.BASEURL+"getBlogById/"+bid)
						.then(function(response)
						{
							console.log(response.data)
							$scope.BlogById=response.data;				
									})
									
									
						console.log($scope.BlogById)
				    	
					    $scope.BlogById['status']='R';
				    	$http.post( $scope.BASEURL+"updateBlog",$scope.BlogById)
				    	.then(function(response)
				    			{
				    		      alert($scope.BlogById.blogName+" blog is rejected ");
				    			},
				    			function(error)
				    			{
				    			 alert($scope.BlogById.blogName+"error");
				    			}
				    			)
				    	
				    };
				    $scope.getAllBlogs = function() {
				    	
					 	   console.log("getAllBlogs Executed");
					     	$http.get( $scope.BASEURL+"getAllBlogs")
					     	.then(function(response)
					     			{
					     		$scope.Blogs=response.data;
					     		console.log($scope.Blog)
					 		    
					 			},
					 			function(error)
					 			{
					 			 alert("error");
					 			}
					 			)
					 	
					 };

					 $scope.getAllBlogs(); 

					$scope.getBlogById=function(bid){
						console.log("blog fetched successfully")
						$http.get( $scope.BASEURL+"getBlogById")
						.then(function(response)
						{
									
							$scope.BlogById=response.data;				
									})
						
							
						};
						
					 
		});