angular
    .module('myApp', ['ngResource'])
    .service('TestService', function () {
        return {
            getTest: function ($http) {
                return $http({ method: 'GET', params:{name: 'Fred'}, url: '/greeting' }).
                then(function(response) {
                    return response.data;
                });
            }
        }
    })
    .controller('TestController', function ($scope, $http, TestService) {
         TestService.getTest($http).then(function (d) {
             $scope.titi = d;
        });

    });
