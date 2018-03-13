app.controller('blogCtrl', function($scope,$http,$rootScope,$location,$cookieStore) {
	
	$scope.Blog={userid:$rootScope.currentuser.userId,username:$rootScope.currentuser.username};
	$scope.BlogComment={userId:$rootScope.currentuser.userId,username:$rootScope.currentuser.username,blogId:$rootScope.eblog.blogId};
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
		       			 alert($scope.Blog.blogName+"blog added Successfully");
		       			}
		       			)
	  $location.path("/blog")
		       };
		

	 
		  
		    $scope.deleteBlog= function() {
			      
			       
			       $scope.deleteBlog = function(blogId)
			       {
			    	   $http.get( $scope.BASEURL+"deleteBlog/"+blogId)
			       	.then(function(response)
			       			{
			       		      alert($scope.Blog.blogName+"blog deleted Successfully");
			       			},
			       			function(error)
			       			{
			       			 alert($scope.Blog.blogName+" blog deleted Successfully");
			       			}
			       			)
		 
			       }
		 
			    };
			    
			    $scope.getBlog=function(blogId)
			    {
					console.log("blog fetched successfully")
					$http.get( $scope.BASEURL+"getBlogById/"+blogId)
					.then(function(response)
					{
								
						 $rootScope.eblog=response.data;	
						 $cookieStore.put('blog', $rootScope.eblog);
					});
					
						
					}
			    
			    $scope.getBlogById=function(blogId)
			    {
			    	$scope.getBlog(blogId);
						  $location.path('/blogUpdate')
					}
			    
			    $scope.viewBlogById=function(blogId)
			    {
			    	$scope.getBlog(blogId);
			    	 $scope.getAllBlogComments(blogId);
			    	
						  $location.path('/blogpostdetail');
					}
			   
					
				       
			 $scope.updateBlog = function(blogId)
				       {
				    	   console.log("blogId :"+blogId)
				    	   
				    			if($scope.Blog.blogName==null)
				    			{
				    				$scope.Blog.blogName=$rootScope.eblog.blogName;
				    			}
				    	   		if($scope.Blog.blogContent==null)
				    	   		{
				    	   			$scope.Blog.blogContent=$rootScope.eblog.blogContent;
				    	   		}
				    	   		
				    	   		console.log($scope.Blog)
				    	 $http.post( $scope.BASEURL+"updateBlog",$scope.Blog)
				       	.then(function(response)
				       			{
				       		      alert($scope.Blog.blogName+"blog updated Successfully");
				       			},
				       			function(error)
				       			{
				       			 alert($scope.Blog.blogName+"blog updated unSuccessfully");
				       			}
				       			)
			 $location.path("/blog")
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
				    
				    function myallblogs()
					{
						console.log("in all my blogs method")
						console.log($rootScope.currentuser.username)
						$http.get($scope.BASEURL+"getAllMyBlogs/"+$rootScope.currentuser.userid)
						.then(function(response)
						{
							
							$rootScope.myblogs=response.data;
							
										
						},function(error)
						{
							console.log("Error on retrieving blogs")
						});	
						
						
					}
				    
				     
				    	   
				   /* $scope.addBlogComment=function()
					 {
						console.log("in add blogComment method")
						console.log($rootScope.eblog.blogId+$rootScope.currentuser.username+$scope.BlogComment.cmnt)

						$http.get($scope.BASEURL+$rootScope.eblog.blogId+"/"+$rootScope.currentuser.userId+"/"+$scope.BlogComment.cmnt+"/"+$rootScope.currentuser.username)
						.then(function(response)
							{
							 alert($scope.BlogComment.cmnt+"blog added Successfully");			
							},
							function(error)
							{
								 alert($scope.Blog.cmnt+"error");
							});
						
						$http.get($scope.BASEURL+"/"+$rootScope.eblog.blogId)
						.then(function(response)
						{
							$rootScope.eblogcmnt=response.data;
						},
						function(error)
						{
							console.log("Error")
						});		
						
						$location.path('/BlogPostDetail')	 
						 
					 }*/
				    		
				    $scope.addBlogComment= function(blogId) {
						  console.log("In Add Blogcomment",$scope.BlogComment)
					       
					    	   $http.post( $scope.BASEURL+"addBlogComment",$scope.BlogComment)
					       	.then(function(response)
					       			{
					       		     
					       		      alert($scope.BlogComment.cmnt+"blog comment added Successfully");
					       			},
					       			function(error)
					       			{
					       			 alert($scope.BlogComment.cmnt+"blog comment added Successfully");
					       			}
					       			)
					       			$scope.getBlog(blogId);
						  $scope.getAllBlogComments(blogId);
				  $location.path("/blogpostdetail")
					       };
					       
					     
					       
					  $scope.getAllBlogComments= function(blogId) 
					       {
					       $http.get($scope.BASEURL+"getAllBlogComments/"+blogId)
							.then(function(response)
							{
								console.log($rootScope.eblog.blogId)
								$rootScope.gblogcomm=response.data;
								 $cookieStore.put('blogcom', $rootScope.gblogcomm);
								//alert("success");
							},function(error)
							{
								alert("error");
							});		
							
							//$location.path('/blogpostdetail')	 
							 
						 }  
					
					  
				 $scope.likeBlog=function(blogId)
						 {
							console.log("in like blog method"+blogId)
							 $http.get($scope.BASEURL+"likeBlog/"+blogId)
							 .then(function(response)
							    {
								 console.log("Blog liked successfully");
								}
							 ,function(error){
									console.error("Error while liking blog");
								});
							 $scope.viewBlogById(blogId);
							 
						 }

					
				    
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
					 

					
					 
		});