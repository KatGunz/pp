var app = angular.module("ppApp", ["ngRoute"]);
app.config(['$httpProvider', function($httpProvider) {
    //initialize get if not there
    if (!$httpProvider.defaults.headers.get) {
        $httpProvider.defaults.headers.get = {};
   }
}]);
app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "../html/foodLookup.html",
        controller: "foodLookupCtrl.js"
    })
});