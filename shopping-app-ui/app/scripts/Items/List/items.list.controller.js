'use strict';

/**
 * @ngdoc function
 * @name codebaseFrontendApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the codebaseFrontendApp
 */
angular.module('items.list.controller', [])
        .controller('itemsListController', ['$scope', 'itemsFactory', 'cartsFactory', '$location', function ($scope, itemsFactory, cartsFactory, $location) {

                $scope.items = [];

                $scope.go = function (path, data) {
                    $location.path(path).search(data);
                };

                $scope.initItems = function () {
                    itemsFactory.initItems().success(function () {
                        $scope.loadItems();
                    }).error(function (data) {
                        console.log("Error Data: ");
                        console.log(data);

                    });
                };

                $scope.loadItems = function () {

                    itemsFactory.getAllItems().success(function (items) {
                        console.log(" Start - Items Get All : ");
                        for (var i = 0; i < items.length; i++) {
                            console.log(items[i]);

                        }
                        console.log(" End - Items Get All : ");
                        $scope.items = items;
                    }).error(function (data) {

                        console.log("Error Data: ");
                        console.log(data);

                    });
                };

                $scope.loadItems();

                $scope.addToCart = function (item) {
                    console.log(" Before - Adding Item to Cart : "+ item);
                    cartsFactory.addItemToCart(item).success(function () {
                        console.log(" After - Adding Item to Cart : "+ item);
                        
                    }).error(function (data) {

                        console.log("Error Data: ");
                        console.log(data);

                    });

                }

            }]);