var app = angular.module('myApp', ['ngRoute','ngCookies']);

app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "views/home.html"
    })
    .when("/signup", {
        templateUrl : "User/registration.html"
    })
    .when("/login", {
        templateUrl : "User/Login.html"
    })
    .when("/profile", {
        templateUrl : "User/myProfile.html"
    })
    .when("/friendpreview", {
        templateUrl : "friend/FriendPreview.html"
    })
    .when("/blog", {
        templateUrl : "User/blog.html"
    })
    .when("/blogUpdate", {
        templateUrl : "Blog/blogUpdate.html"
    })
    .when("/blogForm", {
        templateUrl : "Blog/blogForm.html"
    })
     .when("/blogValidn", {
        templateUrl : "Blog/BlogValidation.html"
    })
    .when("/myblogs", {
        templateUrl : "User/MyBlogs.html"
    })
     .when("/blogpostdetail", {
        templateUrl : "Blog/BlogPostDetail.html"
    })
     .when("/userList", {
        templateUrl : "views/UserList.html"
    })
    .when("/job", {
        templateUrl : "User/job.html"
    })
    .when("/jobForm", {
        templateUrl : "views/jobForm.html"
    })
     .when("/jobupdate", {
        templateUrl : "jobs/jobUpdate.html"
    })
    .when("/notifications", {
        templateUrl : "notifications/Notifications.html"
    })
    .when("/usersearch", {
        templateUrl : "friend/UsersList.html"
    })
    
    .when("/friendslist", {
        templateUrl : "friend/FriendsListing.html"
    })
     .when("/pendingrequests", {
        templateUrl : "friend/PendingRequests.html"
    })
    .when("/chat", {
        templateUrl : "chat/Chat.html"
    })
   
    .when("/forums", 
    		{
        templateUrl : "User/Forums.html"
    });
});


app.run( function ($rootScope, $location, $cookieStore, $http) 
		{
		 $rootScope.$on('$locationChangeStart', function (event, next, current) 
					 {
						 console.log("$locationChangeStart")
						    
						 var userPages = ['/noti','/profile','/blog','job','/blogUpdate','/myblogs'];
				 var adminPages = ['/blogValidn','/userList','jobForm','jobupdate'];
						 
						 var currentPage = $location.path();
						 
						 var isUserPage = $.inArray(currentPage, userPages);
						 var isAdminPage = $.inArray(currentPage, adminPages);
						 
						 var isLoggedIn = $rootScope.currentuser.email;
					        
					     console.log("isLoggedIn:" +isLoggedIn)
					     console.log("isUserPage:" +isUserPage)
					     console.log("isAdminPage:" +isAdminPage)
					        
					        if(!isLoggedIn)
					        	{
					        	
					        		if(isUserPage!=-1 || isAdminPage!=-1)  
					        	 	{
						        	  console.log("Navigating to login page:")
						        	  alert("You need to Login first!")
						        	  $location.path('/login');
						         	}
					        	}
					        
							 else //logged in
					        	{
					        	
								 var role = $rootScope.currentuser.role;
								
								 if(isAdminPage!=-1 && role!='ROLE_ADMIN')
									 {
									  alert("You cannot view this page as a " + role )
									  $location.path('/blog');
									 }
								 
								 
					        	}
					 });
					 
					 // to keep the user logged in after page refresh
				    $rootScope.currentuser = $cookieStore.get('user') || {};
				    if ($rootScope.currentuser)
				    {
				        $http.defaults.headers.common['Authorization'] = 'Basic' + $rootScope.currentuser; 
				    }
				    
				    // to keep the blog view in after page refresh
				    $rootScope.eblog = $cookieStore.get('blog') || {};
				    if ($rootScope.eblog)
				    {
				        $http.defaults.headers.common['Authorization'] = 'Basic' + $rootScope.eblog; 
				    }
				    
				    // to keep the job view  in after page refresh
					$rootScope.job = $cookieStore.get('job') || {};
				    if (	$rootScope.job)
				    {
				        $http.defaults.headers.common['Authorization'] = 'Basic' + 	$rootScope.job; 
				    }
				    $rootScope.gblogcomm = $cookieStore.get('blogcom') || {};
				    if ($rootScope.gblogcomm)
				    {
				        $http.defaults.headers.common['Authorization'] = 'Basic' + 	$rootScope.gblogcomm; 
				    }
				   
				    
		});
				    
				  
				   

