/**
 * Created by ezequ on 12/11/2016.
 */
var app = angular.module('myApp', []);
app.controller('myCtrl', function ($scope, $http) {

    $http.get("/autos")
        .success(function (data) {
            console.log(data);
            $scope.appUserList = data;
        });

    $scope.crearAuto = function () {
        $http({
            method: 'POST',
            url: "/auto/nuevo",
            data: {
                   marca: $scope.marca,
                   modelo: $scope.modelo,
                   matricula: $scope.matricula,
                   anio: $scope.anio,
                   color : $scope.color,
                   combustible :$scope.combustible
                   }
        }).success(function (data) {
            $scope.crearAuto = data;
        });
    };

    $scope.actualizarAuto = function () {
        $http({
            method: 'PUT',
            url: "/auto/"+$scope.id,
            data: {marca: $scope.marca,
                modelo: $scope.modelo,
                matricula: $scope.matricula,
                anio: $scope.anio,
                color : $scope.color,
                combustible :$scope.combustible
            }
        }).success(function (data) {
            $scope.actualizarAuto = data;
        });
    };

    $scope.getUserById = function () {
        $http.get("/auto/" + $scope.id)
            .success(function (data) {
                $scope.oneUser = data;
            });
    };

    $scope.borrarAuto = function () {
        $http.delete("/auto/" + $scope.id)
            .success(function (data) {
                $scope.deleteStatus = data;
            });
    };


});