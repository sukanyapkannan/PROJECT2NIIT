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
    .when("/job", {
        templateUrl : "User/job.html"
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