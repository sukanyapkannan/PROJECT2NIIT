var app = angular.module('myApp', ['ngRoute']);

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
    .when("/blog", {
        templateUrl : "User/blog.html"
    })
    .when("/blogForm", {
        templateUrl : "Blog/blogForm.html"
    })
     .when("/blogValidn", {
        templateUrl : "Blog/BlogValidation.html"
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
   
    .when("/forums", {
        templateUrl : "User/Forums.html"
    });
});

app.controller('myCtrl', function($scope)
{
    $scope.firstName= "John";
    $scope.lastName= "Doe";
});